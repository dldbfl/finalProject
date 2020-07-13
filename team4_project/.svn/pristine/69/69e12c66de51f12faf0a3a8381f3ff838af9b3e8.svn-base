package com.dlms.dao.lecture;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dlms.dto.Lecture_reviewVO;
import com.dlms.dto.Lecture_review_imgVO;
import com.dlms.request.LectureReviewRequest;
import com.dlms.request.SearchCriteria;

public interface LectureReviewDAO {
	public List<LectureReviewRequest> selectlectureSearchReviewList (SearchCriteria cri) throws SQLException;
	public int selectlectureReviewListCount() throws SQLException;
	public List<Lecture_reviewVO> selectlectureReviewList () throws SQLException;
	public LectureReviewRequest selectlectureReviewDetail (int Lecture_review_no) throws SQLException;
	public void insertlectureReview(Lecture_reviewVO lecture_review) throws SQLException;
	public void updatelectureReview(LectureReviewRequest review) throws SQLException;
	public void deletelectureReview(int lecture_review_no) throws SQLException;
	public int selectLectureReviewSeqNext() throws SQLException;
	public List<LectureReviewRequest> myReviewList(Map<String, Object>dataMap) throws SQLException;
	public int myReviewListCount(Map<String, Object> dataMap) throws SQLException;
	public Lecture_reviewVO selectlectureReviewDetailById(String member_id) throws SQLException;
	public List<LectureReviewRequest> bestReviewList()throws SQLException;
	public void reviewLikeCountUp(int lecture_review_no) throws SQLException;
	public void reviewLikeCountDown(int lecture_review_no) throws SQLException;
	public void reviewCountUp(int lecture_review_no ) throws SQLException;
}
