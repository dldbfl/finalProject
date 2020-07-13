package com.dlms.dto;

import java.util.Date;
/**
 * 
 * @사용목적		:	강의실을 참조하는 자료테이브	
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 7. 1.오후 05:03:38
 * @see			:	
 *
 */
public class Lecture_dataVO {

	private int lecture_data_no; 			// 자료실 번호
	private int lecture_no; 				// 교과목 번호
	private String professor_id; 			// 교과목 교수
	private String lecture_data_filename;   // 동영상파일명, 문서 명등..
	private int lecture_data_status; 		// 기본값 1 정지시 0 동영상 내리고 올릴때 사용
	private Date lecture_data_regdate;	    // 등록일자
	private String lecture_data_video;		// 동영상 여부
	private String lecture_data_image;		// 영상 썸네일 이미지
	private int lecture_lastview_time; 		// 영상 종료시간- 이어보기용
	private String lecture_data_memo;		// 영상 필기
	private int lecture_data_favorites;		// 영상 즐겨찾기
	
	public Lecture_dataVO() {};
	
	public int getLecture_data_no() {
		return lecture_data_no;
	}
	public void setLecture_data_no(int lecture_data_no) {
		this.lecture_data_no = lecture_data_no;
	}
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
	public String getLecture_data_filename() {
		return lecture_data_filename;
	}
	public void setLecture_data_filename(String lecture_data_filename) {
		this.lecture_data_filename = lecture_data_filename;
	}
	public int getLecture_data_status() {
		return lecture_data_status;
	}
	public void setLecture_data_status(int lecture_data_status) {
		this.lecture_data_status = lecture_data_status;
	}
	public Date getLecture_data_regdate() {
		return lecture_data_regdate;
	}
	public void setLecture_data_regdate(Date lecture_data_regdate) {
		this.lecture_data_regdate = lecture_data_regdate;
	}
	public String getLecture_data_video() {
		return lecture_data_video;
	}
	public void setLecture_data_video(String lecture_data_video) {
		this.lecture_data_video = lecture_data_video;
	}
	
	public String getLecture_data_image() {
		return lecture_data_image;
	}

	public void setLecture_data_image(String lecture_data_image) {
		this.lecture_data_image = lecture_data_image;
	}

	public int getLecture_lastview_time() {
		return lecture_lastview_time;
	}

	public void setLecture_lastview_time(int lecture_lastview_time) {
		this.lecture_lastview_time = lecture_lastview_time;
	}

	public String getLecture_data_memo() {
		return lecture_data_memo;
	}

	public void setLecture_data_memo(String lecture_data_memo) {
		this.lecture_data_memo = lecture_data_memo;
	}

	public int getLecture_data_favorites() {
		return lecture_data_favorites;
	}

	public void setLecture_data_favorites(int lecture_data_favorites) {
		this.lecture_data_favorites = lecture_data_favorites;
	}

	@Override
	public String toString() {
		return "Lecture_dataVO [lecture_data_no=" + lecture_data_no + ", lecture_no=" + lecture_no + ", professor_id="
				+ professor_id + ", lecture_data_filename=" + lecture_data_filename + ", lecture_data_status="
				+ lecture_data_status + ", lecture_data_regdate=" + lecture_data_regdate + ", lecture_data_video="
				+ lecture_data_video + ", lecture_data_image=" + lecture_data_image + ", lecture_lastview_time="
				+ lecture_lastview_time + ", lecture_data_memo=" + lecture_data_memo + ", lecture_data_favorites="
				+ lecture_data_favorites + "]";
	}

	public Lecture_dataVO(int lecture_data_no, int lecture_no, String professor_id, String lecture_data_filename,
			int lecture_data_status, Date lecture_data_regdate, String lecture_data_video, String lecture_data_image,
			int lecture_lastview_time, String lecture_data_memo, int lecture_data_favorites) {
		super();
		this.lecture_data_no = lecture_data_no;
		this.lecture_no = lecture_no;
		this.professor_id = professor_id;
		this.lecture_data_filename = lecture_data_filename;
		this.lecture_data_status = lecture_data_status;
		this.lecture_data_regdate = lecture_data_regdate;
		this.lecture_data_video = lecture_data_video;
		this.lecture_data_image = lecture_data_image;
		this.lecture_lastview_time = lecture_lastview_time;
		this.lecture_data_memo = lecture_data_memo;
		this.lecture_data_favorites = lecture_data_favorites;
	}
	
	
	

}
