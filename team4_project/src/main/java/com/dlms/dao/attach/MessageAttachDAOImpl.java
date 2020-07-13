package com.dlms.dao.attach;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dlms.dto.Message_attachVO;

/**
 * 
 * @사용목적		:	쪽지함 첨부파일 관리하는 DAO
 * @작성자		:	민태홍
 * @작성날짜      	:	2020. 6. 2.
 * @마지막수정자	:	민태홍
 * @마지막수정일	:	2020. 6. 2.오후 12:37:12
 * @see			:	MessageAttachDAO
 *
 */
public class MessageAttachDAOImpl implements MessageAttachDAO{

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
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
	public List<Message_attachVO> messenger_attachList(int messenger_no) throws SQLException {
		
		List<Message_attachVO> messenger_attachList = new ArrayList<Message_attachVO>();
		messenger_attachList = sqlSession.selectList("messenger_attach-mapper.messenger_attachList",messenger_no);
		return messenger_attachList;
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
	public List<Message_attachVO> receiver_attachList(int receiver_no) throws SQLException {
		
		List<Message_attachVO> receiver_attachList = new ArrayList<Message_attachVO>();
		receiver_attachList = sqlSession.selectList("messenger_attach-mapper.receiver_attachList",receiver_no);
		return receiver_attachList;
	}


	
	/**
	 * 
	 * @기능설명		:	발신함 첨부파일 등록
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 11:10:12
	 * @see			:	X
	 * @param messenger_attach
	 * @throws SQLException
	 *
	 */
	@Override
	public void messenger_attach(Message_attachVO messenger_attach) throws SQLException {
		sqlSession.update("messenger_attach-mapper.messenger_attach",messenger_attach);
		
	}
	
	/**
	 * 
	 * @기능설명		:	수신함 첨부파일 등록
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 11:10:26
	 * @see			:	X
	 * @param messenger_attach
	 * @throws SQLException
	 *
	 */
	@Override
	public void receiver_attach(Message_attachVO messenger_attach) throws SQLException {
		sqlSession.update("messenger_attach-mapper.receiver_attach",messenger_attach);
		
	}

	
	/**
	 * 
	 * @기능설명		:	쪽지 첨부파일 번호 생성
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 11:11:09
	 * @see			:	X
	 * @return messenger_attach_no
	 * @throws SQLException
	 *
	 */
	@Override
	public int selectMessenger_attachSeqNext() throws SQLException {
		int message_attach_no = sqlSession.selectOne("messenger_attach-mapper.selectMessenger_attachSeqNext");
		return message_attach_no;
	}


}
