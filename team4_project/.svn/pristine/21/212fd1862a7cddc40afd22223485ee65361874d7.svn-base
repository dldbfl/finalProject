package com.dlms.controller.lecture;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dlms.dto.LectureVO;
import com.dlms.dto.Lecture_dataVO;
import com.dlms.dto.MemberVO;
import com.dlms.dto.PayVO;
import com.dlms.request.LectureDataRequest;
import com.dlms.request.SearchCriteria;
import com.dlms.service.lecture.LectureService;
import com.dlms.service.member.MemberService;
import com.dlms.service.pay.PayService;

@Controller
@RequestMapping("/lecture")
public class LectureController {

	@Autowired
	private LectureService lectureService;
	public void setLectureService(LectureService lectureService) {
		this.lectureService = lectureService;
	}
	@Autowired
	private PayService payService;
	
	@Resource(name="darft_path")
	String draftPah;
	public void setDraftPah(String draftPah) {
		this.draftPah = draftPah;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView lectureList(ModelAndView mnv,SearchCriteria cri)throws Exception{
		String url="lecture/lectureList.page";
		Map<String, Object>dataMap=lectureService.getLectureList(cri);
		System.out.println("lectureDataMap::"+dataMap);
		
		mnv.addAllObjects(dataMap);
		mnv.setViewName(url);
		return mnv;
		
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public ModelAndView lectureDetail(ModelAndView mnv,int lecture_no, HttpSession session)throws Exception{
		String url="lecture/lectureDetail.page";
		LectureVO lecture = lectureService.getLectureDetail(lecture_no);
		
		/*MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		String student_id = loginUser.getMember_id();
		System.out.println("student+++:"+student_id);
		PayVO pay = payService.selectPayStudentId(student_id);
		
		System.out.println("LectureController:::"+pay);
		
		mnv.addObject("pay", pay.getStudent_id());*/
		mnv.addObject("lecture",lecture);
		mnv.setViewName(url);
		return mnv;
	}
	
	@RequestMapping("/img")
	public ResponseEntity<byte[]> studentProfile(int lecture_data_no, HttpSession session, HttpServletResponse response)throws Exception{
		ResponseEntity<byte[]> entity = null;
		Lecture_dataVO data = lectureService.getLectureData(lecture_data_no);
		System.out.println(data);
		String fileName = data.getLecture_data_image();
		FileInputStream in = null;
		try {
			in = new FileInputStream(draftPah + File.separator + fileName);
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
