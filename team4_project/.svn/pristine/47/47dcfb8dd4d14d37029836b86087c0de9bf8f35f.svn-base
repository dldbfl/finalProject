package com.dlms.service.board;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dlms.dao.board.FreeBoardReplyDAO;
import com.dlms.dto.FreeBoard_ReplyVO;
import com.dlms.request.PageMaker;
import com.dlms.request.SearchCriteria;

public class FreeboardReplyServiceImpl implements FreeboardReplyService{
	
	@Autowired
	private FreeBoardReplyDAO replyDAO;
	public void setReplyDAO(FreeBoardReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}
	
	@Override
	public List<FreeBoard_ReplyVO> getReplyList(int freeboard_no) throws SQLException {
		
		List<FreeBoard_ReplyVO> replyList= replyDAO.selectReplyListPage(freeboard_no);
		return replyList;
	}
	@Override
	public void registReply(FreeBoard_ReplyVO replyVO) throws SQLException {
		int rno=replyDAO.selectfreeBoardReplySeqNext();
		
		replyVO.setFreeboard_reply_no(rno);
		
		replyDAO.insertReply(replyVO);
		
	}
	@Override
	public void modifyReply(FreeBoard_ReplyVO replyVO) throws SQLException {
		replyDAO.updateReply(replyVO);
		
	}
	@Override
	public void removeReply(int freeboard_reply_no) throws SQLException {
		replyDAO.deleteReply(freeboard_reply_no);
		
	}

	@Override
	public FreeBoard_ReplyVO ReplyDetail(int freeboard_reply_no) throws SQLException {
		return replyDAO.ReplyDetail(freeboard_reply_no);
	}
	


}
