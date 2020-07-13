package com.dlms.service.board;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dlms.dao.board.QnaBoardDAO;
import com.dlms.dao.member.MemberDAO;
import com.dlms.dto.QnaVO;
import com.dlms.request.PageMaker;
import com.dlms.request.SearchCriteria;

public class QnaBoardServiceImpl implements QnaBoardService{

	QnaBoardDAO qnaDAO;
	public void setQnaBoardDAO(QnaBoardDAO qnaDAO) {
		this.qnaDAO = qnaDAO;
	}
	
	@Override
	public Map<String, Object> getSearchQnaList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		List<QnaVO> qna = qnaDAO.selectQnAList(cri);
		
		int totalCount = qnaDAO.selectSearchQnAListCount(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setDisplayPageNum(5);
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("qna", qna);
		dataMap.put("pageMaker", pageMaker);
		
		
		return dataMap;
	}
	
	@Override
	public Map<String, Object> getRegistQnaList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		List<QnaVO> qna = qnaDAO.registQnAList(cri);
		
		int totalCount = qnaDAO.searchRegistQnAList(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("qna", qna);
		dataMap.put("pageMaker", pageMaker);
		
		
		return dataMap;
	}
	

	@Override
	public List<QnaVO> getQnaList() throws SQLException {
		List<QnaVO> qna = qnaDAO.selectQnaList();
		return qna;
	}
	
	@Override
	public QnaVO getDetailList(int qna_no) throws SQLException {
		QnaVO qna = qnaDAO.selectQnaByQna_no(qna_no);
		qnaDAO.increaseQnAviewCnt(qna_no);
		return qna;
	}
	
	@Override
	public QnaVO getDetailList(int qna_no, String check) throws SQLException {
		QnaVO qna = qnaDAO.selectQnaByQna_no(qna_no);
		return qna;
	}


	@Override
	public void writer(QnaVO qna) throws SQLException {
		int qna_no = qnaDAO.selectQnaSeqNext();
		qna.setQna_no(qna_no);
		qnaDAO.insertQnA(qna);
	}

	@Override
	public void modify(QnaVO qna) throws SQLException {
		qnaDAO.updateQnA(qna);
	}

	@Override
	public void remove(int qna_no) throws SQLException {
		qnaDAO.deleteQnA(qna_no);
	}

	@Override
	public void AnswerWriterAndUpdate(QnaVO qna) throws SQLException {
		qnaDAO.insertAndUpdateAnswer(qna);		
	}

	@Override
	public Map<String, Object> getNoRegistQnaList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		List<QnaVO> qna = qnaDAO.noRegistQnAList(cri);
		
		int totalCount = qnaDAO.searchNoRegistQnAList(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("qna", qna);
		dataMap.put("pageMaker", pageMaker);
		
		
		return dataMap;
	}

	@Override
	public Map<String, Object> getToProfessorQnAList(Map<String, Object> dataMap) throws SQLException {
		Map<String, Object> result = new HashMap<String, Object>();
		
		SearchCriteria cri = new SearchCriteria();

		cri.setPage((int)dataMap.get("page"));
		cri.setPerPageNum((int)dataMap.get("perPageNum"));
		cri.setSearchType((String)dataMap.get("searchType"));
		cri.setKeyword((String)dataMap.get("keyword"));
		
		dataMap.put("cri", cri);
		List<QnaVO> qna = qnaDAO.selectToProfessorQnAList(dataMap);
		
		int totalCount = qnaDAO.selectToProfessorQnAListCount(dataMap);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		result.put("qna", qna);
		result.put("pageMaker", pageMaker);
		
		
		return result;
	}

	@Override
	public  Map<String, Object> getRegistFromProfessorQnAList(Map<String,Object> dataMap) throws SQLException {
		Map<String, Object> result = new HashMap<String, Object>();
		
		SearchCriteria cri = new SearchCriteria();

		cri.setPage((int)dataMap.get("page"));
		cri.setPerPageNum((int)dataMap.get("perPageNum"));
		cri.setSearchType((String)dataMap.get("searchType"));
		cri.setKeyword((String)dataMap.get("keyword"));
		
		dataMap.put("cri", cri);
		
		List<QnaVO> qna = qnaDAO.registFromProfessorQnAList(dataMap);
		
		int totalCount = qnaDAO.searchRegistFromProfessorQnAList(dataMap);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		result.put("qna", qna);
		result.put("pageMaker", pageMaker);
		
		
		return result;
	}

	@Override
	public Map<String, Object> getNoRegistFromProfessorQnAList(Map<String, Object> dataMap) throws SQLException {
		Map<String, Object> result = new HashMap<String, Object>();
		
		SearchCriteria cri = new SearchCriteria();

		cri.setPage((int)dataMap.get("page"));
		cri.setPerPageNum((int)dataMap.get("perPageNum"));
		cri.setSearchType((String)dataMap.get("searchType"));
		cri.setKeyword((String)dataMap.get("keyword"));
		
		dataMap.put("cri", cri);
		
		List<QnaVO> qna = qnaDAO.noRegistFromProfessorQnAList(dataMap);
		
		int totalCount = qnaDAO.searchNoRegistFromProfessorQnAList(dataMap);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		result.put("qna", qna);
		result.put("pageMaker", pageMaker);
		
		
		return result;
	}





	
}
