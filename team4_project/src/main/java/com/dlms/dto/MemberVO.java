package com.dlms.dto;

import java.util.Date;
/**
 * 
 * @사용목적		:	회원정보(수강생, 교수 회원 공통정보)	
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	강현철
 * @마지막수정일	:	2020. 6. 8.오후 8:30:49
 * @see			:	
 *
 */
public class MemberVO {

	private String member_id; 				// 아이디
	private String member_pwd; 				// 비밀번호
	private String member_name; 			// 이름
	private String member_post; 			// 우편번호
	private String member_address1; 		// 주소
	private String member_address2; 		// 상세주소
	private String member_email; 			// 이메일
	private String member_phone; 			// 연락처
	private String member_gender; 			// 성별
	private String member_birth; 			// 생일
	private String member_authority; 		// 수강생/교수
	private String member_picture;			// 프로필 사진
	private int member_status; 				// 1일때 활성, 0일때 정지
	private int member_pwdcheck; 			// 5회 이상 연속으로 비밀번호 틀릴시 체크할 카운트
	private Date member_regdate; 			// 멤버 등록일
	private String member_memberOutReason; 	// 탈퇴시 탈퇴사유내용
	
	private String member_infoOpen;			// Y-정보공개 N-비공개 (기본 정보 타인에개 공개여부)  
	private String member_eventReception;	//Y-수신 N-거부  (선택 이용약관 광고 수신여부)
	public MemberVO () {}
	
	
	
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



	public String getMember_picture() {
		return member_picture;
	}

	public void setMember_picture(String member_picture) {
		this.member_picture = member_picture;
	}

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

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public String getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}

	public String getMember_birth() {
		return member_birth;
	}

	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}

	public String getMember_authority() {
		return member_authority;
	}

	public void setMember_authority(String member_authority) {
		this.member_authority = member_authority;
	}

	public int getMember_status() {
		return member_status;
	}

	public void setMember_status(int member_status) {
		this.member_status = member_status;
	}

	public int getMember_pwdcheck() {
		return member_pwdcheck;
	}

	public void setMember_pwdcheck(int member_pwdcheck) {
		this.member_pwdcheck = member_pwdcheck;
	}

	public Date getMember_regdate() {
		return member_regdate;
	}

	public void setMember_regdate(Date member_regdate) {
		this.member_regdate = member_regdate;
	}

	
	
	public String getMember_memberOutReason() {
		return member_memberOutReason;
	}



	public void setMember_memberOutReason(String member_memberOutReason) {
		this.member_memberOutReason = member_memberOutReason;
	}



	@Override
	public String toString() {
		return "MemberVO [member_id=" + member_id + ", member_pwd=" + member_pwd + ", member_name=" + member_name
				+ ", member_post=" + member_post + ", member_address1=" + member_address1 + ", member_address2="
				+ member_address2 + ", member_email=" + member_email + ", member_phone=" + member_phone
				+ ", member_gender=" + member_gender + ", member_birth=" + member_birth + ", member_authority="
				+ member_authority + ", member_picture=" + member_picture + ", member_status=" + member_status
				+ ", member_pwdcheck=" + member_pwdcheck + ", member_regdate=" + member_regdate
				+ ", member_memberOutReason=" + member_memberOutReason + ", member_infoOpen=" + member_infoOpen
				+ ", member_eventReception=" + member_eventReception + "]";
	}



	public MemberVO(String member_id, String member_pwd, String member_name, String member_post, String member_address1,
			String member_address2, String member_email, String member_phone, String member_gender, String member_birth,
			String member_authority, String member_picture, int member_status, int member_pwdcheck, Date member_regdate,
			String member_memberOutReason, String member_infoOpen, String member_eventReception) {
		super();
		this.member_id = member_id;
		this.member_pwd = member_pwd;
		this.member_name = member_name;
		this.member_post = member_post;
		this.member_address1 = member_address1;
		this.member_address2 = member_address2;
		this.member_email = member_email;
		this.member_phone = member_phone;
		this.member_gender = member_gender;
		this.member_birth = member_birth;
		this.member_authority = member_authority;
		this.member_picture = member_picture;
		this.member_status = member_status;
		this.member_pwdcheck = member_pwdcheck;
		this.member_regdate = member_regdate;
		this.member_memberOutReason = member_memberOutReason;
		this.member_infoOpen = member_infoOpen;
		this.member_eventReception = member_eventReception;
	}



	
}
