package com.dlms.service.board;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dlms.dao.board.ConsultBoardDAO;
import com.dlms.dao.board.NoticeBoardDAO;
import com.dlms.dto.ConsultVO;
import com.dlms.dto.NoticeVO;
import com.dlms.dto.QnaVO;
import com.dlms.request.PageMaker;
import com.dlms.request.SearchCriteria;

public class ConsultBoardServiceImpl implements ConsultBoardService{
	@Autowired
	ConsultBoardDAO consultDAO;
	public void setConsultBoardDAO(ConsultBoardDAO consultDAO) {
		this.consultDAO = consultDAO;
	}
	@Autowired
	NoticeBoardDAO noticeDAO;
	public void setNoticeDAO(NoticeBoardDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	@Override
	public Map<String, Object> getConsultList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		List<ConsultVO> consult = consultDAO.selectSearchConsultList(cri);
		
		int totalCount = consultDAO.selectSearchConsultListCount(cri);
		
		String notice_point = "consult";
		List<NoticeVO> point = noticeDAO.selectNoticePoint(notice_point);
		

		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("point", point);
		dataMap.put("consult", consult);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}

	@Override
	public Map<String, Object> getRegistConsultList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		List<ConsultVO> consult = consultDAO.registConsultList(cri);
		
		int totalCount = consultDAO.searchRegistConsultList(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("consult", consult);
		dataMap.put("pageMaker", pageMaker);
		
		
		return dataMap;
	}
	
	@Override
	public Map<String, Object> getNoRegistConsultList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		List<ConsultVO> consult = consultDAO.noRegistConsultList(cri);
		
		int totalCount = consultDAO.searchNoRegistConsultList(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("consult", consult);
		dataMap.put("pageMaker", pageMaker);
		
		
		return dataMap;
	}

	@Override
	public ConsultVO getDetailList(int consult_no) throws SQLException {
		ConsultVO consult = consultDAO.selectConsultByConsult_no(consult_no);

		if(consult.getConsult_status()==1) {
			consultDAO.read(consult_no);
			}
		
		consultDAO.increaseConsultviewCnt(consult_no);
		return consult;
	}
	
	/**
	 * 
	 * @기능설명		:	관리자의 답변 완료 조회를 위함
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 16.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 16.오후 4:59:28
	 * @see			    :	-
	 * @param consult_no
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public ConsultVO getDetaiAdminRead(int consult_no)throws SQLException{
		ConsultVO consult = consultDAO.selectConsultByConsult_no(consult_no);
		return consult;
	}
	
	@Override
	public ConsultVO getDetailList(int consult_no, String check) throws SQLException {
		ConsultVO consult = consultDAO.selectConsultByConsult_no(consult_no);
		return consult;
	}


	@Override
	public void writer(ConsultVO consult) throws SQLException {
		int consult_no = consultDAO.selectConsultSeqNext();
		consult.setConsult_no(consult_no);
		
		if(consult.getConsult_type() == null) {
			consult.setConsult_type("일반글");
		}
		consultDAO.insertConsult(consult);
		
	}

	@Override
	public void modify(ConsultVO consult) throws SQLException {
		consultDAO.updateConsult(consult);
	}

	@Override
	public void remove(int consult_no) throws SQLException {
		consultDAO.deleteConsult(consult_no);
	}

	@Override
	public void AnswerWriterAndUpdate(ConsultVO consult) throws SQLException {
		consultDAO.insertAndUpdateAnswer(consult);		
	}


}
