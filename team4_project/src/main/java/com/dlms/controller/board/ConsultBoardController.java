package com.dlms.controller.board;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dlms.dto.ConsultVO;
import com.dlms.request.ConsultRequest;
import com.dlms.request.SearchCriteria;
import com.dlms.service.board.ConsultBoardService;

@Controller
@RequestMapping("/board/consult/*")
public class ConsultBoardController {

	@Autowired
	ConsultBoardService consultBoardService;
	public void setConsultBoardService(ConsultBoardService consultBoardService) {
		this.consultBoardService = consultBoardService;
	}
	
	
	@RequestMapping("list")
	public String list(SearchCriteria cri, Model model)throws Exception {
		String url = "board/consult/consultBoardList.page";
		
		Map<String, Object> dataMap =consultBoardService.getConsultList(cri);
		model.addAllAttributes(dataMap);
		
		return url;
	}
	
	@RequestMapping("registList")
	public ModelAndView answerRegistList(SearchCriteria cri, ModelAndView model)throws Exception{
		String url = "board/consult/consultBoardList.page";
		Map<String, Object> dataMap =consultBoardService.getRegistConsultList(cri);
		model.addAllObjects(dataMap);
		model.addObject("flag", "등록");
		model.setViewName(url);
		return model;
		
	}
	
	@RequestMapping("noRegistList")
	public ModelAndView answerNoRegistList(SearchCriteria cri, ModelAndView model)throws Exception{
		String url = "board/consult/consultBoardList.page";
		Map<String, Object> dataMap =consultBoardService.getNoRegistConsultList(cri);
		model.addAllObjects(dataMap);
		model.addObject("flag", "미완");
		model.setViewName(url);
		return model;
		
	}

	@RequestMapping("registForm")
	public ModelAndView registForm(ModelAndView model) throws Exception {
		String url = "board/consult/consultRegist.page";	
	
		model.setViewName(url);
		return model;
	}
	
	@RequestMapping(value="regist", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
	public void regist( ConsultRequest consultReq, HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		ConsultVO consult = consultReq.toRegistConsultVO();
		consultBoardService.writer(consult);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('질문글이 등록 되었습니다.');");
		out.println("location.href='list'");
		out.println("</script>");
		
	}

	
	
	@RequestMapping("detail")
	@ResponseBody
	public ModelAndView pwdChk (int consult_no, SearchCriteria cri, ModelAndView mnv) throws Exception{
		String url = "board/consult/consultDetail.page";
		ConsultVO consult = consultBoardService.getDetailList(consult_no);
		
		
		mnv.addObject("consult",consult);
		mnv.addObject("pageMaker",cri);
		mnv.setViewName(url);
		return mnv;
		
	}

	@RequestMapping("modifyForm")
	public ModelAndView modifyForm(int consult_no, ModelAndView mnv) throws Exception {
		String url = "board/consult/consultModify.page";
	
		ConsultVO consult = consultBoardService.getDetailList(consult_no);
		
		mnv.addObject("consult", consult);
		mnv.setViewName(url);
		return mnv;
	}

	@RequestMapping(value="modify", method = RequestMethod.POST, produces = "text/plain;charset-utf-8")
	public String modify(int consult_no, ConsultVO consult) throws Exception {
		
		String url = "redirect:detail";
		url = url + "?consult_no= "+ consult_no;
		
		String pwd = consult.getConsult_pwd();

		
		if(pwd!=null) {
			consult.setConsult_type("비밀글");
			
		}
		
		consultBoardService.modify(consult);
		
		return url;
	}
	@RequestMapping("delete")
	public void delete(int consult_no, HttpServletResponse response) throws Exception {

		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('삭제되었습니다.');");
		out.println("window.opener.location.reload(true);window.close();");
		out.println("</script>");
		
	}
/*	@RequestMapping("checkPwd")
	public ModelAndView pwdCheck(int consult_no, String consult_pwd, ModelAndView model) throws Exception {
		String noView = ""; 
		String url = "board/consult/check_pwd.page";
		String pwd = consultBoardService.getDetailList(consult_no,noView).getConsult_pwd();
		
		System.out.println("@@@@@@" + pwd);
		
		model.addObject("consult_no", consult_no);
		model.addObject("pwd", pwd);
		model.setViewName(url);
		
		return model;
	}*/
	
	@RequestMapping("checkPwd")
	@ResponseBody
	public ResponseEntity<Integer> pwdCheck(String consult_no, String consult_pwd,  ModelAndView model) throws Exception {

		ResponseEntity<Integer> entity = null;
		
		int con_no=Integer.parseInt(consult_no);
		
		String noView = ""; 
		
		String checkPwd = consultBoardService.getDetailList(con_no,noView).getConsult_pwd();
		
		if(checkPwd.equals(consult_pwd)){
			entity = new ResponseEntity<Integer>(con_no,HttpStatus.OK);
		}else {
			entity = new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return entity;
	}
	
	@RequestMapping("checkForm")
	public ModelAndView checkForm(SearchCriteria cri, int consult_no, ModelAndView model) throws Exception {
		String url = "board/consult/check_pwd.page";
		model.addObject("consult_no", consult_no);
		model.addObject("pageMaker",cri);
		model.setViewName(url);
		
		return model;
	}
	
}
