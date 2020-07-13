package com.dlms.service.pay;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dlms.dto.LectureVO;
import com.dlms.dto.PayVO;
import com.dlms.dto.RefundVO;
import com.dlms.dto.StudentVO;
import com.dlms.exception.NotPayCharException;
import com.dlms.request.LectureReviewRequest;
import com.dlms.request.SearchCriteria;
import com.dlms.request.payRequest;

public interface PayService {

	public Map<String, Object> getPayList(SearchCriteria cri) throws SQLException;
	public List<PayVO> detailPayList(int lecture_no) throws SQLException;
	/**
	 * 
	 * @기능설명		:	수강생모집 결제부분	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 16.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 16.오전 10:41:16
	 * @see			:	
	 * @param payReq
	 * @throws SQLException
	 *
	 */
	void insertPay(payRequest payReq) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	수강생모집과정 결제화면 출력	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 16.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 16.오후 3:44:53
	 * @see			:	
	 * @param lecture_no
	 * @return
	 * @throws SQLException
	 *
	 */
	LectureVO detailPay(int lecture_no)throws SQLException;
	/**
	 * 
	 * @기능설명		:	결제 아이디 번호 조회
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 18.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 18.오전 11:07:53
	 * @see			:	
	 * @return
	 * @throws SQLException
	 *
	 */
	public payRequest selectPayDetail(int pay_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	수강생인지 확인	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 18.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 18.오후 5:57:25
	 * @see			:	
	 * @param student_id
	 * @throws SQLException
	 *
	 */
	void checkStudent(String student_id)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	수강생이 아니면 입력
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 18.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 18.오후 6:25:15
	 * @see			:	
	 * @param student_id
	 * @throws SQLException
	 *
	 */
	void insertStudent(String student_id)throws SQLException;

	
	/**
	 * 
	 * @기능설명		:	수강후기를 위한 결제 리스트
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 18.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 18.오후 4:06:30
	 * @see			:	
	 * @param student_id
	 * @return
	 * @throws SQLException
	 *
	 */
	List<LectureReviewRequest> getreviewCheckList(String student_id)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	학생 리스트	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 25.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 25.오후 3:39:00
	 * @see			:	
	 * @param student_id
	 * @return
	 * @throws SQLException
	 *
	 */
	List<StudentVO> selectStudentList()throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	결제리스트 출력	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 26.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 26.오후 3:51:11
	 * @see			:	
	 * @return
	 * @throws SQLException
	 *
	 */
	List<PayVO> selectPayMyList(String student_id)throws SQLException;
	
	
	/**
	 * 
	 * @기능설명		:	결제리스트 교수 기준 삭제
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 29.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 29.오후 12:48:33
	 * @see			    :	-
	 * @throws SQLException
	 *
	 */
	void deletePay(String professor_id)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	결제리스트 교수 기준 리스트 출력
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 29.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 29.오후 3:06:04
	 * @see			    :	-
	 * @return
	 * @throws SQLException
	 *
	 */
	List<payRequest> selectProfessorPayList(String professor_id)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	환불시 환불리스트에 추가	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 30.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 30.오전 10:40:26
	 * @see			:	
	 * @param RefundVO
	 * @throws SQLException
	 *
	 */
	void insertRefund(RefundVO refund)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	결제취소 성공시 결제내역 삭제	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 7. 1.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 7. 1.오후 2:42:15
	 * @see			:	
	 * @param pay_no
	 * @throws SQLException
	 *
	 */
	void deletePayNo(int pay_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	수강생 아이디로 확인해 두개의 강의를 결제를 막기 위해
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 7. 4.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 7. 4.오후 12:59:51
	 * @see			:	
	 * @param student_id
	 * @return
	 * @throws SQLException
	 *
	 */
	PayVO selectPayStudentId(String student_id)throws SQLException, NotPayCharException;

}