package com.dlms.dto;

import java.sql.Date;

/**
 * 
 * @사용목적		:	댓글VO	
 * @작성자		:	연은주
 * @작성날짜      	:	2020. 6. 2.
 * @마지막수정자	:	연은주
 * @마지막수정일	:	2020. 6. 2.오후 2:01:17
 * @see			:	
 *
 */
public class FreeBoard_ReplyVO {
	private int freeboard_reply_no; 		//댓글 번호 
	private int freeboard_no;				//게시글 번호
	private String freeboard_reply_content;	//댓글 내용
	private Date freeboard_reply_regdate;	//댓글 입력날짜
	private String freeboard_reply_replyer;	//댓글 작성자
	
	public FreeBoard_ReplyVO() {}

	public FreeBoard_ReplyVO(int freeboard_reply_no, int freeboard_no, String freeboard_reply_content,
			Date freeboard_reply_regdate, String freeboard_reply_replyer) {
		super();
		this.freeboard_reply_no = freeboard_reply_no;
		this.freeboard_no = freeboard_no;
		this.freeboard_reply_content = freeboard_reply_content;
		this.freeboard_reply_regdate = freeboard_reply_regdate;
		this.freeboard_reply_replyer = freeboard_reply_replyer;
	}

	public int getFreeboard_reply_no() {
		return freeboard_reply_no;
	}

	public void setFreeboard_reply_no(int freeboard_reply_no) {
		this.freeboard_reply_no = freeboard_reply_no;
	}

	public int getFreeboard_no() {
		return freeboard_no;
	}

	public void setFreeboard_no(int freeboard_no) {
		this.freeboard_no = freeboard_no;
	}

	public String getFreeboard_reply_content() {
		return freeboard_reply_content;
	}

	public void setFreeboard_reply_content(String freeboard_reply_content) {
		this.freeboard_reply_content = freeboard_reply_content;
	}

	public Date getFreeboard_reply_regdate() {
		return freeboard_reply_regdate;
	}

	public void setFreeboard_reply_regdate(Date freeboard_reply_regdate) {
		this.freeboard_reply_regdate = freeboard_reply_regdate;
	}

	public String getFreeboard_reply_replyer() {
		return freeboard_reply_replyer;
	}

	public void setFreeboard_reply_replyer(String freeboard_reply_replyer) {
		this.freeboard_reply_replyer = freeboard_reply_replyer;
	}

	@Override
	public String toString() {
		return "FreeBoard_ReplyVO [freeboard_reply_no=" + freeboard_reply_no + ", freeboard_no=" + freeboard_no
				+ ", freeboard_reply_content=" + freeboard_reply_content + ", freeboard_reply_regdate="
				+ freeboard_reply_regdate + ", freeboard_reply_replyer=" + freeboard_reply_replyer + "]";
	}
	
	
	
}
