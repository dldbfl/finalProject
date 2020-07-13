package com.dlms.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dlms.dto.MemberVO;

public class User implements UserDetails {

	private MemberVO member;
	
	public User() {};
	public User(MemberVO member) {
		this.member=member;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	@Override
	public String getPassword() {
		return this.member.getMember_pwd();
	}
	@Override
	public String getUsername() {
		return this.member.getMember_id();
	}
	
	//계정 만료 여부 만료되었으면 false
	@Override
	public boolean isAccountNonExpired() {
		//true로 변경
		return true;
	}
	
	//사용 제제 여부 : 가입 대기상태(2)
	@Override
	public boolean isAccountNonLocked() {
		boolean result=true;
		if(this.member.getMember_status()>1) result=false;
		return result;
	}
	
	//인증정보 만료 여부 판단(패스워드 만료)
	@Override
	public boolean isCredentialsNonExpired() {
		//true로 변경
		return true;
	}
	//휴면계정 여부 : 탈퇴 또는 퇴사(0)
	@Override
	public boolean isEnabled() {
		boolean result=true;
		if(this.member.getMember_status()==0) result=false;
		return result;
	}
	
	public MemberVO getMemberVO() {
		return this.member;
	}
	
}
