package com.dlms.service.message;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dlms.dto.ReceiverVO;
import com.dlms.request.MessageRequest;
import com.dlms.request.SearchCriteria;

public interface ReceiverService {

	public Map<String, Object> getSearchReceiverList(Map<String, Object> dataMap)throws SQLException;
	public ReceiverVO getReceiverDetail(int receiver_NO)throws SQLException;
	public Map<String, Object> getSearchReceiverRecycleList(Map<String, Object> dataMap)throws SQLException;
	public ReceiverVO getReceiverRecycleDetail(int receiver_NO)throws SQLException;
	public void goRecycle(int receiver_no) throws SQLException;
	public void removeMessage(int receiver_no) throws SQLException;
	public void restore(int receiver_no) throws SQLException;

}
