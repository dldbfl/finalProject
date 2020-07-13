package com.dlms.dao.attach;

import java.sql.SQLException;
import java.util.List;
import com.dlms.dto.Notice_dataVO;

public interface NoticeAttachDAO {

	/**
	 * 
	 * @기능설명		: 	공지사항 첨부파일 번호로 첨부파일 조회 	
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 3:48:54
	 * @param 		:	notice_data_no
	 * @return		:	List<Notice_dataVO
	 * @throws 		:	SQLException
	 *
	 */
	public List<Notice_dataVO> selectAttachByNotice_data_no(int notice_data_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	공지게시글 번호로 첨부파일 조회 
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 3:52:47
	 * @param 		:	notice_no
	 * @return		: 	List<Notice_dataVO>
	 * @throws 		:	SQLException
	 *
	 */
	public List<Notice_dataVO> selectAttachByNotice_no(int notice_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	파일 저장
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:00:04
	 * @param 		: 	notice_attach
	 * @throws 		:	SQLException
	 *
	 */
	public void insertAttach(Notice_dataVO notice_attach)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	파일 삭제	
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:00:54
	 * @param 		:	notice_data_no
	 * @throws 		:	SQLException
	 *
	 */
	public void deleteAttach(int notice_data_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	파일 전체 삭제	
	 * @작성자		:	박진영
	 * @작성날짜      :	2020. 6. 3.
	 * @마지막수정자	:	박진영
	 * @마지막수정일	:	2020. 6. 3.오후 4:01:10
	 * @param 		:	notice_no
	 * @throws 		:	SQLException
	 *
	 */
	public void deleteAllAttach(int notice_no)throws SQLException;
	
}
