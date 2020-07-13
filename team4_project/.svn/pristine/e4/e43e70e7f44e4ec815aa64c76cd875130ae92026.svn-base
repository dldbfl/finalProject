package com.dlms.controller.pds;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.dlms.dto.DraftVO;
import com.dlms.dto.LectureVO;
import com.dlms.dto.MemberVO;
import com.dlms.request.LectureDataRequest;
import com.dlms.service.draft.DraftService;
import com.dlms.service.lecture.LectureService;

@Controller
@RequestMapping("/pds/lecture/*")
public class LecturePDSController {

	@Autowired
	private LectureService lectureService;
	public void setLectureService(LectureService lectureService) {
		this.lectureService = lectureService;
	}
	
	@Autowired
	private DraftService draftService;
	public void setDraftService(DraftService draftService) {
		this.draftService = draftService;
	}
	
	@Resource(name="darft_path")
	private String draftPath;
	
	@RequestMapping("list")
	public ModelAndView lecturePdsList(ModelAndView model, HttpSession session) throws SQLException {
	
		String url = "pds/lecture/lectureList.page";
		
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		List<LectureDataRequest> dataList = lectureService.getLectureDataList(member.getMember_id());
		int count = dataList.size();
		model.addObject("count",count);
		model.setViewName(url);
		model.addObject("lectureData", dataList);
		
		return model;
	}
	@RequestMapping("draft")
	public ModelAndView uploadDraft(DraftVO draft, LectureDataRequest req, ModelAndView model, MultipartFile imageFile, MultipartFile movieFile)throws Exception{
		String url = "pds/lecture/lectureList.page";
		
		int lno = draftFileUpload(req, imageFile, movieFile);
		draft.setLecture_data_no(lno);
		System.out.println(lno);
		draftService.writeDraft(draft);
		
		List<LectureDataRequest> dataList = lectureService.getLectureDataList(req.getProfessor_id());
		model.setViewName(url);
		model.addObject("lectureData", dataList);
		return model;
	}
	
	public int draftFileUpload(LectureDataRequest req, MultipartFile imageFile, MultipartFile movieFile) throws Exception {
		

		String uploadPath = draftPath + File.separator;
		System.out.println(uploadPath);
		String imageName = UUID.randomUUID().toString().replace("-", "") + "$$" + imageFile.getOriginalFilename();
		imageName = imageName.replaceAll(" ", "");
		File file = new File(uploadPath,imageName);
		
		if (!file.exists()) {
			file.mkdirs();
		}
		imageFile.transferTo(file);
		
		String movieName = UUID.randomUUID().toString().replace("-", "") + "$$" + movieFile.getOriginalFilename();
		movieName = movieName.replaceAll(" ", "");
		file = new File(uploadPath,movieName); 
		if (!file.exists()) {
			file.mkdirs();
		}
		System.out.println(file);
		movieFile.transferTo(file);
		
		req.setLecture_data_image(imageName);
		req.setLecture_data_filename(movieName);
		LectureVO lecture = lectureService.getLectureDetail(req.getProfessor_id());
		req.setLecture_no(lecture.getLecture_no());
		req.setProfessor_id(req.getProfessor_id());
		
		int lno = lectureService.writeLectureData(req);
		
		return lno;
	}
}
