package com.dlms.service.board;

import java.sql.SQLException;
import java.util.Map;

import com.dlms.dto.ConsultVO;
import com.dlms.request.SearchCriteria;

public interface ConsultBoardService {

	/**
	 * 
	 * @기능설명		:	상담문의글 조회	
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:50:57
	 * @param 		:	cri
	 * @return		:	Map<String, Object>	
	 * @throws 		:	SQLException
	 *
	 */
	public Map<String, Object> getConsultList(SearchCriteria cri)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	댓글이 등록된 리스트
	 * @작성자		:	박진영
	 * @작성날짜      	:	2020. 6. 10.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 10.오후 6:00:04
	 * @see			:	
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	public Map<String, Object> getRegistConsultList(SearchCriteria cri) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	댓글이 등록된 리스트
	 * @작성자		:	박진영
	 * @작성날짜      	:	2020. 6. 10.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 10.오후 6:00:04
	 * @see			:	
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	public Map<String, Object> getNoRegistConsultList(SearchCriteria cri) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	문의글 상세내용 조회
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 5:06:56
	 * @param 		:	consult_no
	 * @return		:	consultVO
	 * @throws 		:	SQLException
	 *
	 */
	public ConsultVO getDetailList(int consult_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	문의글 상세내용 조회
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 14.오후 10:06:56
	 * @param 		:	consult_no
	 * @return		:	ConsultVO
	 * @throws 		:	SQLException
	 *
	 */
	public ConsultVO getDetailList(int consult_no, String check)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	문의글 게시글 작성	
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 5:07:48
	 * @param 		:	consult
	 * @throws 		:	SQLException
	 *
	 */
	public void writer(ConsultVO consult)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	문의글에 대한 답글 작성 및 수정
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 5:08:28
	 * @param 		:	consult
	 * @throws 		:	SQLException
	 *
	 */
	public void AnswerWriterAndUpdate(ConsultVO consult)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	문의글 수정 
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 5:09:46
	 * @param 		:	consult
	 * @throws 		:	SQLException
	 *
	 */
	public void modify(ConsultVO consult)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	문의글 삭제
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 5:10:52
	 * @param 		:	consult_no
	 * @throws 		:	SQLException
	 *
	 */
	public void remove(int consult_no)throws SQLException;

	/**
	 * 
	 * @기능설명		:	관리자의 답변완료 조회
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 16.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 16.오후 4:59:50
	 * @see			    :	-
	 * @param consult_no
	 * @return
	 * @throws SQLException
	 *
	 */
	public ConsultVO getDetaiAdminRead(int consult_no) throws SQLException;
	
	
}
