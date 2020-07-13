package com.dlms.service.lecture;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dlms.dao.board.LikeCountDAO;
import com.dlms.dao.lecture.LectureDAO;
import com.dlms.dao.lecture.LectureReviewDAO;
import com.dlms.dao.pay.PayDAO;
import com.dlms.dto.LectureVO;
import com.dlms.dto.Lecture_reviewVO;
import com.dlms.dto.Lecture_review_imgVO;
import com.dlms.dto.LikeCountVO;
import com.dlms.dto.PayVO;
import com.dlms.request.LectureReviewRequest;
import com.dlms.request.PageMaker;
import com.dlms.request.SearchCriteria;
import com.dlms.utils.Slatter;

/**
 * 
 * @사용목적		:	수강 후기와 관련된 Service
 * @작성자		:	민태홍
 * @작성날짜      	:	2020. 6. 2.
 * @마지막수정자	:	민태홍
 * @마지막수정일	:	2020. 6. 2.오전 11:08:22
 * @see			:	LectureReviewService
 *
 */
public class LectureReviewServiceImpl implements LectureReviewService {
	
	private LectureReviewDAO lectureReviewDAO;
	public void setLectureReviewDAO(LectureReviewDAO lectureReviewDAO) {
		this.lectureReviewDAO = lectureReviewDAO;
	}
	@Autowired
	private LectureDAO lectureDAO;
	public void setLectureDAO(LectureDAO lectureDAO) {
		this.lectureDAO = lectureDAO;
	}
	@Autowired
	private LikeCountDAO likeCountDAO;
	public void setLikeCountDAO(LikeCountDAO likeCountDAO) {
		this.likeCountDAO = likeCountDAO;
	}

	@Autowired
	private PayDAO payDAO;
	public void setPayDAO(PayDAO payDAO) {
		this.payDAO = payDAO;
	}
	/**
	 * 
	 * @기능설명		:	수강후기 검색 리스트 출력
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 11:08:59
	 * @see			:	X
	 * @param cri
	 * @return lectureReviewList
	 * @throws SQLException
	 *
	 */
	@Override
	public Map<String, Object> getReviewList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<LectureReviewRequest> reviewList = lectureReviewDAO.selectlectureSearchReviewList(cri);
		int totalCount = lectureReviewDAO.selectlectureReviewListCount();
		List<LectureVO> lectureList=lectureDAO.selectLectureList();
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		dataMap.put("lecture", lectureList);
		dataMap.put("lecture_review", reviewList);
		dataMap.put("pageMaker", pageMaker);
		return dataMap;

	}
	
	/**
	 * 
	 * @기능설명		:	수강후기 리스트 출력
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 11:08:59
	 * @see			:	X
	 * @param X
	 * @return lectureReviewList
	 * @throws SQLException
	 *
	 */
	@Override
	public List<Lecture_reviewVO> getReviewList() throws SQLException {
		List<Lecture_reviewVO> lectureReviewList = lectureReviewDAO.selectlectureReviewList();
		return lectureReviewList;
	}

	/**
	 * 
	 * @기능설명		:	수강후기 상세
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 3.오전 9:24:25
	 * @see			:	X
	 * @param Lecture_review_no
	 * @return Lecture_review
	 * @throws SQLException
	 *
	 */
	@Override
	public LectureReviewRequest getReviewDetail(int Lecture_review_no) throws SQLException {
		LectureReviewRequest lecture_review = lectureReviewDAO.selectlectureReviewDetail(Lecture_review_no);
		lectureReviewDAO.reviewCountUp(Lecture_review_no);
		for(int i = 0; i < 5; i++ ) {
			String content = lecture_review.getLecture_review_content();
			lecture_review.setLecture_img_list(Slatter.imgSlatter(content));
			
		}
		return lecture_review;
	}

	/**
	 * 
	 * @기능설명		:	수강후기 등록
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 11:10:12
	 * @see			:	X
	 * @param lecture_review
	 * @throws SQLException
	 *
	 */
	@Override
	public void writeLectureReview(Lecture_reviewVO lecture_review) throws SQLException {
		int lecture_review_no = lectureReviewDAO.selectLectureReviewSeqNext();
		lecture_review.setLecture_review_no(lecture_review_no);
		lectureReviewDAO.insertlectureReview(lecture_review);
		payDAO.reviewCheck(lecture_review.getLecture_review_writer());
		
	}

	/**
	 * 
	 * @기능설명		:	수강후기 수정
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 11:10:36
	 * @see			:	X
	 * @param lecture_review
	 * @throws SQLException
	 *
	 */
	@Override
	public LectureReviewRequest modifyLectureReview(LectureReviewRequest review) throws SQLException {
		lectureReviewDAO.updatelectureReview(review);
		
		LectureReviewRequest reviewReq = lectureReviewDAO.selectlectureReviewDetail(review.getLecture_review_no());
		for(int i = 0; i < 5; i++ ) {
			String content = reviewReq.getLecture_review_content();
			reviewReq.setLecture_img_list(Slatter.imgSlatter(content));
			
		}
		
		return reviewReq;
	}

	/**
	 * 
	 * @기능설명		:	수강후기 삭제
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 11:10:53
	 * @see			:	X
	 * @param lecture_review_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void removeLectureReview(int lecture_review_no) throws SQLException {
		lectureReviewDAO.deletelectureReview(lecture_review_no);
		
	}

	@Override
	public Map<String, Object> getReviewList(Map<String, Object> dataMap) throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		List<LectureReviewRequest> reviewList = lectureReviewDAO.myReviewList(dataMap);
		int totalCount = lectureReviewDAO.myReviewListCount(dataMap);
		List<LectureVO> lectureList=lectureDAO.selectLectureList();
		SearchCriteria cri  = new SearchCriteria();
		cri.setKeyword((String) dataMap.get("keyword"));
		cri.setPage((Integer) dataMap.get("page"));
		cri.setPerPageNum((Integer) dataMap.get("perPageNum"));
		cri.setSearchType((String) dataMap.get("searchType"));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		map.put("lecture", lectureList);
		map.put("lecture_review", reviewList);
		map.put("pageMaker", pageMaker);
		return map;
	
	}

	@Override
	public Lecture_reviewVO getDetailById(String member_id) throws SQLException {
		Lecture_reviewVO review = lectureReviewDAO.selectlectureReviewDetailById(member_id);
		return review;
	}

	@Override
	public List<LectureReviewRequest> bestReviewList() throws SQLException {
		List<LectureReviewRequest> reviewList = lectureReviewDAO.bestReviewList();
		for(int i = 0; i < reviewList.size(); i++ ) {
			String content = reviewList.get(i).getLecture_review_content();
			reviewList.get(i).setLecture_img_list(Slatter.imgSlatter(content));
			String con = Slatter.conSlatter(content);
			reviewList.get(i).setLecture_review_content(con);
		}
		return reviewList;

	}
	@Override
	public Map<String,Object> photoList(SearchCriteria cri) throws SQLException {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<LectureReviewRequest> reviewList = lectureReviewDAO.selectlectureSearchReviewList(cri);
		for(int i = 0; i < reviewList.size(); i++ ) {
			String content = reviewList.get(i).getLecture_review_content();
			reviewList.get(i).setLecture_img_list(Slatter.imgSlatter(content));
			String con = Slatter.conSlatter(content);
			reviewList.get(i).setLecture_review_content(con);
		}
		
		for(int i = 0; i < reviewList.size(); i++) {
			if(reviewList.get(i).getLecture_img_list().isEmpty()) {
				reviewList.remove(i);
			}
		}
		
		int totalCount = lectureReviewDAO.selectlectureReviewListCount();
		List<LectureVO> lectureList=lectureDAO.selectLectureList();
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		dataMap.put("lecture", lectureList);
		dataMap.put("lecture_review", reviewList);
		dataMap.put("pageMaker", pageMaker);
		return dataMap;

	}
	/**
	 * 
	 * @기능설명		:   좋아요 관리 누른적이 없을때는 좋아요 증가, 누른적이 있을때는 좋아요 취소
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 19.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 19.오후 12:22:28
	 * @see			:	X
	 * @param like
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public String likeCount(LikeCountVO like) throws SQLException {
		LikeCountVO likeInfo = likeCountDAO.detailLikeInfo(like);
		String flag = "";
		if(likeInfo == null) {
			int count = likeCountDAO.selectlikeSeqNext();
			like.setLike_no(count);
			likeCountDAO.insertBoardLike(like);
			lectureReviewDAO.reviewLikeCountUp(like.getLecture_review_no());
			flag = "up";
		}
		else {
			likeCountDAO.deleteBoardLike(likeInfo.getLike_no());
			lectureReviewDAO.reviewLikeCountDown(like.getLecture_review_no());
			flag="down";
		}
		return flag;
	}
	
}
