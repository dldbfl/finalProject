package com.dlms.dao.manager_board;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSessionException;

import com.dlms.dto.Manager_boardVO;

public interface Education_purposeDAO {


	/**
	 * 
	 * @기능설명		:	관리자 게시판 - 교육목적 조회
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 9.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 9.오후 2:05:39
	 * @see			    :	-
	 * @return
	 * @throws SQLException
	 *
	 */
	Manager_boardVO selectManager_board_Education_purpose(int manager_board_no) throws SQLException;	
		

	/**
	 * 
	 * @기능설명		:	관리자 게시판 - 교육목적 수정
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 9.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 9.오후 2:05:47
	 * @see			    :	-
	 * @param manager_board
	 * @throws SQLException
	 *
	 */
	void updateManager_board_education_purpose(Manager_boardVO manager_board)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	관리자게시판 - 이미지 조회
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 9.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 9.오후 1:46:41
	 * @see			    :	-
	 * @param manager_board_no
	 * @return
	 * @throws SqlSessionException
	 *
	 */
	String selectManager_board_getimage(int manager_board_no) throws SqlSessionException;
	
	
	/**
	 * 
	 * @기능설명		:	관리자 게시판 - 이미지 수정
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 9.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 9.오후 1:47:03
	 * @see			    :	-
	 * @param manager_board
	 * @throws SQLException
	 *
	 */
	void updateManager_board_Manager_data_filename(Manager_boardVO manager_board)throws SQLException;
	
}
