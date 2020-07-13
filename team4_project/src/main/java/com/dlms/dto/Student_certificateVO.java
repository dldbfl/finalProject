package com.dlms.dto;


/**
 * 
 * @사용목적		:	수강생 자격증명서 정보 테이블 (선택사항)	
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	강현철
 * @마지막수정일	:	2020. 6. 12.오전 10:48:55
 * @see			:	
 *
 */
public class Student_certificateVO {

	private int student_certificate_no; 				// 자격증 번호
	private String student_id; 							// 수강생 아이디
	private String student_certificate_name; 			// 자격증명
	private String student_certificate_division; 		// 자격구분
	private String student_certificate_date; 			// 취득일자
	private String student_certificate_agency; 			// 발급한 기관

	
	public Student_certificateVO() {}


	public int getStudent_certificate_no() {
		return student_certificate_no;
	}


	public void setStudent_certificate_no(int student_certificate_no) {
		this.student_certificate_no = student_certificate_no;
	}


	public String getStudent_id() {
		return student_id;
	}


	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}


	public String getStudent_certificate_name() {
		return student_certificate_name;
	}


	public void setStudent_certificate_name(String student_certificate_name) {
		this.student_certificate_name = student_certificate_name;
	}


	public String getStudent_certificate_division() {
		return student_certificate_division;
	}


	public void setStudent_certificate_division(String student_certificate_division) {
		this.student_certificate_division = student_certificate_division;
	}


	public String getStudent_certificate_date() {
		return student_certificate_date;
	}


	public void setStudent_certificate_date(String student_certificate_date) {
		this.student_certificate_date = student_certificate_date;
	}


	public String getStudent_certificate_agency() {
		return student_certificate_agency;
	}


	public void setStudent_certificate_agency(String student_certificate_agency) {
		this.student_certificate_agency = student_certificate_agency;
	}


	@Override
	public String toString() {
		return "Student_certificateVO [student_certificate_no=" + student_certificate_no + ", student_id=" + student_id
				+ ", student_certificate_name=" + student_certificate_name + ", student_certificate_division="
				+ student_certificate_division + ", student_certificate_date=" + student_certificate_date
				+ ", student_certificate_agency=" + student_certificate_agency + "]";
	}


	public Student_certificateVO(int student_certificate_no, String student_id, String student_certificate_name,
			String student_certificate_division, String student_certificate_date, String student_certificate_agency) {
		super();
		this.student_certificate_no = student_certificate_no;
		this.student_id = student_id;
		this.student_certificate_name = student_certificate_name;
		this.student_certificate_division = student_certificate_division;
		this.student_certificate_date = student_certificate_date;
		this.student_certificate_agency = student_certificate_agency;
	}


	

	
	
}
