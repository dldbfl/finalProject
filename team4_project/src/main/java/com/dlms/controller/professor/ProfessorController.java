package com.dlms.controller.professor;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.dlms.dto.LectureVO;
import com.dlms.dto.Lecture_dataVO;
import com.dlms.dto.MemberVO;
import com.dlms.dto.PayVO;
import com.dlms.dto.ProfessorVO;
import com.dlms.dto.Professor_careerVO;
import com.dlms.dto.QnaVO;
import com.dlms.dto.StudentVO;
import com.dlms.exception.NotFoundMemberDataException;
import com.dlms.request.LectureDataRequest;
import com.dlms.request.Professor_careerRequest;
import com.dlms.request.ProfileRequest;
import com.dlms.request.QnARequest;
import com.dlms.request.SearchCriteria;
import com.dlms.request.StudentListRequest;
import com.dlms.service.board.QnaBoardService;
import com.dlms.service.lecture.LectureAttendService;
import com.dlms.service.lecture.LectureService;
import com.dlms.service.manager.ManagerService;
import com.dlms.service.member.MemberService;
import com.dlms.service.pay.PayService;
import com.dlms.service.professor.ProfessorService;
import com.dlms.service.student.StudentService;

@Controller
@RequestMapping("professor/*")
public class ProfessorController {

	@Autowired
	private LectureService lectureService;
	public void setLectureService(LectureService lectureService) {
		this.lectureService = lectureService;
	}
	
	@Autowired
	private ManagerService managerService;
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
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
	
	@Autowired
	private StudentService studentService;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@Autowired
	private LectureAttendService lectureAttendService;
	public void setLectureAttendService(LectureAttendService lectureAttendService) {
		this.lectureAttendService = lectureAttendService;
	}
	
	@Autowired
	private ProfessorService professorService;
	public void setProfessorService(ProfessorService professorService) {
		this.professorService = professorService;
	}
	@Autowired
	private QnaBoardService qnaBoardService;
	public void setQnaBoardSerivce(QnaBoardService qnaBoardService) {
		this.qnaBoardService = qnaBoardService;
	}
	@Autowired
	private JavaMailSender mailSender;
	
	@Resource(name="member_Profile_Professor_PicturePath")
	String profilePath;
	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}
	@Resource(name="member_Profile_Student_PicturePath")
	String studentPath;
	public void setStudentPath(String studentPath) {
		this.studentPath = studentPath;
	}
	
	@RequestMapping("student/list")
	public ModelAndView studentList(ModelAndView model,HttpServletRequest request, HttpSession session) throws SQLException, NotFoundMemberDataException {
		
		List<StudentListRequest> studentList = new ArrayList<>();
		int count = 0;
		String url = "professor/studentList.page";
		try {
		StudentListRequest student = new StudentListRequest();
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		//교수가 맡은 강의를 불러온다
		LectureVO lecture = lectureService.getLectureDetail(member.getMember_id());
		//교수가 맡은 강의의 출석부를 불러온다.
		List<PayVO> payList = payService.detailPayList(lecture.getLecture_no());

		for(int i = 0; i < payList.size(); i++) {
			student = new StudentListRequest();
			student.setLecture_regist_no(payList.get(i).getLecture_regist_no());
			student.setStudent_id(payList.get(i).getStudent_id());
			student.setStudent_name(memberService.getMember(payList.get(i).getStudent_id()).getMember_name());
			student.setStudent_remark(studentService.getStudent(payList.get(i).getStudent_id()).getStudent_remark());
			student.setStudent_status(memberService.getMember(payList.get(i).getStudent_id()).getMember_status());
			int percent = managerService.lecture_attend_percent(payList.get(i).getStudent_id());
			int allpercent = managerService.lecture_attend_all_percent(payList.get(i).getStudent_id());
			student.setAttend_rate(percent);
			student.setLecture_attend_all_percent(allpercent);
			System.out.println(allpercent);
			studentList.add(student);
		}
		}
		catch (NullPointerException e) {
			// TODO: handle exception
		}
		count = studentList.size();
		model.addObject("count",count);
		model.addObject("student",studentList);
		model.setViewName(url);
		return model;
	
	}
	@RequestMapping("student/profile")
	public ResponseEntity<ProfileRequest> profile( String id) throws SQLException, NotFoundMemberDataException{
				
		MemberVO member = memberService.getMember(id);
		ProfileRequest profile = new ProfileRequest();
		profile.setId(id);
		profile.setName(member.getMember_name());
		profile.setGender(member.getMember_gender());
		profile.setBirth(member.getMember_birth());
		profile.setMail(member.getMember_email());
		profile.setPhone(member.getMember_phone());
		StudentVO student = studentService.getStudent(id);
		profile.setPurpose(student.getStudent_hope_business());
		profile.setRemark(student.getStudent_remark());
		ResponseEntity<ProfileRequest> entity = new ResponseEntity<>(profile,HttpStatus.OK);
		return entity;
	}
	
	@RequestMapping("student/sendMail")
	public ResponseEntity<String> sendEmail(String id, String title, String content,HttpSession session, HttpServletRequest request,Model model) throws SQLException, NotFoundMemberDataException{
		ResponseEntity<String> entity=null;
		MemberVO member = memberService.getMember(id);
//		MemberVO professor = (MemberVO)session.getAttribute("loginUser");
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
	
	@RequestMapping(value="mypage",produces = "text/plain;charset=utf-8")
	public ModelAndView professorPage(ModelAndView model, HttpSession session)throws Exception{
		MemberVO member =(MemberVO)session.getAttribute("loginUser");
		Map<String, Object> dataMap = professorService.getProfessorDetail(member.getMember_id());
		String url = "professor/ProfessorMyPage.page";
		dataMap.put("member", member);
		model.addAllObjects(dataMap);
		model.setViewName(url);
		
		return model;
	}
	
	@RequestMapping(value="modifyProfile",produces = "text/plain;charset=utf-8")
	public ModelAndView modifyProfile(ModelAndView model, MemberVO member, ProfessorVO professor, Professor_careerRequest req,
									  MultipartFile picture, @RequestParam("careerFile") List<MultipartFile> careerFile, HttpSession session, HttpServletResponse response
									  ) throws SQLException, NotFoundMemberDataException{
		List<Professor_careerVO> career = req.getCareerList();
	
		String url = "/professor/ProfessorMyPage.page";
		Map<String, Object> dataMap = professorService.modifyProfessorDetail(member, professor,career, picture, careerFile, session);
		model.addAllObjects(dataMap);
		model.setViewName(url);

		return model;
	}
	@RequestMapping("checkPwd")
	public ResponseEntity<String> checkPwd(HttpSession session, String password, String id){
		ResponseEntity<String> entity =null;
		
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		
		if(member.getMember_id().equals(id) && member.getMember_pwd().equals(password)) {
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}else {
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping("qna/answer")
	public ModelAndView answer(QnARequest answerReq, SearchCriteria cri, ModelAndView model) throws Exception {
		String url = "professor/qnaDetail.page";
		QnaVO qna =  answerReq.toAnswerVO();
		qnaBoardService.AnswerWriterAndUpdate(qna);
		String nullcontent="";
		
		qna = qnaBoardService.getDetailList(qna.getQna_no(), nullcontent);
		System.out.println(qna);
		model.addObject("qna",qna);
		model.addObject("pageMaker",cri);
		
		model.setViewName(url);
		
		return model;
	} 
	
	@RequestMapping("qna/list")
	public ModelAndView qnaList(SearchCriteria cri, ModelAndView model, HttpSession session) throws Exception{
		String url = "professor/qnaBoardList.page";
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		Map<String,Object> dataMap = new HashMap<String, Object>();
		
		dataMap.put("page",cri.getPage());
		dataMap.put("perPageNum", cri.getPerPageNum());
		dataMap.put("searchType", cri.getSearchType());
		dataMap.put("keyword", cri.getKeyword());
		dataMap.put("professor_id", member.getMember_id());
		dataMap = qnaBoardService.getToProfessorQnAList(dataMap);
		
		model.setViewName(url);
		model.addAllObjects(dataMap);
		
		return model;
	}
	
	@RequestMapping("qna/registList")
	public ModelAndView answerRegistList(SearchCriteria cri, ModelAndView model, HttpSession session)throws Exception{
		String url = "professor/qnaBoardList.page";
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		Map<String,Object> dataMap = new HashMap<String, Object>();
		
		dataMap.put("page",cri.getPage());
		dataMap.put("perPageNum", cri.getPerPageNum());
		dataMap.put("searchType", cri.getSearchType());
		dataMap.put("keyword", cri.getKeyword());
		dataMap.put("professor_id", member.getMember_id());
		dataMap =qnaBoardService.getRegistFromProfessorQnAList(dataMap);
		model.addAllObjects(dataMap);
		model.addObject("flag", "등록");
		model.setViewName(url);
		return model;
		
	}
	
	@RequestMapping("qna/noRegistList")
	public ModelAndView answerNoRegistList(SearchCriteria cri, ModelAndView model, HttpSession session)throws Exception{
		String url = "professor/qnaBoardList.page";
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		Map<String,Object> dataMap = new HashMap<String, Object>();
		
		dataMap.put("page",cri.getPage());
		dataMap.put("perPageNum", cri.getPerPageNum());
		dataMap.put("searchType", cri.getSearchType());
		dataMap.put("keyword", cri.getKeyword());
		dataMap.put("professor_id", member.getMember_id());
		dataMap =qnaBoardService.getNoRegistFromProfessorQnAList(dataMap);
		model.addAllObjects(dataMap);
		model.addObject("flag", "미완");
		model.setViewName(url);
		return model;
		
	}
	
	@RequestMapping("qna/detail")
	public ModelAndView detail (int qna_no, SearchCriteria cri, ModelAndView mnv, HttpSession session) throws Exception{
		String url = "professor/qnaDetail.page";
		QnaVO qna = qnaBoardService.getDetailList(qna_no);
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		try {
			if(qna.getQna_answer().equals(member.getMember_id())) {
				System.out.println(member.getMember_id());
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
	
	@RequestMapping("pds/main")
	public ModelAndView pdsMain	(ModelAndView mnv) throws Exception{
		String url ="pds/pdsMain.page";
		mnv.setViewName(url);
		return mnv;
	}
	
	@RequestMapping("myLecture")
	public ModelAndView myLecture (ModelAndView mnv, HttpSession session) throws Exception{
		String url ="professor/myLecture.page";
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		LectureVO lecture = lectureService.getLectureDetail(member.getMember_id());
		List<LectureDataRequest> dataList = new ArrayList<>();
	    try {
		dataList = lectureService.getLectureDataList(lecture.getLecture_no());
	    }catch (NullPointerException e) {
			// TODO: handle exception
		}
	    
	    int count = dataList.size();
	    mnv.addObject("count", count);
		mnv.addObject("lecture",lecture);
		mnv.setViewName(url);
		return mnv;
	}
	
	@RequestMapping("profile/img")
	public ResponseEntity<byte[]> memberProfile(HttpSession session, HttpServletResponse response)throws Exception{
		ResponseEntity<byte[]> entity = null;
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		member = memberService.getMember(member.getMember_id());
		String fileName = member.getMember_picture();
/*		String savePath = profilePath + File.separator + member.getMember_id();*/
		FileInputStream in = null;
		try {
			in = new FileInputStream(profilePath + File.separator + fileName);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), HttpStatus.OK);
			in.close();
		} catch (IOException e) {
			entity = new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		} finally {
			if(in!=null)in.close();
		}
		return entity;

	}
	
	@RequestMapping("student/profile/img")
	public ResponseEntity<byte[]> studentProfile(String id, HttpSession session, HttpServletResponse response)throws Exception{
		ResponseEntity<byte[]> entity = null;
		MemberVO member = memberService.getMember(id);
		String fileName = member.getMember_picture();
		FileInputStream in = null;
		try {
			in = new FileInputStream(studentPath + File.separator + fileName);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), HttpStatus.OK);
			in.close();
		} catch (IOException e) {
			entity = new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		} finally {
			if(in!=null)in.close();
		}
		return entity;

	}
	
}
