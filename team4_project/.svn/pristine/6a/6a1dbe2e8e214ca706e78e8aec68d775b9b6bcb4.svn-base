package com.dlms.dao.board;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.dlms.dto.LikeCountVO;

public class LikeCountDAOImpl implements LikeCountDAO {

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	/**
	 * 
	 * @기능설명		: 좋아요 누를시 정보를 입력한다.	
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 19.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 19.오전 11:09:33
	 * @see			:	X
	 * @throws SQLException
	 *
	 */
	@Override
	public void insertBoardLike(LikeCountVO like) throws SQLException {
		sqlSession.update("like-mapper.insertBoardLike",like);
		
	}
	
	/**
	 * 
	 * @기능설명		: 좋아요를 눌렀던 상태일시 정보를 삭제한다.	
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 19.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 19.오전 11:09:47
	 * @see			:	X
	 * @throws SQLException
	 *
	 */
	@Override
	public void deleteBoardLike(int like_no) throws SQLException {
		sqlSession.update("like-mapper.deleteBoardLike",like_no);
		
	}
	
	/**
	 * 
	 * @기능설명		:	한 아이디당 하나의 좋아요만 가능하다.
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 19.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 19.오전 11:10:09
	 * @see			:	X
	 * @param member_id
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public LikeCountVO detailLikeInfo(LikeCountVO like) throws SQLException {
		LikeCountVO getLike = sqlSession.selectOne("like-mapper.detailLikeInfo",like);
		return getLike;
	}
	@Override
	public int selectlikeSeqNext() throws SQLException {
		int count = sqlSession.selectOne("like-mapper.selectlikeSeqNext");
		return count;
	}
}
