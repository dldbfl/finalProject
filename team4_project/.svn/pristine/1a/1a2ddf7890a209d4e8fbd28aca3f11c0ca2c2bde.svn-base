package com.dlms.request;

import java.util.Date;

import com.dlms.dto.FreeBoardVO;



public class FreeboardRequest {
	private int freeboard_no; 			// 게시판 번호
	private String freeboard_title; 	// 제목
	private String member_id; 			// 수강생 / 교수
	private String freeboard_content; 	// 내용
	private Date freeboard_regdate; 	// 등록일자
	private int freeboard_viewcnt; 		// 조회수
	

	public FreeboardRequest() {}

	public FreeboardRequest(int freeboard_no, String freeboard_title, String member_id, String freeboard_content,
			Date freeboard_regdate, int freeboard_viewcnt) {
		super();
		this.freeboard_no = freeboard_no;
		this.freeboard_title = freeboard_title;
		this.member_id = member_id;
		this.freeboard_content = freeboard_content;
		this.freeboard_regdate = freeboard_regdate;
		this.freeboard_viewcnt = freeboard_viewcnt;
	}

	public int getFreeboard_no() {
		return freeboard_no;
	}

	public void setFreeboard_no(int freeboard_no) {
		this.freeboard_no = freeboard_no;
	}

	public String getFreeboard_title() {
		return freeboard_title;
	}

	public void setFreeboard_title(String freeboard_title) {
		this.freeboard_title = freeboard_title;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getFreeboard_content() {
		return freeboard_content;
	}

	public void setFreeboard_content(String freeboard_content) {
		this.freeboard_content = freeboard_content;
	}

	public Date getFreeboard_regdate() {
		return freeboard_regdate;
	}

	public void setFreeboard_regdate(Date freeboard_regdate) {
		this.freeboard_regdate = freeboard_regdate;
	}

	public int getFreeboard_viewcnt() {
		return freeboard_viewcnt;
	}

	public void setFreeboard_viewcnt(int freeboard_viewcnt) {
		this.freeboard_viewcnt = freeboard_viewcnt;
	}
	
	@Override
	public String toString() {
		return "FreeboardRequest [freeboard_no=" + freeboard_no + ", freeboard_title=" + freeboard_title
				+ ", member_id=" + member_id + ", freeboard_content=" + freeboard_content + ", freeboard_regdate="
				+ freeboard_regdate + ", freeboard_viewcnt=" + freeboard_viewcnt + "]";
	}
	
	public FreeBoardVO tofreeboardVO() {
		FreeBoardVO board = new FreeBoardVO();
		board.setFreeboard_no(freeboard_no);
		board.setFreeboard_title(freeboard_title);
		board.setFreeboard_content(freeboard_content);

		return board;
	}
}
