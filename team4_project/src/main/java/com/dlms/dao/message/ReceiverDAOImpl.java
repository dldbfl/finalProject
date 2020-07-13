package com.dlms.dao.message;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import com.dlms.dto.ReceiverVO;
import com.dlms.request.MessageRequest;
import com.dlms.request.SearchCriteria;
import com.dlms.dao.message.ReceiverDAO;

public class ReceiverDAOImpl implements ReceiverDAO{

	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	/**
	 * 
	 * @기능설명		:	수신함 검색리스트 출력
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:37:34
	 * @see			:	X
	 * @param cri
	 * @return receiverList
	 * @throws SQLException
	 *
	 */
	@Override
	public List<ReceiverVO> selectSearchReceiverList(Map<String, Object> dataMap) throws SQLException {
		SearchCriteria cri = new SearchCriteria();
		cri.setKeyword((String) dataMap.get("keyword"));
		cri.setPage((Integer) dataMap.get("page"));
		cri.setPerPageNum((Integer) dataMap.get("perPageNum"));
		cri.setSearchType((String) dataMap.get("searchType"));
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<ReceiverVO> receiverList = new ArrayList<ReceiverVO>();
		receiverList = sqlSession.selectList("receiver-mapper.selectSearchReceiverList",dataMap, rowBounds);
		return receiverList;
	}
	
	/**
	 * 
	 * @기능설명		:	수신함 리스트에 페이지 달기위한 장치
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:38:59
	 * @see			:	X
	 * @return X
	 * @throws count
	 *
	 */
	@Override
	public int selectSearchReceiverListCount(Map<String, Object> dataMap) throws SQLException {
		int count = sqlSession.selectOne("receiver-mapper.selectSearchReceiverListCount",dataMap);
		return count;
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
	public ReceiverVO selectReceiverDetail(int receiver_no) throws SQLException {
		ReceiverVO receiver = sqlSession.selectOne("receiver-mapper.selectReceiverDetail",receiver_no);
		return receiver;
	}
	
	
	/**
	 * 
	 * @기능설명		:	수신함 휴지통 리스트 출력
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
	public List<ReceiverVO> selectSearchReceiverRecycleList(Map<String, Object> dataMap) throws SQLException {
		SearchCriteria cri = new SearchCriteria();
		cri.setKeyword((String) dataMap.get("keyword"));
		cri.setPage((Integer) dataMap.get("page"));
		cri.setPerPageNum((Integer) dataMap.get("perPageNum"));
		cri.setSearchType((String) dataMap.get("searchType"));
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<ReceiverVO> receiver_RecycleList = new ArrayList<ReceiverVO>();
		receiver_RecycleList = sqlSession.selectList("receiver-mapper.selectSearchReceiverRecycleList",cri,rowBounds);
		return receiver_RecycleList;
	}
	
	/**
	 * 
	 * @기능설명		:	수신함 휴지통 리스트에 페이지 달기위한 장치
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:38:59
	 * @see			:	X
	 * @return X
	 * @throws count
	 *
	 */
	@Override
	public int selectSearchReceiverRecycleListCount(Map<String, Object> dataMap) throws SQLException {
		int count = sqlSession.selectOne("receiver-mapper.selectSearchReceiverRecycleListCount",dataMap);
		return count;
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
	public ReceiverVO selectReceiverRecycleDetail(int receiver_no) throws SQLException {
		ReceiverVO receiver = sqlSession.selectOne("receiver-mapper.selectReceiverRecycleDetail",receiver_no);
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
		sqlSession.update("receiver-mapper.goRecycle",receiver_no);
		
	}
	
	/**
	 * 
	 * @기능설명		:	수신쪽지 완전삭제
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
	public void deleteMessage(int receiver_no) throws SQLException {
		sqlSession.delete("receiver-mapper.deleteMessage",receiver_no);
		
	}
	
	/**
	 * 
	 * @기능설명		:	수신쪽지 복원
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
		sqlSession.update("receiver-mapper.restore",receiver_no);
		
		
	}

	/**
	 * 
	 * @기능설명		:	쪽지 수신번호를 생성한다.
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:48:37
	 * @see			:	X
	 * @return receiver_no
	 * @throws SQLException
	 *
	 */
	@Override
	public int selectReceiver_SeqNext() throws SQLException {
		int receiver_no = sqlSession.selectOne("receiver-mapper.selectReceiver_SeqNext");
		return receiver_no;
	}
	/**
	 * 
	 * @기능설명		:	읽기여부 체크
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 8.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 8.오후 4:09:02
	 * @see			:	X
	 * @param receiver_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void openEnvelope(int receiver_no) throws SQLException{
		sqlSession.update("receiver-mapper.openEnvelope",receiver_no);
	}
	
	/**
	 * 
	 * @기능설명		:	파일 체크
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 8.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 8.오후 4:09:02
	 * @see			:	X
	 * @param receiver_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void fileCheck(int receiver_no) throws SQLException {
		sqlSession.update("receiver-mapper.fileCheck",receiver_no);
		
	}
}
