package com.dlms.controller.manager.consult;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dlms.dto.ConsultVO;
import com.dlms.request.SearchCriteria;
import com.dlms.service.board.ConsultBoardService;

/**
 * 
 * @사용목적		:	관리자_상담문의
 * @작성자		    :	이누리
 * @작성날짜     	:	2020. 6. 17.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 17.오후 4:48:26
 * @see			    :	-
 *
 */
@Controller
@RequestMapping("/manager/consult/*")
public class ConsultManagerController {

	@Autowired
	ConsultBoardService consultBoardService;
	public void setConsultBoardService(ConsultBoardService consultBoardService) {
		this.consultBoardService = consultBoardService;
	}
	
	/**
	 * 
	 * @기능설명		:	관리자_상담문의 리스트 출력
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 4:48:37
	 * @see			    :	-
	 * @param cri
	 * @param model
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping("list")
	public String list(SearchCriteria cri, Model model)throws Exception {
		String url = "manager/consult/consultManagerList.page";
		System.out.println(cri);
		Map<String, Object> dataMap =consultBoardService.getConsultList(cri);
		model.addAllAttributes(dataMap);
		
		return url;
	}
	
	/**
	 * 
	 * @기능설명		:	관리자_답변이 등록된 상담문의 리스트 출력
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 4:49:00
	 * @see			    :	-
	 * @param cri
	 * @param model
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping("registList")
	public ModelAndView answerRegistList(SearchCriteria cri, ModelAndView model)throws Exception{
		String url = "manager/consult/consultManagerList.page";
		Map<String, Object> dataMap =consultBoardService.getRegistConsultList(cri);
		model.addAllObjects(dataMap);
		model.addObject("flag", "등록");
		model.setViewName(url);
		return model;
		
	}
	
	/**
	 * 
	 * @기능설명		:	관리자_답변이 등록되지 않은 상담문의 리스트 출력
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 4:49:16
	 * @see			    :	-
	 * @param cri
	 * @param model
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping("noRegistList")
	public ModelAndView answerNoRegistList(SearchCriteria cri, ModelAndView model)throws Exception{
		String url = "manager/consult/consultManagerList.page";
		Map<String, Object> dataMap =consultBoardService.getNoRegistConsultList(cri);
		model.addAllObjects(dataMap);
		model.addObject("flag", "미완");
		model.setViewName(url);
		return model;
		
	}

	/**
	 * 
	 * @기능설명		:	관리자_상담문의 상세보기
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 4:49:29
	 * @see			    :	-
	 * @param consult_no
	 * @param cri
	 * @param mnv
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping("detail")
	@ResponseBody
	public ModelAndView detail (int consult_no, SearchCriteria cri, ModelAndView mnv) throws Exception{
		String url = "manager/consult/consultDetail.page";
		ConsultVO consult = consultBoardService.getDetaiAdminRead(consult_no);
		System.out.println("consult 상세보기 : "+consult);
		mnv.addObject("consult",consult);
		mnv.addObject("pageMaker",cri);
		mnv.setViewName(url);
		return mnv;
		
	}
	
	/**
	 * 
	 * @기능설명		:	관리자_상담문의 수정토대
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 4:49:49
	 * @see			    :	-
	 * @param consult_no
	 * @param model
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping("modifyForm")
	public String modifyForm(int consult_no, Model model) throws Exception {
		String url = "manager/consult/consultModify.page";
	
		return url;
	}
	
	/**
	 * 
	 * @기능설명		:	관리자_상담문의 수정
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 4:50:21
	 * @see			    :	-
	 * @param consult
	 * @param cri
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modify(ConsultVO consult, SearchCriteria cri) throws Exception {
		String url = "redirect:detail";
		url = url + "?consult_no= "+ consult.getConsult_no();
			
		return url;
	}
	
	/**
	 * 
	 * @기능설명		:	관리자_상담문의 답변글 삭제
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 4:50:34
	 * @see			    :	-
	 * @param consult_no
	 * @param response
	 * @throws Exception
	 *
	 */
	@RequestMapping("delete")
	public void delete(int consult_no, HttpServletResponse response) throws Exception {

		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('삭제되었습니다.');");
		out.println("window.opener.location.reload(true);window.close();");
		out.println("</script>");
		
	}
	
	/**
	 * 
	 * @기능설명		:	관리자_상담문의 답변 달기
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 4:50:51
	 * @see			    :	-
	 * @param consult
	 * @param cri
	 * @param model
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping("answer")
	public ModelAndView answer(ConsultVO consult, SearchCriteria cri, ModelAndView model) throws Exception {
		String url = "manager/consult/consultDetail.page";
		/*QnaVO qna =  answerReq.toAnswerVO();*/
		System.out.println("consult 들어온 것, 자 이제 여기에 답글 상태 1을 집어넣는다 : " +consult);
		consult.setConsult_status(1);
		consultBoardService.AnswerWriterAndUpdate(consult);
		
		consult = consultBoardService.getDetaiAdminRead(consult.getConsult_no());
		System.out.println("consult 답글 상태 완료 된것. 해치웠냐 : " +consult);
		model.addObject("consult",consult);
		model.addObject("pageMaker",cri);
		
		model.setViewName(url);
		
		return model;
	}
}
