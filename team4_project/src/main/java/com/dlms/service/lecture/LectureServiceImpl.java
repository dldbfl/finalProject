package com.dlms.service.lecture;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dlms.dao.draft.DraftDAO;
import com.dlms.dao.lecture.LectureDAO;
import com.dlms.dto.DraftVO;
import com.dlms.dto.LectureVO;
import com.dlms.dto.Lecture_dataVO;
import com.dlms.request.LectureDataRequest;
import com.dlms.request.PageMaker;
import com.dlms.request.SearchCriteria;


/**
 * 
 * @사용목적		:	강의와 관련된 서비스
 * @작성자			:	민태홍
 * @작성날짜      	:	2020. 6. 2.
 * @마지막수정자	:	민태홍
 * @마지막수정일	:	2020. 6. 2.오전 11:08:22
 * @see				:	lectureLectureService
 *
 */
public class LectureServiceImpl implements LectureService {
	
	private LectureDAO lectureDAO;
	public void setLectureDAO(LectureDAO lectureDAO) {
		this.lectureDAO = lectureDAO;
	}
	@Autowired
	private DraftDAO draftDAO;
	public void setDraftDAO(DraftDAO draftDAO) {
		this.draftDAO = draftDAO;
	}
	
	/**
	 * 
	 * @기능설명		:	강의 검색 리스트 출력
	 * @작성자			:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 11:08:59
	 * @see				:	X
	 * @param cri
	 * @return lectureList
	 * @throws SQLException
	 *
	 */
	@Override
	public Map<String, Object> getLectureList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		List<LectureVO> lectureList = lectureDAO.selectSearchLectureList(cri);
		int totalCount = lectureDAO.selectLectureListCount();
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("lectureList", lectureList);
		dataMap.put("pageMaker", pageMaker);
		return dataMap;
	}

	/**
	 * 
	 * @기능설명		:	강의 리스트 출력
	 * @작성자			:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 11:08:59
	 * @see				:	X
	 * @param cri
	 * @return lectureList
	 * @throws SQLException
	 *
	 */
	@Override
	public List<LectureVO> getLectureList() throws SQLException {
		List<LectureVO> lectureList = lectureDAO.selectLectureList();
		return lectureList;
	}
	
	/**
	 * 
	 * @기능설명		:	강의동영상 리스트
	 * @작성자			:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 11:09:36
	 * @see				:	X
	 * @param cri
	 * @return lectureDataList
	 * @throws SQLException
	 *
	 */
	@Override
	public List<LectureDataRequest> getLectureDataList(int lecture_no) throws SQLException {
		List<LectureDataRequest> lectureDataList = lectureDAO.selectLectureData(lecture_no);
		for(int i=0; i< lectureDataList.size(); i++) {
			String theorem = lectureDataList.get(i).getLecture_data_filename();
			
			String realName = theorem.substring(theorem.lastIndexOf("$$")+2);
			
			String fileName = realName.substring(0,realName.lastIndexOf("."));
			
			lectureDataList.get(i).setLecture_data_filename(fileName);
			DraftVO draft = draftDAO.selectDraftDetailBylno(lectureDataList.get(i).getLecture_data_no());
			lectureDataList.get(i).setDraft_status(draft.getDraft_status());
			
		}
		return lectureDataList;
	}
	
	/**
	 * 
	 * @기능설명		:	강의 동영상 상세
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 9:07:39
	 * @see			    :	-
	 * @param lecture_data_no
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public Lecture_dataVO getLectureDataVideo(int lecture_data_no) throws SQLException {
		Lecture_dataVO lectureVideo = lectureDAO.selectLectureDataVideo(lecture_data_no);
		
		return lectureVideo;
	}

	/**
	 * 
	 * @기능설명		:	강의 상세
	 * @작성자			:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오후 5:13:53
	 * @see				:	X
	 * @param lecture_no
	 * @return lecture
	 * @throws SQLException
	 *
	 */
	@Override
	public LectureVO getLectureDetail(int lecture_no) throws SQLException {
		LectureVO lecture = lectureDAO.selectLectureDetail(lecture_no);
		return lecture;
	}

	/**
	 * 
	 * @기능설명		:	강의 등록
	 * @작성자			:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 24.오전 11:10:12
	 * @see				:	X
	 * @param lecture
	 * @throws SQLException
	 *
	 */
	@Override
	public void writeLecture(LectureVO lecture) throws SQLException {
		int lecture_no = lectureDAO.selectLectureSeqNext();
		lecture.setLecture_no(lecture_no);
		lectureDAO.insertLecture(lecture);
		System.out.println(lecture);
		
		/*if(lecture.getLectureFileList()!=null) {
			for (Lecture_dataVO data : lecture.getLectureFileList()) {
				data.setLecture_no(lecture_no);
				int lecture_data_no = lectureDAO.selectLectureDataSeqNext();
				data.setLecture_data_no(lecture_data_no);
				lectureDAO.insertLectureData(data);
			}
		}*/
	}

	/**
	 * 
	 * @기능설명		:	강의 수정
	 * @작성자			:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 24.오전 11:10:36
	 * @see				:	X
	 * @param lecture
	 * @throws SQLException
	 *
	 */
	@Override
	public void modifyLecture(LectureVO lecture) throws SQLException {
		lectureDAO.updateLecture(lecture);
		
	}

	/**
	 * 
	 * @기능설명		:	강의 삭제
	 * @작성자			:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 11:10:53
	 * @see				:	X
	 * @param lecture_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void removeLecture(int lecture_no) throws SQLException {
		lectureDAO.deleteLecture(lecture_no);
		
	}

	/**
	 * 
	 * @기능설명		:	강의 자료 삭제
	 * @작성자			:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 11:11:00
	 * @see				:	X
	 * @param lecture_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void removeLectureData(int lecture_no) throws SQLException {
		lectureDAO.deleteLectureData(lecture_no);
		
	}

	/**
	 * 
	 * @기능설명		:	교수용 강의 상세
	 * @작성자			:	민태홍
	 * @작성날짜      	:	2020. 6. 15.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 15.오후 12:10:41
	 * @see				:	X
	 * @param professor_id
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public LectureVO getLectureDetail(String professor_id) throws SQLException {
		LectureVO lecture = lectureDAO.selectLectureDetailByid(professor_id);
		return lecture;
	}

	/**
	 * 
	 * @기능설명		:	강의 자료 수정
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 19.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 23.오전 2:18:23
	 * @see			    :	-
	 * @param lecture_data
	 * @throws SQLException
	 *
	 */
	@Override
	public void modifyLecture_data(Lecture_dataVO lecture_data) throws SQLException {		
		lectureDAO.updateLectureData(lecture_data);		
	}

	/**
	 * 
	 * @기능설명		:	강의 리스트 관리자 전용
	 * @작성자			: 	이누리
	 * @작성날짜    	:	2020. 6. 25.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 25.오전 2:18:23
	 * @see			    :	-
	 * @param lecture
	 * @throws SQLException
	 *
	 */
	@Override
	public List<LectureVO> getLectureListAdmin() throws SQLException {
		List<LectureVO> lectureList = lectureDAO.selectLectureListAdmin();
		return lectureList;
	}

	/**
	 * 
	 * @기능설명		:	관리자용 강의리스트 - 페이지네이션용
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 25.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 25.오후 12:09:47
	 * @see			    :	-
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public Map<String, Object> getLectureListAdmin(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		List<LectureVO> lectureList = lectureDAO.selectSearchLectureListAdmin(cri);
		int totalCount = lectureDAO.selectLectureListCountAdmin();
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("lectureList", lectureList);
		dataMap.put("pageMaker", pageMaker);
		return dataMap;
	}


	@Override
	public List<LectureDataRequest> getLectureDataList(String professor_id) throws SQLException {
		List<LectureDataRequest> lectureList = lectureDAO.selectLectureDataList(professor_id);
		for(int i=0; i< lectureList.size(); i++) {
			String theorem = lectureList.get(i).getLecture_data_filename();
			
			String realName = theorem.substring(theorem.lastIndexOf("$$")+2);
			
			String fileName = realName.substring(0,realName.lastIndexOf("."));
			
			lectureList.get(i).setLecture_data_filename(fileName);
			DraftVO draft = draftDAO.selectDraftDetailBylno(lectureList.get(i).getLecture_data_no());
			lectureList.get(i).setDraft_status(draft.getDraft_status());
			
		}
		return lectureList;
	}

	@Override
	public int writeLectureData(LectureDataRequest data) throws SQLException {
		int lno = lectureDAO.selectLectureDataSeqNext();
		data.setLecture_data_no(lno);
		lectureDAO.insertLectureData(data);
		
		return lno;
	}
	
	@Override
	public List<LectureDataRequest> getfavoriteLecture(int lecture_no) throws SQLException {
		List<LectureDataRequest> lectureDataList = lectureDAO.myFavoriteList(lecture_no);
		
//		List<LectureDataRequest> lectureDataList = lectureDAO.selectLectureData(lecture_no);
		System.out.println("lectureDataList : " + lectureDataList);
		for(int i=0; i< lectureDataList.size(); i++) {
			String theorem = lectureDataList.get(i).getLecture_data_filename();
			
			System.out.println("theorem : " + theorem);
			String realName = theorem.substring(theorem.lastIndexOf("$$")+2);
			System.out.println("realName : " + realName);
			String fileName = realName.substring(0,realName.lastIndexOf("."));
			System.out.println("fileName : " + fileName);
			lectureDataList.get(i).setLecture_data_filename(fileName);
			DraftVO draft = draftDAO.selectDraftDetailBylno(lectureDataList.get(i).getLecture_data_no());
			lectureDataList.get(i).setDraft_status(draft.getDraft_status());
			
		}
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		return lectureDataList;
	}
/*
	@Override
	public List<LectureDataRequest> getLectureDataList(int lecture_no) throws SQLException {
		List<LectureDataRequest> lectureDataList = lectureDAO.selectLectureData(lecture_no);
		for(int i=0; i< lectureDataList.size(); i++) {
			String theorem = lectureDataList.get(i).getLecture_data_filename();
			
			String realName = theorem.substring(theorem.lastIndexOf("$$")+2);
			
			String fileName = realName.substring(0,realName.lastIndexOf("."));
			
			lectureDataList.get(i).setLecture_data_filename(fileName);
			DraftVO draft = draftDAO.selectDraftDetailBylno(lectureDataList.get(i).getLecture_data_no());
			lectureDataList.get(i).setDraft_status(draft.getDraft_status());
			
		}
		return lectureDataList;
	}
*/
	/**
	 * 
	 * @기능설명		:	즐겨찾기 등록, 취소
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 7. 1.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 1.오후 9:41:14
	 * @see			    :	-
	 * @param lecture_data_favorites
	 * @param lecture_data_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void updateFavorite(int lecture_data_favorites, int lecture_data_no) throws SQLException {
		lectureDAO.updateFavorite(lecture_data_favorites, lecture_data_no);
		
	}

	/**
	 * 
	 * @기능설명		:	기안서 결재 시 동영상 업로드 상태로 수정
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 7. 2.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 2.오전 11:45:52
	 * @see			    :	-
	 * @param lecture_data_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void uploadVideo(int lecture_data_no) throws SQLException {
		lectureDAO.uploadVideo(lecture_data_no);
		
	}
	
	/**
	 * 
	 * @기능설명		:	강의 데이터 조회(강의 데이터 번호 기준)
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 7. 2.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 2.오후 5:59:51
	 * @see			    :	-
	 * @param lecture_data_no
	 * @throws SQLException
	 *
	 */
	@Override
	public Lecture_dataVO getLectureData(int lecture_data_no) throws SQLException {
		
		Lecture_dataVO lecdata = lectureDAO.selectLectureData_data_no(lecture_data_no);
		
		return lecdata;
		
	}

	@Override
	public List<LectureVO> getListByLecture_no(int lecture_no) throws SQLException {

		List<LectureVO> LectureList = lectureDAO.selectLectureBylecture_no(lecture_no);
		
		return LectureList;
	}
}
