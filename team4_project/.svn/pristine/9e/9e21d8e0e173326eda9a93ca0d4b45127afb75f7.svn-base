package com.dlms.dao.message;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dlms.dto.MessengerVO;
import com.dlms.request.MessageRequest;
import com.dlms.request.SearchCriteria;

public interface MessengerDAO {

	public List<MessengerVO> selectSearchMessengerList(Map<String, Object> dataMap)throws SQLException;
	public int selectSearchMessengerListCount(Map<String, Object> dataMap) throws SQLException;
	public MessengerVO selectMessengerDetail(int messenger_no)throws SQLException;
	public List<MessengerVO> selectSearchMessengerRecycleList(Map<String, Object> dataMap)throws SQLException;
	public int selectSearchMessengerRecycleListCount(Map<String, Object> dataMap) throws SQLException;
	public MessengerVO selectMessengerRecycleDetail(int messenger_no)throws SQLException;
	public void sendMessage(MessengerVO messenger) throws SQLException;
	public void receiveMessage(MessengerVO messenger) throws SQLException;
	public void goRecycle(int messenger_no) throws SQLException;
	public void deleteMessage(int messenger_no) throws SQLException;
	public void restore(int messenger_no) throws SQLException;
	public int selectMessenger_SeqNext() throws SQLException;
	public void openEnvelope(int messenger_no) throws SQLException;
	public void fileCheck(int messenger_no) throws SQLException;

}
