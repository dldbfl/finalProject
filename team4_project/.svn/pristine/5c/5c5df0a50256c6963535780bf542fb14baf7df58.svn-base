package com.dlms.service.message;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dlms.dao.attach.MessageAttachDAO;
import com.dlms.dao.message.MessengerDAO;
import com.dlms.dao.message.ReceiverDAO;
import com.dlms.dto.Draft_AttachVO;
import com.dlms.dto.Lecture_reviewVO;
import com.dlms.dto.Message_attachVO;
import com.dlms.dto.MessengerVO;
import com.dlms.request.MessageRequest;
import com.dlms.request.PageMaker;
import com.dlms.request.SearchCriteria;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;


/**
 * 
 * @사용목적		:	쪽지 발신을 처리하는Service
 * @작성자		:	민태홍
 * @작성날짜      	:	2020. 6. 2.
 * @마지막수정자	:	민태홍
 * @마지막수정일	:	2020. 6. 2.오전 10:36:07
 * @see			:	MessengerService
 */
public class MessengerServiceImpl implements MessengerService{
	
	@Autowired
	private MessengerDAO messengerDAO;
	public void setMessengerDAO(MessengerDAO messengerDAO) {
		this.messengerDAO = messengerDAO;
	}
	@Autowired
	private MessageAttachDAO messageAttachDAO;
	public void setMessageAttachDAO(MessageAttachDAO messageAttachDAO) {
		this.messageAttachDAO = messageAttachDAO;
	}
	@Autowired
	private ReceiverDAO receiverDAO;
	public void setReceiverDAO(ReceiverDAO receiverDAO) {
		this.receiverDAO = receiverDAO;
	}
	/**
	 * 
	 * @기능설명		:	발신함 검색리스트 출력
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:37:34
	 * @see			:	X
	 * @param cri
	 * @return messengerList
	 * @throws SQLException
	 *
	 */
	@Override
	public Map<String, Object> getSearchMessengerList(Map<String, Object> dataMap) throws SQLException {
		Map<String, Object> res = new HashMap<String, Object>();
		
		List<MessengerVO> messengerList = messengerDAO.selectSearchMessengerList(dataMap);
		
		int totalCount = messengerDAO.selectSearchMessengerListCount(dataMap);
		
		SearchCriteria cri  = new SearchCriteria();
		cri.setKeyword((String) dataMap.get("keyword"));
		cri.setPage((Integer) dataMap.get("page"));
		cri.setPerPageNum((Integer) dataMap.get("perPageNum"));
		cri.setSearchType((String) dataMap.get("searchType"));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		res.put("messenger", messengerList);
		res.put("pageMaker", pageMaker);
		return res;
	}

	/**
	 * 
	 * @기능설명		:	메신저상세
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 3.오전 11:26:30
	 * @see			:	X
	 * @param messenger_no
	 * @return messenger
	 * @throws SQLException
	 *
	 */
	@Override
	public MessengerVO getMessengerDetail(int messenger_no) throws SQLException {
		messengerDAO.openEnvelope(messenger_no);
		MessengerVO messenger = messengerDAO.selectMessengerDetail(messenger_no);
		SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        messenger.setFormat_date(formatter.format(messenger.getMessenger_senddate()));
		List<Message_attachVO> fileList= messageAttachDAO.messenger_attachList(messenger_no);
		try {
		String fileName = fileList.get(0).getMessage_attach_filename().substring(fileList.get(0).getMessage_attach_filename().lastIndexOf("$$")+2);
		messenger.setMessage_fileName(fileName);
		messenger.setReal_path(fileList.get(0).getMessage_attach_path());
		messenger.setReal_name(fileList.get(0).getMessage_attach_filename());

		}catch (IndexOutOfBoundsException e) {
			// 파일이 없을때 터지는 에러 예외처리
		}
		return messenger;
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
	 * @return messenger_RecycleList
	 * @throws SQLException
	 *
	 */
	@Override
	public Map<String, Object>getSearchMessengerRecycleList(Map<String, Object> dataMap) throws SQLException {
		Map<String, Object> res = new HashMap<String, Object>();
		
		List<MessengerVO> messengerList = messengerDAO.selectSearchMessengerRecycleList(dataMap);
		int totalCount = messengerDAO.selectSearchMessengerRecycleListCount(dataMap);
		
		SearchCriteria cri  = new SearchCriteria();
		cri.setKeyword((String) dataMap.get("keyword"));
		cri.setPage((Integer) dataMap.get("page"));
		cri.setPerPageNum((Integer) dataMap.get("perPageNum"));
		cri.setSearchType((String) dataMap.get("searchType"));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		res.put("messengerRecycleList", messengerList);
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
	 * @param messenger_no
	 * @return messenger
	 * @throws SQLException
	 *
	 */
	@Override
	public MessengerVO getMessengerRecycleDetail(int messenger_no) throws SQLException {
		messengerDAO.openEnvelope(messenger_no);
		MessengerVO messenger = messengerDAO.selectMessengerRecycleDetail(messenger_no);
		SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        messenger.setFormat_date(formatter.format(messenger.getMessenger_senddate()));
		List<Message_attachVO> fileList= messageAttachDAO.messenger_attachList(messenger_no);
		try {
		String fileName = fileList.get(0).getMessage_attach_filename().substring(fileList.get(0).getMessage_attach_filename().lastIndexOf("$$")+2);
		messenger.setMessage_fileName(fileName);
		messenger.setReal_path(fileList.get(0).getMessage_attach_path()+fileList.get(0).getMessage_attach_filename());
		messenger.setReal_name(fileList.get(0).getMessage_attach_filename());
		}catch (IndexOutOfBoundsException e) {
			// 파일이 없을때 터지는 에러 예외처리
		}
		return messenger;
	}

	/**
	 * 
	 * @기능설명		:	쪽지 발신
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:42:40
	 * @see			:	X
	 * @param messenger
	 * @throws SQLException
	 *
	 */
	@Override
	public void sendMessage(MessengerVO messenger) throws SQLException {
		int messenger_no = messengerDAO.selectMessenger_SeqNext();
		messenger.setMessenger_no(messenger_no);
		messengerDAO.sendMessage(messenger);
		
		
		if(messenger.getMessage_fileName() !=null) {
				Message_attachVO attach= new Message_attachVO();
				attach.setMessenger_no(messenger_no);
				attach.setMessage_attach_filename(messenger.getMessage_fileName());
				attach.setMessage_attach_path(messenger.getMessage_filePath());
				int message_attach_no = messageAttachDAO.selectMessenger_attachSeqNext();
				attach.setMessage_attach_no(message_attach_no);
				messageAttachDAO.messenger_attach(attach);
				messengerDAO.fileCheck(messenger_no);
			
		}
		
	}

	/**
	 * 
	 * @기능설명		:	발신과 동시에 수신함에 넣는다.
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:42:55
	 * @see			:	X
	 * @param messenger
	 * @throws SQLException
	 *
	 */
	@Override
	public void receiveMessage(MessengerVO messenger) throws SQLException {
		int receiver_no = receiverDAO.selectReceiver_SeqNext();
		messenger.setReceiver_no(receiver_no);
		messengerDAO.receiveMessage(messenger);
		
		
		if (messenger.getMessage_fileName() != null) {
			Message_attachVO attach = new Message_attachVO();
			attach.setReceiver_no(receiver_no);
			attach.setMessage_attach_filename(messenger.getMessage_fileName());
			attach.setMessage_attach_path(messenger.getMessage_filePath());
			int message_attach_no = messageAttachDAO.selectMessenger_attachSeqNext();
			attach.setMessage_attach_no(message_attach_no);
			messageAttachDAO.receiver_attach(attach);
			receiverDAO.fileCheck(receiver_no);
		}

	}

	/**
	 * 
	 * @기능설명		:	휴지통으로 보내기
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:43:05
	 * @see			:	X
	 * @param messenger_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void goRecycle(int messenger_no) throws SQLException {
		messengerDAO.goRecycle(messenger_no);
		
	}
	
	/**
	 * 
	 * @기능설명		:	발신쪽지 완전삭제
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:43:18
	 * @see			:	X
	 * @param messenger_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void removeMessage(int messenger_no) throws SQLException {
		messengerDAO.deleteMessage(messenger_no);
		
	}

	/**
	 * 
	 * @기능설명		:	발신쪽지 복원
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:43:42
	 * @see			:	X
	 * @param messenger_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void restore(int messenger_no) throws SQLException {
		messengerDAO.restore(messenger_no);
		
	}

}
