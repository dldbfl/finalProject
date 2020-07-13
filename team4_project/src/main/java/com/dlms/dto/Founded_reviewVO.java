package com.dlms.dto;

import java.util.Date;
import java.util.List;
/**
 * 
 * @사용목적		:	창업후기 게시판	
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	연은주
 * @마지막수정일	:	2020. 6. 3
 * @see			:	
 *
 */
public class Founded_reviewVO {

	private int founded_review_no; 			 // 후기글 번호
	private String founded_review_title; 	 // 제목
	private String founded_review_writer;	 // 수강생
	private String founded_review_content;	 // 내용
	private Date founded_review_regdate;	 // 등록일자
	private int founded_review_viewcnt; 	 // 조회수

	
	public Founded_reviewVO() {}


	public int getFounded_review_no() {
		return founded_review_no;
	}


	public void setFounded_review_no(int founded_review_no) {
		this.founded_review_no = founded_review_no;
	}


	public String getFounded_review_title() {
		return founded_review_title;
	}


	public void setFounded_review_title(String founded_review_title) {
		this.founded_review_title = founded_review_title;
	}


	public String getFounded_review_writer() {
		return founded_review_writer;
	}


	public void setFounded_review_writer(String founded_review_writer) {
		this.founded_review_writer = founded_review_writer;
	}


	public String getFounded_review_content() {
		return founded_review_content;
	}


	public void setFounded_review_content(String founded_review_content) {
		this.founded_review_content = founded_review_content;
	}


	public Date getFounded_review_regdate() {
		return founded_review_regdate;
	}


	public void setFounded_review_regdate(Date founded_review_regdate) {
		this.founded_review_regdate = founded_review_regdate;
	}


	public int getFounded_review_viewcnt() {
		return founded_review_viewcnt;
	}


	public void setFounded_review_viewcnt(int founded_review_viewcnt) {
		this.founded_review_viewcnt = founded_review_viewcnt;
	}


	@Override
	public String toString() {
		return "Founded_reviewVO [founded_review_no=" + founded_review_no + ", founded_review_title="
				+ founded_review_title + ", founded_review_writer=" + founded_review_writer
				+ ", founded_review_content=" + founded_review_content + ", founded_review_regdate="
				+ founded_review_regdate + ", founded_review_viewcnt=" + founded_review_viewcnt + "]";
	}


	public Founded_reviewVO(int founded_review_no, String founded_review_title, String founded_review_writer,
			String founded_review_content, Date founded_review_regdate, int founded_review_viewcnt) {
		super();
		this.founded_review_no = founded_review_no;
		this.founded_review_title = founded_review_title;
		this.founded_review_writer = founded_review_writer;
		this.founded_review_content = founded_review_content;
		this.founded_review_regdate = founded_review_regdate;
		this.founded_review_viewcnt = founded_review_viewcnt;
	}


}
