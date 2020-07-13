package com.dlms.dao.board;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.dlms.dto.FreeBoard_ReplyVO;
import com.dlms.request.SearchCriteria;
/**
 * 
 * @사용목적		:	게시글 댓글	
 * @작성자		:	연은주
 * @작성날짜      	:	2020. 6. 2.
 * @마지막수정자	:	연은주
 * @마지막수정일	:	2020. 6. 2.오후 4:42:47
 * @see			:	
 *
 */
public class FreeBoardReplyDAOImpl implements FreeBoardReplyDAO {
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void insertReply(FreeBoard_ReplyVO reply) throws SQLException {
		sqlSession.update("freeReply-mapper.insertReply",reply);
	}

	@Override
	public void updateReply(FreeBoard_ReplyVO reply) throws SQLException {
		sqlSession.update("freeReply-mapper.updateReply",reply);

	}

	@Override
	public void deleteReply(int freeboard_no) throws SQLException {
		sqlSession.update("freeReply-mapper.deleteReply",freeboard_no);
			
	}

	@Override
	public List<FreeBoard_ReplyVO> selectReplyListPage(int freeboard_no) throws SQLException {
		List<FreeBoard_ReplyVO> replyList= sqlSession.selectList("freeReply-mapper.selectReplyList",freeboard_no);
		
		return replyList;
	}

	@Override
	public int countReply(int freeboard_no) throws SQLException {
		int count=sqlSession.selectOne("freeReply-mapper.selectfreeBoardReplyCnt",freeboard_no);
		return count;
	}

	@Override
	public FreeBoard_ReplyVO ReplyDetail(int freeboard_reply_no) throws SQLException {
		return sqlSession.selectOne("freeReply-mapper.replyDetail", freeboard_reply_no);
	}

	@Override
	public int selectfreeBoardReplySeqNext() throws SQLException {
		int reply_no = sqlSession.selectOne("freeReply-mapper.selectfreeBoardReplySeqNext");
		return reply_no;
	}

}
