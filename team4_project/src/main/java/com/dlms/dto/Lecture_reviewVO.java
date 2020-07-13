package com.dlms.dto;

import java.util.Date;
import java.util.List;
/**
 * 
 * @사용목적		:	수강후기 게시판	
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	박진영
 * @마지막수정일	:	2020. 6. 1.오후 3:49:42
 * @see			:	
 *
 */

public class Lecture_reviewVO {


	private int lecture_review_no          ;// 수강후기 번호
	private int pay_no                     ;// 결제 번호
	private String lecture_review_title       ;// 수강후기 제목
	private String lecture_review_writer      ;// 수강후기 작성자
	private String lecture_review_content     ;// 수강후기 내용
	private Date lecture_review_regdate     ;// 수강후기 등록일자
	private int lecture_review_viewcnt     ;// 수강후기 조회수
	private int lecture_review_likecnt     ;// 수강후기 좋아요수
	private List<Lecture_review_imgVO> lectureReviewImageFileList;
	
	
	
	
	
	public Lecture_reviewVO() {
		super();
	}
	
	
	
	
	public int getLecture_review_no() {
		return lecture_review_no;
	}




	public void setLecture_review_no(int lecture_review_no) {
		this.lecture_review_no = lecture_review_no;
	}




	public int getPay_no() {
		return pay_no;
	}




	public void setPay_no(int pay_no) {
		this.pay_no = pay_no;
	}




	public String getLecture_review_title() {
		return lecture_review_title;
	}




	public void setLecture_review_title(String lecture_review_title) {
		this.lecture_review_title = lecture_review_title;
	}




	public String getLecture_review_writer() {
		return lecture_review_writer;
	}




	public void setLecture_review_writer(String lecture_review_writer) {
		this.lecture_review_writer = lecture_review_writer;
	}




	public String getLecture_review_content() {
		return lecture_review_content;
	}




	public void setLecture_review_content(String lecture_review_content) {
		this.lecture_review_content = lecture_review_content;
	}




	public Date getLecture_review_regdate() {
		return lecture_review_regdate;
	}




	public void setLecture_review_regdate(Date lecture_review_regdate) {
		this.lecture_review_regdate = lecture_review_regdate;
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




	@Override
	public String toString() {
		return "Lecture_reviewVO [lecture_review_no=" + lecture_review_no + ", pay_no=" + pay_no
				+ ", lecture_review_title=" + lecture_review_title + ", lecture_review_writer=" + lecture_review_writer
				+ ", lecture_review_content=" + lecture_review_content + ", lecture_review_regdate="
				+ lecture_review_regdate + ", lecture_review_viewcnt=" + lecture_review_viewcnt
				+ ", lecture_review_likecnt=" + lecture_review_likecnt + ", lectureReviewImageFileList="
				+ lectureReviewImageFileList + "]";
	}




	public Lecture_reviewVO(int lecture_review_no, int pay_no, String lecture_review_title,
			String lecture_review_writer, String lecture_review_content, Date lecture_review_regdate,
			int lecture_review_viewcnt, int lecture_review_likecnt,
			List<Lecture_review_imgVO> lectureReviewImageFileList) {
		super();
		this.lecture_review_no = lecture_review_no;
		this.pay_no = pay_no;
		this.lecture_review_title = lecture_review_title;
		this.lecture_review_writer = lecture_review_writer;
		this.lecture_review_content = lecture_review_content;
		this.lecture_review_regdate = lecture_review_regdate;
		this.lecture_review_viewcnt = lecture_review_viewcnt;
		this.lecture_review_likecnt = lecture_review_likecnt;
		this.lectureReviewImageFileList = lectureReviewImageFileList;
	}




	public List<Lecture_review_imgVO> getLectureReviewImageFileList() {
		return lectureReviewImageFileList;
	}
	public void setLectureReviewImageFileList(List<Lecture_review_imgVO> lectureReviewImageFileList) {
		this.lectureReviewImageFileList = lectureReviewImageFileList;
	}

	

	
}
