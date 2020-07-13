package com.dlms.service.lecture;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dlms.dto.LectureVO;
import com.dlms.dto.Lecture_dataVO;
import com.dlms.request.LectureDataRequest;
import com.dlms.request.LectureRequest;
import com.dlms.request.SearchCriteria;

public interface LectureService {
	public Map<String, Object> getLectureList (SearchCriteria cri) throws SQLException;
	public List<LectureVO> getLectureList () throws SQLException;
	public List<LectureDataRequest> getLectureDataList(int lecture_no) throws SQLException;
	public LectureVO getLectureDetail (int lecture_no) throws SQLException;
	public void writeLecture(LectureVO lecture) throws SQLException;
	public void modifyLecture(LectureVO lecture) throws SQLException;
	public void removeLecture(int lecture_no) throws SQLException;
	public void removeLectureData(int lecture_no) throws SQLException;	
	public LectureVO getLectureDetail(String professor_id) throws SQLException;
	public Lecture_dataVO getLectureDataVideo(int lecture_data_no) throws SQLException; 
	public void modifyLecture_data(Lecture_dataVO lecture_data) throws SQLException;
	public List<LectureVO> getLectureListAdmin() throws SQLException;
	public Map<String, Object> getLectureListAdmin(SearchCriteria cri) throws SQLException;
	public List<LectureDataRequest> getLectureDataList(String professor_id) throws SQLException;
	public int writeLectureData(LectureDataRequest data) throws SQLException; 
	public List<LectureDataRequest> getfavoriteLecture(int lecture_no) throws SQLException; 
	/**
	 * 
	 * @기능설명		:	즐겨찾기 등록, 취소
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 7. 1.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 1.오후 9:37:43
	 * @see			    :	-
	 * @param lecture_data_no
	 * @param student_id
	 * @throws SQLException
	 *
	 */
	public void updateFavorite(int lecture_data_favorites, int lecture_data_no) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	동영상 등록
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 7. 2.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 2.오전 11:43:06
	 * @see			    :	-
	 * @param lecture_data_no
	 * @throws SQLException
	 *
	 */
	public void uploadVideo(int lecture_data_no)throws SQLException;
	
	
	/**
	 * 
	 * @기능설명		:	강의 자료 조회
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 7. 2.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 2.오후 5:57:34
	 * @see			    :	-
	 * @param lecture_data_no
	 * @throws SQLException
	 *
	 */
	public Lecture_dataVO getLectureData(int lecture_data_no)throws SQLException;

	public List<LectureVO> getListByLecture_no(int lecture_no)throws SQLException;
	
	
}
