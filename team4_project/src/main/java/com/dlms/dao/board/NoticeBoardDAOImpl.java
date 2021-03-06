package com.dlms.dao.board;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dlms.dto.NoticeVO;
import com.dlms.request.SearchCriteria;

public class NoticeBoardDAOImpl implements NoticeBoardDAO{
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	

	@Override
	public List<NoticeVO> selectSearchNoticeList(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<NoticeVO> noticeList = sqlSession.selectList("notice-mapper.selectSearchNoticeList", cri, rowBounds);
		return noticeList;
	}
	
	@Override
	public int selectSearchNoticeListCount() throws SQLException {
		int count = sqlSession.selectOne("notice-mapper.selectSearchNoticeListCount");
		return count;
	}
	
	@Override
	public NoticeVO selectNoticeByNotice_no(int notice_no) throws SQLException {
		NoticeVO notice = sqlSession.selectOne("notice-mapper.selectNoticeByNotice_no", notice_no);
		return notice;
	}
	@Override
	public void insertNotice(NoticeVO notice) throws SQLException {
		sqlSession.update("notice-mapper.insertNotice", notice);
		
	}
	@Override
	public void updateNotice(NoticeVO notice) throws SQLException {
		sqlSession.update("notice-mapper.updateNotice", notice);
		
	}
	@Override
	public void deleteNotice(int notice_no) throws SQLException {
		sqlSession.update("notice-mapper.deleteNotice", notice_no);
		
	}
	@Override
	public void increaseViewCnt(int notice_no) throws SQLException {
		sqlSession.update("notice-mapper.increaseViewCnt", notice_no);
		
	}
	@Override
	public int selectNoticeSeqNext() throws SQLException {
		int seq_num = (Integer)sqlSession.selectOne("notice-mapper.selectNoticeSeqNext");
		return seq_num;
	}


	@Override
	public List<NoticeVO> selectNoticePoint(String notice_point) throws SQLException {
		List<NoticeVO> point = sqlSession.selectList("notice-mapper.selectNoticePoint", notice_point); 
		return point;
	}

	
	@Override
	public int next_notice_no(int notice_no) throws SQLException {
		int next_notice_no = sqlSession.selectOne("notice-mapper.next_notice_no", notice_no); 
		return next_notice_no;
	}


	@Override
	public int prev_notice_no(int notice_no) throws SQLException {
		int prev_notice_no = sqlSession.selectOne("notice-mapper.prev_notice_no", notice_no); 
		return prev_notice_no;
	}


	@Override
	public String next_notice_title(int notice_no) throws SQLException {
		String next_notice_title = sqlSession.selectOne("notice-mapper.next_notice_title", notice_no); 
		return next_notice_title;
	}


	@Override
	public String prev_notice_title(int notice_no) throws SQLException {
		String prev_notice_title = sqlSession.selectOne("notice-mapper.prev_notice_title", notice_no); 
		return prev_notice_title;
	}



}
