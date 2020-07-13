package com.dlms.dto;

import java.util.Date;

/**
 * 
 * @사용목적		:	수강생 출석부
 * @작성자		:	강현철
 * @작성날짜      	:	2020. 6. 2.
 * @마지막수정자	:	강현철
 * @마지막수정일	:	2020. 6. 2.오후 12:11:56
 *
 */
public class AttendanceVO {

	private int lecture_attend_no;
	private int lecture_no;
	private String professor_id;
	private String student_id;
	private Date lecture_attend_date;
	private String lecture_attend_status;
	public int getLecture_attend_no() {
		return lecture_attend_no;
	}
	public void setLecture_attend_no(int lecture_attend_no) {
		this.lecture_attend_no = lecture_attend_no;
	}
	public int getLecture_no() {
		return lecture_no;
	}
	public void setLecture_no(int lecture_no) {
		this.lecture_no = lecture_no;
	}
	public String getProfessor_id() {
		return professor_id;
	}
	public void setProfessor_id(String professor_id) {
		this.professor_id = professor_id;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public Date getLecture_attend_date() {
		return lecture_attend_date;
	}
	public void setLecture_attend_date(Date lecture_attend_date) {
		this.lecture_attend_date = lecture_attend_date;
	}
	public String getLecture_attend_status() {
		return lecture_attend_status;
	}
	public void setLecture_attend_status(String lecture_attend_status) {
		this.lecture_attend_status = lecture_attend_status;
	}
	@Override
	public String toString() {
		return "AttendanceVO [lecture_attend_no=" + lecture_attend_no + ", lecture_no=" + lecture_no + ", professor_id="
				+ professor_id + ", student_id=" + student_id + ", lecture_attend_date=" + lecture_attend_date
				+ ", lecture_attend_status=" + lecture_attend_status + "]";
	}
	
	
}
