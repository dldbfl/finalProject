package com.dlms.service.manager_board;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.dlms.dao.manager_board.Education_purposeDAO;
import com.dlms.dto.Manager_boardVO;



public class Education_purposeServiceImpl<L> implements Education_purposeService {
	
	private Education_purposeDAO education_purposeDAO;
	public void setEducation_purposeDAO(Education_purposeDAO education_purposeDAO) {
		this.education_purposeDAO = education_purposeDAO;
	}
	/**
	 * 	
	 * @기능설명		:	교육목표 조회
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 9.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 9.오후 3:36:38
	 * @see			    :	-
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public Map<String, Object> getEducation_purpose(int manager_board_no) throws SQLException {
		Map<String,Object> dataMap = new HashMap<String,Object>();
		
		Manager_boardVO manager_board = education_purposeDAO.selectManager_board_Education_purpose(manager_board_no);
		String manager_data_filename = education_purposeDAO.selectManager_board_getimage(manager_board_no);
		
		//System.out.println(manager_data_filename);
		manager_board.setManager_data_filename(manager_data_filename);
				
		
		dataMap.put("manager_board", manager_board);
		dataMap.put("manager_board.manager_data_filename", manager_data_filename);
		
		return dataMap; 
	}

	/**
	 * 
	 * @기능설명		:	교육목표 수정
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 9.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 9.오후 3:36:50
	 * @see			    :	-
	 * @param manager_board
	 * @throws SQLException
	 *
	 */
	@Override
	public void modifyEducation_purpose(Manager_boardVO manager_board, int manager_board_no) throws SQLException {
		String manager_data_filename = education_purposeDAO.selectManager_board_getimage(manager_board_no);
		
		if(manager_board.getManager_data_filename() == null) {
			manager_board.setManager_data_filename(manager_data_filename);
		}
		manager_board.setManager_board_no(manager_board_no);
		System.out.println("manager_board.getManager_data_filename() : "+ manager_board.getManager_data_filename());	
		System.out.println("manager_board : " + manager_board);
		
		education_purposeDAO.updateManager_board_Manager_data_filename(manager_board);
		education_purposeDAO.updateManager_board_education_purpose(manager_board);
	}






	
	
}
