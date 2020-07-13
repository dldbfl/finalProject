package com.dlms.controller.lecture;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dlms.dto.LectureVO;
import com.dlms.dto.Lecture_dataVO;
import com.dlms.dto.Manager_boardVO;
import com.dlms.dto.MemberVO;
import com.dlms.dto.QnaVO;
import com.dlms.request.LectureDataRequest;
import com.dlms.request.QnARequest;
import com.dlms.request.SearchCriteria;
import com.dlms.request.StudentListRequest;
import com.dlms.service.board.QnaBoardService;
import com.dlms.service.lecture.LectureAttendService;
import com.dlms.service.lecture.LectureService;
import com.dlms.service.member.MemberService;

/**
 * 
 * @사용목적		:	나의 강의실 	
 * @작성자		    :	이누리
 * @작성날짜     	:	2020. 6. 17.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 17.오후 9:10:08
 * @see			    :	-
 *
 */
@Controller
@RequestMapping("/*")
public class LectureDataController {

	@Autowired
	private LectureService lectureService;
	public void setLectureService(LectureService lectureService) {
		this.lectureService = lectureService;
	}
	
	@Autowired
	private MemberService memberService;
	public void setmemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Autowired
	private QnaBoardService qnaBoardService;
	public void setQnaBoardService(QnaBoardService qnaBoardService) {
		this.qnaBoardService = qnaBoardService;
	}
	
	@Autowired
	private LectureAttendService lectureAttendService;
	public void setlectureAttendService(LectureAttendService lectureAttendService) {
		this.lectureAttendService = lectureAttendService;
	}

	/**
	 * 
	 * @기능설명		:	나의 강의실 강의 리스트
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 9:11:24
	 * @see			    :	-
	 * @param mnv
	 * @param session
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/lecture/video", method=RequestMethod.GET)
	public ModelAndView lectureList(ModelAndView mnv,HttpSession session)throws Exception{

		String url="commons/login.login";
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
				if(member != null && !member.getMember_id().isEmpty() ) {
					url="lecture/video.page";
					System.out.println("member :"+member);
					if (!memberService.getStudent_member_id(member.getMember_id()).isEmpty()) {
						
						StudentListRequest studentReq = (StudentListRequest) memberService.getStudent_member_id(member.getMember_id()).get(0);
						System.out.println("거기서 꺼낸건 이런거야...studentReq : "+studentReq);
						System.out.println(studentReq.toString());
						
						List<LectureDataRequest> lectureDataList =lectureService.getLectureDataList(studentReq.getLecture_no());
						System.out.println("그 친구의 강의는 이런거야...");
						System.out.println("lectureDataList : "+lectureDataList);
						
						mnv.addObject("member_id", member.getMember_id());
						mnv.addObject("lecture_no", studentReq.getLecture_no());
						mnv.addObject("lectureDataList",lectureDataList);			
						
					}
				}
			
		mnv.setViewName(url);
		return mnv;
		
	}
	
	/**
	 * 
	 * @기능설명		:	교수 강의실 강의 리스트
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 9:11:24
	 * @see			    :	-
	 * @param mnv
	 * @param session
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/professor/video", method=RequestMethod.GET)
	public ModelAndView professorLectureList(ModelAndView mnv,HttpSession session)throws Exception{
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
				String url="professor/video.page";
	
				LectureVO lecture = lectureService.getLectureDetail(member.getMember_id());
	
				List<LectureDataRequest> lectureDataList =lectureService.getLectureDataList(member.getMember_id());
				try {
				mnv.addObject("member_id", member.getMember_id());
				mnv.addObject("lecture_no",lecture.getLecture_no());
				mnv.addObject("lectureDataList",lectureDataList);			
				}
				catch (NullPointerException e) {

				}
		mnv.setViewName(url);
		return mnv;
		
	}
	
	/**
	 * 
	 * @기능설명		:	나의 강의실 동영상 보기
	 * @작성자		    :	이누리  
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 18.오후 7:57:50
	 * @see			    :	-
	 * @param mnv
	 * @param lecture_data_no
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/lecture/video/view", method=RequestMethod.GET)
	public ModelAndView lectureVideo(ModelAndView mnv,int lecture_data_no,int lecture_lastview_time, int lecture_no, String member_id,HttpSession session)throws Exception{
		String url="lecture/view";
		Lecture_dataVO lectureVideo = lectureService.getLectureDataVideo(lecture_data_no);
		if(lecture_lastview_time != 0) {
			lectureVideo.setLecture_lastview_time(lecture_lastview_time);
		}
		System.out.println("lecture_no : "+lecture_no);
		
		List<LectureDataRequest> lectureDataList =lectureService.getLectureDataList(lecture_no);
		
		String student_id = "학생아이디가 없습니다.";
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		if(member != null && !member.getMember_id().isEmpty()) {
			System.out.println("member :"+member);
			StudentListRequest studentReq = memberService.getStudent_member_id(member.getMember_id()).get(0);	
			student_id = studentReq.getStudent_id();
			System.out.println("학생아이디 : " + student_id);
		}		
		
		mnv.addObject("student_id",student_id);		
		mnv.addObject("member_id",member_id);		
		mnv.addObject("lectureDataList",lectureDataList);
		mnv.addObject("lectureVideo",lectureVideo);
		mnv.setViewName(url);
		return mnv;
		
	}
	
	/**
	 * 
	 * @기능설명		:	교수 강의실 동영상 보기
	 * @작성자		    :	이누리  
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 18.오후 7:57:50
	 * @see			    :	-
	 * @param mnv
	 * @param lecture_data_no
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/professor/video/view", method=RequestMethod.GET)
	public ModelAndView professorLectureVideo(ModelAndView mnv,int lecture_data_no,int lecture_lastview_time, int lecture_no, String member_id,HttpSession session)throws Exception{
		String url="professor/view";
		Lecture_dataVO lectureVideo = lectureService.getLectureDataVideo(lecture_data_no);
		if(lecture_lastview_time != 0) {
			lectureVideo.setLecture_lastview_time(lecture_lastview_time);
		}
		
		MemberVO member = (MemberVO) session.getAttribute("loginUser");		
		List<LectureDataRequest> lectureDataList =lectureService.getLectureDataList(member.getMember_id());
		
		mnv.addObject("student_id",member.getMember_id());		
		mnv.addObject("member_id",member.getMember_id());		
		mnv.addObject("lectureDataList",lectureDataList);
		mnv.addObject("lectureVideo",lectureVideo);
		mnv.setViewName(url);
		return mnv;
		
	}
	
	/**
	 * 
	 * @기능설명		:	나의 강의실 동영상 종료시간 수정
	 * @작성자		    :	이누리  
	 * @작성날짜    	:	2020. 6. 18.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 20.오후 7:57:50
	 * @see			    :	-
	 * @param mnv
	 * @param lecture_data_no , lecture_lastview_time
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/lecture/video/view", method=RequestMethod.POST)
	public ModelAndView lectureVideoUpdate(ModelAndView mnv, int lecture_lastview_time, int lecture_data_no)throws Exception{
		String url="lecture/timeSet";
		Lecture_dataVO lecture_data = lectureService.getLectureDataVideo(lecture_data_no);
		
		System.out.println("lecture_data_no : "+lecture_data_no);
		System.out.println("lecture_lastview_time : "+lecture_lastview_time);
		
		/*lecture_data.setLecture_data_no(lecture_data_no);*/
		lecture_data.setLecture_lastview_time(lecture_lastview_time);
		
		lectureService.modifyLecture_data(lecture_data);		
		
		mnv.setViewName(url);
		
		return mnv;
		
	}
	/**
	 * 
	 * @기능설명		:	나의 강의실 질의문답
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 22.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 22.오후 12:46:20
	 * @see			    :	-
	 * @param cri
	 * @param model
	 * @param member_id
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping("/lecture/qnalist")
	public String qnaList(SearchCriteria cri, Model model,String member_id,String professor_id) throws Exception {
		String url = "lecture/qnaList";
		cri.setPerPageNum(5);
		Map<String, Object> dataMap =qnaBoardService.getSearchQnaList(cri);
		dataMap.put("member_id", member_id);
		dataMap.put("professor_id", professor_id);
		model.addAllAttributes(dataMap);
		
		return url;
	}
	
	/**
	 * 
	 * @기능설명		:	나의 강의실 질의문답 나만보기
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 22.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 22.오후 12:46:34
	 * @see			    :	-
	 * @param cri
	 * @param model
	 * @param member_id
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping("/lecture/melist")
	public ModelAndView answerRegistList(SearchCriteria cri, ModelAndView model,String member_id,String professor_id)throws Exception{
		String url = "lecture/qnaList";
		Map<String, Object> dataMap =qnaBoardService.getRegistQnaList(cri);
		model.addAllObjects(dataMap);
		System.out.println("meList_member_id : "+member_id);
		model.addObject("member_id", member_id);
		model.addObject("professor_id", professor_id);
		model.addObject("flag", "내글");
		model.setViewName(url);
		return model;
		
	}
	
	/**
	 * 
	 * @기능설명		:	나의 강의실 질의문답 등록
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 22.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 22.오후 12:46:50
	 * @see			    :	-
	 * @param model
	 * @param member_id
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping("/lecture/registForm")
	public ModelAndView registForm(ModelAndView model,String member_id,String professor_id) throws Exception {
		String url = "lecture/qnaRegist";	

		System.out.println("들어온 교수 아이디는 이렇다! professor_id : "+professor_id);
		System.out.println("registForm_member_id : "+member_id);
		model.addObject("member_id", member_id);
		model.addObject("professor_id", professor_id);
		model.setViewName(url);
		return model;
	}
	
	/**
	 * 
	 * @기능설명		:	나의 강의실 질의문답 등록받기
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 22.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 22.오후 12:47:04
	 * @see			    :	-
	 * @param qnaReq
	 * @param response
	 * @param request
	 * @param member_id
	 * @throws Exception
	 *
	 */
	@RequestMapping("/lecture/regist")
	public void regist( QnARequest qnaReq, HttpServletResponse response, HttpServletRequest request, String member_id,String professor_id ) throws Exception {
		QnaVO qna = qnaReq.toRegistQnAVO();
		if(qna.getQna_type() == null) {
			qna.setQna_type("일반글");
		}
		qna.setProfessor_id(professor_id);
		qnaBoardService.writer(qna);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		System.out.println("regist_member_id : "+member_id);
		System.out.println("regist_professor_id : "+professor_id);
		out.println("<script>");
		out.println("alert('질문글이 등록 되었습니다.');");
		out.println("location.href='qnalist?member_id="+member_id+"&professor_id="+professor_id+"'");
		out.println("</script>");
		
	}

	/**
	 * 
	 * @기능설명		:	나의 강의실 질의문답 상세보기
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 22.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 22.오후 3:36:50
	 * @see			    :	-
	 * @param qna_no
	 * @param cri
	 * @param mnv
	 * @param member_id
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping("/lecture/detail")
	public ModelAndView detail (int qna_no, SearchCriteria cri, ModelAndView mnv, String member_id,String professor_id) throws Exception{
		
		String url = "lecture/qnaDetail";
		QnaVO qna = qnaBoardService.getDetailList(qna_no);
		System.out.println(member_id);
		mnv.addObject("member_id", member_id);
		mnv.addObject("professor_id", professor_id);
		mnv.addObject("qna",qna);
		mnv.addObject("pageMaker",cri);
		mnv.setViewName(url);
		return mnv;
		
	}
	/**
	 * 
	 * @기능설명		:	나의 강의실 질의문답 삭제
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 22.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 22.오후 3:44:16
	 * @see			    :	-
	 * @param qna_no
	 * @param response
	 * @param member_id
	 * @throws Exception
	 *
	 */
	@RequestMapping("/lecture/delete")
	public void delete(int qna_no, HttpServletResponse response,String member_id,String professor_id) throws Exception {

		qnaBoardService.remove(qna_no);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('삭제되었습니다.');");
		out.println("location.href='qnalist?member_id="+member_id+"&professor_id="+professor_id+"'");
		out.println("</script>");
		
	}
	/**
	 * 
	 * @기능설명		:	나의 강의실 질의문답 비밀번호 체크폼
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 22.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 22.오후 3:44:27
	 * @see			    :	-
	 * @param cri
	 * @param qna_no
	 * @param model
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping("/lecture/checkForm")
	public ModelAndView checkForm(SearchCriteria cri, int qna_no, ModelAndView model,String professor_id,String member_id) throws Exception {
		String url = "lecture/check_pwd";
		model.addObject("professor_id", professor_id);
		model.addObject("qno", qna_no);
		model.addObject("pageMaker",cri);
		model.setViewName(url);
		
		return model;
	}
	
	/**
	 * 
	 * @기능설명		:	나의 강의실 질의문답 비밀번호 체크
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 22.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 22.오후 3:44:44
	 * @see			    :	-
	 * @param qno
	 * @param password
	 * @param model
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping("/lecture/checkPwd")
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
	
	/**
	 * 
	 * @기능설명		:	나의 강의실 메모수정 
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 23.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 23.오후 12:42:04
	 * @see			    :	-
	 * @param mnv
	 * @param lecture_data_no
	 * @param lecture_data_memo
	 * @return
	 * @throws Exception
	 *
	 */
	@ResponseBody
	@RequestMapping("/lecture/note")
	public String registForm(@RequestParam("lecture_data_no") Integer lecture_data_no, @RequestParam("lecture_data_memo") String lecture_data_memo) throws Exception {
		System.out.println("lecture_data_no : "+lecture_data_no);
		Lecture_dataVO lecture_data = lectureService.getLectureDataVideo(lecture_data_no);
		
		System.out.println("lecture_data : "+lecture_data);
		
		/*lecture_data.setLecture_data_no(lecture_data_no);*/
		lecture_data.setLecture_data_memo(lecture_data_memo);
		
		lectureService.modifyLecture_data(lecture_data);	
		
		return lecture_data_memo;
		
	}
	
	/**
	 * 
	 * @기능설명		:	나의 강의실 - 영상 종료시 출석
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 7. 1.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 1.오후 12:35:01
	 * @see			    :	-
	 * @param mnv
	 * @param lecture_data_no
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/lecture/video/attend", method=RequestMethod.POST)
	public void lectureVideoUpdate(int lecture_data_no, String student_id)throws Exception{
				
		System.out.println("출석 기록 : "+student_id+"학생의 "+lecture_data_no+"번은 강의가 출석되었습니다.");
		
		lectureAttendService.updateAttend(lecture_data_no,student_id);	
				
	}
	
	/**
	 * 영상 저장 경로
	 */
	@Resource(name="darft_path")
	private String draftPath;
	
	
	/**
	 * 
	 * @기능설명		:	나의 강의실 동영상 이미지 출력
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 7. 1.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 1.오후 2:37:40
	 * @see			    :	-
	 * @param lecture_data_image
	 * @param response
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping("/lecture/picture/{lecture_data_no}")
	@ResponseBody
	public ResponseEntity<byte[]> sendPicture(@PathVariable("lecture_data_no") int lecture_data_no, HttpServletResponse response)
			throws Exception {

		ResponseEntity<byte[]> entity = null;

		Lecture_dataVO lecture_data = lectureService.getLectureData(lecture_data_no);
		
		
		String fileName = lecture_data.getLecture_data_image();
		String savePath = draftPath + File.separator + fileName;

		FileInputStream in = null;
		System.out.println("fileName : "+fileName);
		System.out.println("savePath : "+savePath);
		try {
			//in = new FileInputStream(savePath + File.separator + fileName);
			in = new FileInputStream(savePath);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), HttpStatus.OK);
		} catch (IOException e) {
			entity = new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		} finally {
			if(in!=null)in.close();
		}

		return entity;
	}
	
	/**
	 * 
	 * @기능설명		:	나의 강의실 동영상 동영상 출력
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 7. 1.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 1.오후 3:37:33
	 * @see			    :	-
	 * @param lecture_data_image
	 * @param response
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping("/lecture/videofile/{lecture_data_no}")
	//@ResponseBody
	public void sendVideo(@PathVariable("lecture_data_no") int lecture_data_no, HttpServletResponse response)
			throws Exception {

		ResponseEntity<byte[]> entity = null;

		Lecture_dataVO lecture_data = lectureService.getLectureData(lecture_data_no);
		
		String fileName = lecture_data.getLecture_data_filename();
		String savePath = draftPath + File.separator + fileName;

		FileInputStream in = null;
		System.out.println("fileName : "+fileName);
		System.out.println("savePath : "+savePath);
		

		response.setContentType("video/mp4");
		
		response.setHeader("Content-Disposition",
				"attachment;filename="+savePath);
		
		try {
			File file = new File(savePath);
			in = new FileInputStream(file);
	        ServletOutputStream out = response.getOutputStream();
	        int size = (int)file.length();
	        response.setHeader ( "Accept-Ranges", "bytes 0-"+ size);
	        response.setHeader ( "Content-Range", "bytes 0-"+ size);
	        response.setContentLength(size);
	        //
	        
	        byte[] outputByte = new byte[(int)file.length()];
	        //copy binary contect to output stream
	        while(in.read(outputByte, 0, (int)file.length()) != -1)
	        {
	        	out.write(outputByte, 0, (int)file.length());
	        }
	        out.flush();
		} catch (IOException e) {
			
		} finally {
			if(in!=null)in.close();
		}
		System.out.println("돌았음");	

		/*
		try {
			//in = new FileInputStream(savePath + File.separator + fileName);
			in = new FileInputStream(savePath);
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), HttpStatus.OK);
		} catch (IOException e) {
			entity = new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		} finally {
			if(in!=null)in.close();
		}

		return entity;*/
	}
	
	/**
	 * 
	 * @기능설명		:   즐겨찾기 등록, 취소
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 7. 1.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 1.오후 9:23:28
	 * @see			    :	-
	 * @param lecture_data_no
	 * @param student_id
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/lecture/favorite", method=RequestMethod.POST)
	public void lectureFavorite(int lecture_data_favorites, int lecture_data_no)throws Exception{
				
		lectureService.updateFavorite(lecture_data_favorites, lecture_data_no);
								
	}

}
