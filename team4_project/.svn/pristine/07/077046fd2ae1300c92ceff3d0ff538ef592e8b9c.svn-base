package com.dlms.service.message;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dlms.dto.MessengerVO;
import com.dlms.request.MessageRequest;
import com.dlms.request.SearchCriteria;

public interface MessengerService {

	public Map<String, Object> getSearchMessengerList(Map<String, Object> dataMap)throws SQLException;
	public MessengerVO getMessengerDetail(int messenger_no)throws SQLException;
	public Map<String, Object> getSearchMessengerRecycleList(Map<String, Object> dataMap)throws SQLException;
	public MessengerVO getMessengerRecycleDetail(int messenger_no)throws SQLException;
	public void sendMessage(MessengerVO messenger) throws SQLException;
	public void receiveMessage(MessengerVO messenger) throws SQLException;
	public void goRecycle(int messenger_no) throws SQLException;
	public void removeMessage(int messenger_no) throws SQLException;
	public void restore(int messenger_no) throws SQLException;

}
