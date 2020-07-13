package com.dlms.dto;

import java.util.Date;
/**
 * 
 *
 * @기능설명		:	응권글 리스트 
 * @작성자		:	강현철
 * @작성날짜		:	2020. 6. 28.
 * @마지막수정자	:	강현철
 * @마지막수정일	:	2020. 6. 28.오후 12:17:47
 */
public class CheerVO {

	private int cheer_no;			//응원글번호
	private String cheer_writer;	//작성자
	private String cheer_content;	//작성자내용
	private Date cheer_regdate;		//작성날짜
	
	
	public CheerVO() {}

	
	public int getCheer_no() {
		return cheer_no;
	}

	public void setCheer_no(int cheer_no) {
		this.cheer_no = cheer_no;
	}

	public String getCheer_writer() {
		return cheer_writer;
	}

	public void setCheer_writer(String cheer_writer) {
		this.cheer_writer = cheer_writer;
	}

	public String getCheer_content() {
		return cheer_content;
	}

	public void setCheer_content(String cheer_content) {
		this.cheer_content = cheer_content;
	}

	public Date getCheer_regdate() {
		return cheer_regdate;
	}

	public void setCheer_regdate(Date cheer_regdate) {
		this.cheer_regdate = cheer_regdate;
	}

	@Override
	public String toString() {
		return "CheerVO [cheer_no=" + cheer_no + ", cheer_writer=" + cheer_writer + ", cheer_content=" + cheer_content
				+ ", cheer_regdate=" + cheer_regdate + "]";
	}

	public CheerVO(int cheer_no, String cheer_writer, String cheer_content, Date cheer_regdate) {
		super();
		this.cheer_no = cheer_no;
		this.cheer_writer = cheer_writer;
		this.cheer_content = cheer_content;
		this.cheer_regdate = cheer_regdate;
	}
	
	
}
