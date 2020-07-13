package com.dlms.dao.board;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dlms.dto.QnaVO;
import com.dlms.request.SearchCriteria;

public class QnaBoardDAOImpl implements QnaBoardDAO {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<QnaVO> selectQnAList(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<QnaVO> qna = sqlSession.selectList("qna-mapper.selectQnAList", cri, rowBounds);
		return qna;
	}

	@Override
	public int selectSearchQnAListCount(SearchCriteria cri) throws SQLException {
		int count = sqlSession.selectOne("qna-mapper.selectSearchQnAListCount", cri);
		return count;
	}
	
	@Override
	public List<QnaVO> selectQnaList() throws SQLException {
		List<QnaVO> qna = sqlSession.selectList("qna-mapper.selectQnaList");
		return qna;
	}

	@Override
	public QnaVO selectQnaByQna_no(int qna_no) throws SQLException {
		QnaVO qna = sqlSession.selectOne("qna-mapper.selectQnaByQna_no", qna_no);
		return qna;
	}
	
	@Override
	public void insertQnA(QnaVO qna) throws SQLException {
		sqlSession.update("qna-mapper.insertQnA", qna);
	}

	@Override
	public void updateQnA(QnaVO qna) throws SQLException {
		sqlSession.update("qna-mapper.updateQnA", qna);

	}

	@Override
	public void deleteQnA(int qna_no) throws SQLException {
		sqlSession.update("qna-mapper.deleteQnA", qna_no);

	}

	@Override
	public void insertAndUpdateAnswer(QnaVO qna) throws SQLException {
		sqlSession.update("qna-mapper.insertAndUpdateAnswer", qna);
	
	}

	@Override
	public void deleteAnswer(int qna_no) throws SQLException {
		sqlSession.update("qna-mapper.deleteAnswer", qna_no);

	}

	@Override
	public void increaseQnAviewCnt(int qna_no) throws SQLException {
		sqlSession.update("qna-mapper.increaseQnAviewCnt", qna_no);
	}

	@Override
	public int selectQnaSeqNext() throws SQLException {
		int seq_num = (Integer)sqlSession.selectOne("qna-mapper.selectQnaSeqNext");
		return seq_num;
	}

	@Override
	public List<QnaVO> registQnAList(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<QnaVO> qna = sqlSession.selectList("qna-mapper.registQnAList", cri, rowBounds);
		return qna;
	}

	@Override
	public int searchRegistQnAList(SearchCriteria cri) throws SQLException {
		int count = sqlSession.selectOne("qna-mapper.searchRegistQnAList", cri);
		return count;
	
	}

	@Override
	public List<QnaVO> noRegistQnAList(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<QnaVO> qna = sqlSession.selectList("qna-mapper.noRegistQnAList", cri, rowBounds);
		return qna;
	}

	@Override
	public int searchNoRegistQnAList(SearchCriteria cri) throws SQLException {
		int count = sqlSession.selectOne("qna-mapper.searchNoRegistQnAList", cri);
		return count;
	}

	@Override
	public List<QnaVO> selectToProfessorQnAList(Map<String,Object> dataMap) throws SQLException {
		SearchCriteria cri = (SearchCriteria)dataMap.get("cri");
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<QnaVO> qnaList = sqlSession.selectList("qna-mapper.selectToProfessorQnAList",dataMap,rowBounds);
		return qnaList;
	}

	@Override
	public int selectToProfessorQnAListCount(Map<String,Object> dataMap) throws SQLException {
		int count = sqlSession.selectOne("qna-mapper.selectToProfessorQnAListCount", dataMap);
		return count;
	}

	@Override
	public List<QnaVO> registFromProfessorQnAList(Map<String,Object> dataMap) throws SQLException {
		SearchCriteria cri = (SearchCriteria)dataMap.get("cri");
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<QnaVO> qna = sqlSession.selectList("qna-mapper.registFromProfessorQnAList", dataMap, rowBounds);
		return qna;
	}

	@Override
	public int searchRegistFromProfessorQnAList(Map<String,Object> dataMap) throws SQLException {
		int count = sqlSession.selectOne("qna-mapper.searchRegistFromProfessorQnAList", dataMap);
		return count;
	}

	@Override
	public List<QnaVO> noRegistFromProfessorQnAList(Map<String,Object> dataMap) throws SQLException {
		SearchCriteria cri = (SearchCriteria)dataMap.get("cri");
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<QnaVO> qna = sqlSession.selectList("qna-mapper.noRegistFromProfessorQnAList", dataMap, rowBounds);
		return qna;
	}

	@Override
	public int searchNoRegistFromProfessorQnAList(Map<String,Object> dataMap) throws SQLException {
		int count = sqlSession.selectOne("qna-mapper.searchNoRegistFromProfessorQnAList", dataMap);
		return count;
	}

	@Override
	public List<QnaVO> myQnaList(String member_id) throws SQLException {
		List<QnaVO> qna = sqlSession.selectList("qna-mapper.myQnaList", member_id);
		return qna;
	}

	@Override
	public void insertQnAToStudent(QnaVO qna) throws SQLException {
		sqlSession.update("qna-mapper.insertQnAToStudent", qna);
		
	}





}
