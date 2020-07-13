package com.dlms.service.manager_board;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.dlms.dao.enterprise_introduce.Enterprise_introduceDAO;
import com.dlms.dao.manager_board.Enterprise_comingDAO;
import com.dlms.dto.Enterprise_introduceVO;
import com.dlms.dto.Manager_boardVO;
import com.dlms.dto.Manager_dataVO;
import com.dlms.request.Enterprise_introduceRequest;


public class Enterprise_comingServiceImpl<L> implements Enterprise_comingService {
	
	private Enterprise_comingDAO enterprise_comingDAO;
	public void setEnterprise_comingDAO(Enterprise_comingDAO enterprise_comingDAO) {
		this.enterprise_comingDAO = enterprise_comingDAO;
	}
	
	/**
	 * 
	 * @기능설명		:	찾아오는길 조회
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 9.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 9.오후 3:10:06
	 * @see			    :	-
	 * @param manager_board_no
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public Map<String, Object> getEnterprise_coming(int manager_board_no) throws SQLException {
		Map<String,Object> dataMap = new HashMap<String,Object>();
		
		Manager_boardVO manager_board = enterprise_comingDAO.selectManager_board_Enterprise_coming(manager_board_no);
		String manager_data_filename = enterprise_comingDAO.selectManager_board_getimage(manager_board_no);
		
		//System.out.println(manager_data_filename);
		manager_board.setManager_data_filename(manager_data_filename);
		
		dataMap.put("manager_board", manager_board);
		dataMap.put("manager_board.manager_data_filename", manager_data_filename);
		
		return dataMap; 
	}

	/**
	 * 
	 * @기능설명		:	찾아오는길 수정
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 9.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 9.오후 3:12:55
	 * @see			    :	-
	 * @param manager_board
	 * @param manager_board_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void modifyEnterprise_coming(Manager_boardVO manager_board, int manager_board_no) throws SQLException {
		//Manager_dataVO manager_data = null;
				
		String manager_data_filename = enterprise_comingDAO.selectManager_board_getimage(manager_board_no);
		//manager_data.setManager_data_filename(manager_data_filename);
		//System.out.println("manager_data : "+manager_data);
		//enterprise_introduceReq.setOld_manager_data_filename(manager_data_filename);		
		//Enterprise_introduceVO enterprise_introduce = enterprise_introduceReq.toEnterprise_introduceVO();
			
		if(manager_board.getManager_data_filename() == null) {
			manager_board.setManager_data_filename(manager_data_filename);
		}
		manager_board.setManager_board_no(manager_board_no);
		
		System.out.println("manager_board.getManager_data_filename() : "+ manager_board.getManager_data_filename());	
		System.out.println("manager_board : " + manager_board);
		
		enterprise_comingDAO.updateManager_board_Manager_data_filename(manager_board);
		enterprise_comingDAO.updateManager_board_enterprise_coming(manager_board);
	}






	
	
}
