package com.dlms.service.lecture;

import java.sql.SQLException;
import java.util.List;

import com.dlms.dto.Lecture_attendVO;
import com.dlms.dto.StudentVO;

/**
 * 
 * @사용목적		:	강의 출석부 목적
 * @작성자		    :	이누리
 * @작성날짜     	:	2020. 6. 29.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 29.오후 3:21:39
 * @see			    :	-
 *
 */
public interface LectureAttendService {
	public List<Lecture_attendVO> getAttend(String student_id)throws SQLException;
	/**
	 * 
	 * @기능설명		:	강의 출석부 - 교수기준 조회
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 29.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 29.오후 3:21:51
	 * @see			    :	-
	 * @param professor_id
	 * @return
	 * @throws SQLException
	 *
	 */
	public List<Lecture_attendVO> selectAttend_professor_id(String professor_id)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	강의 출석부 - 교수기준 삭제
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 29.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 29.오후 3:22:31
	 * @see			    :	-
	 * @param professor_id
	 * @throws SQLException
	 *
	 */
	public void deleteAttend(String professor_id)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	강의 출석부 - 추가
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 29.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 29.오후 3:39:54
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
	 * @마지막수정일	:	2020. 7. 1.오후 12:33:19
	 * @see			    :	-
	 * @param lecture_data_no
	 * @param student_id 
	 * @throws SQLException
	 *
	 */
	public void updateAttend(int lecture_data_no, String student_id) throws SQLException;
	/**
	 * 
	 * @기능설명		:	수강생 아이디를 가지고 출석갯수 가져오기	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 7. 6.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 7. 6.오전 11:14:57
	 * @param 		:	member_id(수강생아이디)
	 * @return		:	수강출석 갯수
	 *
	 */
	public int getLectureAteendCnt(String member_id)throws SQLException;
	
}
