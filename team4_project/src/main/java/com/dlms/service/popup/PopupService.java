package com.dlms.service.popup;

import java.sql.SQLException;

import java.util.Map;

import com.dlms.dto.Manager_boardVO;
import com.dlms.dto.Manager_dataVO;

/**
 * 
 * @사용목적		:	팝업 이미지 관리
 * @작성자		    :	이누리
 * @작성날짜     	:	2020. 6. 13.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 13.오후 2:02:28
 * @see			    :	-
 *
 */
public interface PopupService {
	
	Map<String, Object> getPopup() throws SQLException;

	Manager_dataVO getPopup(int popup_no) throws SQLException;

	void modifyAndDeletePopup(Manager_dataVO manager_data, int popup_no) throws SQLException;
	
	
}


