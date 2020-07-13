package com.dlms.dao.attach;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dlms.dto.Notice_dataVO;

public class NoticeAttachDAOImpl implements NoticeAttachDAO{

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<Notice_dataVO> selectAttachByNotice_data_no(int notice_data_no) throws SQLException {
		List<Notice_dataVO> notice_attach = sqlSession.selectList("notice_attach-mapper.selectAttachByNotice_data_no", notice_data_no);
		return notice_attach;
	}

	@Override
	public List<Notice_dataVO> selectAttachByNotice_no(int notice_no) throws SQLException {
		List<Notice_dataVO> notice_attach = sqlSession.selectList("notice_attach-mapper.selectAttachByNotice_no", notice_no);
		return notice_attach;
	}

	@Override
	public void insertAttach(Notice_dataVO notice_attach) throws SQLException {
		sqlSession.update("notice_attach-mapper.insertAttach", notice_attach);
		

	}

	@Override
	public void deleteAttach(int notice_data_no) throws SQLException {
		sqlSession.update("notice_attach-mapper.deleteAttach", notice_data_no);
		
	}

	@Override
	public void deleteAllAttach(int notice_no) throws SQLException {
		sqlSession.update("notice_attach-mapper.deleteAllAttach", notice_no);
		
	}


}
