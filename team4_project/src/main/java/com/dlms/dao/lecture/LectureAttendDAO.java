package com.dlms.dao.lecture;

import java.sql.SQLException;
import java.util.List;

import com.dlms.dto.Lecture_attendVO;

/**
 * 
 * @사용목적		:	강의 출석부
 * @작성자		    :	이누리
 * @작성날짜     	:	2020. 6. 29.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 29.오후 3:14:31
 * @see			    :	-
 *
 */
public interface LectureAttendDAO {
	public List<Lecture_attendVO> selectAttend(String student_id)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	교수 리스트 기준 조회
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 29.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 29.오후 3:15:29
	 * @see			    :	-
	 * @param professor_id
	 * @return
	 * @throws SQLException
	 *
	 */
	public List<Lecture_attendVO> selectAttend_professor(String professor_id)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	교수리스트 기준 삭제
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 29.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 29.오후 3:16:11
	 * @see			    :	-
	 * @param professor_id
	 * @throws SQLException
	 *
	 */
	void deleteAttend_professor(String professor_id)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	출석부 추가
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 29.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 29.오후 3:38:16
	 * @see			    :	-
	 * @param lec_attend
	 * @throws SQLException
	 *
	 */
	public void insertAttend(Lecture_attendVO lec_attend)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	출석
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 7. 1.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 1.오후 12:30:00
	 * @see			    :	-
	 * @param lecture_data_no
	 * @param student_id 
	 * @throws SQLException
	 *
	 */
	public void updateAttend(int lecture_data_no, String student_id)throws SQLException;

	/**
	 * 
	 * @기능설명		:	출석부 등록 시 강의번호 생성
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 7. 2.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 2.오후 4:37:50
	 * @see			    :	-
	 * @return
	 * @throws SQLException
	 *
	 */
	public int selectLectureAttendSeqNext() throws SQLException;
	/**
	 * 
	 * @기능설명		:	출석갯수 가져오기
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 7. 6.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 7. 6.오전 9:58:29
	 * @param 		:	member_id(로그인중인 아이디)
	 * @return		:	출석갯수
	 *
	 */
	public int selectLectureAttendStatusCnt(String member_id);
}
