package com.dlms.request;

import java.util.Date;
import java.util.List;

public class LectureReviewRequest {
	
	private String lecture_title;
	private int pay_no;
	private int review_check;
	private int lecture_review_no;
	private String lecture_review_title;
	private String member_name;
	private String lecture_review_content;
	private int lecture_review_viewcnt;
	private int lecture_review_likecnt;
	private Date lecture_review_regdate;
	private String lecture_img;
	private List<String>lecture_img_list;
	
	public int getLecture_review_no() {
		return lecture_review_no;
	}
	public void setLecture_review_no(int lecture_review_no) {
		this.lecture_review_no = lecture_review_no;
	}
	public String getLecture_title() {
		return lecture_title;
	}
	public void setLecture_title(String lecture_title) {
		this.lecture_title = lecture_title;
	}
	public String getLecture_review_title() {
		return lecture_review_title;
	}
	public void setLecture_review_title(String lecture_review_title) {
		this.lecture_review_title = lecture_review_title;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getLecture_review_content() {
		return lecture_review_content;
	}
	public void setLecture_review_content(String lecture_review_content) {
		this.lecture_review_content = lecture_review_content;
	}
	public int getLecture_review_viewcnt() {
		return lecture_review_viewcnt;
	}
	public void setLecture_review_viewcnt(int lecture_review_viewcnt) {
		this.lecture_review_viewcnt = lecture_review_viewcnt;
	}
	public int getLecture_review_likecnt() {
		return lecture_review_likecnt;
	}
	public void setLecture_review_likecnt(int lecture_review_likecnt) {
		this.lecture_review_likecnt = lecture_review_likecnt;
	}
	public Date getLecture_review_regdate() {
		return lecture_review_regdate;
	}
	public void setLecture_review_regdate(Date lecture_review_regdate) {
		this.lecture_review_regdate = lecture_review_regdate;
	}
	public List<String> getLecture_img_list() {
		return lecture_img_list;
	}
	public void setLecture_img_list(List<String> lecture_img_list) {
		this.lecture_img_list = lecture_img_list;
	}
	public int getPay_no() {
		return pay_no;
	}
	public void setPay_no(int pay_no) {
		this.pay_no = pay_no;
	}
	public int getReview_check() {
		return review_check;
	}
	public void setReview_check(int review_check) {
		this.review_check = review_check;
	}
	public String getLecture_img() {
		return lecture_img;
	}
	public void setLecture_img(String lecture_img) {
		this.lecture_img = lecture_img;
	}
		
}
