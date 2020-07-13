package com.dlms.dto;

import java.util.Date;
import java.util.List;
/**
 * 
 * @사용목적		:	발신함 테이블	
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	민태홍
 * @마지막수정일	:	2020. 6. 1.오후 4:17:20
 * @see			:	
 *
 */
public class MessengerVO {

	private int messenger_no; 				// 발신번호
	private String messenger_writer; 		// 발신자
	private String messenger_check;
	private String messenger_title;
	private String messenger_content; 		// 발신내용
	private Date messenger_senddate; 		// 발신일자
	private int messenger_status; 			// 기본값 = 1, 0일때 휴지통으로 보낸다.
	private String messenger_receiver; 		// 수신자
	private int receiver_no; //수신자번호
	private String message_fileName;
	private String message_filePath;
	private String format_date;
	private String real_path;
	private String real_name;
	private String messenger_filecheck;
	public MessengerVO(){}

	public int getMessenger_no() {
		return messenger_no;
	}

	public void setMessenger_no(int messenger_no) {
		this.messenger_no = messenger_no;
	}

	public String getMessenger_writer() {
		return messenger_writer;
	}

	public void setMessenger_writer(String messenger_writer) {
		this.messenger_writer = messenger_writer;
	}

	public String getMessenger_check() {
		return messenger_check;
	}

	public void setMessenger_check(String messenger_check) {
		this.messenger_check = messenger_check;
	}

	public String getMessenger_title() {
		return messenger_title;
	}

	public void setMessenger_title(String messenger_title) {
		this.messenger_title = messenger_title;
	}

	public String getMessenger_content() {
		return messenger_content;
	}

	public void setMessenger_content(String messenger_content) {
		this.messenger_content = messenger_content;
	}

	public Date getMessenger_senddate() {
		return messenger_senddate;
	}

	public void setMessenger_senddate(Date messenger_senddate) {
		this.messenger_senddate = messenger_senddate;
	}

	public int getMessenger_status() {
		return messenger_status;
	}

	public void setMessenger_status(int messenger_status) {
		this.messenger_status = messenger_status;
	}

	public String getMessenger_receiver() {
		return messenger_receiver;
	}

	public void setMessenger_receiver(String messenger_receiver) {
		this.messenger_receiver = messenger_receiver;
	}

	public int getReceiver_no() {
		return receiver_no;
	}

	public void setReceiver_no(int receiver_no) {
		this.receiver_no = receiver_no;
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

	public MessengerVO(int messenger_no, String messenger_writer, String messenger_check, String messenger_title,
			String messenger_content, Date messenger_senddate, int messenger_status, String messenger_receiver,
			int receiver_no) {
		super();
		this.messenger_no = messenger_no;
		this.messenger_writer = messenger_writer;
		this.messenger_check = messenger_check;
		this.messenger_title = messenger_title;
		this.messenger_content = messenger_content;
		this.messenger_senddate = messenger_senddate;
		this.messenger_status = messenger_status;
		this.messenger_receiver = messenger_receiver;
		this.receiver_no = receiver_no;
	}

	@Override
	public String toString() {
		return "MessengerVO [messenger_no=" + messenger_no + ", messenger_writer=" + messenger_writer
				+ ", messenger_check=" + messenger_check + ", messenger_title=" + messenger_title
				+ ", messenger_content=" + messenger_content + ", messenger_senddate=" + messenger_senddate
				+ ", messenger_status=" + messenger_status + ", messenger_receiver=" + messenger_receiver
				+ ", receiver_no=" + receiver_no + "]";
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

	public String getMessenger_filecheck() {
		return messenger_filecheck;
	}

	public void setMessenger_filecheck(String messenger_filecheck) {
		this.messenger_filecheck = messenger_filecheck;
	}
	
	

}
