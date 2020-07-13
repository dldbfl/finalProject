package com.dlms.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.dlms.dto.FreeBoard_ReplyVO;
import com.dlms.request.SearchCriteria;
	/**
	 * 
	 * @사용목적		:	댓글 DAO	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 10.오전 9:49:24
	 * @see			:	
	 *
	 */
public interface FreeBoardReplyDAO {
	
	/**
	 * 
	 * @기능설명		:	댓글등록
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 2.오후 5:18:23
	 * @param reply
	 * @throws SQLException
	 *
	 */
	void insertReply(FreeBoard_ReplyVO reply)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	댓글수정	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 2.오후 5:18:40
	 * @see			:	
	 * @param reply
	 * @throws SQLException
	 *
	 */
	void updateReply(FreeBoard_ReplyVO reply)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	댓글삭제	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 2.오후 5:19:03
	 * @see			:	
	 * @param freeboard_no
	 * @throws SQLException
	 *
	 */
	void deleteReply(int freeboard_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	댓글목록	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 2.오후 5:19:49
	 * @see			:	
	 * @param bno
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	List<FreeBoard_ReplyVO> selectReplyListPage(int bno)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	댓글 갯수	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오후 3:33:24
	 * @see			:	
	 * @param freeboard_no
	 * @return
	 * @throws SQLException
	 *
	 */
	int countReply(int freeboard_no) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	댓글 상세보기 수정화면을 출력하시 위해서	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 10.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 10.오전 9:49:24
	 * @see			:	
	 * @param freeboard_reply_no
	 * @return
	 * @throws SQLException
	 *
	 */
	FreeBoard_ReplyVO ReplyDetail(int freeboard_reply_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	댓글 번호 시퀀스 생성	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 22.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 22.오전 9:34:45
	 * @see			:	
	 * @param freboard_reply_no
	 * @return
	 * @throws SQLException
	 *
	 */
	int selectfreeBoardReplySeqNext()throws SQLException;
	
}
