package com.dlms.service.board;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dlms.dao.board.FreeBoardDAO;
import com.dlms.dao.board.FreeBoardReplyDAO;
import com.dlms.dao.board.NoticeBoardDAO;
import com.dlms.dao.member.MemberDAO;
import com.dlms.dto.FreeBoardVO;
import com.dlms.dto.MemberVO;
import com.dlms.dto.NoticeVO;
import com.dlms.request.PageMaker;
import com.dlms.request.SearchCriteria;

public class FreeboardServiceImpl implements FreeboardService {
	
	@Autowired
	private FreeBoardDAO freeDAO;
	public void setFreeDAO(FreeBoardDAO freeDAO) {
		this.freeDAO = freeDAO;
	}
	@Autowired
	private FreeBoardReplyDAO replyDAO;
	public void setReplyDAO(FreeBoardReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}

	@Autowired
	private NoticeBoardService notice;
	public void setNotice(NoticeBoardService notice) {
		this.notice = notice;
	}
	@Autowired
	private NoticeBoardDAO noticeDAO;
	public void setNoticeDAO(NoticeBoardDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	@Autowired
	private MemberDAO memberDAO;
	
	//리스트 전체 출력
	@Override
	public List<FreeBoardVO> getfreeBoardList() throws SQLException {
//		공지사항리스트 추가 필요++
		
//		List<FreeBoardVO> boardList=freeDAO.selectfreeBoardList();		
		return null;
	}

	
	@Override
	public Map<String, Object> getfreeBoardList(SearchCriteria cri) throws SQLException {
		//전체 board 개수
		List<FreeBoardVO> freeboardList=freeDAO.selectSearchfreeBoardList(cri);
		
		/*FreeBoardVO boardList = freeDAO.selectfreeBoardList(member_id);
		String id=boardList.get(0).getMember_id();
		MemberVO member = memberDAO.selectMemberById(id);*/
		
		for(FreeBoardVO freeReply : freeboardList) {
			int replycnt=replyDAO.countReply(freeReply.getFreeboard_no());
			freeReply.setFreeReplycnt(replycnt);
		}
		
		
		//현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.		
		int totalCount=freeDAO.selectSearchfreeBoardCriTotalCount(cri);
		
		
		//PageMaker 생성.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);

		String notice_point="free";
		
		List<NoticeVO> point = noticeDAO.selectNoticePoint(notice_point);
		
		Map<String,Object> dataMap=new HashMap<String,Object>();
//		dataMap.put("member", member);
		dataMap.put("point", point);
		dataMap.put("freeboardList", freeboardList);
		dataMap.put("pageMaker",pageMaker);
		
		return dataMap;
	}

	@Override
	public FreeBoardVO readfreeBoard(int freeboard_no) throws SQLException {
		/*상세보기 안 다음글 이전글 목록 */
		int nextNo = freeDAO.next_freeboard_no(freeboard_no);
		int prevNo = freeDAO.prev_freeboard_no(freeboard_no);
		String nextTitle = freeDAO.next_freeboard_title(freeboard_no);
		String prevTitle = freeDAO.prev_freeboard_title(freeboard_no);
		
		if (nextNo == 0) {
			nextNo = freeboard_no;
		}
		
		if (prevNo == 0) {
			prevNo = freeboard_no;
		}
		
		/*화면 상세보기 출력*/
		FreeBoardVO freeboard = freeDAO.selectfreeBoardByBno(freeboard_no);
		int replycnt = replyDAO.countReply(freeboard_no);
		
		freeboard.setFreeReplycnt(replycnt); //댓글
		freeboard.setNextNo(nextNo);
		freeboard.setPrevNo(prevNo);
		freeboard.setNextTitle(nextTitle);
		freeboard.setPrevTitle(prevTitle);
		
		freeDAO.increaseViewCnt(freeboard_no);
		return freeboard;
	}

	@Override
	public FreeBoardVO getfreeBoardForModify(int freeboard_no) throws SQLException {
		FreeBoardVO freeboard = freeDAO.selectfreeBoardByBno(freeboard_no);
		return freeboard;
	}

	@Override
	public void write(FreeBoardVO freeboard) throws SQLException {
		int bno=freeDAO.selectfreeBoardSeqNext();
		
		freeboard.setFreeboard_no(bno);
		
		freeDAO.insertfreeBoard(freeboard);

	}

	@Override
	public void modify(FreeBoardVO freeboard) throws SQLException {
		freeDAO.updatefreeBoard(freeboard);

	}

	@Override
	public void remove(int freeboard_no) throws SQLException {
		freeDAO.deletefreeBoard(freeboard_no);

	}


	@Override
	public FreeBoardVO selectfreeBoardList(String member_id) throws SQLException {
		FreeBoardVO member = freeDAO.selectfreeBoardList(member_id);
		return member;
	}



}
