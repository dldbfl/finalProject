package com.dlms.dto;

import java.util.Date;
import java.util.List;
/**
 * 
 * @사용목적		:	문서자료 데이터관리
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	박진영
 * @마지막수정일	:	2020. 6. 1.오후 3:35:08
 * @see			:	
 *
 */
public class DocumentVO {

	private int document_no; 			// 문서 번호
	private String document_writer; 	// 교수 아이디
	private String document_title; 		// 문서 제목
	private String document_content; 	// 문서 내용
	private Date document_regdate; 		// 문서 등록 일자
	private Document_dataVO document_dataVO;
	private String originalName; //기존파일명
	
	public DocumentVO() {}
	public int getDocument_no() {
		return document_no;
	}

	public void setDocument_no(int document_no) {
		this.document_no = document_no;
	}

	public String getDocument_writer() {
		return document_writer;
	}

	public void setDocument_writer(String document_writer) {
		this.document_writer = document_writer;
	}

	public String getDocument_title() {
		return document_title;
	}

	public void setDocument_title(String document_title) {
		this.document_title = document_title;
	}

	public String getDocument_content() {
		return document_content;
	}

	public void setDocument_content(String document_content) {
		this.document_content = document_content;
	}

	public Date getDocument_regdate() {
		return document_regdate;
	}

	public void setDocument_regdate(Date document_regdate) {
		this.document_regdate = document_regdate;
	}

	@Override
	public String toString() {
		return "DocumentVO [document_no=" + document_no + ", document_writer=" + document_writer + ", document_title="
				+ document_title + ", document_content=" + document_content + ", document_regdate=" + document_regdate
				+ "]";
	}

	public DocumentVO(int document_no, String document_writer, String document_title, String document_content,
			Date document_regdate) {
		super();
		this.document_no = document_no;
		this.document_writer = document_writer;
		this.document_title = document_title;
		this.document_content = document_content;
		this.document_regdate = document_regdate;
	}
	public Document_dataVO getDocument_dataVO() {
		return document_dataVO;
	}
	public void setDocument_dataVO(Document_dataVO document_dataVO) {
		this.document_dataVO = document_dataVO;
	}
	/**
	 * @return the originalName
	 */
	public String getOriginalName() {
		return originalName;
	}
	/**
	 * @param originalName the originalName to set
	 */
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

}
