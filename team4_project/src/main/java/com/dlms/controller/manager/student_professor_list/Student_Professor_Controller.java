package com.dlms.controller.manager.student_professor_list;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dlms.dto.MemberVO;
import com.dlms.request.MemberRequest;
import com.dlms.request.ProfessorListReq;
import com.dlms.request.SearchCriteria;
import com.dlms.security.CustomAuthentication;
import com.dlms.security.User;
import com.dlms.service.manager.ManagerService;
import com.dlms.service.member.MemberService;

/**
 * 
 * @사용목적		:	수강생, 교수 리스트
 * @작성자		    :	이누리
 * @작성날짜     	:	2020. 6. 17.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 17.오후 4:53:30
 * @see			    :	-
 *
 */
@Controller
@RequestMapping("/manager/*")
public class Student_Professor_Controller {

	@Autowired
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Autowired
	private ManagerService managerService;
	
	/**
	 * 
	 * @기능설명		:	수강생 리스트
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 4:53:42
	 * @see			    :	-
	 * @param cri
	 * @param mnv
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping("/student_list") //@GetMapping("list") 또는 @PostMapping("...") : spring 4.3부터 사용가능, value=RequestMethod 대신 사용가능
	public ModelAndView studentlist(SearchCriteria cri, ModelAndView mnv) throws Exception {
		String url = "manager/student/student_list.page";
		
		mnv.addAllObjects(managerService.getStudentList(cri));
		System.out.println(cri);
		mnv.setViewName(url);
		
		return mnv;
	}
		
	/**
	 * 
	 * @기능설명		:	수강생 상세보기
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 4:54:14
	 * @see			    :	-
	 * @param student_id
	 * @param model
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping("/student_detail")
	public String studentdetail(String student_id, Model model) throws Exception {
		String url = "manager/student/student_detail";
		
		//수강생 정보 가져오기
		Map<String, Object> dataMap = managerService.getStudent(student_id);
		System.out.println(dataMap);
		model.addAllAttributes(dataMap);
		
		return url;
	}
	/**
	 * 학생 사진 저장 경로
	 */
	@Resource(name="member_Profile_Student_PicturePath")
	private String Student_PicturePath;
	
	
	/**
	 * 
	 * @기능설명		:	멤버 사진 불러오기
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 7. 2.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 2.오후 2:23:42
	 * @see			    :	-
	 * @param member_picture
	 * @param response
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping("/student_detail/picture/{member_picture}")
	@ResponseBody
	public ResponseEntity<byte[]> sendStudentPicture(@PathVariable("member_picture") String member_picture, HttpServletResponse response)
			throws Exception {

		ResponseEntity<byte[]> entity = null;

		String fileName = member_picture;
		String savePath = Student_PicturePath + File.separator + member_picture+".jpg";

		FileInputStream in = null;
		System.out.println("fileName : "+fileName);
		System.out.println("savePath : "+savePath);
		try {
			//in = new FileInputStream(savePath + File.separator + fileName);
			in = new FileInputStream(savePath);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), HttpStatus.OK);
		} catch (IOException e) {
			entity = new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		} finally {
			if(in!=null)in.close();
		}

		return entity;
	}
	
	/**
	 * 
	 * @기능설명		:	교수 리스트
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 4:54:24
	 * @see			    :	-
	 * @param cri
	 * @param mnv
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping("/professor_list") 
	public ModelAndView professorlist(SearchCriteria cri, ModelAndView mnv) throws Exception {
		String url = "manager/professor/professor_list.page";
					
		mnv.addAllObjects(managerService.getProfessorList(cri));
		mnv.setViewName(url);
		
		return mnv;
	}
	
	
	/**
	 * 
	 * @기능설명		:	교수 상세보기
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 4:54:32
	 * @see			    :	-
	 * @param professor_id
	 * @param model
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/professor_detail", method=RequestMethod.GET)
	public String professordetail(String professor_id, Model model) throws Exception {
			
		String url = "manager/professor/professor_detail";
		
		//교수 정보 가져오기
		Map<String, Object> dataMap = managerService.getProfessor(professor_id);
		
		model.addAllAttributes(dataMap);
		
		return url;
	}
	
	/**
	 * 교수 사진 저장 경로
	 */
	@Resource(name="member_Profile_Professor_PicturePath")
	private String Professor_PicturePath;
	
	@RequestMapping("/professor_detail/picture/{member_picture}")
	@ResponseBody
	public ResponseEntity<byte[]> sendProfessorPicture(@PathVariable("member_picture") String member_picture, HttpServletResponse response)
			throws Exception {

		ResponseEntity<byte[]> entity = null;

		String fileName = member_picture;
		String savePath = Professor_PicturePath + File.separator + member_picture+".jpg";

		FileInputStream in = null;
		System.out.println("fileName : "+fileName);
		System.out.println("savePath : "+savePath);
		try {
			//in = new FileInputStream(savePath + File.separator + fileName);
			in = new FileInputStream(savePath);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), HttpStatus.OK);
		} catch (IOException e) {
			entity = new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		} finally {
			if(in!=null)in.close();
		}

		return entity;
	}
	@Autowired
	private CustomAuthentication authProvider;
	
	
	/**
	 * 
	 * @기능설명		:	교수 재직 상태 수정
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 4:54:39
	 * @see			    :	-
	 * @param model
	 * @param memReq
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/professor_detail", method=RequestMethod.POST)
	public String modifyPOST(Model model, MemberRequest memReq, Authentication auth, HttpSession session) throws Exception {
		String url = "manager/professor/modify_ok";
		
		System.out.println("memReq.toString()" + memReq.toString());
		
		ProfessorListReq professorAll = memReq.toProfessorAllVO();
		
		managerService.modify(professorAll);
		
		
		if(auth.getName().equals(professorAll.getMember_id())) {			
			// 변경된 로그인 사용자 정보를 가져온다.
			MemberVO updateMember =memberService.getMember(professorAll.getMember_id());
			
			// 권한을 갱신한다.
			List<GrantedAuthority> updatedAuthorities = new ArrayList<GrantedAuthority>();
			updatedAuthorities.add(new SimpleGrantedAuthority(updateMember.getMember_authority()));
			
			// 새로운 Authentication을 생성.
			UsernamePasswordAuthenticationToken newAuth = 
				new UsernamePasswordAuthenticationToken(auth.getPrincipal(), 
						auth.getCredentials(), updatedAuthorities);
						
			//SecurityContextHolder으로 새로 생성한 authentication 을 setting
			SecurityContextHolder.getContext().setAuthentication(newAuth);
			// security의 userDetail을 갱신하기위한 User 생성.
			User user = new User(updateMember);
			
			//authentication detail과 session attribute를 교체한다.
			newAuth.setDetails(user);
			session.setAttribute("loginUser", updateMember);
			
		}
		
		
		
		return url;
	}
		
	
	
	
	
}
