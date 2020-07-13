package com.dlms.dao.pay;

import java.sql.SQLException;
import java.util.List;

import com.dlms.dto.LectureVO;
import com.dlms.dto.PayVO;
import com.dlms.dto.RefundVO;
import com.dlms.dto.StudentVO;
import com.dlms.request.LectureReviewRequest;
import com.dlms.request.SearchCriteria;
import com.dlms.request.payRequest;

public interface PayDAO {
	
	public List<PayVO> selectPayList(SearchCriteria cri) throws SQLException;
	public int selectPayListCount(SearchCriteria cri) throws SQLException;
	public List<PayVO> detailPayList(int lecture_no) throws SQLException;
	/**
	 * 
	 * @기능설명		:	수강생모집 결제	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 16.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 16.오전 10:34:11
	 * @see			:	
	 * @param pay
	 * @throws SQLException
	 *
	 */
	void insertPay(payRequest pay)throws SQLException;
	/**
	 * 
	 * @기능설명		:	수강생모집 결제번호 증가	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 16.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 16.오전 10:34:28
	 * @see			:	
	 * @return
	 * @throws SQLException
	 *
	 */
	public int selectPaySeqNext() throws SQLException;
	
	/**
	 * 
	 * @기능설명		: 	수강생결제 화면 출력	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 16.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 16.오후 3:40:39
	 * @see			:	
	 * @param lecture_no
	 * @return
	 * @throws SQLException
	 *
	 */
	LectureVO detailPay(int lecture_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	결제번호로 정보출력
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 16.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 16.오후 9:23:27
	 * @see			:	
	 * @param pay_no
	 * @return
	 * @throws SQLException
	 *
	 */
	public PayVO detailPayByPno(int pay_no) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	결제 회원아이디 결제번호 조회용
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 18.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 18.오전 11:03:41
	 * @see			:	
	 * @return
	 * @param pay_no
	 * @throws SQLException
	 *
	 */
	public payRequest selectPayDetail(int pay_no)throws SQLException;
	
	/**
	 * @기능설명		:	수강후기를 위한 수강생 아이디로 조회
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 18.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 18.오후 4:01:20
	 * @see			:	
	 * @param student_id
	 * @return
	 * @throws SQLException
	 *
	 */
	public List<LectureReviewRequest>detailPayListById(String student_id) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:  수강후기를 한번만 쓰게 한다	
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 18.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 18.오후 5:13:52
	 * @see			:	
	 * @param student_id
	 * @throws SQLException
	 *
	 */
	public void reviewCheck(String student_id)throws SQLException;

	/**
	 * 
	 * @기능설명		:	결제 작업전 student에 넣어주기 위한 작업
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 18.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 18.오후 12:19:49
	 * @see			:	
	 * @param student_id
	 * @return 
	 * @throws SQLException
	 *
	 */
	void insertStudent(String member_id)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	수강생인지 아닌지 확인	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 18.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 18.오후 5:52:53
	 * @see			:	
	 * @param student_id
	 * @throws SQLException
	 *
	 */
	void checkStudent(String student_id)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	수강생 리스트 확인
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 25.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 25.오후 3:35:46
	 * @see			:	
	 * @param student_id
	 * @return
	 * @throws SQLException
	 *
	 */
	List<StudentVO>selectStudentList()throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	결제 리스트 출력 
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 26.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 26.오후 3:49:07
	 * @see			:	
	 * @return
	 * @throws SQLException
	 *
	 */
	List<PayVO>selectPayMyList(String student_id)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	환불 처리 	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 30.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 30.오전 10:33:08
	 * @see			:	
	 * @param RefundVO
	 * @throws SQLException
	 *
	 */
	void insertRefund(RefundVO refund)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	교수 기준 결제 삭제
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 29.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 29.오후 6:08:03
	 * @see			    :	-
	 * @param professor_id
	 * @throws SQLException
	 *
	 */
	void deletePay(String professor_id) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	교수 기준 결제내역 조회
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 29.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 29.오후 6:08:57
	 * @see			    :	-
	 * @param professor_id
	 * @return
	 * @throws SQLException
	 *
	 */
	List<payRequest> selectPayProfessorList(String professor_id) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	결제 번호 시퀀스 생성	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 30.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 30.오후 1:58:45
	 * @see			:	
	 * @return
	 * @throws SQLException
	 *
	 */
	int selectRefundSeqNext() throws SQLException;
	
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
	 * @기능설명		:	교수 아이디를 기준으로 강의를 듣는 학생 전체 조회
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 7. 2.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 2.오후 4:55:28
	 * @see			    :	-
	 * @param professor_id
	 * @return
	 * @throws SQLException
	 *
	 */
	List<String>lectureStudentList(String professor_id)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	수강생 아이디로 확인해 두개의 강의를 결제를 막기 위해
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 7. 4.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 7. 4.오후 12:53:36
	 * @see			:	
	 * @param student_id
	 * @return
	 * @throws SQLException
	 *
	 */
	PayVO selectPayStudentId(String student_id)throws SQLException;
}
