package com.dlms.service.cheer;

import java.sql.SQLException;
import java.util.Map;

import com.dlms.dto.CheerVO;

public interface CheerService {

	/**
	 * 
	 * @기능설명		:	응원글 가져와서 등록하기	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 5:42:09
	 * @param 		:	textOnly(작성글)
	 * @throws 		:	SQLException
	 *
	 */
	void insertCheer(CheerVO cheer)throws SQLException;

	/**
	 * 
	 *
	 * @기능설명		:	오늘 날짜 기준으로 응원글리스트 가져오기
	 * @작성자		:	강현철
	 * @작성날짜		:	2020. 6. 20.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 20.오후 4:12:34
	 * @return		:	List(CheerVO)응원글 리스트 
	 */
	Map<String, Object> selectCheerListDaily()throws SQLException;

	
	
	
}
