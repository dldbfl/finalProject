package com.dlms.request;

import java.util.Date;
/**
 * 
 * @사용목적		:	교수 정보 전체 조회
 * @작성자		:	이누리
 * @작성날짜     	:	2020. 6. 4.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 17.오전 9:53:03
 * @see			:	-
 *
 */
public class ProfessorListReq {

	private String member_id; 			// 아이디
	private String member_name; 		// 이름
	private String member_email; 		// 이메일
	private String member_phone; 		// 연락처
	private String member_gender; 		// 성별
	private String member_birth; 		// 생일
	private String member_picture;		// 프로필 사진
	private int member_status; 			// 1일때 활성, 0일때 정지
	private Date member_regdate; 		// 멤버 등록일
	private String professor_id; 			// 아이디
	private String professor_hope_subject; 	// 원하는 과목
	private String professor_subject; 		// 맡게된 과목
	private String professor_remark; 		// 비고
	private int professor_subject_count; // 맡은 강의 수 
	
	public ProfessorListReq() {}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
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

	public String getMember_picture() {
		return member_picture;
	}

	public void setMember_picture(String member_picture) {
		this.member_picture = member_picture;
	}

	public int getMember_status() {
		return member_status;
	}

	public void setMember_status(int member_status) {
		this.member_status = member_status;
	}

	public Date getMember_regdate() {
		return member_regdate;
	}

	public void setMember_regdate(Date member_regdate) {
		this.member_regdate = member_regdate;
	}

	public String getProfessor_id() {
		return professor_id;
	}

	public void setProfessor_id(String professor_id) {
		this.professor_id = professor_id;
	}

	public String getProfessor_hope_subject() {
		return professor_hope_subject;
	}

	public void setProfessor_hope_subject(String professor_hope_subject) {
		this.professor_hope_subject = professor_hope_subject;
	}

	public String getProfessor_subject() {
		return professor_subject;
	}

	public void setProfessor_subject(String professor_subject) {
		this.professor_subject = professor_subject;
	}

	public String getProfessor_remark() {
		return professor_remark;
	}

	public void setProfessor_remark(String professor_remark) {
		this.professor_remark = professor_remark;
	}

	public int getProfessor_subject_count() {
		return professor_subject_count;
	}

	public void setProfessor_subject_count(int professor_subject_count) {
		this.professor_subject_count = professor_subject_count;
	}
	
	
}
