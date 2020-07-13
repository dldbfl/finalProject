package com.dlms.service.board;

import java.sql.SQLException;
import java.util.List;

import com.dlms.dto.FreeBoard_ReplyVO;
/**
 * 
 * @사용목적		:	창업후기 댓글 관리	
 * @작성자		:	연은주
 * @작성날짜      	:	2020. 6. 3.
 * @마지막수정자	:	연은주
 * @마지막수정일	:	2020. 6. 3.오후 5:20:14
 * @see			:	
 *
 */
public interface FreeboardReplyService {

	/**
	 * 
	 * @기능설명		:	댓글 리스트
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 3.오후 4:42:23
	 * @see			:	
	 * @param freeboard_no
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	List<FreeBoard_ReplyVO> getReplyList(int freeboard_no)throws SQLException;		

	/**
	 * 
	 * @기능설명		:	댓글 등록	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오후 4:42:45
	 * @see			:	
	 * @param replyVO
	 * @throws SQLException
	 *
	 */
	void registReply(FreeBoard_ReplyVO replyVO)throws SQLException;
		
	/**
	 * 
	 * @기능설명		:	댓글 수정	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오후 4:43:44
	 * @see			:	
	 * @param replyVO
	 * @throws SQLException
	 *
	 */
	void modifyReply(FreeBoard_ReplyVO replyVO)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	댓글 삭제	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오후 4:43:54
	 * @see			:	
	 * @param freeboard_reply_no
	 * @throws SQLException
	 *
	 */
	void removeReply(int freeboard_reply_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	댓글 상세보기
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 10.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 10.오전 9:51:39
	 * @see			:	
	 * @param freeboard_reply_no
	 * @return
	 * @throws SQLException
	 *
	 */
	FreeBoard_ReplyVO ReplyDetail(int freeboard_reply_no)throws SQLException;

}
