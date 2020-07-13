package com.dlms.controller.board;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlms.dto.FreeBoard_ReplyVO;
import com.dlms.service.board.FreeboardReplyService;
import com.dlms.service.member.MemberService;

@Controller
@RequestMapping("/freeBoardReply")
public class FreeboardReplyController {

	//url : /replies
	///replies/all/{bno}		list : GET방식, bno번 게시글의 댓글 목록
	///replies/{rno}			modify : PUT,PATCH방식, rno 댓글의 수정 
	///replies/{rno}			remove : DELETE 방식, rno 댓글의 삭제
	///replies 					regist : POST 방식 : 댓글 입력
	///replies/{bno}/{page} 	page list: GET방식 
	//bno번 게시글의 페이징 처리된 댓글 목록

	//required=false 는 당장 bean이 없다고 터지지는 않는데 null포인터가 뜨고
	//required=true 는 bean이 없으면 바로 터치
	
	@Resource(name="member_Profile_Student_PicturePath")
	private String member_Profile_Student_PicturePath;
	
	@Autowired
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Autowired
	private FreeboardReplyService replyService;
	public void setReplyService(FreeboardReplyService replyService) {
		this.replyService = replyService;
	}
	
	
	@RequestMapping("/regist")
	@ResponseBody
	public ResponseEntity<String> registReply(@RequestBody FreeBoard_ReplyVO reply){
		ResponseEntity<String> entity=null;
		try {
			replyService.registReply(reply);
			entity = new ResponseEntity<String>(HttpStatus.OK);
		} catch (SQLException e) {
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	
	@RequestMapping("/replyUpLoad")
	@ResponseBody
	public ResponseEntity<String> replyUpLoad(@RequestBody FreeBoard_ReplyVO reply){
		ResponseEntity<String> entity=null;
		try {
			replyService.modifyReply(reply);
			entity = new ResponseEntity<String>(HttpStatus.OK);
		} catch (SQLException e) {
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	
	@RequestMapping("/remove")
	public ResponseEntity<String> remove(int replyNum){
		System.out.println("replyNum : " + replyNum);
		ResponseEntity<String> entity=null;
		try {
			replyService.removeReply(replyNum);
			System.out.println("!!!!!!!!!여기타나?");
			entity = new ResponseEntity<String>(HttpStatus.OK);
		} catch (SQLException e) {
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	
	
}
	

