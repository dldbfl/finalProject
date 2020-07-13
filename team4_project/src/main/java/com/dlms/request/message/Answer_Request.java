package com.dlms.request.message;

import java.util.Date;
import java.util.List;

import com.dlms.dto.Message_attachVO;
import com.dlms.dto.MessengerVO;

public class Answer_Request {

	private String answer_writer; 		// 발신자
	private String answer_title;		//제목
	private String answer_content; 		// 발신내용
	private String answer_receiver; 		// 수신자
	private List<Message_attachVO> messengerFileList;
	

	public Answer_Request() {}
	
	

	public Answer_Request(String answer_writer, String answer_title, String answer_content, String answer_receiver,
			List<Message_attachVO> messengerFileList) {
		super();
		this.answer_writer = answer_writer;
		this.answer_title = answer_title;
		this.answer_content = answer_content;
		this.answer_receiver = answer_receiver;
		this.messengerFileList = messengerFileList;
	}



	@Override
	public String toString() {
		return "Answer_Request [answer_writer=" + answer_writer + ", answer_title=" + answer_title + ", answer_content="
				+ answer_content + ", answer_receiver=" + answer_receiver + ", messengerFileList=" + messengerFileList
				+ "]";
	}



	public String getAnswer_writer() {
		return answer_writer;
	}



	public void setAnswer_writer(String answer_writer) {
		this.answer_writer = answer_writer;
	}



	public String getAnswer_title() {
		return answer_title;
	}



	public void setAnswer_title(String answer_title) {
		this.answer_title = answer_title;
	}



	public String getAnswer_content() {
		return answer_content;
	}



	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}



	public String getAnswer_receiver() {
		return answer_receiver;
	}



	public void setAnswer_receiver(String answer_receiver) {
		this.answer_receiver = answer_receiver;
	}



	public List<Message_attachVO> getMessengerFileList() {
		return messengerFileList;
	}



	public void setMessengerFileList(List<Message_attachVO> messengerFileList) {
		this.messengerFileList = messengerFileList;
	}



	public MessengerVO toMessenger() {
		MessengerVO messenger = new MessengerVO();
		messenger.setMessenger_title(this.answer_title);
		messenger.setMessenger_content(this.answer_content);
		messenger.setMessenger_receiver(this.answer_receiver);
		messenger.setMessenger_writer(this.answer_writer);
		return messenger;
		
	}
}
