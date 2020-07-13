package com.dlms.dao.lecture;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dlms.dto.LectureVO;
import com.dlms.dto.Lecture_attendVO;
import com.dlms.dto.StudentVO;

/**
 * 
 * @사용목적		:	강의 출석부
 * @작성자		    :	이누리
 * @작성날짜     	:	2020. 6. 29.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 29.오후 3:16:29
 * @see			    :	-
 *
 */
public class LectureAttendDAOImpl implements LectureAttendDAO {
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<Lecture_attendVO> selectAttend(String student_id) throws SQLException {
		List<Lecture_attendVO> lecture_attend = sqlSession.selectList("lecture_attend-mapper.selectAttend",student_id);
		return lecture_attend;
	}

	/**
	 * 
	 * @기능설명		:	강의 출석부 교수 기준 조회
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 29.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 29.오후 3:16:41
	 * @see			    :	-
	 * @param professor_id
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public List<Lecture_attendVO> selectAttend_professor(String professor_id) throws SQLException {
		List<Lecture_attendVO> attendList = sqlSession.selectList("lecture_attend-mapper.selectAttend_professor",professor_id);
		return attendList;
	}

	/**
	 * 
	 * @기능설명		:	강의 출석부 교수 기준 삭제
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 29.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 29.오후 3:16:50
	 * @see			    :	-
	 * @param professor_id
	 * @throws SQLException
	 *
	 */
	@Override
	public void deleteAttend_professor(String professor_id) throws SQLException {
		sqlSession.selectOne("lecture_attend-mapper.deletelecture_attend", professor_id);
		
	}
	
	/**
	 * 
	 * @기능설명		:	강의 출석부 추가
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 29.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 29.오후 3:39:12
	 * @see			    :	-
	 * @param lec_attend
	 * @throws SQLException
	 *
	 */
	@Override
	public void insertAttend(Lecture_attendVO lec_attend) throws SQLException {
		sqlSession.selectOne("lecture_attend-mapper.insertlecture_attend", lec_attend);
		
	}

	/**
	 * 
	 * @기능설명		:	출석
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 7. 1.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 1.오후 12:31:36
	 * @see			    :	-
	 * @param lecture_data_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void updateAttend(int lecture_data_no,String student_id) throws SQLException {
		Map<String, Object> Attendvideo = new HashMap<>();
		Attendvideo.put("lecture_data_no", lecture_data_no);
		Attendvideo.put("student_id", student_id);		
		sqlSession.selectOne("lecture_attend-mapper.updatelecture_attend", Attendvideo);
		
	}
	
	/**
	 * 
	 * @기능설명		:	출석부 등록 시 강의 번호 생성
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 7. 2.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 2.오후 4:38:32
	 * @see			    :	-
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public int selectLectureAttendSeqNext() throws SQLException {
		int lecture_attend_no = sqlSession.selectOne("lecture_attend-mapper.selectLectureAttendSeqNext");
		return lecture_attend_no;
	}

	/**
	 * 
	 * @기능설명		:	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 7. 6.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 7. 6.오전 10:00:30
	 * @param member_id
	 * @return
	 */
	@Override
	public int selectLectureAttendStatusCnt(String member_id) {
		int attendStatusCnt=0;
		attendStatusCnt=sqlSession.selectOne("lecture_attend-mapper.selectLectureAttendStatusCnt",member_id);
		return attendStatusCnt;
	}
	
	
	
	
}
