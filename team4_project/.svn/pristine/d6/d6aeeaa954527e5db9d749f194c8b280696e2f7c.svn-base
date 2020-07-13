package com.dlms.service.board;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dlms.dto.FreeBoardVO;
import com.dlms.request.SearchCriteria;
/**
 * 
 * @사용목적		:	자유게시판	
 * @작성자		:	연은주
 * @작성날짜      	:	2020. 6. 3.
 * @마지막수정자	:	연은주
 * @마지막수정일	:	2020. 6. 3.오후 5:15:44
 * @see			:	
 *
 */
public interface FreeboardService {
	/**
	 * 
	 * @기능설명		:	게시글 리스트 출력	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오후 4:44:12
	 * @see			:	
	 * @return
	 * @throws SQLException
	 *
	 */
	List<FreeBoardVO> getfreeBoardList()throws SQLException;

	/**
	 * 
	 * @기능설명		:	게시글 검색리스트 출력	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오후 4:44:48
	 * @see			:	
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	
	FreeBoardVO selectfreeBoardList(String member_id)throws SQLException;
	
	Map<String,Object> getfreeBoardList(SearchCriteria cri)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	게시글 상세보기	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오후 4:45:02
	 * @see			:	
	 * @param freeboard_no
	 * @return
	 * @throws SQLException
	 *
	 */
	FreeBoardVO readfreeBoard(int freeboard_no)throws SQLException;	
	
	/**
	 * 
	 * @기능설명		:	게시글 작성/수정화면	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오후 4:45:25
	 * @see			:	
	 * @param freeboard_no
	 * @return
	 * @throws SQLException
	 *
	 */
	FreeBoardVO getfreeBoardForModify(int freeboard_no)throws SQLException;
		
	/**
	 * 
	 * @기능설명		:	게시글 작성
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오후 4:46:02
	 * @see			:	
	 * @param freeboard
	 * @throws SQLException
	 *
	 */
	void write(FreeBoardVO freeboard)throws SQLException;
		
	/**
	 * 
	 * @기능설명		:	게시글 수정	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오후 4:46:19
	 * @see			:	
	 * @param freeboard
	 * @throws SQLException
	 *
	 */
	void modify(FreeBoardVO freeboard)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	게시글 삭제	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오후 4:46:30
	 * @see			:	
	 * @param freeboard_no
	 * @throws SQLException
	 *
	 */
	void remove(int freeboard_no)throws SQLException;
	
}
