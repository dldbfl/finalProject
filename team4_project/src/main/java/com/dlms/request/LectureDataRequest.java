package com.dlms.request;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.dlms.dto.LectureVO;
import com.dlms.dto.Lecture_dataVO;

/**
 * 
 * @사용목적		:	동영상 자료 수정용도
 * @작성자		    :	이누리
 * @작성날짜     	:	2020. 6. 27.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 27.오후 4:01:25
 * @see			    :	-
 *
 */
public class LectureDataRequest {

	private int lecture_no ;
	private String professor_id;
	private String manager_id;
	private String lecture_distinction;
	private String lecture_title;
	private Date lecture_progress;
	private Date lecture_recruit_date;
	private Date lecture_recruit_status;
	private int approval_code;
	private String lecture_img;
	private int lecture_price;
	private String lecture_content;
	private int lecture_data_no;
	private String lecture_data_filename;
	private int lecture_data_status;
	private Date lecture_data_regdate;
	private String lecture_data_image;    
	private Date lecture_end;
	private String draft_status; 
	private int lecture_data_favorites; 
	private String lecture_data_memo;           
	private String lecture_data_video;         
	private int lecture_lastview_time;   
		
	public int getLecture_data_favorites() {
		return lecture_data_favorites;
	}
	public void setLecture_data_favorites(int lecture_data_favorites) {
		this.lecture_data_favorites = lecture_data_favorites;
	}
	public String getLecture_data_memo() {
		return lecture_data_memo;
	}
	public void setLecture_data_memo(String lecture_data_memo) {
		this.lecture_data_memo = lecture_data_memo;
	}
	public String getLecture_data_video() {
		return lecture_data_video;
	}
	public void setLecture_data_video(String lecture_data_video) {
		this.lecture_data_video = lecture_data_video;
	}
	public int getLecture_lastview_time() {
		return lecture_lastview_time;
	}
	public void setLecture_lastview_time(int lecture_lastview_time) {
		this.lecture_lastview_time = lecture_lastview_time;
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
	public void setApproval_code(int approval_code) {
		this.approval_code = approval_code;
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
	public int getLecture_data_no() {
		return lecture_data_no;
	}
	public void setLecture_data_no(int lecture_data_no) {
		this.lecture_data_no = lecture_data_no;
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
	public String getLecture_data_image() {
		return lecture_data_image;
	}
	public void setLecture_data_image(String lecture_data_image) {
		this.lecture_data_image = lecture_data_image;
	}
	
	public Lecture_dataVO toLectureDataVO() {
		Lecture_dataVO lecture_data = new Lecture_dataVO();
		
		lecture_data.setLecture_data_favorites(lecture_data_favorites);
		lecture_data.setLecture_data_memo(lecture_data_memo);
		lecture_data.setLecture_data_video(lecture_data_video);
		lecture_data.setLecture_lastview_time(lecture_lastview_time);
		lecture_data.setLecture_data_filename(lecture_data_filename);
		lecture_data.setLecture_data_image(lecture_data_image);
		lecture_data.setLecture_data_no(lecture_data_no);
		lecture_data.setLecture_data_regdate(lecture_data_regdate);
		lecture_data.setLecture_data_status(lecture_data_status);
		lecture_data.setLecture_no(lecture_no);
		lecture_data.setProfessor_id(professor_id);

		return lecture_data;

	}
	@Override
	public String toString() {
		return "LectureDataRequest [lecture_no=" + lecture_no + ", professor_id=" + professor_id + ",lecture_data_no= "+ lecture_data_no 
				+ ", lecture_data_filename="
				+ lecture_data_filename +  ", lecture_data_image=" + lecture_data_image +  "]";
	}
	public Date getLecture_end() {
		return lecture_end;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setLecture_end(Date lecture_end) {
		this.lecture_end = lecture_end;
	}
	public String getDraft_status() {
		return draft_status;
	}
	public void setDraft_status(String draft_status) {
		this.draft_status = draft_status;
	}
	
}	