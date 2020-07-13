package com.dlms.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dlms.dto.CheerVO;
import com.dlms.dto.Email_certificationVO;
import com.dlms.dto.Founded_reviewVO;
import com.dlms.dto.Founded_review_imgVO;
import com.dlms.dto.LectureVO;
import com.dlms.dto.MemberVO;
import com.dlms.dto.NoticeVO;
import com.dlms.dto.ProfessorVO;
import com.dlms.dto.Professor_careerVO;
import com.dlms.dto.StudentVO;
import com.dlms.dto.Student_certificateVO;
import com.dlms.exception.InUseIdException;
import com.dlms.exception.NotFoundEmailException;
import com.dlms.exception.NotFoundMemberDataException;
import com.dlms.exception.NotMatchEmailException;
import com.dlms.exception.NotMatchedUUIDPwd;
import com.dlms.request.IdCheckSnsRequest;
import com.dlms.request.RegistProfessorInfoRequest;
import com.dlms.request.RegistStudentInfoRequest;
import com.dlms.request.SearchCriteria;
import com.dlms.service.board.NoticeBoardService;
import com.dlms.service.cheer.CheerService;
import com.dlms.service.founded.FoundedReviewService;
import com.dlms.service.lecture.LectureService;
import com.dlms.service.member.MemberService;
import com.dlms.service.popup.PopupService;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Controller
public class CommonController {
	
	@Autowired
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Autowired
	private NoticeBoardService noticeBoardService;
	public void setNoticeBoardService(NoticeBoardService noticeBoardService) {
		this.noticeBoardService = noticeBoardService;
	}
	
	@Autowired
	private PopupService popupService;
	public void setPopupService(PopupService popupService)throws Exception {
		this.popupService = popupService;
	}
	
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private CheerService cheerService;
	public void setCheerService(CheerService cheerService) {
		this.cheerService = cheerService;
	}
	
	@Autowired
	private FoundedReviewService foundedReviewService;
	public void setFoundedReviewService(FoundedReviewService foundedReviewService) {
		this.foundedReviewService = foundedReviewService;
	}
	
	@Autowired
	private LectureService lectureService;
	public void setLectureService(LectureService lectureService) {
		this.lectureService = lectureService;
	}
	
	@RequestMapping("/main")
	public ModelAndView mainPage(ModelAndView mnv, String member_id,HttpSession session)throws Exception {
		String url="main.page";
		SearchCriteria cri= new SearchCriteria();
		Map<String,Object> noticedateList = new HashMap<String, Object>();
		noticedateList=noticeBoardService.getNoticeList(cri);
		List<NoticeVO> noticeList=(List<NoticeVO>) noticedateList.get("noticeList");
		
		//알림기능입니다
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");			
		if(loginUser != null) {
			member_id = loginUser.getMember_id();
			System.out.println("member_id가 있어..? "+member_id);
			int count_consult_end = memberService.mainConsultAlert(member_id);
			mnv.addObject("count_consult_end", count_consult_end);
		}
		
		//팝업기능입니다.
		Map<String, Object> popup = popupService.getPopup();
		mnv.addObject("popup",popup);
		System.out.println(popup);
		
		mnv.addObject("noticeList",noticeList);
		
		mnv.setViewName(url);
		return mnv;
	}
	
	
	
	/**
	 * 
	 * @기능설명		:	
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 7. 10.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 7. 10.오전 11:46:54
	 * @param 		:	textOnly
	 * @param		:	session
	 * @return		:	
	 *
	 */
	@RequestMapping("/registCheerUp")
	public ResponseEntity<String> registCheerUp(String textOnly, HttpSession session){
		ResponseEntity<String> entity=null;
		CheerVO cheer= new CheerVO();
		try {
			MemberVO member=(MemberVO) session.getAttribute("loginUser");
				
			String id=member.getMember_id();
			cheer.setCheer_writer(id);
			cheer.setCheer_content(textOnly);
			cheerService.insertCheer(cheer);
			entity= new ResponseEntity<String>(HttpStatus.OK);
		} catch (SQLException e) {
			entity= new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
			
		return entity;
	}
	/**
	 * 
	 *
	 * @기능설명		:	응원글 리스트를 보여주는 화면 
	 * @작성자		:	강현철
	 * @작성날짜		:	2020. 6. 21.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 21.오전 12:11:16
	 * @param 		:	session	(loginUser 가져오기)
	 * @return		:	entity(ajax 성공, 실패에 따른 결과값)
	 */
	@RequestMapping("/cheerList")
	public ResponseEntity<Map<String, Object>> cheerList(HttpSession session){
		ResponseEntity<Map<String, Object>> entity=null;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		try {
			dataMap=cheerService.selectCheerListDaily();
			entity= new ResponseEntity<Map<String, Object>>(dataMap,HttpStatus.OK);
		} catch (SQLException e) {
			entity= new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		
		return entity;
	}
	
	/**
	 * 
	 * @기능설명		:	
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 20.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 20.오전 09:47:51
	 * @param 		:	session
	 * @return		:	entity(ajax 성공, 실패에 따른 결과값)
	 *
	 */
	@RequestMapping("/foundedReviewList")
	public ResponseEntity<List<Founded_reviewVO>> foundedReviewList(HttpSession session){
		ResponseEntity<List<Founded_reviewVO>> entity=null;
		try {
			List<Founded_reviewVO> founedList=foundedReviewService.getfoundedReviewList();
			entity= new ResponseEntity<List<Founded_reviewVO>>(founedList,HttpStatus.OK);
			
		} catch (SQLException e) {
			entity= new ResponseEntity<List<Founded_reviewVO>>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		
		return entity;
	}
	/**
	 * 
	 * @기능설명		:	
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 7. 10.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 7. 10.오전 11:49:42
	 * @param 		:	session
	 * @return		:	entity(ajax 성공, 실패에 따른 결과값)	
	 *
	 */
	@RequestMapping("/lectureThisMonth")
	public ResponseEntity<List<LectureVO>> lectureThisMonth(HttpSession session){
		ResponseEntity<List<LectureVO>> entity=null;
		try {
			List<LectureVO> lectureList= lectureService.getLectureList();
			entity= new ResponseEntity<List<LectureVO>>(lectureList,HttpStatus.OK);

			
		} catch (SQLException e) {
			entity= new ResponseEntity<List<LectureVO>>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		
		return entity;
	}
	
	/**
	 * 	
	 * @기능설명		:	로그인을 누르면 로그인 화면으로 이동하는 기능	
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 2:12:31
	 * @return		:	화면경로
	 * @throws 		:	Exception
	 *
	 */
	@RequestMapping("/commons/login")
	public String loginForm()throws Exception {
		return "commons/login.login";
	}
	
	// java 시큐리티에서 하는기능
	/*@RequestMapping("/commons/loginCheck")
	public ModelAndView loginCheck(MemberVO member , ModelAndView mnv){
		ResponseEntity<Map<String,Object>> entity=null;
		MemberVO memberInfo =new MemberVO();
		
		String id= member.getMember_id();
		String pwd= member.getMember_pwd();
		
		memberInfo.setMember_id(id);
		memberInfo.setMember_pwd(pwd);
		
		Map<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put("member",memberInfo);
		
		mnv.addObject("member",memberInfo);
		
		try {
			memberService.Login(id, pwd);
			entity= new ResponseEntity<Map<String,Object>>(dataMap,HttpStatus.OK);
		}catch(NotMathchedIdAndPwd notMath) {
			dataMap.put("exception",notMath.getMessage());
			entity= new ResponseEntity<Map<String,Object>>(dataMap,HttpStatus.BAD_REQUEST);
			notMath.getMessage();
		}catch(OutOfficeMemberException outOffice) {
			dataMap.put("exception",outOffice.getMessage());
			entity= new ResponseEntity<Map<String,Object>>(dataMap,HttpStatus.BAD_REQUEST);
			outOffice.getMessage();
		}catch(PwdWrongInputException overInput) {
			dataMap.put("exception", overInput.getMessage());
			entity= new ResponseEntity<Map<String,Object>>(dataMap,HttpStatus.BAD_REQUEST);
			overInput.getMessage();
		}catch(SQLException e) {
			entity= new ResponseEntity<Map<String,Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		
		return entity;
	}*/
	/**
	 * 
	 * @기능설명		:	세션이 만료되면 자동으로 로그인아웃을 하여 정해진 곳으로 이동 기능
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 2:02:47
	 * @param 		:	response
	 * @param 		:	request
	 * @throws		:	Exception
	 *
	 */
	@RequestMapping("/commons/loginTimeOut")
	public String loginTimeOut()throws Exception{
		String url="/error/loginTimeOut.page";
		return url;
	}

	//중복 로그인시 해당 메시지 출력 및 화면 전환
	/**
	 * 
	 * @기능설명		:	중복로그인시 화면 전환 기능
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 2:02:11
	 * @param 		:	response
	 * @param 		:	request
	 * @throws 		:	Exception
	 *
	 */
	@RequestMapping("/commons/loginExpired")
	public void loginExpired(HttpServletResponse response, HttpServletRequest request)throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String retURL = request.getHeader("Referer");
		if(retURL == null || retURL.contains("login")) {
			retURL = request.getContextPath() +"/commons/login";
		}
		
		out.println("<script>");
		out.println("alert('중복 로그인이 확인되었습니다 \\n다시 로그인하면 다른 장치에서 로그인은 취소됩니다.');");
//		out.println("location.href ='"+request.getContextPath()+"/commons/login';");
		out.println("location.href ='"+retURL+"';");
		out.println("</script>");
		
	}
	
	/**
	 * 
	 * @기능설명		:	아이디 찾기 화면으로 이동 기능
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 2:01:36
	 * @return		:	화면경로
	 * @throws 		:	Exception
	 *
	 */
	@RequestMapping("/commons/idForgot")
	public String idFindSetp1()throws Exception {
		return "commons/idForgot.login";
	}
	/**
	 * 
	 * @기능설명		:	휴대폰찾기 화면으로 이동 기능
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 2:01:14
	 * @return		:	화면경로
	 * @throws 		:	Exception
	 *
	 */
	@RequestMapping("/commons/pwdFoget")
	public String pwdFindSetp1()throws Exception {
		return "commons/pwdForgot.login";
	}
	/**
	 * 
	 * @기능설명		:	이름과 이메일을 기준으로 아이디를 찾는 기능
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 1:59:44
	 * @param 		:	mem(id,name)
	 * @param 		:	ModelAndView mnv
	 * @return		:	mnv(화면 결정주소, 해당개인저보를 가지고 있는 객체)
	 *
	 */
	@RequestMapping("/commons/idCheck_EmailCertify")
	public ModelAndView idFindSetp1_1(MemberVO mem, ModelAndView mnv ) {
		String url="commons/idcheckLoadingEmail.login";
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		try {
			memberList = memberService.getMemberByNameAndEmailFind(mem);
		} catch(NotFoundEmailException email) {
			mnv.addObject("exception",email.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		mnv.addObject("memberList", memberList);
		mnv.setViewName(url);
		return mnv;
	}
	/**
	 * 
	 * @기능설명		:	해당 휴대폰번로 인증문자 발송 기능	
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 1:58:27
	 * @param 		:	snsRequest(id,hp,name)
	 * @param 		:	ModelAndView mnv
	 * @return		:	entity(ajax 성공, 실패에 따른 결과값)
	 *
	 */
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
		sendSms(snsRequest.getHp(),randomNum);
		
		return entity;
	}
	/**
	 * 
	 * @기능설명		:	아이름과 휴대폰번호를 가지고 해당 이름이 있는지 확인하는 기능
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 1:57:00
	 * @param 		:	member(이름,휴대폰번호)
	 * @return		:	entity(ajax 성공, 실패에 따른 결과값)
	 *
	 */
	@RequestMapping(value="/commons/idcheckLoading",method=RequestMethod.POST)
	public ResponseEntity<List<MemberVO>> idCheckLoading(@RequestBody MemberVO member) {
		ResponseEntity<List<MemberVO>> entity=null;
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		try {
			memberList=memberService.checkMemberByNameAndHpFind(member);
			entity = new ResponseEntity<List<MemberVO>>(memberList,HttpStatus.OK);
		} catch (NotFoundMemberDataException data) {
			entity = new ResponseEntity<List<MemberVO>>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * 
	 * @기능설명		:	아이디 일치확인후 아이디를 알려주는 화면으로 이동기능	
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 1:53:17
	 * @param		:	ModelAndView mnv
	 * @param 		:	member(member_id)
	 * @return		:	mnv(화면 결정 주소, id를 가지고 있는 객체)
	 * @throws 		:	Exception
	 *
	 */
	@RequestMapping("/commons/idcheckPage")
	public ModelAndView idCheckLoading(ModelAndView mnv, String member_name, String member_phone )throws Exception {
		String url="/commons/idcheckLoadingPhone.login";
		MemberVO member = new MemberVO();
		member.setMember_name(member_name);
		member.setMember_phone(member_phone);
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		memberList=memberService.checkMemberByNameAndHpFind(member);
		mnv.addObject("memberList",memberList);
		mnv.setViewName(url);
		return mnv;
	}
	/**
	 * 
	 * @기능설명		:	난수 6자리를 만들어서 내보내는 기능
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 1:50:44
	 * @param 		:	ModelAndView mnv
	 * @return		:	mnv(화면결정 URL, 난수)
	 *
	 */
	@RequestMapping("/commons/pwdCheck_Send")
	public ResponseEntity<String> pwdFindSetp2_1(@RequestBody IdCheckSnsRequest snsRequest, ModelAndView mnv){
		ResponseEntity<String> entity=null;
		String randomNum=null;
		try {
			randomNum = Integer.toString((int) (Math.random()*1000000+1));
			entity = new ResponseEntity<String>(randomNum,HttpStatus.OK);
		}catch (Exception e) {
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		sendSms(snsRequest.getHp(),randomNum);
		
		return entity;
	}
	/**
	 * 
	 * @기능설명		:	휴대폰인증후 해당 아이디로 일치하는지 확인하는 기능
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 1:43:15
	 * @param 		:	member(id,name,phone)
	 * @return		:	entity(ajax 성공,실패에 따른 결과값)
	 *
	 */
	@RequestMapping("/commons/pwdCheckLoading")
	public ResponseEntity<MemberVO> pwdCheckLoading(@RequestBody MemberVO member) {
		ResponseEntity<MemberVO> entity=null;
		try {
			MemberVO mem=memberService.getMember(member.getMember_id());
			entity = new ResponseEntity<MemberVO>(mem,HttpStatus.OK);
		} catch (NotFoundMemberDataException data) {
			entity = new ResponseEntity<MemberVO>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * 
	 * @기능설명		:	비밀번호찾기에서 휴대폰번호 인증 후 비밀번호  
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 1:35:51
	 * @see			:	
	 * @param mnv
	 * @param member
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping("/commons/pwdcheckPage")
	public ModelAndView pwdCheckLoading(ModelAndView mnv, String member)throws Exception {
		String url="/commons/pwdcheckLoadingPhone.login";
		mnv.setViewName(url);
		mnv.addObject("member_id",member);
		return mnv;
	}
	/**
	 * 
	 * @기능설명		:	이메일 인증버튼을 누르면 해당 이메일로 인증메일(id,key)전송기능
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 1:32:07
	 * @param 		:	member(id, email)
	 * @param 		:	request
	 * @param 		:	ModelAndView model
	 * @return		:	entity(ajax 성공,실패 여부에 따른 결과값)
	 *
	 */
	@RequestMapping("/commons/certifyEmail")
	public ResponseEntity<String> sendEmail(@RequestBody MemberVO member, HttpServletRequest request,Model model){
		ResponseEntity<String> entity=null;
		
		MimeMessage message = mailSender.createMimeMessage();

		String key = UUID.randomUUID().toString().replace("-", ""); 
		
		String content="<h2>안녕하세요 "+ member.getMember_name()+"님</h2><br><br>"
					 + "<h3>" + member.getMember_name() + "님</h3>" + "<p>이메일 인증을 하시려면 이메일 인증 버튼을 눌러주세요 " 
					 + "<a href='http://localhost:80" + request.getContextPath() + "/commons/checkPwdForm?member_id="+ member.getMember_id() +"&member_key="+key+"'>인증하기</a></p>"
					 + "(불편 사항은 해당 고객센터로 문의 바랍니다)";
		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true,"UTF-8");
			memberService.checkMemberByIdAndNameAndEmailFind(member);
			messageHelper.setFrom("kkokkok8989@naver.com");
			messageHelper.setTo(member.getMember_email());
			messageHelper.setSubject("[본인인증] D-LMS " + member.getMember_name()+"님의 인증메일");
			messageHelper.setText(content,true);
			mailSender.send(message);
			
			member.setMember_pwd(key);
			
			entity= new ResponseEntity<String>(HttpStatus.OK);
			
			//패스워드에 UUID 넣기(인증메일에 URL과 비교해서 화면보여주기위해)
			memberService.insertPwdByIdAndPwd(member);
		} catch (MessagingException email) {
			entity= new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			model.addAttribute("excepion", "이메일 발송중 오류가 발상했습니다.");
		} catch (NotFoundMemberDataException e) {
			entity= new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			model.addAttribute("excepion", e.getMessage());
		} catch (Exception e) {
			entity= new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			model.addAttribute("excepion", "서버 오류로 이메일 발송이 실패했습니다.");
			e.printStackTrace();
		}
		return entity;
	}
	
	
	/**
	 * 
	 * @기능설명		:	이메일로 인증 받은 인증링크를 클릭시 해당 id와 key값을 가져와서 비밀번호변경 화면으로 보내주는 기능 
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 12:43:05
	 * @param 		:	ModelAndView mnv
	 * @param 		:	member_id(아이디)
	 * @param 		:	member_key(인증문자)
	 * @return		:	mnv(화면결정 URL)
	 * @throws 		:	Exception
	 *
	 */
	@RequestMapping("/commons/checkPwdForm")
	public ModelAndView checkPwdForm(ModelAndView mnv,String member_id, String member_key)throws Exception {
		MemberVO member = new MemberVO();
		String url ="commons/checkPwdForm.login";
		member.setMember_id(member_id);
		member.setMember_pwd(member_key);
		mnv.addObject("member",member);
		mnv.setViewName(url);
		
		return mnv;
	}
	/**
	 * 
	 * @기능설명		:	인증받은 문자가 있는지 확인 하는 작업
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 12:39:30
	 * @param 		:	member(해당아이디)
	 * @return		:	entity(ajax 성공,실패 여부에 따른 상태값)
	 * @throws 		:	Exception
	 *
	 */
	@RequestMapping("/checkPwd")
	public ResponseEntity<String> checkPwd(@RequestBody MemberVO member)throws Exception{
		ResponseEntity<String> entity=null;
		String id =member.getMember_id();
		try {
			memberService.checkPwd(member);
			entity = new ResponseEntity<String>(id,HttpStatus.OK);
		} catch (NotMatchedUUIDPwd e) {
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		} catch (SQLException e) {
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * 
	 * @기능설명		:	새로운 비밀번호 등록 화면(아이디를 가지고) 
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 12:36:12
	 * @param 		:	ModelAndView mnv
	 * @param 		:	member_id(기존아이디)
	 * @return		:	mnv(화면결정 URL)
	 * @throws 		:	Exception
	 *
	 */
	@RequestMapping("/commons/makePassword")
	public ModelAndView makePassword(ModelAndView mnv, String member_id)throws Exception {
		String url="commons/makePassword.login";
		mnv.addObject("member_id",member_id);
		mnv.setViewName(url);
		return mnv;
	}
	/**
	 * 
	 * @기능설명		:	새로운 비밀번호  등록
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 12:34:23
	 * @param 		:	ModelAndView mnv
	 * @param 		:	member(아이디 비밀번호를 통한 비밀번호 변경)
	 * @return		:	mnv(화면결정URL)
	 * @throws 		:	Exception
	 *
	 */
	@RequestMapping("/commons/insertPwd")
	public ModelAndView newMakePwd(ModelAndView mnv, MemberVO member)throws Exception {
		String url="commons/login.login";
		try {
			memberService.insertPwdByIdAndPwd(member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		mnv.setViewName(url);
		return mnv;
	}
	/**
	 * 
	 * @기능설명		:	교수 또는 학생 회원가입 선택 화면
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 12:33:46
	 * @return		:	화면URL
	 * @throws 		:	Exception
	 *
	 */
	@RequestMapping("/commons/registFormChoose")
	public String registFormChoose()throws Exception {
		return "commons/registFormChoose.login";
	}
	/**
	 * 
	 * @기능설명		:	이용약관동의 화면(교수또는 학생의 결정 인자를 가지고)
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 12:32:19
	 * @param 		:	ModelAndView mnv
	 * @param 		:	member(교수또는 학생의 결정인자)
	 * @return		:	mnv(화면결정 URL)
	 * @throws 		:	Exception
	 *
	 */
	@RequestMapping("/commons/termsOfService")
	public ModelAndView termsOfServiceForm(ModelAndView mnv,String member)throws Exception {
		String url="commons/termsOfService.login";
		mnv.addObject("member",member);
		mnv.setViewName(url);
		return mnv;
	}
	/**
	 * 
	 * @기능설명		:	회원가입 3단계 화면 (이전 교수 또는 학생 결정인자와, 약관동의 인자를 가지고) 이동
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 12:29:14
	 * @param 		:	ModelAndView mnv
	 * @param 		:	memAgree(약관동의 여부문구)
	 * @param 		:	member(교수 또는 학생 결정인자)
	 * @return		:	mnv(화면결정 URL)
	 * @throws 		:	Exception
	 *
	 */
	@RequestMapping("/commons/registForm")
	public ModelAndView registForm(ModelAndView mnv,String memAgree,String member)throws Exception {
			String url="/commons/registForm.login";
			mnv.addObject("memAgree",memAgree);
			mnv.addObject("member",member);
			mnv.setViewName(url);
		return mnv;
	}
	
	/**
	 * 
	 * @기능설명		:	입력받은 아이디를 가지고 아이디 중복검사 	
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 10.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 10.오후 4:56:47
	 * @param 		:	id(입력아이디)
	 * @return		:	success 또는 error
	 *
	 */
	@RequestMapping("/commons/searchId")
	public ResponseEntity<String> searchId(Model model,String member_id)throws Exception {
		ResponseEntity<String> entity=null;
		
		try {
			memberService.searchId(member_id);
			entity= new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (InUseIdException e) {
			entity= new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			model.addAttribute("exception",e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return entity;
	}
	
	//학생 프로필사진 저장 경로
	@Resource(name="member_Profile_Student_PicturePath")
	private String member_Profile_Student_PicturePath;
	
	//교수 프로필사진 저장 경로
	@Resource(name="member_Profile_Professor_PicturePath")
	private String member_Profile_Professor_PicturePath;
	
	//교수 경력사항File 저장 경로
	@Resource(name="member_Professor_CareerPath")
	private String member_Professor_CareerPath;

	
	//수강생 가입버튼 클릭시 저장 및 화면 보여주는 작업
	/**
	 * 
	 * @기능설명		:	수강생 가입버튼 클릭시 저장 및 화면 보여주는 작업	
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 12:28:10
	 * @param 		:	info(학생용 커맨드객체)
	 * @param 		:	ModelAndView mnv
	 * @param 		:	request
	 * @return		:	mnv(화면결정 URL)
	 * @throws 		:	Exception
	 *
	 */
	@RequestMapping("/commons/registMember")
	public ModelAndView registStudentMember(RegistStudentInfoRequest info, ModelAndView mnv,HttpServletRequest request)throws Exception {
		String url="/commons/registSuccess.login";
		
		try {
			//파일 로컬에 저장 하고 파일 넘로드
			String uplaodProFileName = saveProFile(info,request);
			MemberVO member= new MemberVO();
			StudentVO student = new StudentVO();
			member=info.tomember();
			member.setMember_picture(uplaodProFileName);
			student=info.toStudentVO();
			Student_certificateVO[]	certificateVO = info.getCertificate();
			for(Student_certificateVO vo : certificateVO) {
				vo.setStudent_id(member.getMember_id());
			}
			member.setMember_authority("USER");
			member.setMember_status(1);
			memberService.registStudent(member, student, certificateVO);
			
		} catch (IllegalStateException | IOException | SQLException  e) {
			e.printStackTrace();
		}
		mnv.setViewName(url);
		return mnv;
	}
	
	/**
	 * @기능설명		:	교수 가입버튼 클릭시 저장 및 화면 보여주는 작업	
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 12:26:21
	 * @param 		:	mnv
	 * @param 		:	request
	 * @param 		:	pro(교수용VO)
	 * @param 		:	proInfo(교수용 커맨드객체)
	 * @return		:	mnv(화면결정 URL)
	 * @throws 		:	Exception
	 *
	 */
	@RequestMapping("/commons/registMemberProfessor")
	public ModelAndView registMemberProfessor(ModelAndView mnv, HttpServletRequest request, ProfessorVO pro, RegistProfessorInfoRequest proInfo)throws Exception {
		String url="/commons/registSuccess.login";
		
		try {
			//파일 로컬에 저장 하고 파일 넘로드
			String uplaodProFileName = saveProFile(proInfo,request);
			List<String> uploadCareerName = saveCareerFile(proInfo,request);
			
			MemberVO member = new MemberVO();
			member=proInfo.tomember();
			member.setMember_picture(uplaodProFileName);
			Professor_careerVO[] careers = proInfo.getCareer();
			
			for(int i=0; i<uploadCareerName.size(); i++) {
				String careerName=uploadCareerName.get(i);
				careers[i].setProfessor_career(careerName);
			}
			
			for(Professor_careerVO career : careers) {
				
				pro.setProfessor_id(member.getMember_id());
				career.setProfessor_id(member.getMember_id());
			}
			
			member.setMember_authority("PROFESSOR");
			member.setMember_status(2);
			
			memberService.registProfessor(member, pro, careers);
			
		} catch (IllegalStateException | IOException | SQLException  e) {
			e.printStackTrace();
		}
		
		mnv.setViewName(url);
		
		return mnv;
	}
	
	/**
	 * 
	 * @기능설명		:	인증 문자를 이메일로 보내어 이메일 인증을 하는 기능
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 12:24:47
	 * @param 		:	emailAddr(입력한이메일주소)
	 * @param 		:	request
	 * @return		:	entity(ajax 성공,실패에 따른 상태값 넘김)
	 * @throws 		:	Exception
	 *
	 */
	@RequestMapping("/commons/emailSendCheckNum")
	public ResponseEntity<String> emailSendCheckNum(String emailAddr, HttpServletRequest request)throws Exception{
			ResponseEntity<String> entity=null;
			
			MimeMessage message = mailSender.createMimeMessage();

			String key = UUID.randomUUID().toString().replace("-", ""); 
			String content="<h2>안녕하세요 D-LMS 창업 교육 센터 입니다.</h2><br><br>"
						 + "<h3><p>이메일 인증을 하시려면 이메일 인증 버튼을 눌러주세요 " 
						 + "<a href='http://localhost:80" + request.getContextPath() + "/commons/checkEmailForm?emailAddress="+ emailAddr +"&emailKey="+key+"'>인증하기</a></p>"
						 + "(불편 사항은 해당 고객센터로 문의 바랍니다)";
			Email_certificationVO certification= new Email_certificationVO();
			certification.setEmail_address(emailAddr);
			certification.setEmail_checktext(key);
				MimeMessageHelper messageHelper;
				try {
					messageHelper = new MimeMessageHelper(message,true,"UTF-8");
				
					memberService.insertEmailSendText(certification);
					messageHelper.setFrom("kkokkok8989@naver.com");
					messageHelper.setTo(emailAddr);
					messageHelper.setSubject("[본인인증] D-LMS 이메일인증");
					messageHelper.setText(content,true);
					mailSender.send(message);
					entity= new ResponseEntity<String>(key,HttpStatus.OK);
				} catch (MessagingException e) {
					entity= new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
					e.printStackTrace();
				} catch (SQLException e) {
					entity= new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
					e.printStackTrace();
				}

			return entity;
	}
	/**
	 * 
	 * @기능설명		:	해당 이메일함에서 이메일인증을 클릭시 인증문구, 체크문구, 이메일주소 등록 기능
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 12:21:38
	 * @param 		:	ModelAndView mnv
	 * @param 		:	emailAddress(이메일주소)
	 * @param 		:	emailKey(인증문자)
	 * @return		:	mnv(보여줄 화면 URL)
	 * @throws 		:	Exception
	 *
	 */
	@RequestMapping("/commons/checkEmailForm")
	public ModelAndView checkEmailForm(ModelAndView mnv, String emailAddress, String emailKey)throws Exception {
		String url="commons/checkEmailForm.login";
		Email_certificationVO certification= new Email_certificationVO();
		certification.setEmail_address(emailAddress);
		certification.setEmail_checktext(emailKey);
		certification.setEmail_check("Y");
		try {
			memberService.updateEmailCheck(certification);
			mnv.setViewName(url);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mnv;
			
			
	}
	/**
	 * 
	 * @기능설명		:	회원가입시 해당 이메일인증메일에 있는 인증문구의 값과 DB에 있는 인증문구의 값 비교하는 기능
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 12:18:13
	 * @param 		:	emailVO(이메일,인증문자)
	 * @return		:	entity (ajax에 성공,실패 여부에 따른 결과값)
	 * @throws 		:	Exception
	 *
	 */
	@RequestMapping("/commons/registBtnEmailCheck")
	public ResponseEntity<String> registBtnEmailCheck(Email_certificationVO  emailVO)throws Exception{
		ResponseEntity<String> entity = null;
		try {
			memberService.selectEmailTextCheck(emailVO);
			entity= new ResponseEntity<String>(HttpStatus.OK);
		} catch (NotMatchEmailException e) {
			entity= new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		} catch (SQLException e) {
			entity= new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		
		return entity;
	}
	
	@RequestMapping("/board/tableList")
	public String asdsd()throws Exception {
		return "/board/tableList";
	}
	/**
	 * 
	 * 기능설명		:	학생 프로필 사진 저장 기능	
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 12:16:23
	 * @see			:	registForm(학생용)
	 * @param 		:	info(학생용 커맨드객체)
	 * @param 		:	request
	 * @return		:	fileName(파일이름)
	 * @throws 		:	IllegalStateException
	 * @throws 		:	IOException
	 *
	 */
	public String saveProFile(RegistStudentInfoRequest info, HttpServletRequest request) throws IllegalStateException, IOException {
		
		MultipartFile file=info.getPicture();
		
		String filename = UUID.randomUUID().toString().replace("-", "") + "$$"
				+ file.getOriginalFilename();
		
		File savePath = new File(member_Profile_Student_PicturePath,filename);
		if(!savePath.exists()) {
			savePath.mkdirs();
		}
		file.transferTo(savePath);
		return filename;
	}
	/**
	 * 
	 * @기능설명		:	교수 프로필 사진 저장 기능
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 12:02:49
	 * @see			:	registForm(학생용)
	 * @param 		:	proInfo(교수용 커맨드객체)
	 * @param 		:	request
	 * @return		:	fileName(파일이름)
	 * @throws 		:	IllegalStateException
	 * @throws 		:	IOException
	 *
	 */
	public String saveProFile(RegistProfessorInfoRequest proInfo, HttpServletRequest request) throws IllegalStateException, IOException {
			
			MultipartFile file=proInfo.getPicture();
			String filename = UUID.randomUUID().toString().replace("-", "") + "$$"
					+ file.getOriginalFilename();
			
			File savePath = new File(member_Profile_Professor_PicturePath,filename);
			if(!savePath.exists()) {
				savePath.mkdirs();
			}
			file.transferTo(savePath);
			return filename;
	}
	/**
	 * 
	 * @기능설명		:	교수전용 경력 사항 파일 저장 기능	
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 12:00:19
	 * @see			:	registForm(교수용)
	 * @param 		:	proInfo(교수용 커맨드객체)
	 * @param 		:	request
	 * @return		:	String 타입 의 List 
	 * @throws 		:	IllegalStateException
	 * @throws 		:	IOException
	 *
	 */
	public List<String> saveCareerFile(RegistProfessorInfoRequest proInfo, HttpServletRequest request)throws IllegalStateException,IOException{
		List<String>careerFileNames = new ArrayList<String>();
		List<MultipartFile> files = proInfo.getCareerFile();
		for(int i=0; i<files.size(); i++) {
			MultipartFile file=files.get(i);
			String filename = UUID.randomUUID().toString().replace("-", "") + "$$"
					+ file.getOriginalFilename();
			careerFileNames.add(filename);;
			File savePath = new File(member_Professor_CareerPath,filename);
			if(!savePath.exists()) {
				savePath.mkdirs();
			}
			file.transferTo(savePath);
		}
		
		return careerFileNames;
	}
	
	/**
	 * 
	 * @기능설명		:	SMS API (CoolSms)를 이용한 문자 전송 기능 	
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오전 11:58:15
	 * @see			:	LoginIdForgot, LoginPWdForgot, registForm	
	 * @param 		:	phone(입력받은 휴대폰번호)
	 * @param 		:	randomNum(난순 6자리 생성)
	 *
	 */
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
	 @ResponseBody
	 @RequestMapping("/news")
	 public ResponseEntity<String>news() throws UnsupportedEncodingException{
		 ResponseEntity<String> entity=null;
		 
	        String clientId = "gthIqeaeVOQUOjbKZpWz"; //애플리케이션 클라이언트 아이디값"
	        String clientSecret = "inCwnIluU0"; //애플리케이션 클라이언트 시크릿값"

	        String text = null;
	        try {
	            text = URLEncoder.encode("창업", "UTF-8");
	        } catch (UnsupportedEncodingException e) {
	            throw new RuntimeException("검색어 인코딩 실패",e);
	        }

	        String apiURL = "https://openapi.naver.com/v1/search/news.json?query=" + text;    // json 결과
	        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과

	        Map<String, String> requestHeaders = new HashMap<>();
	        requestHeaders.put("X-Naver-Client-Id", clientId);
	        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
	        String responseBody = get(apiURL,requestHeaders);
	        
	     /*  
	        byte[] euckrStringBuffer  = responseBody.getBytes(Charset.forName("UTF-8"));
	        // euc-kr 로 변환된 byte 문자열을 다시 유니코드 String 으로 변환.
	        // String 생성자의 
	        // 첫 번째 인자로 문자열 byte 배열을  넣어주고, 
	        // 두 번째 인자로 byte 배열의 인코딩 값을 넣어준다.
	        String decodedHelloString = new String(euckrStringBuffer, "UTF-8");



	        System.out.println(responseBody);
	        System.out.println(decodedHelloString);*/
	        
	        entity = new ResponseEntity<String>(responseBody,HttpStatus.OK);
	        
	        return entity;
	    }

	    private static String get(String apiUrl, Map<String, String> requestHeaders){
	        HttpURLConnection con = connect(apiUrl);
	        try {
	            con.setRequestMethod("GET");
	            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
	                con.setRequestProperty(header.getKey(), header.getValue());
	            }

	            int responseCode = con.getResponseCode();
	            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
	                return readBody(con.getInputStream());
	            } else { // 에러 발생
	                return readBody(con.getErrorStream());
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("API 요청과 응답 실패", e);
	        } finally {
	            con.disconnect();
	        }
	    }

	    private static HttpURLConnection connect(String apiUrl){
	        try {
	            URL url = new URL(apiUrl);
	            return (HttpURLConnection)url.openConnection();
	        } catch (MalformedURLException e) {
	            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
	        } catch (IOException e) {
	            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
	        }
	    }

	    private static String readBody(InputStream body) throws UnsupportedEncodingException{
	        InputStreamReader streamReader = new InputStreamReader(body,"UTF-8");

	        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
	            StringBuilder responseBody = new StringBuilder();

	            String line;
	            while ((line = lineReader.readLine()) != null) {
	                responseBody.append(line);
	            }

	            return responseBody.toString();
	        } catch (IOException e) {
	            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
	        }
	    }
	    
	    /**
	     * 
	     * @기능설명		:	footer 공지사항 중요공지사항 가져오가서 뿌려주기
	     * @작성자		:	강현철
	     * @작성날짜      	:	2020. 6. 24.
	     * @마지막수정자	:	강현철
	     * @마지막수정일	:	2020. 6. 24.오후 6:39:30
	     * @return		:	entity (ajax성공 실패시 결과값) noticePointList 
	     *
	     */
	    @RequestMapping("/noticePointList")
	    public ResponseEntity<List<NoticeVO>>noticePointList() {
	    	ResponseEntity<List<NoticeVO>> entity=null;
	    	SearchCriteria cri =null;
	    		String point = "notice";
	    		try {
					List<NoticeVO> noticePointList=noticeBoardService.getNoticePointList(point);
					entity = new ResponseEntity<List<NoticeVO>>(noticePointList,HttpStatus.OK);
					
				} catch (SQLException e) {
					entity = new ResponseEntity<List<NoticeVO>>(HttpStatus.BAD_REQUEST);
					e.printStackTrace();
				}
	    	
	    	return entity;
	    }
	    
	    @RequestMapping("/commons/images/{member_id}")
	    public ResponseEntity<byte[]> mainImages( @PathVariable("member_id") String member_id){
	    	
	    	ResponseEntity<byte[]> entity=null;
	    	MemberVO member;
			try {
				member = memberService.getMemberProfileInfo(member_id);
	    	FileInputStream in = null;
	    	String savePath =null;
	    	if(member.getMember_authority().equals("PROFESSOR")) {
	    		savePath = member_Profile_Professor_PicturePath + File.separator + member.getMember_picture();
	    	}else {
	    		savePath = member_Profile_Student_PicturePath + File.separator + member.getMember_picture();
	    	}
				in = new FileInputStream(savePath);
				entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), HttpStatus.OK);
	    	} catch (FileNotFoundException e) {
	    		e.printStackTrace();
	    	} catch (IOException e) {
	    		e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	    	return entity;
	    }
	    
}
