package com.dlms.service.lecture;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dlms.dao.lecture.LectureAttendDAO;
import com.dlms.dao.lecture.LectureDAO;
import com.dlms.dao.pay.PayDAO;
import com.dlms.dao.student.StudentDAO;
import com.dlms.dto.LectureVO;
import com.dlms.dto.Lecture_attendVO;
import com.dlms.dto.StudentVO;

/**
 * 
 * @사용목적		:	강의 출석부
 * @작성자		    :	이누리
 * @작성날짜     	:	2020. 6. 29.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 29.오후 3:22:50
 * @see			    :	-
 *
 */
public class LectureAttendServiceImpl implements LectureAttendService{

	@Autowired
	private LectureAttendDAO lectureAttendDAO;
	public void setLectureAttendDAO(LectureAttendDAO lectureAttendDAO) {
		this.lectureAttendDAO = lectureAttendDAO;
	}
	
	@Autowired
	private PayDAO payDAO ;
	public void setPayDAO(PayDAO payDAO) {
		this.payDAO = payDAO;
	}

	@Override
	public List<Lecture_attendVO> getAttend(String student_id) throws SQLException {
		List<Lecture_attendVO> lecture_attend = lectureAttendDAO.selectAttend(student_id);
		return lecture_attend;
	}
	/**
	 * 
	 * @기능설명		:	강의 출석부 교수 기준 조회
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 29.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 29.오후 3:23:03
	 * @see			    :	-
	 * @param professor_id
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public List<Lecture_attendVO> selectAttend_professor_id(String professor_id) throws SQLException {
		List<Lecture_attendVO> lecture_attend = lectureAttendDAO.selectAttend_professor(professor_id);
		return lecture_attend;
	}
	
	/**
	 * 
	 * @기능설명		:	강의 출석부 교수 기준 삭제
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 29.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 29.오후 3:23:17
	 * @see			    :	-
	 * @param professor_id
	 * @throws SQLException
	 *
	 */
	@Override
	public void deleteAttend(String professor_id) throws SQLException {
		lectureAttendDAO.deleteAttend_professor(professor_id);
		
	}

	/**
	 * 
	 * @기능설명		:	강의 출석부 - 추가
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 29.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 29.오후 3:40:23
	 * @see			    :	-
	 * @param lec_attend
	 * @throws SQLException
	 *
	 */
	@Override
	public void insertAttend(Lecture_attendVO lec_attend) throws SQLException {
		int lecture_attend_no = 0;
		List<String> studentList = payDAO.lectureStudentList(lec_attend.getProfessor_id());
		
		for(int i = 0; i < studentList.size(); i++) {
			
			lecture_attend_no = lectureAttendDAO.selectLectureAttendSeqNext();
			
			lec_attend.setLecture_attend_no(lecture_attend_no);
			
			lec_attend.setStudent_id(studentList.get(i));
			
			lectureAttendDAO.insertAttend(lec_attend);
		}
		
	}
	
	/**
	 * 
	 * @기능설명		:	강의 출석부 - 출석
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 7. 1.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 1.오후 12:33:36
	 * @see			    :	-
	 * @param lecture_data_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void updateAttend(int lecture_data_no,String student_id) throws SQLException {
		lectureAttendDAO.updateAttend(lecture_data_no,student_id);
		
	}
	/**
	 * 
	 * @기능설명		:	수강생 아이디를 가지고 출석갯수 가져오기	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 7. 6.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 7. 6.오전 11:15:50
	 * @param 		:	member_id(수강생아이디)
	 * @return		:	수강출석 갯수
	 *
	 */
	@Override
	public int getLectureAteendCnt(String member_id) throws SQLException {
		int cnt=0;
		cnt=lectureAttendDAO.selectLectureAttendStatusCnt(member_id);
		return cnt;
	}

}
