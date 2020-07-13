package com.dlms.dao.lecture;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dlms.dto.Lecture_reviewVO;
import com.dlms.dto.Lecture_review_imgVO;
import com.dlms.request.LectureReviewRequest;
import com.dlms.request.SearchCriteria;

/**
 * 
 * @사용목적		:	수강 후기와 관련된 DAO
 * @작성자		:	민태홍
 * @작성날짜      	:	2020. 6. 2.
 * @마지막수정자	:	민태홍
 * @마지막수정일	:	2020. 6. 2.오전 11:08:22
 * @see			:	lectureReviewDAO
 *
 */
public class LectureReviewDAOImpl implements LectureReviewDAO{
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
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
	public List<LectureReviewRequest> selectlectureSearchReviewList(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();		
		int limit=cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		List<LectureReviewRequest> lectureReviewList = new ArrayList<LectureReviewRequest>();
		lectureReviewList = sqlSession.selectList("lecture_review-mapper.selectSearchlectureReviewList",cri,rowBounds);
		return lectureReviewList;
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
	public List<Lecture_reviewVO> selectlectureReviewList() throws SQLException {
		List<Lecture_reviewVO> lectureReviewList = new ArrayList<Lecture_reviewVO>();
		lectureReviewList = sqlSession.selectList("lecture_review-mapper.selectlectureReviewList");
		return lectureReviewList;
	}
	
	/**
	 * 
	 * @기능설명		:	수강후기 리스트 페이지를 구현하기 위한 장치
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 11:09:19
	 * @see			:	X
	 * @return count
	 * @throws SQLException
	 *
	 */
	@Override
	public int selectlectureReviewListCount() throws SQLException {
		int count = sqlSession.selectOne("lecture_review-mapper.selectlectureReviewListCount");
		return count;
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
	public LectureReviewRequest selectlectureReviewDetail(int Lecture_review_no) throws SQLException {
		LectureReviewRequest Lecture_review = sqlSession.selectOne("lecture_review-mapper.selectlectureReviewDetail",Lecture_review_no);
		return Lecture_review;
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
	public void insertlectureReview(Lecture_reviewVO lecture_review) throws SQLException {
		sqlSession.update("lecture_review-mapper.insertlectureReview",lecture_review);
		
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
	public void updatelectureReview(LectureReviewRequest review) throws SQLException {
		sqlSession.update("lecture_review-mapper.updatelectureReview",review);
		
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
	public void deletelectureReview(int lecture_review_no) throws SQLException {
		sqlSession.delete("lecture_review-mapper.deletelectureReview",lecture_review_no);
		
	}

	/**
	 * 
	 * @기능설명		:	수강후기 번호 생성
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 11:11:09
	 * @see			:	X
	 * @return lecture_review_no
	 * @throws SQLException
	 *
	 */
	@Override
	public int selectLectureReviewSeqNext() throws SQLException {
		int lecture_review_no = sqlSession.selectOne("lecture_review-mapper.selectLectureReviewSeqNext");
		return lecture_review_no;
	}

	/**
	 * 
	 * @기능설명		:   나의 수강후기만 출력한다.	
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 19.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 19.오후 12:40:16
	 * @see			:	X
	 * @param dataMap
	 * @return
	 *
	 */
	@Override
	public List<LectureReviewRequest> myReviewList(Map<String, Object> dataMap) {
		List<LectureReviewRequest> lectureReviewList = new ArrayList<LectureReviewRequest>();
		lectureReviewList = sqlSession.selectList("lecture_review-mapper.mylectureReviewList",dataMap);
		return lectureReviewList;
	}
	
	/**
	 * 
	 * @기능설명		:   나의 수강후기의 페이지 번호	
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 19.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 19.오후 12:40:32
	 * @see			:	X
	 * @param dataMap
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public int myReviewListCount(Map<String,Object> dataMap) throws SQLException {
		int count = sqlSession.selectOne("lecture_review-mapper.mylectureReviewListCount",dataMap);
		return count;
	}

	/**
	 * 
	 * @기능설명		:   수강후기 상세를 아이디로 조회한다.	
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 19.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 19.오후 12:40:53
	 * @see			:	X
	 * @param member_id
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public Lecture_reviewVO selectlectureReviewDetailById(String member_id) throws SQLException {
		Lecture_reviewVO review = sqlSession.selectOne("lecture_review-mapper.selectlectureReviewDetailById",member_id);
		return review;
	}

	/**
	 * 
	 * @기능설명		:   베스트 후기를 출력한다.	
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 19.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 19.오후 12:41:08
	 * @see			:	X
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public List<LectureReviewRequest> bestReviewList() throws SQLException {
		List<LectureReviewRequest> lectureReviewList = new ArrayList<LectureReviewRequest>();
		lectureReviewList = sqlSession.selectList("lecture_review-mapper.bestReviewList");
		return lectureReviewList;
	}

	/**
	 * 
	 * @기능설명		:   수강후기 좋아요 증가	
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 19.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 19.오후 12:41:17
	 * @see			:	X
	 * @param lecture_review_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void reviewLikeCountUp(int lecture_review_no) throws SQLException {
		sqlSession.update("lecture_review-mapper.reviewLikeCountUp",lecture_review_no);
		
	}

	/**
	 * 
	 * @기능설명		:   수강후기 좋아요 감소	
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 19.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 19.오후 12:41:26
	 * @see			:	X
	 * @param lecture_review_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void reviewLikeCountDown(int lecture_review_no) throws SQLException {
		 sqlSession.update("lecture_review-mapper.reviewLikeCountDown",lecture_review_no);
		
	}

	@Override
	public void reviewCountUp(int lecture_review_no) throws SQLException {
		sqlSession.update("lecture_review-mapper.reviewCountUp",lecture_review_no);
		
	}

}
