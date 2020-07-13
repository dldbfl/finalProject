package com.dlms.dao.pay;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dlms.dto.LectureVO;
import com.dlms.dto.PayVO;
import com.dlms.dto.RefundVO;
import com.dlms.dto.StudentVO;
import com.dlms.request.LectureReviewRequest;
import com.dlms.request.SearchCriteria;
import com.dlms.request.payRequest;

public class PayDAOImpl implements PayDAO{
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public List<PayVO> selectPayList(SearchCriteria cri) throws SQLException {
		List<PayVO> payList = sqlSession.selectList("pay-mapper.selectPayList",cri);
		return payList;
	}
	@Override
	public int selectPayListCount(SearchCriteria cri) throws SQLException {
		int count = sqlSession.selectOne("pay-mapper.sselectPayListCount",cri);
		return count;
	}

	@Override
	public List<PayVO> detailPayList(int lecture_no) throws SQLException {
		System.out.println(lecture_no);
		List<PayVO> payList = sqlSession.selectList("pay-mapper.detailPayList",lecture_no);
		return payList;
	}
	@Override
	public void insertPay(payRequest payReq) throws SQLException {
		System.out.println("payRequest++insertDao+++"+payReq);
		sqlSession.insert("pay-mapper.insertPay",payReq);
		
	}
	@Override
	public int selectPaySeqNext() throws SQLException {
		int pay_no = sqlSession.selectOne("pay-mapper.selectPaySeqNext");
		return pay_no;
	}

	@Override
	public LectureVO detailPay(int lecture_no) throws SQLException {
		LectureVO detailPay = sqlSession.selectOne("pay-mapper.detailPay",lecture_no);
		return detailPay;
	}
	
	@Override
	public PayVO detailPayByPno(int pay_no) throws SQLException {
		PayVO pay = sqlSession.selectOne("pay-mapper.detailPayByPno",pay_no);
		return pay;
	}
	@Override
	public payRequest selectPayDetail(int pay_no) throws SQLException {
		payRequest payDetail = sqlSession.selectOne("pay-mapper.selectPayDetail",pay_no);
		return payDetail;
	}
	@Override
	public void insertStudent(String student_id) throws SQLException {
		sqlSession.update("pay-mapper.insertStudent", student_id);
		
	}
	@Override
	public void checkStudent(String student_id) throws SQLException {
		sqlSession.selectOne("pay-mapper.checkStudent",student_id);
		
	}
	

	@Override
	public List<LectureReviewRequest> detailPayListById(String student_id) throws SQLException {
		List<LectureReviewRequest>	payList = sqlSession.selectList("pay-mapper.detailPayListById",student_id);
		System.out.println(payList);
		return payList;
	}
	@Override
	public void reviewCheck(String student_id) throws SQLException {
		sqlSession.update("pay-mapper.reviewCheck",student_id);
		
	}
	@Override
	public List<StudentVO> selectStudentList() throws SQLException {
		List<StudentVO> studentList = sqlSession.selectList("pay-mapper.selectStudentList");
		return studentList;
	}
	@Override
	public List<PayVO> selectPayMyList(String student_id) throws SQLException {
		List<PayVO> payList = sqlSession.selectList("pay-mapper.selectPayMyList",student_id);
		return payList;
	}
	@Override
	public void insertRefund(RefundVO refund) throws SQLException {
		sqlSession.update("pay-mapper.insertRefund",refund);
	}
	
	/**
	 * 
	 * @기능설명		:	결제 교수 기준 삭제
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 29.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 29.오후 12:38:32
	 * @see			    :	-
	 * @throws SQLException
	 *
	 */
	@Override
	public void deletePay(String professor_id) throws SQLException {
		sqlSession.selectOne("pay-mapper.deletePayProfesser",professor_id);
		
	}
	/**
	 * 
	 * @기능설명		:	결제 교수 기준 리스트 출력
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 29.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 29.오후 6:15:30
	 * @see			    :	-
	 * @param professor_id
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public List<payRequest> selectPayProfessorList(String professor_id) throws SQLException {
		List<payRequest> payList = sqlSession.selectList("pay-mapper.selectPayprofessorList",professor_id);
		return payList;
	}

	@Override
	public int selectRefundSeqNext() throws SQLException {
		int refund_no = sqlSession.selectOne("pay-mapper.selectRefundSeqNext");
		return refund_no;
	}
	@Override
	public void deletePayNo(int pay_no) throws SQLException {
		sqlSession.delete("pay-mapper.deletePayNo",pay_no);
		
	}
	
	/**
	 * 
	 * @기능설명		:	강의 수정자료 전체 조회
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 7. 2.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 2.오후 4:57:40
	 * @see			    :	-
	 * @param professor_id
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public List<String> lectureStudentList(String professor_id) throws SQLException {
			List<String> studentList = sqlSession.selectList("pay-mapper.selectLectureStudentList",professor_id);
		return studentList;
	}
	@Override
	public PayVO selectPayStudentId(String student_id) throws SQLException {
		PayVO student = sqlSession.selectOne("pay-mapper.selectPayStudentId", student_id);
		return student;
	}

}
