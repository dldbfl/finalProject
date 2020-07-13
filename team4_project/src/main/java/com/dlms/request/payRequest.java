package com.dlms.request;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 
 * @사용목적		:	결제 용도
 * @작성자		    :	연은주
 * @작성날짜     	:	2020. 6. 29.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 29.오후 4:10:08
 * @see			    :	-
 *
 */
public class payRequest {

	private int pay_no; 							// 결제 내역 번호
	private int lecture_no; 						// 결제 번호 
	private String professor_id; 					// 교과목 교수
	private String student_id; 						// 수강생 아이디 member_id
	private String class_name; 						// 강의명 lecture_title
	private int pay_price; 							// 금액 lecture_price
	private Date pay_complete_date; 				// 결제일자 
	private int lecture_price;
	private String member_id;
	private String lecture_title;
	
	public payRequest() {}
	
	public int getPay_no() {
		return pay_no;
	}
	public void setPay_no(int pay_no) {
		this.pay_no = pay_no;
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
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public int getPay_price() {
		return pay_price;
	}
	public void setPay_price(int pay_price) {
		this.pay_price = pay_price;
	}
	public Date getPay_complete_date() {
		return pay_complete_date;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setPay_complete_date(Date pay_complete_date) {
		this.pay_complete_date = pay_complete_date;
	}

	public int getLecture_price() {
		return lecture_price;
	}
	public void setLecture_price(int lecture_price) {
		this.lecture_price = lecture_price;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getLecture_title() {
		return lecture_title;
	}
	public void setLecture_title(String lecture_title) {
		this.lecture_title = lecture_title;
	}


	@Override
	public String toString() {
		return "payRequest [pay_no=" + pay_no + ", lecture_no=" + lecture_no + ", professor_id=" + professor_id
				+ ", student_id=" + student_id + ", class_name=" + class_name + ", pay_price=" + pay_price
				+ ", pay_complete_date=" + pay_complete_date + ", lecture_price=" + lecture_price + ", member_id="
				+ member_id + ", lecture_title=" + lecture_title + "]";
	}

	public payRequest(int pay_no, int lecture_no, String professor_id, String student_id, String class_name,
			int pay_price, Date pay_complete_date, String pay_method, int lecture_price, String member_id,
			String lecture_title) {
		super();
		this.pay_no = pay_no;
		this.lecture_no = lecture_no;
		this.professor_id = professor_id;
		this.student_id = student_id;
		this.class_name = class_name;
		this.pay_price = pay_price;
		this.pay_complete_date = pay_complete_date;
		this.lecture_price = lecture_price;
		this.member_id = member_id;
		this.lecture_title = lecture_title;
	} 
	
	
}                                    
