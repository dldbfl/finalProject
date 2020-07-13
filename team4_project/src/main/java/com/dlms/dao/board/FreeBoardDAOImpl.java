package com.dlms.dao.board;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dlms.dto.FreeBoardVO;
import com.dlms.request.SearchCriteria;
/**
 * 
 * @사용목적		: 	자유게시판	
 * @작성자		:	연은주
 * @작성날짜      	:	2020. 6. 2.
 * @마지막수정자	:	연은주
 * @마지막수정일	:	2020. 6. 2.오전 10:44:33
 * @see			:	
 *
 */
public class FreeBoardDAOImpl implements FreeBoardDAO{
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//게시글 전체 보기
	@Override
	public FreeBoardVO selectfreeBoardList(String member_id) throws SQLException {
		FreeBoardVO freeboard =	sqlSession.selectOne("freeboard-mapper.selectfreeBoardList",member_id);		
		return freeboard;
	}
	
	//게시글 검색 리스트
	@Override
	public List<FreeBoardVO> selectSearchfreeBoardList(SearchCriteria cri) throws SQLException {
		int offset=cri.getPageStartRowNum();
		int limit=cri.getPerPageNum();
		RowBounds rowBounds=new RowBounds(offset,limit);
		
		List<FreeBoardVO> freeSerchList=sqlSession.selectList("freeboard-mapper.selectSearchfreeBoardList",cri,rowBounds);	
		
		return freeSerchList;
	}
	//게시글검색 전체 갯수
	@Override
	public int selectSearchfreeBoardCriTotalCount(SearchCriteria cri) throws SQLException {
	
		int count = sqlSession.selectOne("freeboard-mapper.selectSearchBoardListCount",cri);
		return count;
		
	}

	//게시글 상세보기
	@Override
	public FreeBoardVO selectfreeBoardByBno(int freeboard_no) throws SQLException {
		FreeBoardVO board= (FreeBoardVO)sqlSession.selectOne("freeboard-mapper.selectfreeBoardByBno",freeboard_no);
		return board;
	}
	//게시글 작성
	@Override
	public void insertfreeBoard(FreeBoardVO freeboard) throws SQLException {
		sqlSession.update("freeboard-mapper.insertfreeBoard",freeboard);
		
	}
	//게시글 수정
	@Override
	public void updatefreeBoard(FreeBoardVO freeboard) throws SQLException {
		sqlSession.update("freeboard-mapper.updatefreeBoard",freeboard);
		
	}
	//게시글 삭제
	@Override
	public void deletefreeBoard(int freeboard_no) throws SQLException {
		sqlSession.update("freeboard-mapper.deletefreeBoard",freeboard_no);
	}
	//게시글 조회수
	@Override
	public void increaseViewCnt(int freeboard_no) throws SQLException {
		sqlSession.update("freeboard-mapper.increaseViewCnt",freeboard_no);
		
	}
	//게시글 번호
	@Override
	public int selectfreeBoardSeqNext() throws SQLException {
		int seq_num=(Integer)sqlSession.selectOne("freeboard-mapper.selectfreeBoardSeqNext");
		return seq_num;
	}

	@Override
	public int next_freeboard_no(int freeboard_no) throws SQLException {
		int next_free_no= sqlSession.selectOne("freeboard-mapper.next_freeboard_no",freeboard_no);
		return next_free_no;
	}

	@Override
	public int prev_freeboard_no(int freeboard_no) throws SQLException {
		int prev_freeboard_no=sqlSession.selectOne("freeboard-mapper.prev_freeboard_no",freeboard_no);
		return prev_freeboard_no;
	}

	@Override
	public String next_freeboard_title(int freeboard_no) throws SQLException {
		String next_freeboard_title=sqlSession.selectOne("freeboard-mapper.next_freeboard_title",freeboard_no);
		return next_freeboard_title;
	}

	@Override
	public String prev_freeboard_title(int freeboard_no) throws SQLException {
		String prev_freeboard_title=sqlSession.selectOne("freeboard-mapper.prev_freeboard_title",freeboard_no);
		return prev_freeboard_title;
	}

	@Override
	public List<FreeBoardVO> myfreeList(String member_id) throws SQLException {
		List<FreeBoardVO> freeboard =sqlSession.selectList("freeboard-mapper.myfreeList",member_id);
		return freeboard;
	}

	@Override
	public int selectfreeBoardReplyCnt(int freeboard_no) throws SQLException {
		int count = sqlSession.selectOne("freeboard-mapper.selectfreeBoardReplyCnt", freeboard_no);
		
		return count;
	}

	
	
	
}
