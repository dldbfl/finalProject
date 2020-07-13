package com.dlms.dao.manager_board;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSessionException;

import com.dlms.dto.Enterprise_introduceVO;
import com.dlms.dto.Manager_boardVO;
import com.dlms.dto.Manager_dataVO;
import com.dlms.request.Enterprise_introduceRequest;

public interface Enterprise_comingDAO {

	/**
	 * 
	 * @기능설명		:	관리자 게시판 - 찾아오는길 조회
	 * @작성자			:	이누리
	 * @작성날짜    	:	2020. 6. 9.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 9.오후 12:49:12
	 * @see				:	-
	 * @return
	 * @throws SQLException
	 *
	 */
	Manager_boardVO selectManager_board_Enterprise_coming(int manager_board_no) throws SQLException;	
		

	/**
	 * 
	 * @기능설명		:	관리자게시판 - 찾아오는길 수정
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 9.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 9.오후 1:46:17
	 * @see			    :	-
	 * @param manager_board
	 * @throws SQLException
	 *
	 */
	void updateManager_board_enterprise_coming(Manager_boardVO manager_board)throws SQLException;
	
	
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
