package com.dlms.dto;

import java.util.Date;
import java.util.List;

/**
 * 
 * @사용목적		:	공지사항 게시판
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	박진영
 * @마지막수정일	:	2020. 6. 1.오후 4:18:42
 * @see			:	
 *
 */
public class NoticeVO {
	private int notice_no;				// 공지사항 번호
	private String notice_title;		// 제목	
	private String notice_writer;		// 관리자
	private String notice_content;		// 내용
	private Date notice_regdate;		// 등록일자
	private Date notice_update_date;	// 수정일자
	private int notice_viewcnt;			// 조회수
	private String notice_point;		// 중요공지글 코드번호
	private int nextNo;					// 다음글
	private int prevNo;					// 이전글
	private String nextTitle;			// 다음제목
	private String prevTitle;			// 이전제목
	private Date notice_finishdate;		// 게시글 마감날짜
	
	private List<Notice_dataVO> notice_attach; // 첨부파일 리스트

	
	
	public NoticeVO() {
		super();
	}



	public int getNotice_no() {
		return notice_no;
	}



	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}



	public String getNotice_title() {
		return notice_title;
	}



	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}



	public String getNotice_writer() {
		return notice_writer;
	}



	public void setNotice_writer(String notice_writer) {
		this.notice_writer = notice_writer;
	}



	public String getNotice_content() {
		return notice_content;
	}



	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}



	public Date getNotice_regdate() {
		return notice_regdate;
	}



	public void setNotice_regdate(Date notice_regdate) {
		this.notice_regdate = notice_regdate;
	}



	public Date getNotice_update_date() {
		return notice_update_date;
	}



	public void setNotice_update_date(Date notice_update_date) {
		this.notice_update_date = notice_update_date;
	}



	public int getNotice_viewcnt() {
		return notice_viewcnt;
	}



	public void setNotice_viewcnt(int notice_viewcnt) {
		this.notice_viewcnt = notice_viewcnt;
	}



	public String getNotice_point() {
		return notice_point;
	}



	public void setNotice_point(String notice_point) {
		this.notice_point = notice_point;
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



	public Date getNotice_finishdate() {
		return notice_finishdate;
	}



	public void setNotice_finishdate(Date notice_finishdate) {
		this.notice_finishdate = notice_finishdate;
	}



	public List<Notice_dataVO> getNotice_attach() {
		return notice_attach;
	}



	public void setNotice_attach(List<Notice_dataVO> notice_attach) {
		this.notice_attach = notice_attach;
	}



	@Override
	public String toString() {
		return "NoticeVO [notice_no=" + notice_no + ", notice_title=" + notice_title + ", notice_writer="
				+ notice_writer + ", notice_content=" + notice_content + ", notice_regdate=" + notice_regdate
				+ ", notice_update_date=" + notice_update_date + ", notice_viewcnt=" + notice_viewcnt
				+ ", notice_point=" + notice_point + ", nextNo=" + nextNo + ", prevNo=" + prevNo + ", nextTitle="
				+ nextTitle + ", prevTitle=" + prevTitle + ", notice_finishdate=" + notice_finishdate
				+ ", notice_attach=" + notice_attach + "]";
	}



	public NoticeVO(int notice_no, String notice_title, String notice_writer, String notice_content,
			Date notice_regdate, Date notice_update_date, int notice_viewcnt, String notice_point, int nextNo,
			int prevNo, String nextTitle, String prevTitle, Date notice_finishdate, List<Notice_dataVO> notice_attach) {
		super();
		this.notice_no = notice_no;
		this.notice_title = notice_title;
		this.notice_writer = notice_writer;
		this.notice_content = notice_content;
		this.notice_regdate = notice_regdate;
		this.notice_update_date = notice_update_date;
		this.notice_viewcnt = notice_viewcnt;
		this.notice_point = notice_point;
		this.nextNo = nextNo;
		this.prevNo = prevNo;
		this.nextTitle = nextTitle;
		this.prevTitle = prevTitle;
		this.notice_finishdate = notice_finishdate;
		this.notice_attach = notice_attach;
	}



	
	
	
	
	
	

	


}
