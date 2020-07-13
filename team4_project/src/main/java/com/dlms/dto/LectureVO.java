package com.dlms.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 
 * @사용목적		:	강의실	
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 29
 * @see			:	
 *
 * lecture_img 추가(은주)
 * lecture_distinction 타입 수정 Spring >> Date
 */
public class LectureVO {

	private int lecture_no; 					// 강의 번호
	private String professor_id; 				// 담당교수
	private String manager_id; 					// 관리자
	private String lecture_distinction; 		// 교과목 구분
	private String lecture_title; 				// 제목
	private Date lecture_progress; 				// 진행할 기간
	private Date lecture_recruit_date;		    // 모집할 기간
	private Date lecture_recruit_status; 		// 모집 종료등
	private int approval_code; 					// 결재 코드
	private String lecture_img;					// 모집강의 이미지
	private int lecture_price;					// 강의금액
	private String lecture_content;				// 강의내용
	private Date lecture_end;					// 강의종료일
	
	public LectureVO() {}

	public int getLecture_no() {
		return lecture_no;
	}

	public void setLecture_no(int lecture_no) {
		this.lecture_no = lecture_no;
	}

	public String getProfessor_id() {
		return professor_id;
	}

	public void setProfessor_id(String professor_id) {
		this.professor_id = professor_id;
	}

	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

	public String getLecture_distinction() {
		return lecture_distinction;
	}

	public void setLecture_distinction(String lecture_distinction) {
		this.lecture_distinction = lecture_distinction;
	}

	public String getLecture_title() {
		return lecture_title;
	}

	public void setLecture_title(String lecture_title) {
		this.lecture_title = lecture_title;
	}

	public Date getLecture_progress() {
		return lecture_progress;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setLecture_progress(Date lecture_progress) {
		this.lecture_progress = lecture_progress;
	}

	public Date getLecture_recruit_date() {
		return lecture_recruit_date;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setLecture_recruit_date(Date lecture_recruit_date) {
		this.lecture_recruit_date = lecture_recruit_date;
	}
	
	public Date getLecture_recruit_status() {
		return lecture_recruit_status;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setLecture_recruit_status(Date lecture_recruit_status) {
		this.lecture_recruit_status = lecture_recruit_status;
	}

	public int getApproval_code() {
		return approval_code;
	}

	public void setApproval_code(int i) {
		this.approval_code = i;
	}

	public String getLecture_img() {
		return lecture_img;
	}

	public void setLecture_img(String lecture_img) {
		this.lecture_img = lecture_img;
	}

	public int getLecture_price() {
		return lecture_price;
	}

	public void setLecture_price(int lecture_price) {
		this.lecture_price = lecture_price;
	}

	public String getLecture_content() {
		return lecture_content;
	}

	public void setLecture_content(String lecture_content) {
		this.lecture_content = lecture_content;
	}

	public Date getLecture_end() {
		return lecture_end;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setLecture_end(Date lecture_end) {
		this.lecture_end = lecture_end;
	}

	public LectureVO(int lecture_no, String professor_id, String manager_id, String lecture_distinction,
			String lecture_title, Date lecture_progress, Date lecture_recruit_date, Date lecture_recruit_status,
			int approval_code, String lecture_img, int lecture_price, String lecture_content, Date lecture_end) {
		super();
		this.lecture_no = lecture_no;
		this.professor_id = professor_id;
		this.manager_id = manager_id;
		this.lecture_distinction = lecture_distinction;
		this.lecture_title = lecture_title;
		this.lecture_progress = lecture_progress;
		this.lecture_recruit_date = lecture_recruit_date;
		this.lecture_recruit_status = lecture_recruit_status;
		this.approval_code = approval_code;
		this.lecture_img = lecture_img;
		this.lecture_price = lecture_price;
		this.lecture_content = lecture_content;
		this.lecture_end = lecture_end;
	}

	@Override
	public String toString() {
		return "LectureVO [lecture_no=" + lecture_no + ", professor_id=" + professor_id + ", manager_id=" + manager_id
				+ ", lecture_distinction=" + lecture_distinction + ", lecture_title=" + lecture_title
				+ ", lecture_progress=" + lecture_progress + ", lecture_recruit_date=" + lecture_recruit_date
				+ ", lecture_recruit_status=" + lecture_recruit_status + ", approval_code=" + approval_code
				+ ", lecture_img=" + lecture_img + ", lecture_price=" + lecture_price + ", lecture_content="
				+ lecture_content + ", lecture_end=" + lecture_end + "]";
	}
	

	
}
