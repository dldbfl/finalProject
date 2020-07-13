package com.dlms.service.attach;

import java.sql.SQLException;
import java.util.List;

import com.dlms.dao.attach.MessageAttachDAO;
import com.dlms.dto.Message_attachVO;

/**
 * 
 * @사용목적		:	쪽지함 첨부파일 관리하는 서비스
 * @작성자		:	민태홍
 * @작성날짜      	:	2020. 6. 2.
 * @마지막수정자	:	민태홍
 * @마지막수정일	:	2020. 6. 2.오후 12:37:12
 * @see			:	MessengerAttachService
 *
 */
public class MessengerAttachServiceImpl implements MessageAttachService{
	
	private MessageAttachDAO messageAttachDAO;
	public void setMessageAttachDAO(MessageAttachDAO messageAttachDAO) {
		this.messageAttachDAO = messageAttachDAO;
	}
	
	/**
	 * 
	 * @기능설명		:	발신함 첨부파일 출력
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 11:08:59
	 * @see			:	X
	 * @param messenger_id
	 * @return messenger_attachList
	 * @throws SQLException
	 *
	 */
	@Override
	public List<Message_attachVO> getMessengerAttachList(int messenger_no) throws SQLException {
		List<Message_attachVO> messenger = messageAttachDAO.messenger_attachList(messenger_no);
		return messenger;
	}
	
	/**
	 * 
	 * @기능설명		:	수신함 첨부파일 출력
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 11:08:59
	 * @see			:	X
	 * @param receiver_id
	 * @return receiver_attachList
	 * @throws SQLException
	 *
	 */
	@Override
	public List<Message_attachVO> getReceiverAttachList(int receiver_no) throws SQLException {
		List<Message_attachVO> receiver = messageAttachDAO.messenger_attachList(receiver_no);
		return receiver;
	}
}
