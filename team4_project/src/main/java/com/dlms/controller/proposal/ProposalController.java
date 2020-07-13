package com.dlms.controller.proposal;

import java.io.PrintWriter;
import java.util.List;

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

import com.dlms.dto.NoticeVO;
import com.dlms.dto.ProposalVO;
import com.dlms.service.proposal.ProposalServiceImpl;

@Controller
@RequestMapping("/myPage/proposal/*")
public class ProposalController {
	
	@Autowired
	ProposalServiceImpl proposalServiceImpl;
	public void setProposalServiceImpl(ProposalServiceImpl proposalServiceImpl) {
		this.proposalServiceImpl = proposalServiceImpl;
	}
	
	
	
	@RequestMapping("list")
	public ModelAndView noticeList(ModelAndView mnv) throws Exception {
		String url = "proposal/proposalList.page";

		List<ProposalVO> proposal = proposalServiceImpl.getProposalList();
		mnv.addObject("proposal", proposal);
		mnv.setViewName(url);
		return mnv;
	}

	@RequestMapping("registForm")
	public ModelAndView registForm(ModelAndView mnv, ProposalVO proposal, HttpServletResponse response) throws Exception {
			String url = "proposal/proposalRegist.page";
			mnv.setViewName(url);
		return mnv;
	}
	@RequestMapping(value="regist", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public void regist(ProposalVO proposal, ModelAndView mnv, HttpServletResponse response) throws Exception {
		proposal.setProposal_writer("mimi");
		proposalServiceImpl.writer(proposal);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('등록되었습니다.');");
		out.println("location.href='list;'");
		out.println("</script>");
	}
	@RequestMapping(value="delete", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
	@ResponseBody
	public ResponseEntity<String> delete(int proposal_num) throws Exception {
		
		ResponseEntity<String> entity = null;
		try {
			proposalServiceImpl.remove(proposal_num);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);	
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return entity;
		
	}
	

	
	@RequestMapping("detail")
	public ModelAndView detail(int proposal_num, ModelAndView mnv) throws Exception {
		String url = "proposal/proposalDetail.page";
		
		ProposalVO proposal = proposalServiceImpl.getDetailProposalList(proposal_num);
		
		mnv.addObject("proposal", proposal);
		mnv.setViewName(url);
		
		return mnv;
	}

	@RequestMapping("modifyForm")
	public ModelAndView modifyForm(int proposal_num, ModelAndView mnv) throws Exception {
		String url = "proposal/proposalModify.page";
		
		ProposalVO proposal = proposalServiceImpl.getDetailProposalList(proposal_num);
		
		
		
		mnv.addObject("proposal", proposal);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="modify", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
	public String modify(int proposal_num, ProposalVO proposal, HttpServletResponse response) throws Exception {
		String url = "redirect:detail";
		url = url + "?proposal_num=" + proposal_num;
		System.out.println("proposal_num : " + proposal_num);
		System.out.println("proposal : " + proposal);
		
		proposalServiceImpl.modify(proposal);

		
		/*response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('수정되었습니다.');");
		out.println("location.href='list;'");
		out.println("</script>");
		*/
		return url;
	}
	
	@RequestMapping("modifyForm1")
	@ResponseBody
	public ResponseEntity<ProposalVO> modifyForm1(int proposal_num) throws Exception {
		
		ResponseEntity<ProposalVO> entity = null;
		
		try {
			ProposalVO proposal = proposalServiceImpl.getDetailProposalList(proposal_num);
			entity = new ResponseEntity<ProposalVO>(proposal, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<ProposalVO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
		
		

	}
}
