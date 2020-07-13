package com.dlms.controller.pay;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dlms.dto.LectureVO;
import com.dlms.dto.MemberVO;
import com.dlms.dto.PayVO;
import com.dlms.dto.StudentVO;
import com.dlms.exception.NotPayCharException;
import com.dlms.request.payRequest;
import com.dlms.service.member.MemberService;
import com.dlms.service.pay.PayService;
import com.dlms.service.student.StudentService;

@Controller
@RequestMapping("/pay")
public class payController {
	@Autowired
	private PayService payService;
	public void setPayService(PayService payService) {
		this.payService = payService;
	}
	@Autowired
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	/**
	 * 
	 * @기능설명		:	신청하기 눌럿을때 화면 전환	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 7. 7.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 7. 7.오전 9:07:31
	 * @see			:	
	 * @param mnv
	 * @param lecture_no
	 * @param session
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/charLMS")
	public ModelAndView detailPay(ModelAndView mnv,String lecture_no, HttpSession session)throws Exception{
		String url="/lecture/lecturePay.page";
		System.out.println("lecture_no : " + lecture_no);
		
		LectureVO lecture = payService.detailPay(Integer.parseInt(lecture_no)); 
		System.out.println("lecture : " +lecture.toString());
		
		payRequest payDetail = payService.selectPayDetail(Integer.parseInt(lecture_no));
		System.out.println("payDetail : " +payDetail);
		
		mnv.addObject("lecture", lecture);
		mnv.addObject("payDetail",payDetail);
		mnv.setViewName(url);
		return mnv;
		
	}
	
	@RequestMapping(value="/lecturePay")
	public ResponseEntity<String> payListCheck(HttpSession session){
		ResponseEntity<String> entity=null;
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		String student_id = loginUser.getMember_id();
		System.out.println("student_id::::"+student_id);
		try {
			payService.selectPayStudentId(student_id);
		} catch (NotPayCharException err) {
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
				
	}
	
	
	/**
	 * 
	 * @기능설명		:	결제 성공 시	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 19.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 19.오전 9:33:19
	 * @see			:	
	 * @param mnv
	 * @param payReq
	 * @param session
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/payIng")
	@ResponseBody
	public String successPay(ModelAndView mnv, @RequestBody payRequest payReq,HttpSession session)throws Exception{
		String url = "/lecture/payIng";
		System.out.println(payReq.getStudent_id());
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		System.out.println("loginUser.getMember_id() : " + loginUser.getMember_id());
		memberService.updateStudentAuthority(loginUser.getMember_id());
		payService.insertPay(payReq);
		
		mnv.addObject(payReq);
		mnv.setViewName(url);
		
		return "{'restult' : 'ok' }";
	}

	
	/**
	 * 
	 * @기능설명		:	결제 성공 화면 전환
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 7. 7.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 7. 7.오전 9:09:07
	 * @see			:	
	 * @param mnv
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/paySuccess")
	public ModelAndView paySuccess(ModelAndView mnv)throws Exception{
		String url = "/lecture/paySuccess.page";
		mnv.setViewName(url);
		return mnv;
	}
	/**
	 * 
	 * @기능설명		:	결제 실패 화면 전환	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 7. 7.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 7. 7.오전 9:09:20
	 * @see			:	
	 * @param mnv
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/payFail")
	public ModelAndView payFail(ModelAndView mnv)throws Exception{
		String url = "/lecture/payFail.page";
		mnv.setViewName(url);
		return mnv;
	}
	
}
