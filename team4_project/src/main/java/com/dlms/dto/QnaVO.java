package com.dlms.dto;

import java.util.Date;
/**
 * 
 * @사용목적		:	질의 문답 게시판
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	박진영
 * @마지막수정일	:	2020. 6. 1.오후 4:23:26
 * @see			:	
 *
 */
public class QnaVO {

	private int qna_no; 			// 질의문 번호
	private String qna_writer; 		// 작성자
	private String qna_answer; 		// 답변자
	private String qna_title; 		// 제목
	private String qna_content; 	// 내용
	private Date qna_regdate; 		// 질문 일자
	private String answer_content; 	// 답변내용
	private Date answer_date; 		// 답변날짜
	private int qna_viewcnt; 		// 조회수
	private int qna_status; 		// 답변유무 0이 기본값, 유 = 1, 무 = 0
	private String qna_password;
	private String qna_type;
	private String professor_id;
	public QnaVO() {}
	
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public String getQna_writer() {
		return qna_writer;
	}
	public void setQna_writer(String qna_writer) {
		this.qna_writer = qna_writer;
	}
	public String getQna_answer() {
		return qna_answer;
	}
	public void setQna_answer(String qna_answer) {
		this.qna_answer = qna_answer;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public Date getQna_regdate() {
		return qna_regdate;
	}
	public void setQna_regdate(Date qna_regdate) {
		this.qna_regdate = qna_regdate;
	}
	public String getAnswer_content() {
		return answer_content;
	}
	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}
	public Date getAnswer_date() {
		return answer_date;
	}
	public void setAnswer_date(Date answer_date) {
		this.answer_date = answer_date;
	}
	public int getQna_viewcnt() {
		return qna_viewcnt;
	}
	public void setQna_viewcnt(int qna_viewcnt) {
		this.qna_viewcnt = qna_viewcnt;
	}
	public int getQna_status() {
		return qna_status;
	}
	public void setQna_status(int qna_status) {
		this.qna_status = qna_status;
	}
	public String getQna_password() {
		return qna_password;
	}
	public void setQna_password(String qna_password) {
		this.qna_password = qna_password;
	}
	public String getQna_type() {
		return qna_type;
	}
	public void setQna_type(String qna_type) {
		this.qna_type = qna_type;
	}

	public String getProfessor_id() {
		return professor_id;
	}

	public void setProfessor_id(String professor_id) {
		this.professor_id = professor_id;
	}

	@Override
	public String toString() {
		return "QnaVO [qna_no=" + qna_no + ", qna_writer=" + qna_writer + ", qna_answer=" + qna_answer + ", qna_title="
				+ qna_title + ", qna_content=" + qna_content + ", qna_regdate=" + qna_regdate + ", answer_content="
				+ answer_content + ", answer_date=" + answer_date + ", qna_viewcnt=" + qna_viewcnt + ", qna_status="
				+ qna_status + ", qna_password=" + qna_password + ", qna_type=" + qna_type + ", professor_id="
				+ professor_id + "]";
	}

	public QnaVO(int qna_no, String qna_writer, String qna_answer, String qna_title, String qna_content,
			Date qna_regdate, String answer_content, Date answer_date, int qna_viewcnt, int qna_status,
			String qna_password, String qna_type, String professor_id) {
		super();
		this.qna_no = qna_no;
		this.qna_writer = qna_writer;
		this.qna_answer = qna_answer;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.qna_regdate = qna_regdate;
		this.answer_content = answer_content;
		this.answer_date = answer_date;
		this.qna_viewcnt = qna_viewcnt;
		this.qna_status = qna_status;
		this.qna_password = qna_password;
		this.qna_type = qna_type;
		this.professor_id = professor_id;
	}
	
	
	
}
