package com.dlms.dao.founded;

import java.sql.SQLException;
import java.util.List;

import com.dlms.dto.Founded_reviewVO;
import com.dlms.request.DetailFoundedRequest;
import com.dlms.request.SearchCriteria;

public interface FoundedReviewDAO {
	/**
	 * 
	 * @기능설명		:	창업후기 검색리스트 출력
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오전 10:18:23
	 * @see			:	
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	List<Founded_reviewVO>selectFoundedReviewSearchList(SearchCriteria cri)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	전체 게시글 갯수(게시글 토탈 카운트)
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오후 7:15:43
	 * @see			:	
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	int selectFoundedReviewCriteriaTotalCount(SearchCriteria cri) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	창업후기 게시글 리스트 출력	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오전 10:22:29
	 * @see			:	
	 * @return
	 * @throws SQLException
	 *
	 */
	List<Founded_reviewVO>selectFoundedReviewList()throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	창업후기 상세보기 출력	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오전 10:13:59
	 * @see			:	
	 * @param founded_review_no
	 * @return
	 * @throws SQLException
	 *
	 */
	Founded_reviewVO selectFoundedReviewByReviewNo(int founded_review_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	창업후기 베스트 후기 출력	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오전 10:14:15
	 * @see			:	
	 * @return
	 * @throws SQLException
	 *
	 */
	List<Founded_reviewVO>selectFoundedReviewViewCntList()throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	창업후기 작성	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오전 10:14:53
	 * @see			:	
	 * @param reviewVO
	 * @throws SQLException
	 *
	 */
	void insertFoundedReview(Founded_reviewVO reviewVO)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	창업후기 수정	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오전 10:15:08
	 * @see			:	
	 * @param reviewVO
	 * @throws SQLException
	 *
	 */
	void updateFoundedReview(Founded_reviewVO reviewVO)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	창업후기 삭제
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오전 10:15:19
	 * @see			:	
	 * @param founded_review_no
	 * @throws SQLException
	 *
	 */
	void deleteFoundedReview(int founded_review_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	창업후기 조회수 증가	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오전 10:15:27
	 * @see			:	
	 * @param founded_review_no
	 * @throws SQLException
	 *
	 */
	void increaseViewCnt(int founded_review_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	창업후기 시퀀스 번호 생성해서 가져오기
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 18.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 18.오후 12:06:30
	 * @return		:	시퀀스 번호
	 * @throws 		:	SQLException
	 *
	 */
	int selectFoundedReviewSeqNext()throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	상세내용에서 다음을과 이전글 제목 및 번호를 가져오기
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 23.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 23.오후 2:09:53
	 * @param 		:	detailReviewNo(해당글번호)
	 * @return		:	다음글,이전글 번호 및 제목
	 *
	 */
	DetailFoundedRequest selectPrevNexTitle(int detailReviewNo)throws SQLException;

	void viewCountUP(int review_no)throws SQLException;

	List<Founded_reviewVO> selectfoundedListByCount(int count)throws SQLException;
	
	
	List<Founded_reviewVO> myfounded_reviewList(String member_id)throws SQLException;
}
