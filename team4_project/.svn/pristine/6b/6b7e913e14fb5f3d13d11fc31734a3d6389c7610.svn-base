package com.dlms.dao.founded;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dlms.dto.Founded_reviewVO;
import com.dlms.request.DetailFoundedRequest;
import com.dlms.request.SearchCriteria;

public class FoundedReviewDAOImpl implements FoundedReviewDAO{
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	//게시글 검색 리스트 출력
	@Override
	public List<Founded_reviewVO> selectFoundedReviewSearchList(SearchCriteria cri) throws SQLException {
		int offset=cri.getPageStartRowNum();
		int limit=cri.getPerPageNum();
		RowBounds rowBounds=new RowBounds(offset,limit);
				
		List<Founded_reviewVO> reviewList=
				sqlSession.selectList("founded_review-mapper.selectFoundedReviewSearchList",cri,rowBounds);	
			
		return reviewList;
	}
	//총 게시물 갯수 카운트
	@Override
	public int selectFoundedReviewCriteriaTotalCount(SearchCriteria cri) throws SQLException {
		int count=0;
		count=sqlSession.selectOne("founded_review-mapper.selectFoundedReviewCriteriaTotalCount",cri);
		
		return count;
	}
	//게시글 전체 리스트 출력
	@Override
	public List<Founded_reviewVO> selectFoundedReviewList() throws SQLException {
		List<Founded_reviewVO> FoundedReviewList=
				sqlSession.selectList("founded_review-mapper.selectFoundedReviewList",null);		
		return FoundedReviewList;
	}
	
	@Override
	public Founded_reviewVO selectFoundedReviewByReviewNo(int founded_review_no) throws SQLException {
		Founded_reviewVO foundedReview=
				sqlSession.selectOne("founded_review-mapper.selectFoundedReviewByReviewNo",founded_review_no);
		return foundedReview;
	}
	
	@Override
	public List<Founded_reviewVO> selectFoundedReviewViewCntList() throws SQLException {
		List<Founded_reviewVO> foundedReview=
				sqlSession.selectList("founded_review-mapper.selectFoundedReviewViewCntList");
		return foundedReview;
	}
	
	@Override
	public void insertFoundedReview(Founded_reviewVO reviewVO) throws SQLException {
		sqlSession.update("founded_review-mapper.insertFoundedReview",reviewVO);
		
	}
	
	@Override
	public void updateFoundedReview(Founded_reviewVO reviewVO) throws SQLException {
		sqlSession.update("founded_review-mapper.updateFoundedReview",reviewVO);
		
	}
	
	@Override
	public void deleteFoundedReview(int founded_review_no) throws SQLException {
		sqlSession.update("founded_review-mapper.deleteFoundedReview",founded_review_no);
		
	}
	
	@Override
	public void increaseViewCnt(int founded_review_no) throws SQLException {
		sqlSession.update("founded_review-mapper.increaseViewCnt",founded_review_no);
		
	}
	
	@Override
	public int selectFoundedReviewSeqNext() throws SQLException {
		int seqNum=0;
		seqNum=sqlSession.selectOne("founded_review-mapper.selectFoundedReviewSeqNext",null);
		return seqNum;
		
	}
	@Override
	public DetailFoundedRequest selectPrevNexTitle(int detailReviewNo) {
			DetailFoundedRequest detailReq=sqlSession.selectOne("founded_review-mapper.selectPrevNexTitle", detailReviewNo );
		return detailReq;
	}
	@Override
	public void viewCountUP(int review_no) throws SQLException {
		sqlSession.update("founded_review-mapper.viewCountUP",review_no);
	}
	@Override
	public List<Founded_reviewVO> selectfoundedListByCount(int count) throws SQLException {
		List<Founded_reviewVO> foundedList = sqlSession.selectList("founded_review-mapper.selectfoundedListByCount", count);
		return foundedList;
	}
	@Override
	public List<Founded_reviewVO> myfounded_reviewList(String member_id) throws SQLException {
		List<Founded_reviewVO> foundedReview = sqlSession.selectList("founded_review-mapper.myfounded_reviewList", member_id);
		return foundedReview;
	}
	

	
}
