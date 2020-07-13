package com.dlms.dto;

/**
 * 
 * @사용목적		:	기안서 파일용
 * @작성자		    :	이누리
 * @작성날짜     	:	2020. 6. 10.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 10.오전 11:13:57
 * @see			    :	-
 *
 */
public class Draft_AttachVO {
	public int draft_attach_no;
	public int draft_no;
	public String draft_attach_filename;
	
	public Draft_AttachVO() {}

	public int getDraft_attach_no() {
		return draft_attach_no;
	}

	public void setDraft_attach_no(int draft_attach_no) {
		this.draft_attach_no = draft_attach_no;
	}

	public int getDraft_no() {
		return draft_no;
	}

	public void setDraft_no(int draft_no) {
		this.draft_no = draft_no;
	}

	public String getDraft_attach_filename() {
		return draft_attach_filename;
	}

	public void setDraft_attach_filename(String draft_attach_filename) {
		this.draft_attach_filename = draft_attach_filename;
	}

	@Override
	public String toString() {
		return "Draft_attachVO [draft_attach_no=" + draft_attach_no + ", draft_no=" + draft_no
				+ ", draft_attach_filename=" + draft_attach_filename + "]";
	}

	public Draft_AttachVO(int draft_attach_no, int draft_no, String draft_attach_filename) {
		super();
		this.draft_attach_no = draft_attach_no;
		this.draft_no = draft_no;
		this.draft_attach_filename = draft_attach_filename;
	}
	
	
}
