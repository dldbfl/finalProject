package com.dlms.security;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.dlms.dao.member.MemberDAO;
import com.dlms.dto.MemberVO;

/**
 * 
 * @사용목적		:	로그인한 사용자의 정보를 확인하고 그에따른 권한 부여 및 관련메시지 출력
 * @작성자		:	강현철
 * @작성날짜      	:	2020. 06. 12.
 * @마지막수정자	:	강현철
 * @마지막수정일	:	2020. 06. 12.오전  10:46:50
 * @see			:	LoginPage
 *
 */
public class CustomAuthentication implements AuthenticationProvider{

	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Resource(name="IdAndPasswordFail")
	private String IdAndPasswordFail;
	
	@Resource(name="leavedMember")
	private String leavedMember;
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		String login_id = (String) auth.getPrincipal();				// 로그인 시도한 ID를 가져온다.
		String login_pwd = (String) auth.getCredentials();			// 로그인 시도한  Password를 가져온다.
		
		System.out.println("login_id : " + login_id);
		System.out.println("login_pwd : " + login_pwd);
		
		MemberVO member = null;
		
		try {
			member = memberDAO.selectMemberById(login_id);
		}catch(SQLException e ) {
			// authentication-failure를 호출한다.
			//이 로고가 않나오면 로그인이 됫다고 인정한다(manager가)
			//"Internal server error!" 메시지는 LoginFailureHandler로 출력된다.
			throw new BadCredentialsException("Internal server error!");
		}
		
			//사용자가 입력한 값과 AuthenticationProvider 통해가져온 값을 비교하여 권한 부여 처리 하는 부분 
			if( member !=null && login_pwd.equals(member.getMember_pwd())) {
				
				User loginUser =new User(member);
				
				//회원에 퇴사 따른 화면 표시  또는 권한 부여 
				if(!loginUser.isEnabled()) {
					throw new DisabledException(leavedMember);
				}else {
					//권한 부여
					List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
					
					//로그인한 멤버의 권한Checking하여, 권한을 부여한다.
					if(loginUser.isAccountNonLocked()) {
						roles.add(new SimpleGrantedAuthority(member.getMember_authority()));
					}else {
						roles.add(new SimpleGrantedAuthority("USER"));
					}
					
					//스프링 시큐리티 내부 클래스로 인증 토큰 생성된다.
					UsernamePasswordAuthenticationToken result=
					new UsernamePasswordAuthenticationToken(member.getMember_id(),member.getMember_pwd(),roles);
					
					//전달할 내용을 설정한 후
					result.setDetails(loginUser);
					
					return result;
				}
			}else {
				//실패시 예외처리
				throw new BadCredentialsException(IdAndPasswordFail);
			}
	}
	@Override
	public boolean supports(Class<?> arg) {
		return arg.equals(UsernamePasswordAuthenticationToken.class);
	}

}
