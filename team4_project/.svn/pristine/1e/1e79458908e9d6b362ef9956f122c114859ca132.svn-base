package com.dlms.request.message;

import java.util.Date;
import java.util.List;

import com.dlms.dto.Message_attachVO;
import com.dlms.dto.MessengerVO;

public class ToMessenger_Request {

	private String tomessenger_writer; 		// 발신자
	private String tomessenger_title;
	private String tomessenger_content; 		// 발신내용
	private String tomessenger_receiver; 		// 수신자
	private List<Message_attachVO> messengerFileList;
	

	public ToMessenger_Request() {}
	
	
	
	public ToMessenger_Request(String tomessenger_writer, String tomessenger_title, String tomessenger_content,
			String tomessenger_receiver) {
		super();
		this.tomessenger_writer = tomessenger_writer;
		this.tomessenger_title = tomessenger_title;
		this.tomessenger_content = tomessenger_content;
		this.tomessenger_receiver = tomessenger_receiver;
	}



	@Override
	public String toString() {
		return "ToMessenger_Request [tomessenger_writer=" + tomessenger_writer + ", tomessenger_title="
				+ tomessenger_title + ", tomessenger_content=" + tomessenger_content + ", tomessenger_receiver="
				+ tomessenger_receiver + "]";
	}



	public String getTomessenger_writer() {
		return tomessenger_writer;
	}


	public void setTomessenger_writer(String tomessenger_writer) {
		this.tomessenger_writer = tomessenger_writer;
	}


	public String getTomessenger_title() {
		return tomessenger_title;
	}


	public void setTomessenger_title(String tomessenger_title) {
		this.tomessenger_title = tomessenger_title;
	}


	public String getTomessenger_content() {
		return tomessenger_content;
	}


	public void setTomessenger_content(String tomessenger_content) {
		this.tomessenger_content = tomessenger_content;
	}


	public String getTomessenger_receiver() {
		return tomessenger_receiver;
	}


	public void setTomessenger_receiver(String tomessenger_receiver) {
		this.tomessenger_receiver = tomessenger_receiver;
	}


	public List<Message_attachVO> getMessengerFileList() {
		return messengerFileList;
	}


	public void setMessengerFileList(List<Message_attachVO> messengerFileList) {
		this.messengerFileList = messengerFileList;
	}

	

	public MessengerVO toMessenger() {
		MessengerVO messenger = new MessengerVO();
		messenger.setMessenger_title(this.tomessenger_title);
		messenger.setMessenger_content(this.tomessenger_content);
		messenger.setMessenger_receiver(this.tomessenger_receiver);
		messenger.setMessenger_writer(this.tomessenger_writer);
		return messenger;
		
	}
}
