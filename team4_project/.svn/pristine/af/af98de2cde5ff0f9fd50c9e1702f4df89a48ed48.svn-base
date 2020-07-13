package com.dlms.controller.board;


import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dlms.dao.attach.NoticeAttachDAOImpl;
import com.dlms.dto.NoticeFileDownloadVO;
import com.dlms.dto.NoticeVO;
import com.dlms.dto.Notice_dataVO;
import com.dlms.request.NoticeAttachRequest;
import com.dlms.request.SearchCriteria;
import com.dlms.service.board.NoticeBoardService;
import com.dlms.utils.DownloadView;


@Controller
@RequestMapping("/board/notice/*")
public class NoticeBoardController {

	@Autowired
	private NoticeBoardService noticeBoardService;

	public void setNoticeBoardService(NoticeBoardService noticeBoardService) {
		this.noticeBoardService = noticeBoardService;
	}

	@Autowired
	private NoticeAttachDAOImpl noticeAttachDAOImpl;

	public void setNoticeAttachDAOImpl(NoticeAttachDAOImpl noticeAttachDAOImpl) {
		this.noticeAttachDAOImpl = noticeAttachDAOImpl;
	}

	
	@RequestMapping("list")
	public ModelAndView noticeList(SearchCriteria cri, ModelAndView mnv, NoticeVO notice) throws Exception {
		String url = "board/notice/noticeBoardList.page";
		
		Map<String, Object> dataMap = noticeBoardService.getNoticeList(cri);
		mnv.addAllObjects(dataMap);
		mnv.setViewName(url);

		return mnv;
	}

	@RequestMapping("registForm")
	public ModelAndView registForm(ModelAndView mnv) throws Exception {
		String url = "board/notice/noticeRegist.page";
		mnv.setViewName(url);

		return mnv;
	}

	@RequestMapping(value = "regist", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public void regist(NoticeAttachRequest registReq, HttpServletResponse response, HttpServletRequest request, String notice_point, String notice_finishdate)
			throws Exception {
		
		
		Date finishDate = new SimpleDateFormat("yyyy-MM-dd").parse(notice_finishdate);
		
		List<Notice_dataVO> notice_attach = saveFile(registReq, request, response);

		NoticeVO notice = registReq.toNotice();
		notice.setNotice_attach(notice_attach);
		notice.setNotice_point(notice_point);
		notice.setNotice_finishdate(finishDate);
		noticeBoardService.writer(notice);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('등록되었습니다.');");
		out.println("location.href='list;'");
		out.println("</script>");

	}

	@RequestMapping("detail")
	public ModelAndView detail(String notice_no, ModelAndView mnv) throws Exception {
		String url = "board/notice/noticeDetail.page";
			
		NoticeVO notice = noticeBoardService.getDetailList(Integer.parseInt(notice_no));
		
		mnv.addObject("notice", notice);
		mnv.setViewName(url);

		return mnv;
	}


	@RequestMapping("modifyForm")
	public ModelAndView modifyForm(int notice_no, ModelAndView mnv) throws Exception {
		String url = "board/notice/noticeModify.page";
		NoticeVO notice = noticeBoardService.getDetailList(notice_no);
		mnv.addObject("notice", notice);
		mnv.setViewName(url);

		return mnv;
	}

	@RequestMapping(value = "modify", method = RequestMethod.POST, produces = "text/plain;charset-utf-8")
	public String modify(int notice_no, HttpServletResponse response, HttpServletRequest request,
			NoticeAttachRequest registReq, String notice_point, String notice_finishdate) throws Exception {
		String url = "redirect:detail";
		url = url + "?notice_no=" + notice_no;

		Date finishDate = new SimpleDateFormat("yyyy-MM-dd").parse(notice_finishdate);
		List<Notice_dataVO> notice_attach = saveFile(registReq, request, response);

		NoticeVO notice = registReq.toNotice();
		notice.setNotice_attach(notice_attach);
		notice.setNotice_no(notice_no);
		notice.setNotice_point(notice_point);
		notice.setNotice_finishdate(finishDate);
		noticeBoardService.modify(notice);

		return url;
	}

	@RequestMapping("delete")
	public void delete(int notice_no, HttpServletResponse response, HttpServletRequest request) throws Exception {

		noticeAttachDAOImpl.deleteAllAttach(notice_no);
		noticeBoardService.remove(notice_no);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('삭제되었습니다.');");
		out.println("location.href='list;'");
		out.println("</script>");
		
		
		
		
	}

	@RequestMapping("attachdelete")
	@ResponseBody
	public String attachdelete(int notice_data_no, HttpServletResponse response) throws Exception {

		noticeAttachDAOImpl.deleteAttach(notice_data_no);

		return "success";

	}

	@RequestMapping("getFile")
	@ResponseBody
	public ResponseEntity<NoticeFileDownloadVO> getFile(String notice_data_no) throws Exception {

		ResponseEntity<NoticeFileDownloadVO> entity = null;

		List<Notice_dataVO> attach_data = noticeAttachDAOImpl
				.selectAttachByNotice_data_no(Integer.parseInt(notice_data_no));

		NoticeFileDownloadVO fileDown = new NoticeFileDownloadVO();

		String filePath = attach_data.get(0).getNotice_fileuploadpath();
		String fileName = attach_data.get(0).getUuid() + "$$" + attach_data.get(0).getNotice_filename();
		String originalName = attach_data.get(0).getNotice_filename();

		fileDown.setFileName(fileName);
		fileDown.setFilePath(filePath);
		fileDown.setOriginalName(originalName);

		entity = new ResponseEntity<NoticeFileDownloadVO>(fileDown, HttpStatus.OK);

		return entity;

	}

	@RequestMapping("getDown")
	@ResponseBody
	public void getDown(String fileName, String filePath, String originalName, HttpServletRequest req,
			HttpServletResponse res, ModelAndView mnv) throws Exception {

		System.out.println(fileName);
		System.out.println(filePath);
		System.out.println(originalName);

		try {
			DownloadView fileDown = new DownloadView(); // 파일다운로드 객체생성
			fileDown.fileDown(req, res, filePath, fileName, originalName, mnv); // 파일다운로드

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Resource(name = "messageAttachPath")
	private String messageAttachPath;

	private List<Notice_dataVO> saveFile(NoticeAttachRequest registReq, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<Notice_dataVO> attachList = new ArrayList<Notice_dataVO>();

		if (registReq.getUploadFile() != null) {
			for (MultipartFile multi : registReq.getUploadFile()) {
				String fileName = UUID.randomUUID().toString().replace("-", "") + "$$" + multi.getOriginalFilename();
				File target = new File(messageAttachPath, fileName);

				if (!target.exists()) {
					target.mkdirs();
				}

				multi.transferTo(target);

				Notice_dataVO attach = new Notice_dataVO();
				attach.setNotice_fileuploadpath(messageAttachPath);
				attach.setNotice_filename(fileName.substring(fileName.lastIndexOf('$') + 1));
				attach.setNotice_filetype(fileName.substring(fileName.lastIndexOf('.') + 1).toUpperCase());
				attach.setUuid(fileName.substring(0, fileName.lastIndexOf('$') - 1));

				attachList.add(attach);
			}
		}

		return attachList;

	}

	
/*	
	@RequestMapping("/commons/idCheck_Send")
	public ResponseEntity<String> idFindSetp2_1(@RequestBody IdCheckSnsRequest snsRequest, ModelAndView mnv){
		ResponseEntity<String> entity=null;
		String randomNum=null;
		try {
			randomNum = Integer.toString((int) (Math.random()*1000000+1));
			entity = new ResponseEntity<String>(randomNum,HttpStatus.OK);
		}catch (Exception e) {
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
//		sendSms(snsRequest.getHp(),randomNum);
		
		return entity;
	}
	
	
	 public void sendSms(String phone ,String randomNum) {
		  String api_key = "NCSBRDTFGRQH1DDI";
		    String api_secret = "O1JGWVIIMKJDXEXIWQ9QMO1FKBUMWVVY";
		    Message coolsms = new Message(api_key, api_secret);

		    // 4 params(to, from, type, text) are mandatory. must be filled
//		    String randomNum = Integer.toString((int) (Math.random()*1000000+1));
		    HashMap<String, String> params = new HashMap<String, String>();
		    params.put("to", phone); // 수신번호
		    params.put("from", "01041095191"); // 발신번호
		    params.put("type", "SMS"); // Message type ( SMS, LMS, MMS, ATA )
		    params.put("text", "인증번호는 "+randomNum + "입니다."); // 문자내용    

		    // Optional parameters for your own needs
		    // params.put("image", "desert.jpg"); // image for MMS. type must be set as "MMS"
		    // params.put("image_encoding", "binary"); // image encoding binary(default), base64 
		    // params.put("mode", "test"); // 'test' 모드. 실제로 발송되지 않으며 전송내역에 60 오류코드로 뜹니다. 차감된 캐쉬는 다음날 새벽에 충전 됩니다.
		    // params.put("delay", "10"); // 0~20사이의 값으로 전송지연 시간을 줄 수 있습니다.
		    // params.put("force_sms", "true"); // 푸시 및 알림톡 이용시에도 강제로 SMS로 발송되도록 할 수 있습니다.
		    // params.put("refname", ""); // Reference name
		    // params.put("country", "KR"); // Korea(KR) Japan(JP) America(USA) China(CN) Default is Korea
		    // params.put("sender_key", "5554025sa8e61072frrrd5d4cc2rrrr65e15bb64"); // 알림톡 사용을 위해 필요합니다. 신청방법 : http://www.coolsms.co.kr/AboutAlimTalk
		    // params.put("template_code", "C004"); // 알림톡 template code 입니다. 자세한 설명은 http://www.coolsms.co.kr/AboutAlimTalk을 참조해주세요. 
		    // params.put("datetime", "20140106153000"); // Format must be(YYYYMMDDHHMISS) 2014 01 06 15 30 00 (2014 Jan 06th 3pm 30 00)
		    // params.put("mid", "mymsgid01"); // set message id. Server creates automatically if empty
		    // params.put("gid", "mymsg_group_id01"); // set group id. Server creates automatically if empty
		    // params.put("subject", "Message Title"); // set msg title for LMS and MMS
		    // params.put("charset", "euckr"); // For Korean language, set euckr or utf-8
		    // params.put("app_version", "Purplebook 4.1") // 어플리케이션 버전

		    try {
		      JSONObject obj = (JSONObject) coolsms.send(params);
		      System.out.println(obj.toString());
		    } catch (CoolsmsException e) {
		      System.out.println(e.getMessage());
		      System.out.println(e.getCode());
		    }
	  }
	 
	
	*/
	
	
	
	
	
	
	
}
