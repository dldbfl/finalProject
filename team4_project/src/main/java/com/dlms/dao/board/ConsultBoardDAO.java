package com.dlms.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.dlms.dto.ConsultVO;
import com.dlms.request.SearchCriteria;

public interface ConsultBoardDAO {
	
	/**
	 * 
	 * @기능설명		:	상담문의 조회	
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:02:06
	 * @param 		:	cri
	 * @return		: 	List<ConsultVO>
	 * @throws 		:	SQLException
	 *
	 */
	public List<ConsultVO> selectSearchConsultList(SearchCriteria cri)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	조회 페이지 조절을 위한 보조장치	
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:03:10
	 * @param 		:	cri
	 * @return		:	int
	 * @throws 		:	SQLException
	 *
	 */
	public int selectSearchConsultListCount(SearchCriteria cri)throws SQLException;


	
	/**
	 * 
	 * @기능설명		:	답글이 등록된 리스트
	 * @작성자		:	박진영
	 * @작성날짜      	:	2020. 6. 10.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 10.오후 5:54:01
	 * @see			:	
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	public List<ConsultVO> registConsultList(SearchCriteria cri) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	답글이 등록된 리스트 카운트
	 * @작성자		:	박진영
	 * @작성날짜      	:	2020. 6. 10.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 10.오후 5:54:05
	 * @see			:	
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	public int searchRegistConsultList(SearchCriteria cri) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	답글이 등록된 리스트
	 * @작성자		:	박진영
	 * @작성날짜      	:	2020. 6. 10.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 10.오후 5:54:01
	 * @see			:	
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	public List<ConsultVO> noRegistConsultList(SearchCriteria cri) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	답글이 등록된 리스트 카운트
	 * @작성자		:	박진영
	 * @작성날짜      	:	2020. 6. 10.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 10.오후 5:54:05
	 * @see			:	
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	public int searchNoRegistConsultList(SearchCriteria cri) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	클릭한 상담문의 상세조회
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:42:32
	 * @param 		:	consult_no
	 * @return		:	consultVO
	 * @throws 		:	SQLException
	 *
	 */
	public ConsultVO selectConsultByConsult_no(int consult_no)throws SQLException;

	/**
	 * 
	 * @기능설명		:	상담문의 작성
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:43:13
	 * @param 		:	consult
	 * @throws 		:	SQLException
	 *
	 */
	public void insertConsult(ConsultVO consult) throws SQLException;
	
	

	/**
	 * 
	 * @기능설명		:	상담문의 수정
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:43:33
	 * @param 		:	consult
	 * @throws 		:	SQLException
	 *
	 */
	public void updateConsult(ConsultVO consult) throws SQLException;

	/**
	 * 
	 * @기능설명		:	상담문의 삭제
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:43:53
	 * @param 		:	consult_no
	 * @throws 		:	SQLException
	 *
	 */
	public void deleteConsult(int consult_no) throws SQLException;

	/**
	 * 
	 * @기능설명		:	문의에 대한 답글 등록
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:44:16
	 * @param 		:	consult
	 * @throws 		:	SQLException
	 *
	 */
	public void insertAndUpdateAnswer(ConsultVO consult) throws SQLException;

	/**
	 * 
	 * @기능설명		:	답글 삭제
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:44:48
	 * @param 		:	consult_no
	 * @throws 		:	SQLException
	 *
	 */
	public void deleteAnswer(int consult_no) throws SQLException;

	/**
	 * 
	 * @기능설명		:	상담문의 상세조회시 조회수가 1씩 증가
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:45:08
	 * @param 		:	consult_no
	 * @throws 		:	SQLException
	 *
	 */
	public void increaseConsultviewCnt(int consult_no) throws SQLException;

	/**
	 * 
	 * @기능설명		:	문의사항 작성시 게시글 번호가 1씩 증가
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:45:44
	 * @return		:	int
	 * @throws 		:	SQLException
	 *
	 */
	public int selectConsultSeqNext() throws SQLException;
	
	public void read(int consult_no) throws SQLException;
	
	public List<ConsultVO> myConsultList(String member_id) throws SQLException;
}
