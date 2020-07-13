package com.dlms.dao.cheer;

import java.sql.SQLException;
import java.util.List;

import com.dlms.dto.CheerVO;

public interface CheerDAO {

	/**
	 * 
	 * @기능설명		:	전체 응원글 조회 내역리스트
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 4:59:20
	 * @return		:	CheerVOList
	 * @throws 		:	SQLException
	 *
	 */
	List<CheerVO> selectCheerListAll()throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	해당 일에 값을 기준으로 응원글 내역조회 
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 5:00:13
	 * @param 		:	searchDate(해당일)
	 * @return		:	List CheerVO
	 * @throws 		:	SQLException
	 *
	 */
	List<CheerVO> selelctCheerListByDate(String searchDate)throws SQLException;
	/**
	 * 
	 * @기능설명		:	응원글 등록 기능 
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 5:01:38
	 * @param 		:	CheerVO cheer
	 * @throws 		:	SQLException
	 *
	 */
	void insertCheerByCheer(CheerVO cheer)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	글등록시 사용할 시퀀스 데이터 생성 해서 가져오는 기능
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 5:02:46
	 * @return		:	int(글번호)
	 * @throws 		:	SQLException
	 *
	 */
	int selectCheerSeqNextNum()throws SQLException;
	
	
	/**
	 * 
	 * @기능설명		:	cheer글 전체 갯수 가져오기	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 7. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 7. 2.오후 9:03:53
	 * @return		:	글전체갯수
	 * @throws 		:	SQLException	
	 *
	 */
	int selectCheerListAllCnt()throws SQLException;
	
	
	
}
