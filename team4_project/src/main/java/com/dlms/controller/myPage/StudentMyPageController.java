package com.dlms.controller.myPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dlms.dao.board.ConsultBoardDAO;
import com.dlms.dao.board.FreeBoardDAO;
import com.dlms.dao.board.QnaBoardDAO;
import com.dlms.dao.founded.FoundedReviewDAO;
import com.dlms.dto.ConsultVO;
import com.dlms.dto.Founded_reviewVO;
import com.dlms.dto.FreeBoardVO;
import com.dlms.dto.LectureVO;
import com.dlms.dto.Lecture_attendVO;
import com.dlms.dto.Lecture_dataVO;
import com.dlms.dto.MemberVO;
import com.dlms.dto.PayVO;
import com.dlms.dto.QnaVO;
import com.dlms.dto.StudentVO;
import com.dlms.dto.Student_certificateVO;
import com.dlms.request.LectureDataRequest;
import com.dlms.request.RegistStudentInfoRequest;
import com.dlms.request.StudentListRequest;

import com.dlms.service.lecture.LectureAttendService;
import com.dlms.service.lecture.LectureService;
import com.dlms.service.member.MemberService;
import com.dlms.service.pay.PayService;
import com.dlms.service.pay.PayServiceImpl;
import com.dlms.service.student.StudentService;

@Controller
@RequestMapping("/myPage/*")
public class StudentMyPageController {


	
	@Autowired
	MemberService memberService;
	@Autowired
	StudentService studentService;
	@Autowired
	LectureAttendService lectureAttendService;
	@Autowired
	FoundedReviewDAO foundedReviewDAO;
	@Autowired
	FreeBoardDAO freeBoardDAO;
	@Autowired
	QnaBoardDAO qnaBoardDAO;
	@Autowired
	ConsultBoardDAO consultBoardDAO;
	@Autowired
	LectureService lectureService;
	@Autowired
	PayService payService;
	// 학생 프로필사진 저장 경로
	@Resource(name = "member_Profile_Student_PicturePath")
	private String member_Profile_Student_PicturePath;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	
	@RequestMapping("myPageMain")
	public ModelAndView myPageMain(HttpSession session, ModelAndView mnv) throws Exception {
		String url = "myPage/myPageMain.page";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		List<PayVO> pv = payService.selectPayMyList(loginUser.getMember_id());
		
		int lecture_no = 0;
		for(PayVO payVO : pv) {
			lecture_no = payVO.getLecture_no();
		}
		
		List<FreeBoardVO> free = freeBoardDAO.myfreeList(loginUser.getMember_id());
		List<QnaVO> qna = qnaBoardDAO.myQnaList(loginUser.getMember_id());
		List<Founded_reviewVO> founded_review = foundedReviewDAO.myfounded_reviewList(loginUser.getMember_id());
		List<ConsultVO> consult = consultBoardDAO.myConsultList(loginUser.getMember_id());
		List<LectureVO> lecture = lectureService.getListByLecture_no(lecture_no);
		List<Lecture_attendVO> lecture_attend = lectureAttendService.getAttend(loginUser.getMember_id());
		
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("free", free);
		dataMap.put("qna", qna);
		dataMap.put("founded_review", founded_review);
		dataMap.put("consult", consult);
		dataMap.put("lecture", lecture);
		dataMap.put("lecture_attend", lecture_attend);
	
		mnv.addAllObjects(dataMap);
		
		mnv.setViewName(url);

		return mnv;

	}
	
	
	
	@RequestMapping("profile")
	public ResponseEntity<byte[]> profile(HttpSession session, HttpServletResponse response)throws Exception {
		System.out.println("123123213");
		ResponseEntity<byte[]> entity = null;
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		String picName = loginUser.getMember_picture();
		System.out.println("picName"+picName);
		
		
		String savePath = member_Profile_Student_PicturePath + File.separator;
		System.out.println("save"+savePath);
		
		
		
		FileInputStream in = null;
		
			System.out.println("11");
			in = new FileInputStream(savePath + File.separator + picName);
			System.out.println("in : " + in);
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), HttpStatus.OK);
	
		return entity;
	}
	
	
	
	
	
	

	@RequestMapping("professorMain")
	public ModelAndView professorMain(ModelAndView mnv) throws Exception {
		String url = "professor/myPageMain.page";

		
		
		
		mnv.setViewName(url);

		return mnv;

	}
	
	
	
	// 개인정보수정 --------------------------------------------------------------------------------------------
	// 개인정보수정
	@RequestMapping("myInfoModify")
	public ModelAndView myInfoModify(ModelAndView mnv, HttpSession session) throws Exception {

		String url = "myPage/myInfoModify.page";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		String member_id = loginUser.getMember_id();
		Map<String, Object> dataMap = memberService.getCertificateList(member_id);

		File filePath = new File(member_Profile_Student_PicturePath + File.separator);

		String fileNam = loginUser.getMember_picture();
		
		String fullName = filePath + "\\" +fileNam;
		
		System.out.println("fileNam : " + fileNam);
		System.out.println("filePath : " + filePath);
		System.out.println("fullName : " + fullName);
		
		
		dataMap.put("fullName", fullName);

		mnv.addAllObjects(dataMap);
		mnv.setViewName(url);

		return mnv;
	}



	// 개인정보수정
	@RequestMapping("modifyMember")
	public String modifyMember(ModelAndView mnv, RegistStudentInfoRequest info, HttpServletRequest request, HttpSession session)
			throws Exception {
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		String url = "redirect:myPageMain";

		MemberVO member = info.tomember();
        
		System.out.println("info : " + info);
		System.out.println("member : " + member);
		
		String beforPicName = memberService.getMember(member.getMember_id()).getMember_picture();
		String beforOriginalName = beforPicName.substring(beforPicName.lastIndexOf('$') + 1);
		String newOriginalName = member.getMember_picture();

		if (newOriginalName.equals(beforPicName) || newOriginalName.equals(beforOriginalName)) {
			member.setMember_picture(beforPicName);

		} else {
			String uplaodProFileName = saveProFile(info, request);
			member.setMember_picture(uplaodProFileName);
			loginUser.setMember_picture(uplaodProFileName);
		}

		Student_certificateVO[] certificateVO = info.getCertificate();

		StudentVO studentVO = info.toStudentVO();

		memberService.modifyMember(member, certificateVO, studentVO);

		
		
		return url;

	}

	public String saveProFile(RegistStudentInfoRequest info, HttpServletRequest request)
			throws IllegalStateException, IOException {

		MultipartFile file = info.getPicture();

		String filename = UUID.randomUUID().toString().replace("-", "") + "$$" + file.getOriginalFilename();

		File savePath = new File(member_Profile_Student_PicturePath, filename);
		if (!savePath.exists()) {
			savePath.mkdirs();
		}
		file.transferTo(savePath);
		return filename;
	}

	// 내게시글내역
	// --------------------------------------------------------------------------------------------
	/*@RequestMapping("myBoardList")
	public ModelAndView list(SearchCriteria cri, ModelAndView mnv) throws Exception {
		String url = "myPage/myBoardList.page";
		Map<String, Object> free = freeboardService.getfreeBoardList(cri);
		Map<String, Object> consult = consultBoardService.getConsultList(cri);
		Map<String, Object> qna = qnaBoardService.getSearchQnaList(cri);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("free", free);
		dataMap.put("consult", consult);
		dataMap.put("qna", qna);

		mnv.addAllObjects(dataMap);
		mnv.setViewName(url);

		// System.out.println(dataMap);
		return mnv;

	}*/
	
	
	// 회원탈퇴 ----------------------------------------------------------------------------------
	
	// 회원탈퇴전 비밀번호확인 화면
	@RequestMapping("memberOutConfirm")
	public String memberOutConfirm()throws Exception {
		String url = "myPage/memberOutConfirm.page";
		
		
		
		return url;
		
	}
	
	// 회원탈퇴 안내 및 탈퇴사유입력 화면
	@RequestMapping("memberOut")
	public String memberOut()throws Exception {
		String url = "myPage/memberOut.page";
		
		return url;
		
	}
	
	// 회원탈퇴클릭시 탈퇴 사유 저장 및 회원상태값 탈퇴값으로 변환
	@RequestMapping(value="out", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
	public void out(MemberVO memberVO, HttpSession session, HttpServletResponse response)throws Exception {
		
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		memberVO.setMember_id(loginUser.getMember_id());
		memberVO.setMember_status(0);

		memberService.modifyMember(memberVO);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('정상 탈퇴 되었습니다.');");
		out.println("location.href='http://localhost/main'");
		out.println("</script>");
		
	}
	
	
	// 출석부 --------------------------------------------------------------------------------------------		
	
	// 출석부 화면
	@RequestMapping("AttIprame")
	public ModelAndView AttIprame(ModelAndView mnv, HttpSession session)throws Exception {
		String url = "myPage/AttIprame.page";
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		String student_id = loginUser.getMember_id();
		
		List<Lecture_attendVO> lecture_attend = lectureAttendService.getAttend(student_id);
		
		mnv.addObject("lecture_attend", lecture_attend);
		
		mnv.setViewName(url);
		
		return mnv;
		
	}
	
	// 즐겨찾는 강의 --------------------------------------------------------------------------------------------
	
	// 즐겨찾는 강의 리스트 화면
	@RequestMapping(value="favoriteLecture", method=RequestMethod.GET)
	public ModelAndView favoriteLecture(ModelAndView mnv,HttpSession session)throws Exception {
		
		String url = "commons/login.login";
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		
		if(member != null && !member.getMember_id().isEmpty() ) {
			url="myPage/favoriteLecture.page";
			if (!memberService.getStudent_member_id(member.getMember_id()).isEmpty()) {
		
		StudentListRequest studentReq = (StudentListRequest) memberService.getStudent_member_id(member.getMember_id()).get(0);
		
		List<LectureDataRequest> lectureDataList =lectureService.getfavoriteLecture(studentReq.getLecture_no());
		mnv.addObject("member_id", member.getMember_id());
		mnv.addObject("lecture_no", studentReq.getLecture_no());
		mnv.addObject("lectureDataList",lectureDataList);
		
			}
		}
		mnv.setViewName(url);
		return mnv;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@RequestMapping(value="/lecture/video", method=RequestMethod.GET)
	public ModelAndView lectureList(ModelAndView mnv,HttpSession session)throws Exception{
		
		String url="lecture/video.page";
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		
				System.out.println("member :"+member);
				StudentListRequest studentReq = (StudentListRequest) memberService.getStudent_member_id(member.getMember_id()).get(0);
				System.out.println("거기서 꺼낸건 이런거야...studentReq : "+studentReq);
				System.out.println(studentReq.toString());
				
				List<Lecture_dataVO> lectureDataList =lectureService.getLectureDataList(studentReq.getLecture_no());
				System.out.println("그 친구의 강의는 이런거야...");
				System.out.println("lectureDataList : "+lectureDataList);
				
				mnv.addObject("member_id", member.getMember_id());
				mnv.addObject("lecture_no", studentReq.getLecture_no());
				mnv.addObject("lectureDataList",lectureDataList);
			
		mnv.setViewName(url);
		return mnv;
		
	}*/
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("NewFile")
	public String NewFile()throws Exception {
		String url = "myPage/AttIprame.page";
		
		
		
		return url;
		
	}
	
	
	

}
