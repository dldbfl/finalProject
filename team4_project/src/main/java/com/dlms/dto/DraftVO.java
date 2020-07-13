package com.dlms.dto;

import java.util.List;

/**
 * 
 * @사용목적		:	기안서 리스트
 * @작성자		    :	이누리
 * @작성날짜     	:	2020. 6. 10.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 10.오전 11:11:39
 * @see			    :	-
 *
 */
public class DraftVO {
	
	public int draft_no;
	public String professor_id;
	public String manager_id;
	public String draft_regdate;
	public String draft_deadline;
	public String draft_title;
	public int draft_check;
	public String draft_content;
	public String draft_status;
	public String draft_approveddate;
	public int lecture_data_no;
	
	private List<Draft_AttachVO> draftFileList;
	public DraftVO(){}
	
	public List<Draft_AttachVO> getDraftFileList() {
		return draftFileList;
	}

	public void setDraftFileList(List<Draft_AttachVO> documentFileList) {
		this.draftFileList = documentFileList;
	}

	public int getDraft_no() {
		return draft_no;
	}

	public void setDraft_no(int draft_no) {
		this.draft_no = draft_no;
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

	public String getDraft_regdate() {
		return draft_regdate;
	}

	public void setDraft_regdate(String draft_regdate) {
		this.draft_regdate = draft_regdate;
	}

	public String getDraft_deadline() {
		return draft_deadline;
	}

	public void setDraft_deadline(String draft_deadline) {
		this.draft_deadline = draft_deadline;
	}

	public String getDraft_title() {
		return draft_title;
	}

	public void setDraft_title(String draft_title) {
		this.draft_title = draft_title;
	}

	public String getDraft_content() {
		return draft_content;
	}

	public void setDraft_content(String draft_content) {
		this.draft_content = draft_content;
	}

	public String getDraft_status() {
		return draft_status;
	}

	public void setDraft_status(String draft_status) {
		this.draft_status = draft_status;
	}

	public String getDraft_approveddate() {
		return draft_approveddate;
	}

	public void setDraft_approveddate(String draft_approveddate) {
		this.draft_approveddate = draft_approveddate;
	}

	public int getDraft_check() {
		return draft_check;
	}

	public void setDraft_check(int draft_check) {
		this.draft_check = draft_check;
	}

	
	public int getLecture_data_no() {
		return lecture_data_no;
	}

	public void setLecture_data_no(int lecture_data_no) {
		this.lecture_data_no = lecture_data_no;
	}

	@Override
	public String toString() {
		return "DraftVO [draft_no=" + draft_no + ", professor_id=" + professor_id + ", manager_id=" + manager_id
				+ ", draft_regdate=" + draft_regdate + ", draft_deadline=" + draft_deadline + ", draft_title="
				+ draft_title + ", draft_check=" + draft_check + ", draft_content=" + draft_content + ", draft_status="
				+ draft_status + ", draft_approveddate=" + draft_approveddate + ", draftFileList=" + draftFileList
				+ "]";
	}

	public DraftVO(int draft_no, String professor_id, String manager_id, String draft_regdate, String draft_deadline,
			String draft_title, int draft_check, String draft_content, String draft_status, String draft_approveddate,
			List<Draft_AttachVO> draftFileList) {
		super();
		this.draft_no = draft_no;
		this.professor_id = professor_id;
		this.manager_id = manager_id;
		this.draft_regdate = draft_regdate;
		this.draft_deadline = draft_deadline;
		this.draft_title = draft_title;
		this.draft_check = draft_check;
		this.draft_content = draft_content;
		this.draft_status = draft_status;
		this.draft_approveddate = draft_approveddate;
		this.draftFileList = draftFileList;
	}

	
	
	
	
	
}
