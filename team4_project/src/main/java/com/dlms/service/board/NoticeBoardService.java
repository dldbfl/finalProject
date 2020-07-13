package com.dlms.service.board;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dlms.dto.NoticeVO;
import com.dlms.request.SearchCriteria;

public interface NoticeBoardService {

	/**
	 * 
	 * @기능설명		:	공지사항 게시글 조회
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 5:00:30
	 * @param 		:	cri
	 * @return		:	Map<String, Object>
	 * @throws 		:	SQLException
	 *
	 */
	public Map<String, Object> getNoticeList(SearchCriteria cri)throws SQLException;
	
	
	
	/**
	 * 
	 * @기능설명		:	공지사항 게시글 상세내용 조회
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 5:01:49
	 * @param 		:	notice_no
	 * @return		:	NoticeVO
	 * @throws 		:	SQLException
	 *
	 */
	public NoticeVO getDetailList(int notice_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	공지사항 게시글 작성
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 5:02:22
	 * @param 		:	notice
	 * @throws 		:	SQLException
	 *
	 */
	public void writer(NoticeVO notice)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	공지사항 게시글 수정
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 5:02:42
	 * @param 		:	notice
	 * @throws 		:	SQLException
	 *
	 */
	public void modify(NoticeVO notice)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	공지사항 게시글 삭제	
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 5:03:04
	 * @param 		:	notice_no
	 * @throws 		:	SQLException
	 *
	 */
	public void remove(int notice_no)throws SQLException;


	/**
	 * 
	 * @기능설명		:	화면 하단에 공지사항 중요공지가져오기
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 24.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 24.오후 6:36:45
	 * @param 		:	공지사항중요글(notice)
	 * @return		:	List NoticeVO
	 * @throws 		:	SQLException
	 *
	 */
	public List<NoticeVO> getNoticePointList(String notice)throws SQLException;
	
}
