package com.dlms.dao.enterprise_introduce;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSessionException;

import com.dlms.dto.Enterprise_introduceVO;
import com.dlms.dto.Manager_dataVO;
import com.dlms.request.Enterprise_introduceRequest;

public interface Enterprise_introduceDAO {

	/**
	 * 
	 * @기능설명		:	기업소개 조회
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 5.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 5.오후 2:06:00
	 * @see			:	-
	 * @return
	 * @throws SQLException
	 *
	 */
	Enterprise_introduceVO selectEnterprise_introduce() throws SQLException;	
		
	/**
	 * 
	 * @기능설명		:	기업소개 수정
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 5.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 5.오후 2:06:14
	 * @see			:	-
	 * @param enterprise_introduce
	 * @throws SQLException
	 *
	 */
	void updateEnterprise_introduce(Enterprise_introduceVO enterprise_introduce)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	기업소개 이미지 도출
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 7.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 7.오후 5:58:14
	 * @see			:	-
	 * @param enterprise_introduce_no
	 * @throws SQLException
	 */
	String selectEnterprise_introduce_getimage(int enterprise_introduce_no) throws SqlSessionException;

	
	/**
	 * 
	 * @기능설명		:	기업소개 이미지 수정
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 8.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 8.오전 11:40:32
	 * @see			:	-
	 * @param manager_dataVO
	 * @throws SQLException
	 *
	 */
	void updateManager_data_filename(Enterprise_introduceVO enterprise_introduce)throws SQLException;
	

}
