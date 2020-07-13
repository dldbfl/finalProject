package com.dlms.request;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

import com.dlms.dto.NoticeVO;

public class NoticeAttachRequest {

	private String notice_title;
	private String notice_content;
	private String notice_writer;
	private MultipartFile[] uploadFile;

	public NoticeAttachRequest() {
		super();
	}


	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public String getNotice_writer() {
		return notice_writer;
	}

	public void setNotice_writer(String notice_writer) {
		this.notice_writer = notice_writer;
	}

	public MultipartFile[] getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile[] uploadFile) {
		this.uploadFile = uploadFile;
	}

	public NoticeAttachRequest(String notice_title, String notice_content, String notice_writer,
			MultipartFile[] uploadFile) {
		super();
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.notice_writer = notice_writer;
		this.uploadFile = uploadFile;
	}
	
	@Override
	public String toString() {
		return "NoticeAttachRequest [notice_title=" + notice_title + ", notice_content=" + notice_content
				+ ", notice_writer=" + notice_writer + ", uploadFile=" + Arrays.toString(uploadFile) + "]";
	}

	public NoticeVO toNotice() {
		NoticeVO notice = new NoticeVO();
		notice.setNotice_content(this.notice_content);
		notice.setNotice_title(this.notice_title);
		notice.setNotice_writer(this.notice_writer);

		return notice;
	}
}
