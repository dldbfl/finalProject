package com.dlms.dao.popup;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSessionException;

import com.dlms.dto.Manager_boardVO;
import com.dlms.dto.Manager_dataVO;
/**
 * 
 * @사용목적		:	popup 수정용도
 * @작성자		    :	이누리
 * @작성날짜     	:	2020. 6. 13.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 13.오후 1:55:51
 * @see			    :	-
 *
 */
public interface PopupDAO {
	
	String selectpopup(int popup_no) throws SqlSessionException;
	void updatepopup(Manager_dataVO manager_data)throws SQLException;
	void deletepopup(int popup_no)throws SQLException;
	Manager_dataVO selectManager_data(int popup_no) throws SQLException;
}
