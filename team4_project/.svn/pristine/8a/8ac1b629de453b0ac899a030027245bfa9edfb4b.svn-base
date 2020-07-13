package com.dlms.dao.attach;

import java.sql.SQLException;
import java.util.List;

import com.dlms.dto.Message_attachVO;


public interface MessageAttachDAO {
	public List<Message_attachVO> messenger_attachList(int messenger_no) throws SQLException;
	public List<Message_attachVO> receiver_attachList(int receiver_no) throws SQLException;
	public void messenger_attach(Message_attachVO messenger_attach) throws SQLException;
	public void receiver_attach(Message_attachVO messenger_attach) throws SQLException;
	public int selectMessenger_attachSeqNext() throws SQLException;
	
}
