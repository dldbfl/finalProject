package com.dlms.request;

import java.util.Date;

import com.dlms.dto.QnaVO;

/**
 * 
 * @사용목적		:	등록에 필요한 Request
 * @작성자		:	민태홍
 * @작성날짜      	:	2020. 6. 10.
 * @마지막수정자	:	민태홍
 * @마지막수정일	:	2020. 6. 10.오후 3:14:24
 * @see			:	
 *
 */
public class QnARequest {

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
	private String professor_id;
	private String qna_password;
	private String qna_type;
	
	public QnARequest() {}

	




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


	public QnaVO toRegistQnAVO() {
		QnaVO qna = new QnaVO();
		
		qna.setQna_title(this.qna_title);
		qna.setQna_writer(this.qna_writer);
		qna.setQna_content(this.qna_content);
		qna.setQna_password(this.qna_password);
		qna.setQna_type(this.qna_type);
		
		return qna;
		
	}
	
	public QnaVO toAnswerVO() {
		QnaVO qna = new QnaVO();
		qna.setQna_answer(this.qna_answer);
		qna.setAnswer_content(this.answer_content);
		qna.setQna_no(this.qna_no);
		
		return qna;
	}
	
	public QnaVO toModifyVO() {
		QnaVO qna = new QnaVO();
		qna.setQna_no(this.qna_no);
		qna.setQna_title(this.qna_title);
		qna.setQna_writer(this.qna_writer);
		qna.setQna_content(this.qna_content);
		qna.setQna_password(this.qna_password);
		qna.setQna_type(this.qna_type);
		return qna;
	}


	public String getProfessor_id() {
		return professor_id;
	}


	public void setProfessor_id(String professor_id) {
		this.professor_id = professor_id;
	}

}
