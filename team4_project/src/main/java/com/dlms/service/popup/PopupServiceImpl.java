package com.dlms.service.popup;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.dlms.dao.manager_board.Education_purposeDAO;
import com.dlms.dao.popup.PopupDAO;
import com.dlms.dto.Manager_boardVO;
import com.dlms.dto.Manager_dataVO;



public class PopupServiceImpl<L> implements PopupService {
	
	private PopupDAO popupDAO;
	public void setPopupDAO(PopupDAO popupDAO) {
		this.popupDAO = popupDAO;
	}
	/**
	 * 
	 * @기능설명		:	popup 수정 이미지 조회
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 13.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 13.오후 3:01:53
	 * @see			    :	-
	 * @param popup_no
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public Map<String, Object> getPopup() throws SQLException {
		Map<String,Object> dataMap = new HashMap<String,Object>();
		
		String popup1 = popupDAO.selectpopup(1);	
		String popup2 = popupDAO.selectpopup(2);	
		String popup3 = popupDAO.selectpopup(3);	
		dataMap.put("popup1", popup1);
		dataMap.put("popup2", popup2);
		dataMap.put("popup3", popup3);
		
		return dataMap; 
	}
	
	/**
	 * 
	 * @기능설명		:	특정 이미지 조회
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 13.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 13.오후 3:54:50
	 * @see			    :	-
	 * @param popup_no
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public Manager_dataVO getPopup(int popup_no) throws SQLException {
		Manager_dataVO manager_data = popupDAO.selectManager_data(popup_no);	
		
		return manager_data; 
	}

	/**
	 * 
	 * @기능설명		:	
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 13.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 13.오후 3:02:19
	 * @see			    :	-
	 * @param manager_data
	 * @param popup_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void modifyAndDeletePopup(Manager_dataVO manager_data, int popup_no) throws SQLException {
		//String manager_data_filename = popupDAO.selectpopup(popup_no);
		
		/*if(manager_data.getManager_data_filename() == null) {
			//System.out.println("삭제 : "+popup_no+"번 팝업");
			popupDAO.deletepopup(popup_no);			
		}else {	*/		
			manager_data.setPopup_no(popup_no);
			System.out.println("수정 : "+popup_no+"번 팝업");
			popupDAO.updatepopup(manager_data);		
		/*}*/
	}






	
	
}
