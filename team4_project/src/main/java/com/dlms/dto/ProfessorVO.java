package com.dlms.dto;
/**
 * 
 * @사용목적		:	교수 회원정보 입력시 선택사항
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	강현철
 * @마지막수정일	:	2020. 6. 14.오후 10:21:58
 *
 */
public class ProfessorVO {

	private String professor_id; 			// 아이디
	private String professor_hope_subject; 	// 원하는 강의
	private String professor_subject; 		// 맡게된 강의
	private String professor_remark; 		// 비고
	private String professor_career_education; //학력
	
	
	public ProfessorVO() {}


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


	public String getProfessor_career_education() {
		return professor_career_education;
	}


	public void setProfessor_career_education(String professor_career_education) {
		this.professor_career_education = professor_career_education;
	}


	@Override
	public String toString() {
		return "ProfessorVO [professor_id=" + professor_id + ", professor_hope_subject=" + professor_hope_subject
				+ ", professor_subject=" + professor_subject + ", professor_remark=" + professor_remark
				+ ", professor_career_education=" + professor_career_education + "]";
	}


	public ProfessorVO(String professor_id, String professor_hope_subject, String professor_subject,
			String professor_remark, String professor_career_education) {
		super();
		this.professor_id = professor_id;
		this.professor_hope_subject = professor_hope_subject;
		this.professor_subject = professor_subject;
		this.professor_remark = professor_remark;
		this.professor_career_education = professor_career_education;
	}
	
	

}
