package com.dlms.dto;

import java.util.Date;
/**
 * 
 * @사용목적		:	공지사항을 참조하는 첨부파일데이터	
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	박진영
 * @마지막수정일	:	2020. 6. 1.오후 4:17:58
 * @see			:	
 *
 */
public class Notice_dataVO {
	private int notice_data_no; 			// 파일 번호
	private int notice_no; 					// 공지사항 번호
	private String notice_filename;	// 파일명
	private Date notice_regdate; 		// 등록일자
	private String notice_fileuploadpath; // 파일 경로
	private String notice_filetype;	// 파일 타입
	private String uuid;

	
	
	public Notice_dataVO() {
		super();
	}
	public int getNotice_data_no() {
		return notice_data_no;
	}
	public void setNotice_data_no(int notice_data_no) {
		this.notice_data_no = notice_data_no;
	}
	public int getNotice_no() {
		return notice_no;
	}
	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}
	public String getNotice_filename() {
		return notice_filename;
	}
	public void setNotice_filename(String notice_filename) {
		this.notice_filename = notice_filename;
	}
	public Date getNotice_regdate() {
		return notice_regdate;
	}
	public void setNotice_regdate(Date notice_regdate) {
		this.notice_regdate = notice_regdate;
	}
	public String getNotice_fileuploadpath() {
		return notice_fileuploadpath;
	}
	public void setNotice_fileuploadpath(String notice_fileuploadpath) {
		this.notice_fileuploadpath = notice_fileuploadpath;
	}
	public String getNotice_filetype() {
		return notice_filetype;
	}
	public void setNotice_filetype(String notice_filetype) {
		this.notice_filetype = notice_filetype;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	@Override
	public String toString() {
		return "Notice_dataVO [notice_data_no=" + notice_data_no + ", notice_no=" + notice_no + ", notice_filename="
				+ notice_filename + ", notice_regdate=" + notice_regdate + ", notice_fileuploadpath="
				+ notice_fileuploadpath + ", notice_filetype=" + notice_filetype + ", uuid=" + uuid + "]";
	}
	public Notice_dataVO(int notice_data_no, int notice_no, String notice_filename, Date notice_regdate,
			String notice_fileuploadpath, String notice_filetype, String uuid) {
		super();
		this.notice_data_no = notice_data_no;
		this.notice_no = notice_no;
		this.notice_filename = notice_filename;
		this.notice_regdate = notice_regdate;
		this.notice_fileuploadpath = notice_fileuploadpath;
		this.notice_filetype = notice_filetype;
		this.uuid = uuid;
	}
	
	
	
	
	
	
	
	

}
