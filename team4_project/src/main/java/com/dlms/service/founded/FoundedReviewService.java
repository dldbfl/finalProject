package com.dlms.service.founded;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.dlms.dto.Founded_reviewVO;
import com.dlms.dto.Founded_review_imgVO;
import com.dlms.dto.FreeBoardVO;
import com.dlms.request.DetailFoundedRequest;
import com.dlms.request.FoundedReviewImgRequest;
import com.dlms.request.SearchCriteria;
/**
 * 
 * @사용목적		:	창업후기 게시글 관리 
 * @작성자		:	연은주
 * @작성날짜      	:	2020. 6. 3.
 * @마지막수정자	:	연은주
 * @마지막수정일	:	2020. 6. 3.오후 5:16:05
 * @see			:	
 *
 */
public interface FoundedReviewService {
	/**
	 * 
	 *
	 * @기능설명		:	창업후기 게시글 리스트 
	 * @작성자		:	강현철
	 * @작성날짜		:	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오전 2:42:04
	 * @param 		:	cri(페이지기본구성)
	 * @return		:
	 * @throws SQLException
	 */
	List<Founded_reviewVO> getfoundedReviewList()throws SQLException;

	/**
	 * 
	 *
	 * @기능설명		:	창업후기 게시글 검색리스트	
	 * @작성자		:	강현철
	 * @작성날짜		:	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오전 2:46:31
	 * @param 		:	cri(페이지 번호,한페이지당 리스트개수,검색구분검색어)
	 * @return		:	Map형식 key 중요공지사항리스트, 창업후기 리스트
	 * @throws 		:	SQLException
	 * @throws 		:	ParseException
	 */
	Map<String,Object> getfoundedReviewList(SearchCriteria cri)throws SQLException, ParseException;
	
	/**
	 * 
	 * @기능설명		:	창업후기 게시글 상세보기	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오후 5:16:45
	 * @see			:	
	 * @param freeboard_no
	 * @return
	 * @throws SQLException
	 *
	 */
	Map<String, Object> getfoundedReviewByReviewNo(int review_no, String modifyText)throws SQLException;	

	/**
	 * 
	 * @기능설명		:	창업후기 게시글 수정화면++수정시 상세보기로 돌아왔을때 조회수 증가X
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오후 5:17:08
	 * @see			:	
	 * @param freeboard_no
	 * @return
	 * @throws SQLException
	 *
	 */
	FreeBoardVO getfoundedReviewForModify(int freeboard_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	창업후기 글등록작업	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 18.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 18.오후 12:41:28
	 * @param 		:	reivew (제목, 수강생, 내용 )
	 * @param 		:	fileName(UUID+file이름)
	 * @return		:	창업후기 글번호
	 * @throws 		:	SQLException
	 *
	 */
	int write(Founded_reviewVO reivew, List<Founded_review_imgVO> fileName)throws SQLException;
		
	/**
	 * 
	 * @기능설명		:	창업후기 게시글 수정	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오후 5:17:52
	 * @see			:	
	 * @param freeboard
	 * @throws SQLException
	 *
	 */
	void modify(FreeBoardVO freeboard)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	해당 글을 삭제하는 기능
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 23.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 23.오후 12:08:45
	 * @param 		:	founded_review_no(글번호)
	 * @throws 		:	SQLException
	 *
	 */
	void removeFoundedReview(int founded_review_no, String foundedReivew_imgePath)throws SQLException;
	/**	
	 * 
	 * @기능설명		:	이전글 다음글 값 가져오기 기능
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 22.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 22.오후 8:49:18
	 * @param 		:	detailReviewNo(현재글번호)
	 * @return		:	DetailFoundedRequest(현재글번호, 이전글번호,다음글번호,이전글제목,다음글제목)
	 * @throws 		:	SQLException
	 *
	 */
	DetailFoundedRequest getPrevNextInfoByReviewNo(int detailReviewNo)throws SQLException;
	/**
	 * 
	 * @기능설명		:	창업후기 제목, 내용, 첨부파일이 변경 되면 수정 하는 기능
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 23.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 23.오전 9:35:31
	 * @param 		:	review	(제목,내용)
	 * @param 		:	imgeFiles(삭제될 이미지 번호)
	 * @param 		:	fileNames(등록될 파일 이름)
	 * @throws 		:	SQLException
	 *
	 */
	void modifyFoundedReview(Founded_reviewVO review, FoundedReviewImgRequest imgeFiles,List<Founded_review_imgVO> fileNames)throws SQLException;
	/**
	 * 
	 * @기능설명		:	조회수가 높은 창업후기리스트를 보여주기
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 29.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 29.오후 4:41:07
	 * @param 		:	count
	 * @return		: 	창업후기 이미지 정보 , 창업후기 글 리스트
	 * @throws 		:	SQLException
	 *
	 */
	Map<String, Object> getfoundedReviewBestReview(int count)throws SQLException;
	/**
	 * 
	 * @기능설명		:	이미지번호에 따른 정보 가져오기 
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 29.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 29.오후 4:41:16
	 * @param 		:	review_no(이미지번호)
	 * @return		:	이미지 정보
	 * @throws 		:	SQLException
	 */
	Founded_review_imgVO getimgeFileByReviewNo(int review_img_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	멤버 아이디를 기준으로 창업후기들 가져오기
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 7. 6.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 6.오후 2:02:17
	 * @see			    :	-
	 * @param member_id
	 * @return
	 * @throws SQLException
	 *
	 */
	List<Founded_reviewVO> myfounded_reviewList(String member_id)throws SQLException;
}
