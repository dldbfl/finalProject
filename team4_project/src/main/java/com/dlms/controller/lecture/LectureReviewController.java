package com.dlms.controller.lecture;


import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dlms.dto.Founded_reviewVO;
import com.dlms.dto.LectureVO;
import com.dlms.dto.Lecture_reviewVO;
import com.dlms.dto.LikeCountVO;
import com.dlms.dto.MemberVO;
import com.dlms.dto.PayVO;
import com.dlms.request.LectureReviewRequest;
import com.dlms.request.PageMaker;
import com.dlms.request.SearchCriteria;
import com.dlms.request.StudentListRequest;
import com.dlms.service.lecture.LectureAttendService;
import com.dlms.service.lecture.LectureReviewService;
import com.dlms.service.lecture.LectureService;
import com.dlms.service.manager.ManagerService;
import com.dlms.service.member.MemberService;
import com.dlms.service.pay.PayService;
import com.dlms.utils.Slatter;

@Controller
@RequestMapping("/lecture/review")
public class LectureReviewController {

	
	@Autowired
	private LectureService lectureService;
	public void setLectureService(LectureService lectureService) {
		this.lectureService = lectureService;
	}
	@Autowired
	private LectureReviewService lectureReviewService;
	public void setLectureReviewService(LectureReviewService lectureReviewService) {
		this.lectureReviewService = lectureReviewService;
	}
	@Autowired
	private PayService payService;
	public void setPayService(PayService payService) {
		this.payService = payService;
	}
	@Autowired
	private ManagerService managerService;
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	/**
	 * @기능설명		:	수강후기 등록창을 띄운다. 로그인 정보, 페이지정보, 결제정보를 넘겨준다.
	 * @작성자		:	민태홍
	 * @작성날짜      	: 2020. 6. 22.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 22.오전 10:02:09
	 * @return		:	mnv
	 */
	@RequestMapping("/registForm")
	public ModelAndView registForm(SearchCriteria cri, ModelAndView mnv, HttpSession session)throws Exception{
		
		String url="lecture/reviewRegistForm.page";
		MemberVO member= (MemberVO) session.getAttribute("loginUser");
		List<LectureReviewRequest> payList = payService.getreviewCheckList(member.getMember_id());
		Map<String, Object> reviewList = lectureReviewService.getReviewList(cri);
		mnv.addObject("pay",payList);
		mnv.addAllObjects(reviewList);
		mnv.setViewName(url);
		return mnv;
	}
	/**
	 * @기능설명		:	수강후기 등록. 등록이후 리스트로 돌아갈때 현재 페이지로 이동.
	 * @작성자		:	민태홍
	 * @작성날짜      	: 2020. 6. 22.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 22.오후 12:04:43
	 * @return		:	mnv
	 */
	@RequestMapping(value="/regist", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
	public ModelAndView regist(SearchCriteria cri, Lecture_reviewVO lecture_review, HttpServletResponse response, ModelAndView mnv)throws Exception{
		String url = "lecture/lectureReview.page";
		
		lectureReviewService.writeLectureReview(lecture_review);
		Map<String, Object> reviewList = lectureReviewService.getReviewList(cri);		
		mnv.addAllObjects(reviewList);
		mnv.setViewName(url);
		return mnv;
	}
	
	@RequestMapping("/list")
	public ModelAndView lectureReview(SearchCriteria cri, ModelAndView mnv) throws Exception{

		String url="lecture/lectureReview.page";
		Map<String, Object> reviewList = lectureReviewService.getReviewList(cri);
		List<LectureReviewRequest> bestList = lectureReviewService.bestReviewList();
		mnv.addAllObjects(reviewList);
		mnv.addObject("best",bestList);
		mnv.setViewName(url);
		
		return mnv;
	}
	/**
	 * 
	 * @기능설명		:	메인화면에 보여주는 수강후기리스트
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 22.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 22.오전 10:02:09
	 * @return		:	entity(ajax의 성공 실패에 따른 상태값 및 List)
	 *
	 */
	@RequestMapping("/quickList")
	public ResponseEntity<List<Lecture_reviewVO>> lectureReviewquickList() {
		ResponseEntity<List<Lecture_reviewVO>> entity=null;
		try {
			List<Lecture_reviewVO> lectureReviewList=lectureReviewService.getReviewList();
			for(Lecture_reviewVO lectureReview : lectureReviewList) {
					System.out.println(lectureReview.toString());
			}
			entity= new ResponseEntity<List<Lecture_reviewVO>>(lectureReviewList,HttpStatus.OK);
			
		} catch (SQLException e) {
			entity= new ResponseEntity<List<Lecture_reviewVO>>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	
	@RequestMapping("/photolist")
	public ModelAndView focusPhotoReview(SearchCriteria cri, ModelAndView mnv) throws Exception{

		String url="lecture/lectureReview.page";
		Map<String, Object> reviewList = lectureReviewService.photoList(cri);
		List<LectureReviewRequest> bestList = lectureReviewService.bestReviewList();
		mnv.addAllObjects(reviewList);
		mnv.addObject("best",bestList);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping("/myList")
	public ModelAndView lectureReview(SearchCriteria cri, ModelAndView mnv,String member_id) throws Exception{
		String url="lecture/lectureReview.page";
		Map<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put("keyword", cri.getKeyword());
		dataMap.put("page", cri.getPage());
		dataMap.put("pageStartRowNum", cri.getPageStartRowNum());
		dataMap.put("perPageNum", cri.getPerPageNum());
		dataMap.put("searchType", cri.getSearchType());
		dataMap.put("member_id", member_id);
		
		Map<String, Object> reviewList = lectureReviewService.getReviewList(dataMap);
		mnv.addAllObjects(reviewList);
		mnv.setViewName(url);
		
		
		return mnv;
	}
	@RequestMapping("review_overlap_check")
	public ResponseEntity<String> review_overlap_check (String student_id) throws SQLException{
		ResponseEntity<String> entity = null;
		List<LectureReviewRequest> payList = payService.getreviewCheckList(student_id);
		int allpercent = managerService.lecture_attend_all_percent(student_id);
		
		if(!payList.isEmpty()) {
			if(allpercent>=80 && allpercent <=100)
			entity = new ResponseEntity<String>("non_existence",HttpStatus.OK);
		}else {
			entity = new ResponseEntity<String>("existence",HttpStatus.OK);
		}
		return entity;
	}
	@RequestMapping("likecount")
	public ResponseEntity<String> likeCount(LikeCountVO like) throws SQLException{
		
		ResponseEntity<String> entity = null;
		
		String result = lectureReviewService.likeCount(like);
		entity = new ResponseEntity<String>(result,HttpStatus.OK);
		return entity;
	}
	@RequestMapping("detail")
	public ModelAndView reviewDetail(SearchCriteria cri, int lecture_review_no, ModelAndView mnv) throws SQLException {
		String url = "/lecture/reviewDetail.page";
		LectureReviewRequest review= lectureReviewService.getReviewDetail(lecture_review_no);
		mnv.addObject("review", review);
		mnv.addObject("pageMaker", cri);
		mnv.setViewName(url);
		return mnv;
	}
	
	@RequestMapping("delete")
	public ModelAndView deleteReview(SearchCriteria cri, int rno, ModelAndView mnv) throws SQLException {
		String url = "/lecture/lectureReview.page";
		Map<String, Object> reviewList = lectureReviewService.getReviewList(cri);
		List<LectureReviewRequest> bestList = lectureReviewService.bestReviewList();
		mnv.addAllObjects(reviewList);
		mnv.addObject("best",bestList);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="modifyReview", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
	public ModelAndView modifyReivew(SearchCriteria cri, LectureReviewRequest modifyReq, ModelAndView mnv) throws SQLException {
		String url = "/lecture/reviewDetail.page";
	
		LectureReviewRequest reviewReq=  lectureReviewService.modifyLectureReview(modifyReq);
		mnv.addObject("review",reviewReq);
		mnv.addObject("pageMaker", cri);
		mnv.setViewName(url);
		return mnv;
	}
}
