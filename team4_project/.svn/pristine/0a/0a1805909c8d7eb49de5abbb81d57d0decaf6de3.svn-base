package com.dlms.service.pay;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dlms.dao.pay.PayDAO;
import com.dlms.dto.LectureVO;
import com.dlms.dto.MemberVO;
import com.dlms.dto.PayVO;
import com.dlms.dto.RefundVO;
import com.dlms.dto.StudentVO;
import com.dlms.exception.NotFoundMemberDataException;
import com.dlms.exception.NotPayCharException;
import com.dlms.request.LectureReviewRequest;
import com.dlms.request.PageMaker;
import com.dlms.request.SearchCriteria;
import com.dlms.request.payRequest;
import com.dlms.service.member.MemberService;

public class PayServiceImpl implements PayService{

	@Autowired
	private PayDAO payDAO;
	public void setPayDAO(PayDAO payDAO) {
		this.payDAO = payDAO;
	}
	
	@Override
	public Map<String, Object> getPayList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<PayVO> payList = payDAO.selectPayList(cri);
		int totalCount = payDAO.selectPayListCount(cri);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("pay", payList);
		dataMap.put("pageMaker", pageMaker);
		return dataMap;
	}



	@Override
	public List<PayVO> detailPayList(int lecture_no) throws SQLException {
		List<PayVO> payList = payDAO.detailPayList(lecture_no);
				 
		return payList;
	}
	
	@Override
	public void insertPay(payRequest payReq) throws SQLException {
		int pay_no = payDAO.selectPaySeqNext();
		payReq.setPay_no(pay_no);
		System.out.println("insert");
		payDAO.insertPay(payReq);
		System.out.println("pay_no;;;;;"+pay_no);
		System.out.println("Service::::"+payReq);
	}

	@Override
	public LectureVO detailPay(int lecture_no) throws SQLException {
		LectureVO detailPay=payDAO.detailPay(lecture_no);
		return detailPay;
	}

	@Override
	public payRequest selectPayDetail(int pay_no) throws SQLException {
		payRequest payDetail = payDAO.selectPayDetail(pay_no);
		return payDetail;
	}

	@Override
	public void checkStudent(String student_id) throws SQLException {
		payDAO.checkStudent(student_id);
		
	}

	@Override
	public void insertStudent(String student_id) throws SQLException {
		payDAO.insertStudent(student_id);
		
	}


	@Override
	public List<LectureReviewRequest> getreviewCheckList(String student_id) throws SQLException {
		List<LectureReviewRequest> payList = payDAO.detailPayListById(student_id);
		return payList;
	}

	@Override
	public List<StudentVO> selectStudentList() throws SQLException {
		List<StudentVO>studentList = payDAO.selectStudentList();
		System.out.println("studentList"+studentList);
		return studentList;
	}

	@Override
	public List<PayVO> selectPayMyList(String student_id) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();

		List<PayVO> payList = payDAO.selectPayMyList(student_id);
		System.out.println("payMyList:"+payList);
		dataMap.put("payList", payList);
		return payList;
	}

	/**
	 * 
	 * @기능설명		:	교수기준 결제 삭제
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 29.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 29.오후 2:59:04
	 * @see			    :	-
	 * @param professor_id
	 * @throws SQLException
	 *
	 */
	@Override
	public void deletePay(String professor_id) throws SQLException {
		payDAO.deletePay(professor_id);
		
	}
	
	/**
	 * 
	 * @기능설명		:	교수 기준 결제리스트 출력
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 29.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 29.오후 3:06:39
	 * @see			    :	-
	 * @param professor_id
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public List<payRequest> selectProfessorPayList(String professor_id) throws SQLException {
		List<payRequest> payList = payDAO.selectPayProfessorList(professor_id);
		return payList;
	}

	@Override
	public void insertRefund(RefundVO refund) throws SQLException {
		int refund_no = payDAO.selectRefundSeqNext();
		refund.setRefund_no(refund_no);
		
		payDAO.insertRefund(refund);
		
	}

	@Override
	public void deletePayNo(int pay_no) throws SQLException {
		payDAO.deletePayNo(pay_no);
		
	}

	@Override
	public PayVO selectPayStudentId(String student_id) throws SQLException,NotPayCharException {
		PayVO pay = payDAO.selectPayStudentId(student_id);
		if(pay.getStudent_id().equals(student_id))throw new NotPayCharException();
			
		return pay;
	}

	
}
