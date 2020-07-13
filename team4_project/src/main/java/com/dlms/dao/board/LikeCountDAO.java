package com.dlms.dao.board;

import java.sql.SQLException;

import com.dlms.dto.LikeCountVO;

public interface LikeCountDAO {

	public void insertBoardLike(LikeCountVO like)throws SQLException;
	public void deleteBoardLike(int like_no)throws SQLException;
	public LikeCountVO detailLikeInfo(LikeCountVO like) throws SQLException;
	public int selectlikeSeqNext()throws SQLException;
}
