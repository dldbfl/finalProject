package com.dlms.dto;

import java.util.Date;
/**
 * 
 * @사용목적		:	문서첨부파일 데이터관리
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	박진영
 * @마지막수정일	:	2020. 6. 1.오후 3:34:02
 * @see			:	
 *
 */
public class Document_dataVO {

	private int document_data_no;	 		 // 문서자료 번호
	private int document_no;				 // 문서 번호
	private String document_data_filename;	 // 문서자료 이름
	private Date document_data_regdate; 	 // 문서자료 등록 일자	
	private String document_data_type;		//문서 자료 타입
	private String document_data_path;	   //문서 자료 경로
	public int getDocument_data_no() {
		return document_data_no;
	}

	public void setDocument_data_no(int document_data_no) {
		this.document_data_no = document_data_no;
	}

	public int getDocument_no() {
		return document_no;
	}

	public void setDocument_no(int document_no) {
		this.document_no = document_no;
	}

	public String getDocument_data_filename() {
		return document_data_filename;
	}

	public void setDocument_data_filename(String document_data_filename) {
		this.document_data_filename = document_data_filename;
	}

	public Date getDocument_data_regdate() {
		return document_data_regdate;
	}

	public void setDocument_data_regdate(Date document_data_regdate) {
		this.document_data_regdate = document_data_regdate;
	}

	@Override
	public String toString() {
		return "Document_dataVO [document_data_no=" + document_data_no + ", document_no=" + document_no
				+ ", document_data_filename=" + document_data_filename + ", document_data_regdate="
				+ document_data_regdate + "]";
	}

	public Document_dataVO() {
		super();
		this.document_data_no = document_data_no;
		this.document_no = document_no;
		this.document_data_filename = document_data_filename;
		this.document_data_regdate = document_data_regdate;
	}

	public String getDocument_data_type() {
		return document_data_type;
	}

	public void setDocument_data_type(String document_data_type) {
		this.document_data_type = document_data_type;
	}

	public String getDocument_data_path() {
		return document_data_path;
	}

	public void setDocument_data_path(String document_data_path) {
		this.document_data_path = document_data_path;
	}

}
