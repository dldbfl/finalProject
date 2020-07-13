package com.dlms.dao.message;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import com.dlms.dto.MessengerVO;
import com.dlms.request.MessageRequest;
import com.dlms.request.SearchCriteria;

/**
 * 
 * @사용목적		:	쪽지 발신을 처리하는 DAO
 * @작성자		:	민태홍
 * @작성날짜      	:	2020. 6. 2.
 * @마지막수정자	:	민태홍
 * @마지막수정일	:	2020. 6. 2.오전 10:36:07
 * @see			:	MessengerDAO
 */
public class MessengerDAOImpl implements MessengerDAO{
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
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
	public List<MessengerVO> selectSearchMessengerList(Map<String, Object> dataMap) throws SQLException {
		SearchCriteria cri = new SearchCriteria();
		cri.setKeyword((String) dataMap.get("keyword"));
		cri.setPage((Integer) dataMap.get("page"));
		cri.setPerPageNum((Integer) dataMap.get("perPageNum"));
		cri.setSearchType((String) dataMap.get("searchType"));
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<MessengerVO> messengerList = new ArrayList<MessengerVO>();
		messengerList = sqlSession.selectList("messenger-mapper.selectSearchMessengerList",dataMap,rowBounds);
		return messengerList;
	}
	
	/**
	 * 
	 * @기능설명		:	발신함 리스트에 페이지 달기위한 장치
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
	public int selectSearchMessengerListCount(Map<String, Object> dataMap) throws SQLException {
		int count = sqlSession.selectOne("messenger-mapper.selectSearchMessengerListCount",dataMap);
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
	 * @param messenger_no
	 * @return messenger
	 * @throws SQLException
	 *
	 */
	@Override
	public MessengerVO selectMessengerDetail(int messenger_no) throws SQLException {
		MessengerVO messenger = sqlSession.selectOne("messenger-mapper.selectMessengerDetail",messenger_no);
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
	public List<MessengerVO> selectSearchMessengerRecycleList(Map<String, Object> dataMap) throws SQLException {

		SearchCriteria cri = new SearchCriteria();
		cri.setKeyword((String) dataMap.get("keyword"));
		cri.setPage((Integer) dataMap.get("page"));
		cri.setPerPageNum((Integer) dataMap.get("perPageNum"));
		cri.setSearchType((String) dataMap.get("searchType"));
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<MessengerVO> messenger_RecycleList = new ArrayList<MessengerVO>();
		messenger_RecycleList = sqlSession.selectList("messenger-mapper.selectSearchMessengerRecycleList",dataMap,rowBounds);
		return messenger_RecycleList;
	}
	
	/**
	 * 
	 * @기능설명		:	발신함 휴지통 리스트에 페이지 달기위한 장치
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
	public int selectSearchMessengerRecycleListCount(Map<String, Object> dataMap) throws SQLException {
		int count = sqlSession.selectOne("messenger-mapper.selectSearchMessengerRecycleListCount",dataMap);
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
	 * @param messenger_no
	 * @return messenger
	 * @throws SQLException
	 *
	 */
	@Override
	public MessengerVO selectMessengerRecycleDetail(int messenger_no) throws SQLException {
		MessengerVO messenger = sqlSession.selectOne("messenger-mapper.selectMessengerRecycleDetail",messenger_no);
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
		sqlSession.update("messenger-mapper.sendMessage",messenger);
		
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
		sqlSession.update("messenger-mapper.receiveMessage",messenger);
		
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
		sqlSession.update("messenger-mapper.goRecycle",messenger_no);
		
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
	public void deleteMessage(int messenger_no) throws SQLException {
		sqlSession.delete("messenger-mapper.deleteMessage",messenger_no);
		
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
		sqlSession.update("messenger-mapper.restore",messenger_no);
		
	}

	/**
	 * 
	 * @기능설명		:	쪽지 발신번호를 생성한다.
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:48:37
	 * @see			:	X
	 * @return messenger_no
	 * @throws SQLException
	 *
	 */
	@Override
	public int selectMessenger_SeqNext() throws SQLException {
		int messenger_no = sqlSession.selectOne("messenger-mapper.selectMessenger_SeqNext");
		return messenger_no;
	}
	
	/**
	 * 
	 * @기능설명		:	쪽지 연상태로 변경
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:48:37
	 * @see			:	X
	 * @return X
	 * @throws SQLException
	 *
	 */
	@Override
	public void openEnvelope(int messenger_no) throws SQLException {
		sqlSession.update("messenger-mapper.openEnvelope",messenger_no);
		
	}
	
	/**
	 * 
	 * @기능설명		:	파일체크
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 9.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 9.오전 10:44:07
	 * @see			:	X
	 * @param messenger_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void fileCheck(int messenger_no) throws SQLException {
		sqlSession.update("messenger-mapper.fileCheck",messenger_no);
		
	}
}
