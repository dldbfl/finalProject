package com.dlms.dao.board;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dlms.dto.ConsultVO;
import com.dlms.request.SearchCriteria;

public class ConsultBoardDAOImpl implements ConsultBoardDAO{
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	@Override
	public List<ConsultVO> selectSearchConsultList(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		
		List<ConsultVO> cousult = sqlSession.selectList("consult-mapper.selectSearchConsultList", cri, rowBounds);
		System.out.println(cousult);
		return cousult;
	}
	
	@Override
	public int selectSearchConsultListCount(SearchCriteria cri) throws SQLException {
		int count = sqlSession.selectOne("consult-mapper.selectSearchConsultListCount", cri);
		return count;
	}
	
	
	@Override
	public List<ConsultVO> registConsultList(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<ConsultVO> consult = sqlSession.selectList("consult-mapper.registConsultList", cri, rowBounds);
		return consult;
	}

	@Override
	public int searchRegistConsultList(SearchCriteria cri) throws SQLException {
		int count = sqlSession.selectOne("consult-mapper.searchRegistConsultList", cri);
		return count;
	
	}

	@Override
	public List<ConsultVO> noRegistConsultList(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<ConsultVO> consult = sqlSession.selectList("consult-mapper.noRegistConsultList", cri, rowBounds);
		return consult;
	}

	@Override
	public int searchNoRegistConsultList(SearchCriteria cri) throws SQLException {
		int count = sqlSession.selectOne("consult-mapper.searchNoRegistConsultList", cri);
		return count;
	}

	@Override
	public ConsultVO selectConsultByConsult_no(int consult_no) throws SQLException {
		ConsultVO consult = sqlSession.selectOne("consult-mapper.selectConsultByConsult_no", consult_no);
		return consult;
	}
	
	@Override
	public void insertConsult(ConsultVO consult) throws SQLException {
		sqlSession.update("consult-mapper.insertConsult", consult);
	}

	

	@Override
	public void updateConsult(ConsultVO consult) throws SQLException {
		sqlSession.update("consult-mapper.updateConsult", consult);

	}

	@Override
	public void deleteConsult(int consult_no) throws SQLException {
		sqlSession.update("consult-mapper.deleteConsult", consult_no);

	}

	@Override
	public void insertAndUpdateAnswer(ConsultVO consult) throws SQLException {
		sqlSession.update("consult-mapper.insertAndUpdateAnswer", consult);

	}

	@Override
	public void deleteAnswer(int consult_no) throws SQLException {
		sqlSession.update("consult-mapper.deleteAnswer", consult_no);

	}

	@Override
	public void increaseConsultviewCnt(int consult_no) throws SQLException {
		sqlSession.update("consult-mapper.increaseConsultviewCnt", consult_no);
	}

	@Override
	public int selectConsultSeqNext() throws SQLException {
		int seq_num = (Integer)sqlSession.selectOne("consult-mapper.selectConsultSeqNext");
		return seq_num;
	}


	@Override
	public void read(int consult_no) throws SQLException {
		sqlSession.update("consult-mapper.read", consult_no);
		
	}


	@Override
	public List<ConsultVO> myConsultList(String member_id) throws SQLException {
		List<ConsultVO> consult = sqlSession.selectList("consult-mapper.myConsultList", member_id);
		return consult;
	}

}
