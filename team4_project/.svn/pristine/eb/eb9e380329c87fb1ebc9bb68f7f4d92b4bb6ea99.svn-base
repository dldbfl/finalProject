package com.dlms.controller.board;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dlms.dto.FreeBoardVO;
import com.dlms.dto.FreeBoard_ReplyVO;
import com.dlms.dto.MemberVO;
import com.dlms.exception.NotFoundMemberDataException;
import com.dlms.request.FreeboardRequest;
import com.dlms.request.SearchCriteria;
import com.dlms.service.board.FreeboardReplyService;
import com.dlms.service.board.FreeboardService;
import com.dlms.service.member.MemberService;

@Controller
@RequestMapping("/board")
public class FreeBoardController {
	@Autowired
	private FreeboardService freeboardService;
	
	@Autowired
	private FreeboardReplyService freeReplyService;
	
	@Autowired
	private MemberService memberService;
	

	@Resource(name = "member_Profile_Student_PicturePath")
	private String memberPictureAttach;
	
	/**
	 * 
	 * @기능설명		:	게시글	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 8.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 8.오후 4:02:39
	 * @see			:	
	 * @param cri
	 * @param mnv
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/free")
	public ModelAndView freeboardList(SearchCriteria cri, ModelAndView mnv)throws Exception{
		String url = "board/free/freeboardList.page";
		Map<String, Object> dataMap = freeboardService.getfreeBoardList(cri);

		mnv.addAllObjects(dataMap);
		mnv.setViewName(url);
		
		//System.out.println(dataMap);
		return mnv;
	}

	@RequestMapping(value="/free/regist",method=RequestMethod.GET)
	public String freeRegistGET(FreeBoardVO freeboard, HttpSession session)throws Exception{
		String url="board/free/freeboardRegist.page";
		return url;
	}
	
	@RequestMapping(value="/free/regist.do",method=RequestMethod.POST)
	public String freeRegistPOST(FreeBoardVO freeboard, HttpServletRequest request) throws Exception{
		String url="board/free/freeboardRegist_success";
		try {
			freeboardService.write(freeboard);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "board/free/freeboardRegist_fail";
		}
		return url;
	}
	
	@RequestMapping(value="/free/detail")
	public ModelAndView freeDetailGET(int freeboard_no, ModelAndView mnv, SearchCriteria cri)throws Exception{
		String url="board/free/freeboardDetail.page";
		FreeBoardVO freeboard = freeboardService.readfreeBoard(freeboard_no);
		List<FreeBoard_ReplyVO> replyList= freeReplyService.getReplyList(freeboard_no);
		System.out.println("여긴 controller"+freeboard+","+freeboard_no);
		//mnv.addAllObjects("replyList",replyList);
		mnv.addObject("freeboard",freeboard);
		mnv.addObject("replyList",replyList);
		mnv.setViewName(url);
		return mnv;
	}
	
	@RequestMapping("/modifyForm")
	public ModelAndView freemodifyForm(int freeboard_no, ModelAndView mnv) throws Exception {
		String url = "board/free/freeboardModify.page";
		FreeBoardVO freeboard = freeboardService.getfreeBoardForModify(freeboard_no);
		mnv.addObject("freeboard", freeboard);
		mnv.setViewName(url);

		return mnv;
	}

	@RequestMapping(value = "modify", method = RequestMethod.POST, produces = "text/plain;charset-utf-8")
	public String freemodify(HttpServletResponse response, HttpServletRequest request,FreeboardRequest freeReq) throws Exception {
		String url = "board/free/freeboardModify_success";

		FreeBoardVO free = freeReq.tofreeboardVO();
		System.out.println("modify:++++++++"+free);
		freeboardService.modify(free);

		return url;
	}

	@RequestMapping(value="/free/remove",method=RequestMethod.GET)
//	public void freeRemove( int freeboard_no, HttpServletResponse response, HttpServletRequest request)throws Exception{
	public ResponseEntity<String> freeRemove(int freeboard_no){
		
		/*System.out.println("Remove"+freeboard_no);
		
		freeboardService.remove(freeboard_no);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
	
		out.println("<script>");
		out.println("alert('게시글이 정상적으로 삭제 되었습니다.');");
		out.println("</script>");*/
		
		ResponseEntity<String> entity=null;
		try {
			freeboardService.remove(freeboard_no);
			entity = new ResponseEntity<String>(HttpStatus.OK);
		} catch (SQLException e) {
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
				
	}
	
	@RequestMapping(value="/free/picture/{member_id}")
	public ResponseEntity<byte[]> memberProfile(@PathVariable("member_id") String member_id,  HttpServletResponse response)throws Exception{
		ResponseEntity<byte[]> entity = null;
		
		//MemberVO member = (MemberVO) memberService.getCertificateList(member_id);
		MemberVO member = memberService.getMember(member_id);

		String fileName = member.getMember_picture();
		String savePath = memberPictureAttach + File.separator + member.getMember_id();
		System.out.println("flie"+fileName);
		FileInputStream in = null;
		System.out.println("save"+savePath);
		try {
			in = new FileInputStream(savePath + File.separator + fileName);
			System.out.println("11");
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), HttpStatus.OK);
		} catch (IOException e) {
			entity = new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		} finally {
			if(in!=null)in.close();
		}
		return entity;

	}
	
//	@RequestMapping(value = "/free/memInfo/{member_id}")
//	@ResponseBody
//	public MemberVO getBoardMember(@PathVariable("member_id") String member_id,  HttpServletResponse response) throws Exception {
//		MemberVO memvo = memberService.getMember(member_id);
//
//		return memvo;
//	}

	@RequestMapping(value = "/free/memInfo/{member_id}")
	@ResponseBody
	public ResponseEntity<Map<String, String>> getBoardMember(@PathVariable("member_id") String member_id,  HttpServletResponse response) throws Exception {
		ResponseEntity<Map<String, String>> entity=null;
		
		Map<String, String> result = new HashMap<String, String>();

		try {
			MemberVO memvo = memberService.getMember(member_id);
			
			result.put("id", memvo.getMember_id());
			result.put("email", memvo.getMember_email());
			result.put("picture", memvo.getMember_picture());
			result.put("infoOpen", memvo.getMember_infoOpen());
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		entity = new ResponseEntity<Map<String, String>>(result, HttpStatus.OK);
		return entity;
	}

	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping("/free/infoMail")
	public ResponseEntity<String> sendEmail(String id, String title, String content,HttpSession session, HttpServletRequest request,Model model) throws SQLException, NotFoundMemberDataException{
		ResponseEntity<String> entity=null;
		MemberVO member = memberService.getMember(id);
		MimeMessage message = mailSender.createMimeMessage();

		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true,"UTF-8");
			messageHelper.setFrom("kkokkok8989@naver.com");
			messageHelper.setTo(member.getMember_email());
			messageHelper.setSubject(title);
			messageHelper.setText(content,true);
			mailSender.send(message);
			
			entity= new ResponseEntity<String>(HttpStatus.OK);

		} catch (MessagingException email) {
			entity= new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			model.addAttribute("excepion", "이메일 발송중 오류가 발상했습니다.");
		} catch (Exception e) {
			entity= new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			model.addAttribute("excepion", "서버 오류로 이메일 발송이 실패했습니다.");
			e.printStackTrace();
		}
		return entity;
	}
}
