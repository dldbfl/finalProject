package com.dlms.service.manager_board;

import java.sql.SQLException;

import java.util.Map;

import com.dlms.dto.Manager_boardVO;


public interface Education_curriculumService {
	
    /**
     * 
     * @기능설명		:	교육과정 조회
     * @작성자		    :	이누리
     * @작성날짜    	:	2020. 6. 9.
     * @마지막수정자	:	이누리
     * @마지막수정일	:	2020. 6. 9.오후 3:38:26
     * @see			    :	-
     * @param manager_board_no
     * @return
     * @throws SQLException
     *
     */
	Map<String,Object> getEducation_curriculum(int manager_board_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	교육과정 수정
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 9.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 9.오후 3:38:35
	 * @see			    :	-
	 * @param manager_board
	 * @param manager_board_no
	 * @throws SQLException
	 *
	 */
	void modifyEducation_curriculum(Manager_boardVO manager_board,int manager_board_no)throws SQLException;
	
	
}


