package com.dlms.dao.founded;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dlms.dto.Founded_review_imgVO;

public class FoundedReviewImgDAOImpl implements FoundedReviewImgDAO{
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public List<Founded_review_imgVO> selectFoundedReviewImgByReviewNo(int founded_review_no) throws SQLException {
		List<Founded_review_imgVO> reviewList=
				sqlSession.selectList("founded_img-mapper.selectFoundedReviewImgByReviewNo",founded_review_no);
		return reviewList;
	}
	@Override
	public Founded_review_imgVO selectImgByfoundedImg(int founded_review_img_no) throws SQLException {
		Founded_review_imgVO reviewImg=
				sqlSession.selectOne("founded_img-mapper.selectImgByfoundedImg",founded_review_img_no);
			
			return reviewImg;
	}
	@Override
	public void insertImg(Founded_review_imgVO imgVO) throws SQLException {
		sqlSession.update("founded_img-mapper.insertImg",imgVO);
		
	}
	@Override
	public void deleteImg(int founded_review_img_no) throws SQLException {
		sqlSession.update("founded_img-mapper.deleteImg",founded_review_img_no);
		
	}
	@Override
	public void deleteAllImg(int founded_review_no) throws SQLException {
		sqlSession.update("founded_img-mapper.deleteAllImg",founded_review_no);
		
	}

}
