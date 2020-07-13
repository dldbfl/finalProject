package com.dlms.dto;

import java.util.Date;
/**
 * 
 * @사용목적		:	자유게시판	
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	연은주
 * @마지막수정일	:	2020. 6. 19
 * @see			:	
 *
 */
public class FreeBoardVO {

	private int freeboard_no; 			// 게시판 번호
	private String freeboard_title; 	// 제목
	private String member_id; 			// 수강생 / 교수
	private String freeboard_content; 	// 내용
	private Date freeboard_regdate; 	// 등록일자
	private int freeboard_viewcnt; 		// 조회수
	private String member_email;		// 이메일
	private int freeReplycnt;			//댓글갯수
	
	private int nextNo;					// 다음글
	private int prevNo;					// 이전글
	private String nextTitle;			// 다음제목
	private String prevTitle;			// 이전제목
	
	public FreeBoardVO() {
		super();
	}
	
	public FreeBoardVO(int freeboard_no, String freeboard_title, String member_id, String freeboard_content,
			Date freeboard_regdate, int freeboard_viewcnt, String member_email, int freeReplycnt, int nextNo,
			int prevNo, String nextTitle, String prevTitle) {
		super();
		this.freeboard_no = freeboard_no;
		this.freeboard_title = freeboard_title;
		this.member_id = member_id;
		this.freeboard_content = freeboard_content;
		this.freeboard_regdate = freeboard_regdate;
		this.freeboard_viewcnt = freeboard_viewcnt;
		this.member_email = member_email;
		this.freeReplycnt = freeReplycnt;
		this.nextNo = nextNo;
		this.prevNo = prevNo;
		this.nextTitle = nextTitle;
		this.prevTitle = prevTitle;
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
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public int getFreeReplycnt() {
		return freeReplycnt;
	}
	public void setFreeReplycnt(int freeReplycnt) {
		this.freeReplycnt = freeReplycnt;
	}
	public int getNextNo() {
		return nextNo;
	}
	public void setNextNo(int nextNo) {
		this.nextNo = nextNo;
	}
	public int getPrevNo() {
		return prevNo;
	}
	public void setPrevNo(int prevNo) {
		this.prevNo = prevNo;
	}
	public String getNextTitle() {
		return nextTitle;
	}
	public void setNextTitle(String nextTitle) {
		this.nextTitle = nextTitle;
	}
	public String getPrevTitle() {
		return prevTitle;
	}
	public void setPrevTitle(String prevTitle) {
		this.prevTitle = prevTitle;
	}
	@Override
	public String toString() {
		return "FreeBoardVO [freeboard_no=" + freeboard_no + ", freeboard_title=" + freeboard_title + ", member_id="
				+ member_id + ", freeboard_content=" + freeboard_content + ", freeboard_regdate=" + freeboard_regdate
				+ ", freeboard_viewcnt=" + freeboard_viewcnt + ", member_email=" + member_email + ", freeReplycnt="
				+ freeReplycnt + ", nextNo=" + nextNo + ", prevNo=" + prevNo + ", nextTitle=" + nextTitle
				+ ", prevTitle=" + prevTitle + "]";
	}
	
	
	
}
