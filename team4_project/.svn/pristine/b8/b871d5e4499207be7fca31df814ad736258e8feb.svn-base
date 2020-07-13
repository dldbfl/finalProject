package com.dlms.service.message;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dlms.dao.attach.MessageAttachDAO;
import com.dlms.dao.message.ReceiverDAO;
import com.dlms.dto.Message_attachVO;
import com.dlms.dto.ReceiverVO;
import com.dlms.request.MessageRequest;
import com.dlms.request.PageMaker;
import com.dlms.request.SearchCriteria;


/**
 * 
 * @사용목적		:	쪽지 발신을 처리하는Service
 * @작성자		:	민태홍
 * @작성날짜      	:	2020. 6. 2.
 * @마지막수정자	:	민태홍
 * @마지막수정일	:	2020. 6. 2.오전 10:36:07
 * @see			:	receiverService
 */
public class ReceiverServiceImpl implements ReceiverService{
	
	@Autowired
	private ReceiverDAO ReceiverDAO;
	public void setReceiverDAO(ReceiverDAO ReceiverDAO) {
		this.ReceiverDAO = ReceiverDAO;
	}
	
	@Autowired
	private MessageAttachDAO messageAttachDAO;
	public void setMessageAttachDAO(MessageAttachDAO messageAttachDAO) {
		this.messageAttachDAO = messageAttachDAO;
	}
	/**
	 * 
	 * @기능설명		:	수신함 검색리스트 출력
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 29.오전 10:37:34
	 * @see			:	X
	 * @param dataMap
	 * @return receiverList
	 * @throws SQLException
	 *
	 */
	@Override
	public Map<String, Object> getSearchReceiverList(Map<String, Object> dataMap) throws SQLException {
		Map<String, Object> res = new HashMap<String, Object>();
		
		List<ReceiverVO> receiverList = ReceiverDAO.selectSearchReceiverList(dataMap);
		
		int totalCount = ReceiverDAO.selectSearchReceiverListCount(dataMap);
		SearchCriteria cri  = new SearchCriteria();
		cri.setKeyword((String) dataMap.get("keyword"));
		cri.setPage((Integer) dataMap.get("page"));
		cri.setPerPageNum((Integer) dataMap.get("perPageNum"));
		cri.setSearchType((String) dataMap.get("searchType"));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("receiver", receiverList);
		dataMap.put("pageMaker", pageMaker);
		return dataMap;
	}


	/**
	 * 
	 * @기능설명		:	메신저상세
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 3.오전 11:26:30
	 * @see			:	X
	 * @param receiver_no
	 * @return receiver
	 * @throws SQLException
	 *
	 */
	@Override
	public ReceiverVO getReceiverDetail(int receiver_no) throws SQLException {
		ReceiverDAO.openEnvelope(receiver_no);
		ReceiverVO receiver = ReceiverDAO.selectReceiverDetail(receiver_no);
		SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        receiver.setFormat_date(formatter.format(receiver.getReceiver_date()));
		List<Message_attachVO> fileList= messageAttachDAO.receiver_attachList(receiver_no);
		try {
		String fileName = fileList.get(0).getMessage_attach_filename().substring(fileList.get(0).getMessage_attach_filename().lastIndexOf("$$")+2);
		receiver.setMessage_fileName(fileName);
		receiver.setReal_path(fileList.get(0).getMessage_attach_path());
		receiver.setReal_name(fileList.get(0).getMessage_attach_filename());

		}catch (IndexOutOfBoundsException e) {
			// 파일이 없을때 터지는 에러 예외처리
		}
		
		return receiver;
	}

	/**
	 * 
	 * @기능설명		:	발신함 휴지통 검색 리스트 출력
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:41:07
	 * @see			:	X
	 * @param cri
	 * @return receiver_RecycleList
	 * @throws SQLException
	 *
	 */
	@Override
	public Map<String, Object>getSearchReceiverRecycleList(Map<String, Object> dataMap) throws SQLException {
		Map<String, Object> res = new HashMap<String, Object>();
		
		List<ReceiverVO> receiverRecycleList = ReceiverDAO.selectSearchReceiverRecycleList(dataMap);
		
		int totalCount = ReceiverDAO.selectSearchReceiverRecycleListCount(dataMap);
		SearchCriteria cri  = new SearchCriteria();
		cri.setKeyword((String) dataMap.get("keyword"));
		cri.setPage((Integer) dataMap.get("page"));
		cri.setPerPageNum((Integer) dataMap.get("perPageNum"));
		cri.setSearchType((String) dataMap.get("searchType"));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		res.put("receiverRecycle", receiverRecycleList);
		res.put("pageMaker", pageMaker);
		return res;

	}

	/**
	 * 
	 * @기능설명		:	휴지통 상세
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 3.오전 11:29:14
	 * @see			:	X
	 * @param receiver_no
	 * @return receiver
	 * @throws SQLException
	 *
	 */
	@Override
	public ReceiverVO getReceiverRecycleDetail(int receiver_no) throws SQLException {
		ReceiverDAO.openEnvelope(receiver_no);
		ReceiverVO receiver = ReceiverDAO.selectReceiverRecycleDetail(receiver_no);
		SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        receiver.setFormat_date(formatter.format(receiver.getReceiver_date()));
		List<Message_attachVO> fileList= messageAttachDAO.receiver_attachList(receiver_no);
		try {
		String fileName = fileList.get(0).getMessage_attach_filename().substring(fileList.get(0).getMessage_attach_filename().lastIndexOf("$$")+2);
		receiver.setMessage_fileName(fileName);
		receiver.setReal_path(fileList.get(0).getMessage_attach_path());
		receiver.setReal_name(fileList.get(0).getMessage_attach_filename());

		}catch (IndexOutOfBoundsException e) {
			// 파일이 없을때 터지는 에러 예외처리
		}
		
		return receiver;

	}

	/**
	 * 
	 * @기능설명		:	휴지통으로 보내기
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:43:05
	 * @see			:	X
	 * @param receiver
	 * @throws SQLException
	 *
	 */
	@Override
	public void goRecycle(int receiver_no) throws SQLException {
		ReceiverDAO.goRecycle(receiver_no);

		
	}
	
	/**
	 * 
	 * @기능설명		:	발신쪽지 완전삭제
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:43:18
	 * @see			:	X
	 * @param receiver_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void removeMessage(int receiver_no) throws SQLException {
		ReceiverDAO.deleteMessage(receiver_no);
		
	}

	/**
	 * 
	 * @기능설명		:	발신쪽지 복원
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:43:42
	 * @see			:	X
	 * @param receiver_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void restore(int receiver_no) throws SQLException {
		ReceiverDAO.restore(receiver_no);

	}
}
