package com.dlms.service.board;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.dlms.dao.attach.NoticeAttachDAO;
import com.dlms.dao.board.NoticeBoardDAO;
import com.dlms.dto.NoticeVO;
import com.dlms.dto.Notice_dataVO;
import com.dlms.request.PageMaker;
import com.dlms.request.SearchCriteria;

public class NoticeBoardServiceImpl implements NoticeBoardService{

	private NoticeBoardDAO noticeDAO;
	public void setNoticeDAO(NoticeBoardDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	
	private NoticeAttachDAO noticeAttachDAO;
	public void setNoticeAttachDAO(NoticeAttachDAO noticeAttachDAO) {
		this.noticeAttachDAO = noticeAttachDAO;
	}
	
	@Override
	public Map<String, Object> getNoticeList(SearchCriteria cri) throws SQLException {
		
		
		
		List<NoticeVO> noticeList = noticeDAO.selectSearchNoticeList(cri);
		
		for(NoticeVO notice : noticeList) {
			
			Date sysDate = new Date();
			Date finishDate = notice.getNotice_finishdate();
			if (finishDate != null) {
				int compare = sysDate.compareTo(finishDate);
				
				if (compare == 0 || compare > 0) {  //
					notice.setNotice_point("nomal");
					noticeDAO.updateNotice(notice);
					if (notice.getNotice_attach()!=null) {
					for(Notice_dataVO attach : notice.getNotice_attach()) {
						attach.setNotice_no(notice.getNotice_no());
						noticeAttachDAO.insertAttach(attach);
					}
				}
					
					List<Notice_dataVO> attachList = noticeAttachDAO.selectAttachByNotice_no(notice.getNotice_no());
					notice.setNotice_attach(attachList);
				} else {
					List<Notice_dataVO> attachList = noticeAttachDAO.selectAttachByNotice_no(notice.getNotice_no());
					notice.setNotice_attach(attachList);
				}
			}
		}
		
		
		String notice_point = "notice";
		List<NoticeVO> point = noticeDAO.selectNoticePoint(notice_point);
		
	for(NoticeVO notice : point) {
			Date sysDate = new Date();
			Date finishDate = notice.getNotice_finishdate();
			
			if (finishDate != null) {
				int compare = sysDate.compareTo(finishDate);

				
				if (compare == 0 || compare > 0) {  //
					notice.setNotice_point("nomal");
					noticeDAO.updateNotice(notice);
					if (notice.getNotice_attach()!=null) {
					for(Notice_dataVO attach : notice.getNotice_attach()) {
						attach.setNotice_no(notice.getNotice_no());
						noticeAttachDAO.insertAttach(attach);
					}
				}
					
					List<Notice_dataVO> attachList = noticeAttachDAO.selectAttachByNotice_no(notice.getNotice_no());
					notice.setNotice_attach(attachList);
				} else {
					List<Notice_dataVO> attachList = noticeAttachDAO.selectAttachByNotice_no(notice.getNotice_no());
					notice.setNotice_attach(attachList);
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		int totalCount = noticeDAO.selectSearchNoticeListCount();
		
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		
		
		
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("point", point);
		dataMap.put("noticeList", noticeList);
		dataMap.put("pageMaker", pageMaker);
		dataMap.put("title", "공지사항");
		
		return dataMap;
	}



	@Override
	public NoticeVO getDetailList(int notice_no) throws SQLException {
		int nextNo = noticeDAO.next_notice_no(notice_no);
		int prevNo = noticeDAO.prev_notice_no(notice_no);
		String nextTitle = noticeDAO.next_notice_title(notice_no);
		String prevTitle = noticeDAO.prev_notice_title(notice_no);

		NoticeVO notice = noticeDAO.selectNoticeByNotice_no(notice_no);
		
		if (nextNo == 0) {
			nextNo = notice_no;
			nextTitle = "이전글이 없습니다.";
		}
		
		if (prevNo == 0) {
			prevNo = notice_no;
			prevTitle = "다음글이 없습니다.";
		}
		
		notice.setNextNo(nextNo);
		notice.setPrevNo(prevNo);
		notice.setNextTitle(nextTitle);
		notice.setPrevTitle(prevTitle);
		
		
		List<Notice_dataVO> notice_attach = noticeAttachDAO.selectAttachByNotice_no(notice_no);
		notice.setNotice_attach(notice_attach);
		noticeDAO.increaseViewCnt(notice_no);
	
		return notice;
	}

	@Override
	public void writer(NoticeVO notice) throws SQLException {
		int notice_no = noticeDAO.selectNoticeSeqNext();
		notice.setNotice_no(notice_no);
		noticeDAO.insertNotice(notice);
		
		if(notice.getNotice_attach() != null) {
		for(Notice_dataVO attach:notice.getNotice_attach()) {
			attach.setNotice_no(notice_no);
			noticeAttachDAO.insertAttach(attach);
			}
		}
	}

	@Override
	public void modify(NoticeVO notice) throws SQLException {
		System.out.println("수정 서비스(notice) : " + notice);
		noticeDAO.updateNotice(notice);
			if (notice.getNotice_attach()!=null) {
//				noticeAttachDAO.deleteAllAttach(notice_no);
			for(Notice_dataVO attach : notice.getNotice_attach()) {
				attach.setNotice_no(notice.getNotice_no());
				noticeAttachDAO.insertAttach(attach);
			}
		}
		
	}

	@Override
	public void remove(int notice_no) throws SQLException {
		noticeDAO.deleteNotice(notice_no);
		
	}

	
	/**
	 * @기능설명		:	화면 하단에 공지사항 중요공지가져오기
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 24.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 24.오후 6:37:44
	 * @param 		:	공지사항중요글(notice)
	 * @return		:	List NoticeVO
	 * @throws		:	SQLException
	 */
	@Override
	public List<NoticeVO> getNoticePointList(String notice) throws SQLException {
		List<NoticeVO> noticePointList = noticeDAO.selectNoticePoint(notice);
		return noticePointList;
	}
	

	
	
}
