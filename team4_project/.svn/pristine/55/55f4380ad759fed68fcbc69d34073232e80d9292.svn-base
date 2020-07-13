package com.dlms.dao.founded;

import java.sql.SQLException;
import java.util.List;

import com.dlms.dto.Founded_review_imgVO;

public interface FoundedReviewImgDAO {
	/**
	 * 
	 *
	 * @기능설명		:	창업후기 게시글 번호기준으로 이미지 상세내역 가져오기
	 * @작성자		:	강현철
	 * @작성날짜		:	2020. 6. 21.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 21.오후 5:28:16
	 * @param 		:	founded_review_no(게시글번호)
	 * @return		:	List Founded_review_imgVO
	 * @throws 		:	SQLException
	 */
	public List<Founded_review_imgVO> selectFoundedReviewImgByReviewNo(int founded_review_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	창업후기 이미지 리스트 불러오기	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오후 4:32:52
	 * @param 		:	founded_review_img_no
	 * @return		:	창업후기 이미지 정보
	 * @throws 		:	SQLException
	 *
	 */
	public Founded_review_imgVO selectImgByfoundedImg(int founded_review_img_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	이미지 추가
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오후 4:36:56
	 * @see			:	
	 * @param imgVO
	 * @throws SQLException
	 *
	 */
	public void insertImg(Founded_review_imgVO imgVO) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	이미지 삭제	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오후 4:40:52
	 * @see			:	
	 * @param founded_review_img_no
	 * @throws SQLException
	 *
	 */
	public void deleteImg(int founded_review_img_no) throws SQLException;

	/**
	 * 
	 * @기능설명		:	이미지와게시글 삭제	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 3.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 3.오후 4:41:10
	 * @see			:	
	 * @param founded_review_no
	 * @throws SQLException
	 *
	 */
	public void deleteAllImg(int founded_review_no)throws SQLException;
}
