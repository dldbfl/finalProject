package com.dlms.dao.board;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dlms.dto.FreeBoardVO;
import com.dlms.request.SearchCriteria;
	/**
	 * 
	 * @사용목적		:	자유게시판 
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 2.오전 10:43:56
	 * @see			:	
	 *
	 */
public interface FreeBoardDAO {
	
	/**
	 * 
	 * @기능설명		:	게시글 전체 리스트	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 2.오후 5:07:48
	 * @see			:	
	 * @return		:	null
	 * @throws 		:	SQLException
	 *
	 */
	FreeBoardVO selectfreeBoardList(String member_id)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	게시글 검색 리스트 	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오전 10:30:02
	 * @see			:	
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	List<FreeBoardVO> selectSearchfreeBoardList(SearchCriteria cri)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	게시글 pagenation을 하기 위해서	게시글의 갯수를 확인
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오후 3:13:04
	 * @see			:	
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	int selectSearchfreeBoardCriTotalCount(SearchCriteria cri) throws SQLException;
	/**
	 * 
	 * @기능설명		:	게시글 상세보기	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 2.오후 5:08:59
	 * @param freeboard_no
	 * @throws SQLException
	 *
	 */
	FreeBoardVO selectfreeBoardByBno(int freeboard_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	게시글 작성	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 2.오후 5:10:01
	 * @param freeboard
	 * @throws SQLException
	 *
	 */
	void insertfreeBoard(FreeBoardVO freeboard)throws SQLException;
	
	
	/**
	 * 
	 * @기능설명		:	게시글 수정	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 2.오후 5:11:58
	 * @param freeboard
	 * @throws SQLException
	 *
	 */
	void updatefreeBoard(FreeBoardVO freeboard)throws SQLException;
	
	
	/**
	 * 
	 * @기능설명		:	게시글 삭제	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 2.오후 5:12:27
	 * @see			:	
	 * @param freeboard_no
	 * @throws SQLException
	 *
	 */
	void deletefreeBoard(int freeboard_no)throws SQLException;
	
	
	/**
	 * 
	 * @기능설명		:	게시글 조회수 증가	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 2.오후 5:12:47
	 * @param freeboard_no
	 * @throws SQLException
	 *
	 */
	void increaseViewCnt(int freeboard_no)throws SQLException;
	
	//board_seq.nextval 가져오기
	/**
	 * 
	 * @기능설명		:	게시글 번호 시퀀스 	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 2.오후 5:13:49
	 * @see			:	
	 * @return
	 * @throws SQLException
	 *
	 */
	int selectfreeBoardSeqNext()throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	게시글 상세보기 안 다음글 버튼
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 19.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 19.오후 1:57:52
	 * @see			:	
	 * @return freeboard_no
	 * @throws SQLException 
	 *
	 */
	int next_freeboard_no(int freeboard_no) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	게시글 상세보기 안 이전글 버튼	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 19.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 19.오후 1:58:27
	 * @see			:	
	 * @return freeboard_no
	 * @throws SQLException
	 *
	 */
	int prev_freeboard_no(int freeboard_no) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	게시글 상세보기 안 다음글 제목	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 19.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 19.오후 1:58:43
	 * @see			:	
	 * @return freeboard_no
	 * @throws SQLException
	 *
	 */
	String next_freeboard_title(int freeboard_no) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	게시글 상세보기 안 이전글 제목	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 19.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 19.오후 1:58:59
	 * @see			:	
	 * @return freeboard_no
	 * @throws SQLException
	 *
	 */
	String prev_freeboard_title(int freeboard_no) throws SQLException;
	
	List<FreeBoardVO> myfreeList(String member_id)throws SQLException;
	
	int selectfreeBoardReplyCnt(int freeboard_no)throws SQLException;
	
}
