package com.dlms.dto;

import java.util.Date;
/**
 * 
 * @사용목적		:	수강후기테이블을 참조하는 이미지데이터
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	박진영
 * @마지막수정일	:	2020. 6. 1.오후 3:48:34
 * @see			:	
 *
 */
public class Lecture_review_imgVO {

	private int lecture_review_img_no; 			// 수강후기 이미지 번호
	private int lecture_review_no; 				// 수강후기 번호
	private String lecture_review_img_name; 		// 수강후기 이미지명
	private Date lecture_review_img_regdate; 		// 수강후기 이미지 등록일자
	
	public Lecture_review_imgVO() {}
	public int getLecture_review_img_no() {
		return lecture_review_img_no;
	}
	public void setLecture_review_img_no(int lecture_review_img_no) {
		this.lecture_review_img_no = lecture_review_img_no;
	}
	public int getLecture_review_no() {
		return lecture_review_no;
	}
	public void setLecture_review_no(int lecture_review_no) {
		this.lecture_review_no = lecture_review_no;
	}
	public String getLecture_review_img_name() {
		return lecture_review_img_name;
	}
	public void setLecture_review_img_name(String lecture_review_img_name) {
		this.lecture_review_img_name = lecture_review_img_name;
	}
	public Date getLecture_review_img_regdate() {
		return lecture_review_img_regdate;
	}
	public void setLecture_review_img_regdate(Date lecture_review_img_regdate) {
		this.lecture_review_img_regdate = lecture_review_img_regdate;
	}
	@Override
	public String toString() {
		return "Lecture_review_imgVO [lecture_review_img_no=" + lecture_review_img_no + ", lecture_review_no="
				+ lecture_review_no + ", lecture_review_img_name=" + lecture_review_img_name
				+ ", lecture_review_img_regdate=" + lecture_review_img_regdate + ", getLecture_review_img_no()="
				+ getLecture_review_img_no() + ", getLecture_review_no()=" + getLecture_review_no()
				+ ", getLecture_review_img_name()=" + getLecture_review_img_name()
				+ ", getLecture_review_img_regdate()=" + getLecture_review_img_regdate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public Lecture_review_imgVO(int lecture_review_img_no, int lecture_review_no, String lecture_review_img_name,
			Date lecture_review_img_regdate) {
		super();
		this.lecture_review_img_no = lecture_review_img_no;
		this.lecture_review_no = lecture_review_no;
		this.lecture_review_img_name = lecture_review_img_name;
		this.lecture_review_img_regdate = lecture_review_img_regdate;
	}

}
