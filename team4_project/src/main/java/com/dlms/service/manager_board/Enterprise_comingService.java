package com.dlms.service.manager_board;

import java.sql.SQLException;

import java.util.Map;

import com.dlms.dto.Manager_boardVO;
import com.dlms.dto.Manager_dataVO;


public interface Enterprise_comingService {
	
    /**
     * 
     * @기능설명		:	찾아오는길 조회
     * @작성자		    :	이누리
     * @작성날짜    	:	2020. 6. 9.
     * @마지막수정자	:	이누리
     * @마지막수정일	:	2020. 6. 9.오후 3:02:24
     * @see			    :	-
     * @param manager_board_no
     * @return
     * @throws SQLException
     *
     */
	Map<String,Object> getEnterprise_coming(int manager_board_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	찾아오는길 수정
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 9.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 9.오후 3:59:40
	 * @see			    :	-
	 * @param manager_board
	 * @param manager_board_no
	 * @throws SQLException
	 *
	 */
	void modifyEnterprise_coming(Manager_boardVO manager_board, int manager_board_no)throws SQLException;
	
	
}


