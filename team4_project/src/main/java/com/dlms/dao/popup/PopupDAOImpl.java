package com.dlms.dao.popup;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;

import com.dlms.dto.Manager_boardVO;
import com.dlms.dto.Manager_dataVO;
 
public class PopupDAOImpl implements PopupDAO{
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	/**
	 * 
	 * @기능설명		:	팝업 이미지 조회
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 13.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 13.오후 2:00:13
	 * @see			    :	-
	 * @param popup_no
	 * @return
	 * @throws SqlSessionException
	 *
	 */
	@Override
	public String selectpopup(int popup_no) throws SqlSessionException {
		String manager_data_filename = sqlSession.selectOne("popup-mapper.selectpopup",popup_no);
		return manager_data_filename;
	}
	/**
	 * 
	 * @기능설명		:	팝업 조회
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 13.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 13.오후 4:08:36
	 * @see			    :	-
	 * @param popup_no
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public Manager_dataVO selectManager_data(int popup_no) throws SQLException {		
		Manager_dataVO manager_data =null;
		manager_data = sqlSession.selectOne("popup-mapper.selectManager_data",popup_no);
		return manager_data;
	}	
	/**
	 * 
	 * @기능설명		:	팝업 이미지 수정
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 13.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 13.오후 2:00:29
	 * @see			    :	-
	 * @param manager_board
	 * @throws SQLException
	 *
	 */
	@Override
	public void updatepopup(Manager_dataVO manager_data) throws SQLException {
		sqlSession.update("popup-mapper.updatepopup",manager_data);		
	}

	/**
	 * 
	 * @기능설명		:	팝업 이미지 삭제
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 13.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 13.오후 2:00:37
	 * @see			    :	-
	 * @param popup_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void deletepopup(int popup_no) throws SQLException {
		sqlSession.update("popup-mapper.deletepopup",popup_no);		
	}
	
	

	
	
}
