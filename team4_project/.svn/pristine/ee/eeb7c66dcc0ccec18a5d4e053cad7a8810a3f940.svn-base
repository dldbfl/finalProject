package com.dlms.request;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.dlms.dto.MemberVO;
import com.dlms.dto.ProfessorVO;
import com.dlms.dto.Professor_careerVO;

public class RegistProfessorInfoRequest {

	private String member_id; 					// 아이디
	private String member_pwd; 					// 비밀번호
	private String member_name;					// 이름
	private String member_post; 				// 우편번호
	private String member_address1; 			// 주소
	private String member_address2; 			// 상세주소
	private String member_emailFront; 			// 이메일(앞)
	private String member_emailBack; 			// 이메일(뒤)
	private String member_phone1; 				// 연락처(앞자리)
	private String member_phone2; 				// 연락처(중간자리)
	private String member_phone3; 				// 연락처(뒷자리)
	private String member_gender; 				// 성별
	private Date member_birth; 					// 생일
	private String member_authority; 			// 수강생
	private String member_picture;				// 프로필사진 이름
	private MultipartFile picture;				// 프로필 사진
	
	private String member_infoOpen;				// Y-정보공개 N-비공개 (기본 정보 타인에개 공개여부)  
	private String member_eventReception;		//Y-수신 N-거부  (선택 이용약관 광고 수신여부)
	
	private Professor_careerVO[] career;		//경력사항
	private List<MultipartFile> careerFile;
	
	public RegistProfessorInfoRequest() {}

	
	
	public String getMember_id() {
		return member_id;
	}



	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}



	public String getMember_pwd() {
		return member_pwd;
	}



	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}



	public String getMember_name() {
		return member_name;
	}



	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}



	public String getMember_post() {
		return member_post;
	}



	public void setMember_post(String member_post) {
		this.member_post = member_post;
	}



	public String getMember_address1() {
		return member_address1;
	}



	public void setMember_address1(String member_address1) {
		this.member_address1 = member_address1;
	}



	public String getMember_address2() {
		return member_address2;
	}



	public void setMember_address2(String member_address2) {
		this.member_address2 = member_address2;
	}



	public String getMember_emailFront() {
		return member_emailFront;
	}



	public void setMember_emailFront(String member_emailFront) {
		this.member_emailFront = member_emailFront;
	}



	public String getMember_emailBack() {
		return member_emailBack;
	}



	public void setMember_emailBack(String member_emailBack) {
		this.member_emailBack = member_emailBack;
	}



	public String getMember_phone1() {
		return member_phone1;
	}



	public void setMember_phone1(String member_phone1) {
		this.member_phone1 = member_phone1;
	}



	public String getMember_phone2() {
		return member_phone2;
	}



	public void setMember_phone2(String member_phone2) {
		this.member_phone2 = member_phone2;
	}



	public String getMember_phone3() {
		return member_phone3;
	}



	public void setMember_phone3(String member_phone3) {
		this.member_phone3 = member_phone3;
	}



	public String getMember_gender() {
		return member_gender;
	}



	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}



	public Date getMember_birth() {
		return member_birth;
	}


	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setMember_birth(Date member_birth) {
		this.member_birth = member_birth;
	}



	public String getMember_authority() {
		return member_authority;
	}



	public void setMember_authority(String member_authority) {
		this.member_authority = member_authority;
	}



	public String getMember_picture() {
		return member_picture;
	}



	public void setMember_picture(String member_picture) {
		this.member_picture = member_picture;
	}



	public MultipartFile getPicture() {
		return picture;
	}



	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}



	public String getMember_infoOpen() {
		return member_infoOpen;
	}



	public void setMember_infoOpen(String member_infoOpen) {
		this.member_infoOpen = member_infoOpen;
	}



	public String getMember_eventReception() {
		return member_eventReception;
	}



	public void setMember_eventReception(String member_eventReception) {
		this.member_eventReception = member_eventReception;
	}



	public Professor_careerVO[] getCareer() {
		return career;
	}



	public void setCareer(Professor_careerVO[] career) {
		this.career = career;
	}



	public List<MultipartFile> getCareerFile() {
		return careerFile;
	}



	public void setCareerFile(List<MultipartFile> careerFile) {
		this.careerFile = careerFile;
	}



	@Override
	public String toString() {
		return "RegistProfessorInfoRequest [member_id=" + member_id + ", member_pwd=" + member_pwd + ", member_name="
				+ member_name + ", member_post=" + member_post + ", member_address1=" + member_address1
				+ ", member_address2=" + member_address2 + ", member_emailFront=" + member_emailFront
				+ ", member_emailBack=" + member_emailBack + ", member_phone1=" + member_phone1 + ", member_phone2="
				+ member_phone2 + ", member_phone3=" + member_phone3 + ", member_gender=" + member_gender
				+ ", member_birth=" + member_birth + ", member_authority=" + member_authority + ", member_picture="
				+ member_picture + ", picture=" + picture + ", member_infoOpen=" + member_infoOpen
				+ ", member_eventReception=" + member_eventReception + ", career=" + Arrays.toString(career)
				+ ", careerFile=" + careerFile + "]";
	}



	public MemberVO tomember() {
		MemberVO member =new MemberVO();
		
		Date from = member_birth;
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		String to = transFormat.format(from);

		member.setMember_id(member_id);
		member.setMember_name(member_name);
		member.setMember_pwd(member_pwd);
		member.setMember_birth(to);
		member.setMember_gender(member_gender);
		member.setMember_email(member_emailFront+"@"+member_emailBack);
		member.setMember_post(member_post);
		member.setMember_address1(member_address1);
		member.setMember_address2(member_address2);
		member.setMember_phone(member_phone1+member_phone2+member_phone3);
		member.setMember_infoOpen(member_infoOpen);
		member.setMember_eventReception(member_eventReception);
		
		return member;
	}
}
