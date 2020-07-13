package com.dlms.dto;

import java.util.Date;
import java.util.List;
/**
 * 
 * @사용목적		:	쪽지 발수신함 테이블
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	민태홍
 * @마지막수정일	:	2020. 6. 1.오후 4:25:23
 * @see			:	
 *
 */
public class ReceiverVO {

	private int receiver_no; 			// 수신번호
	private String receiver_id; 		// 수신자
	private String receiver_content; 	// 수신내용
	private Date receiver_date; 		// 수신일자
	private int receiver_status; 		// 기본값 = 3, 2일때 휴지통으로 보낸다.
	private String receiver_sender; 	// 발신자
	private String receiver_title;	//제목
	private String receiver_check;
	private String message_fileName;
	private String message_filePath;
	private String format_date;
	private String real_path;
	private String real_name;
	private String receiver_filecheck;
	
	public ReceiverVO() {}

	public int getReceiver_no() {
		return receiver_no;
	}

	public void setReceiver_no(int receiver_no) {
		this.receiver_no = receiver_no;
	}

	public String getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(String receiver_id) {
		this.receiver_id = receiver_id;
	}

	public String getReceiver_content() {
		return receiver_content;
	}

	public void setReceiver_content(String receiver_content) {
		this.receiver_content = receiver_content;
	}

	public Date getReceiver_date() {
		return receiver_date;
	}

	public void setReceiver_date(Date receiver_date) {
		this.receiver_date = receiver_date;
	}

	public int getReceiver_status() {
		return receiver_status;
	}

	public void setReceiver_status(int receiver_status) {
		this.receiver_status = receiver_status;
	}

	public String getReceiver_sender() {
		return receiver_sender;
	}

	public void setReceiver_sender(String receiver_sender) {
		this.receiver_sender = receiver_sender;
	}

	public String getReceiver_title() {
		return receiver_title;
	}

	public void setReceiver_title(String receiver_title) {
		this.receiver_title = receiver_title;
	}

	public String getReceiver_check() {
		return receiver_check;
	}

	public void setReceiver_check(String receiver_check) {
		this.receiver_check = receiver_check;
	}

	public String getMessage_fileName() {
		return message_fileName;
	}

	public void setMessage_fileName(String message_fileName) {
		this.message_fileName = message_fileName;
	}

	public String getMessage_filePath() {
		return message_filePath;
	}

	public void setMessage_filePath(String message_filePath) {
		this.message_filePath = message_filePath;
	}

	public String getFormat_date() {
		return format_date;
	}

	public void setFormat_date(String format_date) {
		this.format_date = format_date;
	}

	public String getReal_path() {
		return real_path;
	}

	public void setReal_path(String real_path) {
		this.real_path = real_path;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	@Override
	public String toString() {
		return "ReceiverVO [receiver_no=" + receiver_no + ", receiver_id=" + receiver_id + ", receiver_content="
				+ receiver_content + ", receiver_date=" + receiver_date + ", receiver_status=" + receiver_status
				+ ", receiver_sender=" + receiver_sender + ", receiver_title=" + receiver_title + ", receiver_check="
				+ receiver_check + ", message_fileName=" + message_fileName + ", message_filePath=" + message_filePath
				+ ", format_date=" + format_date + ", real_path=" + real_path + ", real_name=" + real_name + "]";
	}

	public ReceiverVO(int receiver_no, String receiver_id, String receiver_content, Date receiver_date,
			int receiver_status, String receiver_sender, String receiver_title, String receiver_check,
			String message_fileName, String message_filePath, String format_date, String real_path, String real_name) {
		super();
		this.receiver_no = receiver_no;
		this.receiver_id = receiver_id;
		this.receiver_content = receiver_content;
		this.receiver_date = receiver_date;
		this.receiver_status = receiver_status;
		this.receiver_sender = receiver_sender;
		this.receiver_title = receiver_title;
		this.receiver_check = receiver_check;
		this.message_fileName = message_fileName;
		this.message_filePath = message_filePath;
		this.format_date = format_date;
		this.real_path = real_path;
		this.real_name = real_name;
	}

	public String getReceiver_filecheck() {
		return receiver_filecheck;
	}

	public void setReceiver_filecheck(String receiver_filecheck) {
		this.receiver_filecheck = receiver_filecheck;
	}

	
	
}
