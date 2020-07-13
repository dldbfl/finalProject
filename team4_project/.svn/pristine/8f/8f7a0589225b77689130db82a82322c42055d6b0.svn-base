package com.dlms.request.message;

import java.util.Date;
import java.util.List;

import com.dlms.dto.Message_attachVO;
import com.dlms.dto.MessengerVO;

public class Messenger_Request {

	private String messenger_writer; 		// 발신자
	private String messenger_title;
	private String messenger_content; 		// 발신내용
	private String messenger_receiver; 		// 수신자
	private List<Message_attachVO> messengerFileList;
	
	public Messenger_Request() {}
	
	public String getMessenger_writer() {
		return messenger_writer;
	}
	public void setMessenger_writer(String messenger_writer) {
		this.messenger_writer = messenger_writer;
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
	public String getMessenger_receiver() {
		return messenger_receiver;
	}
	public void setMessenger_receiver(String messenger_receiver) {
		this.messenger_receiver = messenger_receiver;
	}

	public List<Message_attachVO> getMessengerFileList() {
		return messengerFileList;
	}
	public void setMessengerFileList(List<Message_attachVO> messengerFileList) {
		this.messengerFileList = messengerFileList;
	}
	
	public Messenger_Request(String messenger_writer, String messenger_title, String messenger_content,
			String messenger_receiver) {
		super();
		this.messenger_writer = messenger_writer;
		this.messenger_title = messenger_title;
		this.messenger_content = messenger_content;
		this.messenger_receiver = messenger_receiver;
	}
	
	@Override
	public String toString() {
		return "Messenger_Request [messenger_writer=" + messenger_writer + ", messenger_title=" + messenger_title
				+ ", messenger_content=" + messenger_content + ", messenger_receiver=" + messenger_receiver + "]";
	}

	public MessengerVO toMessenger() {
		MessengerVO messenger = new MessengerVO();
		messenger.setMessenger_title(this.messenger_title);
		messenger.setMessenger_content(this.messenger_content);
		messenger.setMessenger_receiver(this.messenger_receiver);
		messenger.setMessenger_writer(this.messenger_writer);
		return messenger;
		
	}
}
