package com.dlms.service.board;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dlms.dto.QnaVO;
import com.dlms.request.SearchCriteria;

public interface QnaBoardService {
	
	/**
	 * 
	 * @기능설명		:	질문 조회
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 5:05:20
	 * @param 		:	cri
	 * @return		:	Map<String, Object>
	 * @throws 		:	SQLException
	 *
	 */
	public Map<String, Object> getSearchQnaList(SearchCriteria cri)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	질문 조회
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 5:06:27
	 * @return		:	List<QnaVO>
	 * @throws 		:	SQLException
	 *
	 */
	public List<QnaVO> getQnaList()throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	질문글 상세내용 조회
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 5:06:56
	 * @param 		:	qna_no
	 * @return		:	QnaVO
	 * @throws 		:	SQLException
	 *
	 */
	public QnaVO getDetailList(int qna_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	질문글 상세내용 조회
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 5:06:56
	 * @param 		:	qna_no
	 * @return		:	QnaVO
	 * @throws 		:	SQLException
	 *
	 */
	public QnaVO getDetailList(int qna_no,String check)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	질문글 게시글 작성	
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 5:07:48
	 * @param 		:	qna
	 * @throws 		:	SQLException
	 *
	 */
	public void writer(QnaVO qna)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	질문글에 대한 답글 작성 및 수정
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 5:08:28
	 * @param 		:	qna
	 * @throws 		:	SQLException
	 *
	 */
	public void AnswerWriterAndUpdate(QnaVO qna)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	질문글 수정 
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 5:09:46
	 * @param 		:	qna
	 * @throws 		:	SQLException
	 *
	 */
	public void modify(QnaVO qna)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	질문글 삭제
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 5:10:52
	 * @param 		:	qna_no
	 * @throws 		:	SQLException
	 *
	 */
	public void remove(int qna_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	댓글이 등록된 리스트
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 10.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 10.오후 6:00:04
	 * @see			:	
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	public Map<String, Object> getRegistQnaList(SearchCriteria cri) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	댓글이 등록된 리스트
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 10.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 10.오후 6:00:04
	 * @see			:	
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	public Map<String, Object> getNoRegistQnaList(SearchCriteria cri) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	교수가 지정된 리스트
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 25.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 25.오후 2:35:16
	 * @see			:	
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	public Map<String, Object> getToProfessorQnAList (Map<String, Object> dataMap) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	교수가 지정된 답글 리스트
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 25.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 25.오후 4:03:46
	 * @see			:	
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	public  Map<String, Object> getRegistFromProfessorQnAList (Map<String, Object> dataMap) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	교수가 지정된 미답글 리스트
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 25.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 25.오후 4:04:33
	 * @see			:	
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	public Map<String,Object> getNoRegistFromProfessorQnAList (Map<String, Object> dataMap) throws SQLException;
}
