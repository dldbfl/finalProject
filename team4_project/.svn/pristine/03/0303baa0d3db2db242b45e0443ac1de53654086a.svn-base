package com.dlms.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.dlms.dto.NoticeVO;
import com.dlms.request.SearchCriteria;

public interface NoticeBoardDAO {
    
	/**
	 * 
	 * @기능설명		:	공지사항 게시글 조회	
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:13:09
	 * @param 		:	cri
	 * @return		:	List<NoticeVO>
	 * @throws 		:	SQLException
	 *
	 */
	public List<NoticeVO> selectSearchNoticeList(SearchCriteria cri)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	게시글조회시 페이징 처리를 위한 보조장치
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:14:11
	 * @param 		:	cri
	 * @return		:	int
	 * @throws 		:	SQLException
	 *
	 */
	public int selectSearchNoticeListCount()throws SQLException;
	

	
	/**
	 * 
	 * @기능설명		:	클릭한 게시글의 상세내용 조회
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:15:41
	 * @param 		:	notice_no
	 * @return		:	NoticeVO
	 * @throws 		:	SQLException
	 *
	 */
	public NoticeVO selectNoticeByNotice_no(int notice_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	공지사항 게시글 작성
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:16:26
	 * @param 		:	notice
	 * @throws 		:	SQLException
	 *
	 */
	public void insertNotice(NoticeVO notice)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	공지사항 게시글 수정
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:18:08
	 * @param 		:	notice
	 * @throws 		:	SQLException
	 *
	 */
	public void updateNotice(NoticeVO notice)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	공지사항 게시글 삭제
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:18:29
	 * @param 		:	notice_no
	 * @throws 		:	SQLException
	 *
	 */
	public void deleteNotice(int notice_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	상세내역 조회시 조회수 1씩증가
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:18:52
	 * @param 		:	notice_no
	 * @throws 		:	SQLException
	 *
	 */
	public void increaseViewCnt(int notice_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	게시글 작성시 게시글번호가 1씩 증가
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:19:19
	 * @return		:	int
	 * @throws 		:	SQLException
	 *
	 */
	public int selectNoticeSeqNext()throws SQLException;
	/**
	 * 
	 * @기능설명		:	중요 공지사항 글 리스트 가져오기
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 7. 3.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 7. 3.오후 7:39:35
	 * @param 		:	notice_point(중요공지글)
	 * @return		:	공지사항 리스트
	 * @throws 		:	SQLException
	 *
	 */
	public List<NoticeVO> selectNoticePoint(String notice_point) throws SQLException;
	
	public int next_notice_no(int notice_no)throws SQLException;
	public int prev_notice_no(int notice_no)throws SQLException;
	public String next_notice_title(int notice_no)throws SQLException;
	public String prev_notice_title(int notice_no)throws SQLException;
}
