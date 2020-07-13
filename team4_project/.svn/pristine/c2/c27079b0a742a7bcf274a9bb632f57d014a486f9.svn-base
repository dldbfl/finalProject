package com.dlms.dao.lecture;

import java.sql.SQLException;
import java.util.List;

import com.dlms.dto.LectureVO;
import com.dlms.dto.Lecture_dataVO;
import com.dlms.request.LectureDataRequest;
import com.dlms.request.LectureRequest;
import com.dlms.request.SearchCriteria;

public interface LectureDAO {
	public List<LectureVO> selectSearchLectureList (SearchCriteria cri) throws SQLException;
	public List<LectureVO> selectLectureList () throws SQLException;
	public int selectLectureListCount() throws SQLException;
	public LectureVO selectLectureDetail (int lecture_no) throws SQLException;
	public void insertLecture(LectureVO lecture) throws SQLException;
	public void insertLectureData(LectureDataRequest data) throws SQLException;
	public void updateLecture(LectureVO lecture) throws SQLException;
	public void updateLectureData(Lecture_dataVO lecture_data) throws SQLException;
	public void deleteLecture(int lecture_no) throws SQLException;
	public void deleteLectureData(int lecture_no) throws SQLException;
	public int selectLectureSeqNext() throws SQLException;
	public int selectLectureDataSeqNext() throws SQLException;
	public LectureVO selectLectureDetailByid(String professor_id) throws SQLException;
	public List<LectureDataRequest> selectLectureData(int lecture_no)throws SQLException;
	public Lecture_dataVO selectLectureDataVideo(int lecture_data_no)throws SQLException;
	public List<LectureVO> selectLectureListAdmin () throws SQLException;
	public List<LectureVO> selectSearchLectureListAdmin (SearchCriteria cri) throws SQLException;
	public int selectLectureListCountAdmin() throws SQLException;
	public List<LectureDataRequest> selectLectureDataList(String professor_id)throws SQLException;
	public List<LectureDataRequest> myFavoriteList(int lecture_no)throws SQLException;
	public Lecture_dataVO selectLectureDataBylno(int lecture_data_no)throws SQLException;
	/**
	 * 
	 * @기능설명		:	즐겨찾기 등록, 취소
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 7. 1.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 1.오후 9:40:46
	 * @see			    :	-
	 * @param lecture_data_favorites
	 * @param lecture_data_no
	 *
	 */
	public void updateFavorite(int lecture_data_favorites, int lecture_data_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	기안서 결재 시 동영상 업로드 상태로 수정
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 7. 2.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 2.오전 11:46:28
	 * @see			    :	-
	 * @param lecture_data_no
	 *
	 */
	public void uploadVideo(int lecture_data_no)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	강의 자료 조회( 강의 자료 번호 기준)
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 7. 2.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 2.오후 6:02:18
	 * @see			    :	-
	 * @param lecture_data_no
	 * @return
	 * @throws SQLException
	 *
	 */
	public Lecture_dataVO selectLectureData_data_no(int lecture_data_no)throws SQLException;
	
	
	public List<LectureVO> selectLectureBylecture_no(int lecture_no)throws SQLException;
}
