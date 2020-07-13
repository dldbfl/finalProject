package com.dlms.dao.message;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dlms.dto.ReceiverVO;
import com.dlms.request.MessageRequest;
import com.dlms.request.SearchCriteria;

public interface ReceiverDAO {

	public List<ReceiverVO> selectSearchReceiverList(Map<String, Object> dataMap)throws SQLException;
	public int selectSearchReceiverListCount(Map<String, Object> dataMap) throws SQLException;
	public ReceiverVO selectReceiverDetail(int receiver_NO)throws SQLException;
	public List<ReceiverVO> selectSearchReceiverRecycleList(Map<String, Object> dataMap)throws SQLException;
	public int selectSearchReceiverRecycleListCount(Map<String, Object> dataMap) throws SQLException;
	public ReceiverVO selectReceiverRecycleDetail(int receiver_NO)throws SQLException;
	public void goRecycle(int receiver_no) throws SQLException;
	public void deleteMessage(int receiver_no) throws SQLException;
	public void restore(int receiver_no) throws SQLException;
	public int selectReceiver_SeqNext() throws SQLException;
	public void openEnvelope(int receiver_no) throws SQLException;
	public void fileCheck(int receiver_no) throws SQLException;
}
