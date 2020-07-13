package com.dlms.controller.board;


import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dlms.dto.MemberVO;
import com.dlms.dto.QnaVO;
import com.dlms.request.QnARequest;
import com.dlms.request.SearchCriteria;
import com.dlms.service.board.QnaBoardService;


@Controller
@RequestMapping("/board/qna/*")
public class QnAController {

	@Autowired
	private QnaBoardService qnaBoardService;
	public void setQnaBoardService(QnaBoardService qnaBoardService) {
		this.qnaBoardService = qnaBoardService;
	}

	
	
	@RequestMapping("list")
	public String qnaList(SearchCriteria cri, Model model, HttpSession session) throws Exception {
		String url = "board/qna/qnaBoardList.page";
		
		
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		if(member != null) {
		model.addAttribute("member",member);
		}
		Map<String, Object> dataMap =qnaBoardService.getSearchQnaList(cri);
		model.addAllAttributes(dataMap);
		
		return url;
	}
	@RequestMapping("registList")
	public ModelAndView answerRegistList(SearchCriteria cri, ModelAndView model, HttpSession session)throws Exception{
		String url = "board/qna/qnaBoardList.page";
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		if(member != null) {
		model.addObject("member",member);
		}
		Map<String, Object> dataMap =qnaBoardService.getRegistQnaList(cri);
		model.addAllObjects(dataMap);
		model.addObject("flag", "등록");
		model.setViewName(url);
		return model;
		
	}
	
	@RequestMapping("noRegistList")
	public ModelAndView answerNoRegistList(SearchCriteria cri, ModelAndView model, HttpSession session)throws Exception{
		String url = "board/qna/qnaBoardList.page";
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		if(member != null) {
		model.addObject("member",member);
		}
		Map<String, Object> dataMap =qnaBoardService.getNoRegistQnaList(cri);
		model.addAllObjects(dataMap);
		model.addObject("flag", "미완");
		model.setViewName(url);
		return model;
		
	}
	
	@RequestMapping("answer")
	public ModelAndView answer(QnARequest answerReq, SearchCriteria cri, ModelAndView model) throws Exception {
		String url = "professor/qnaDetail.page";
		QnaVO qna =  answerReq.toAnswerVO();
		qnaBoardService.AnswerWriterAndUpdate(qna);
		String nullcontent="";
		qna = qnaBoardService.getDetailList(qna.getQna_no(), nullcontent);
		model.addObject("qna",qna);
		model.addObject("pageMaker",cri);
		
		model.setViewName(url);
		
		return model;
	} 
		
	@RequestMapping("modifyForm")
	public ModelAndView modifyForm(SearchCriteria cri,QnARequest qnaReq, ModelAndView model)throws Exception{
		String url ="board/qna/qnaModify.page";
		QnaVO qna = qnaBoardService.getDetailList(qnaReq.getQna_no());
		
		model.addObject("qna",qna);
		model.addObject("pageMaker",cri);
		
		model.setViewName(url);
		return model;
	}
	
	@RequestMapping("modify")
	public ModelAndView modify(SearchCriteria cri,QnARequest qnaReq, ModelAndView model)throws Exception{
		String url = "board/qna/qnaDetail.page";
		QnaVO qna = qnaReq.toModifyVO();
		if(qna.getQna_type() == null) {
			qna.setQna_type("일반글");
		}
		qnaBoardService.modify(qna);
		qna = qnaBoardService.getDetailList(qnaReq.getQna_no());
		model.addObject("qna",qna);
		model.addObject("pageMaker",cri);
		model.setViewName(url);
		return model;
	}
	

	@RequestMapping("registForm")
	public ModelAndView registForm(ModelAndView model, HttpSession session) throws Exception {
		String url = "board/qna/qnaRegist.page";	
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		
		model.addObject("member",member);
		model.setViewName(url);
		return model;
	}
	
	@RequestMapping("regist")
	public void regist( QnARequest qnaReq, HttpServletResponse response, HttpServletRequest request ) throws Exception {
		QnaVO qna = qnaReq.toRegistQnAVO();
		if(qna.getQna_type() == null) {
			qna.setQna_type("일반글");
		}
		if(qna.getProfessor_id() ==null) {
			qna.setProfessor_id("");
		}
		qnaBoardService.writer(qna);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('질문글이 등록 되었습니다.');");
		out.println("location.href='list'");
		out.println("</script>");
		
	}


	@RequestMapping("detail")
	public ModelAndView detail (int qna_no, SearchCriteria cri, ModelAndView mnv, HttpSession session) throws Exception{
		String url = "board/qna/qnaDetail.page";
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		QnaVO qna = qnaBoardService.getDetailList(qna_no);
		try {
		if(qna.getQna_answer().equals(member.getMember_id())) {
			mnv.addObject("id","id");
		}
		}catch (NullPointerException e) {
			// TODO: handle exception
		}
		mnv.addObject("qna",qna);
		mnv.addObject("pageMaker",cri);
		mnv.setViewName(url);
		return mnv;
		
	}
	
	@RequestMapping("delete")
	public ModelAndView delete(int qna_no, SearchCriteria cri, ModelAndView mnv) throws Exception {

		String url = "board/qna/qnaBoardList.page";
		qnaBoardService.remove(qna_no);

		Map<String, Object> dataMap =qnaBoardService.getSearchQnaList(cri);
		mnv.addAllObjects(dataMap);
		mnv.setViewName(url);
		return mnv;
	}
	@RequestMapping("checkForm")
	public ModelAndView checkForm(SearchCriteria cri, int qna_no, ModelAndView model) throws Exception {
		String url = "board/qna/check_pwd.page";
		model.addObject("qno", qna_no);
		model.addObject("pageMaker",cri);
		model.setViewName(url);
		
		return model;
	}
	
	@RequestMapping("checkPwd")
	@ResponseBody
	public ResponseEntity<Integer> pwdCheck(String qno, String password,  ModelAndView model) throws Exception {

		ResponseEntity<Integer> entity = null;
		
		int qna_no=Integer.parseInt(qno);
		
		String noView = ""; 
		
		String checkPwd = qnaBoardService.getDetailList(qna_no,noView).getQna_password();
		
		if(checkPwd.equals(password)){
			entity = new ResponseEntity<Integer>(qna_no,HttpStatus.OK);
		}else {
			entity = new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return entity;
	}
}









