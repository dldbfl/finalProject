package com.dlms.service.lecture;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dlms.dto.Lecture_reviewVO;
import com.dlms.dto.Lecture_review_imgVO;
import com.dlms.dto.LikeCountVO;
import com.dlms.request.LectureReviewRequest;
import com.dlms.request.SearchCriteria;

public interface LectureReviewService {
	public Map<String, Object> getReviewList (SearchCriteria cri) throws SQLException;
	public Map<String, Object> photoList (SearchCriteria cri) throws SQLException;
	public Map<String, Object> getReviewList (Map<String, Object> dataMap) throws SQLException;
	public List<Lecture_reviewVO> getReviewList () throws SQLException;
	public LectureReviewRequest getReviewDetail (int Lecture_review_no) throws SQLException;
	public void writeLectureReview(Lecture_reviewVO lecture_review) throws SQLException;
	public LectureReviewRequest modifyLectureReview(LectureReviewRequest review) throws SQLException;
	public void removeLectureReview(int lecture_review_no) throws SQLException;
	public Lecture_reviewVO getDetailById(String member_id) throws SQLException;
	public List<LectureReviewRequest>bestReviewList()throws SQLException;
	public String likeCount(LikeCountVO like)throws SQLException;
}
