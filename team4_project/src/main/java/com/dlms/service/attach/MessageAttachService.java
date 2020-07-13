package com.dlms.service.attach;

import java.sql.SQLException;
import java.util.List;

import com.dlms.dto.Message_attachVO;


public interface MessageAttachService {
	public List<Message_attachVO> getMessengerAttachList(int messenger_no) throws SQLException;
	public List<Message_attachVO> getReceiverAttachList(int receiver_no) throws SQLException;
	
}
