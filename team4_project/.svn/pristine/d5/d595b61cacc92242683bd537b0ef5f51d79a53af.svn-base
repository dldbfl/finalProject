package com.dlms.dao.manager;

import java.sql.SQLException;
import java.util.List;

import com.dlms.request.ProfessorListReq;
import com.dlms.request.SearchCriteria;
import com.dlms.request.StudentListRequest;

public interface ManagerDAO {

	/**
	 * 
	 * @기능설명		:	교수 내역 전체 조회
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오전 11:43:30
	 * @see			:	-
	 * @return
	 * @throws SQLException
	 *
	 */
	List<ProfessorListReq> selectProfessorList() throws SQLException;	
	
	/**
	 * 
	 * @기능설명		:	교수 내역 전체 조회
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오후 12:33:20
	 * @see			:	-
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	List<ProfessorListReq> selectProfessorList(SearchCriteria cri) throws SQLException;
	
	/**
	 *
	 * @기능설명		:	교수 내역 전체 리스트 개수
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오후 4:03:11
	 * @see			:	-
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	int selectProfessorListCount(SearchCriteria cri)throws SQLException; 

	/**
	 * 
	 * @기능설명		:	수강생 내역 전체 조회
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오전 11:46:51
	 * @see			:	-
	 * @return
	 * @throws SQLException
	 *
	 */
	List<StudentListRequest> selectStudentList() throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	수강생 검색
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오후 12:33:20
	 * @see			:	-
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	List<StudentListRequest> selectStudentList(SearchCriteria cri) throws SQLException;
	
	/**
	 *
	 * @기능설명		:	검색 결과의 전체 리스트 개수
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오후 4:03:11
	 * @see			:	-
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	int selectStudentListCount(SearchCriteria cri)throws SQLException; 

	/**
	 * 
	 * @기능설명		:	수강생 한명 프로필 보기(student_id로)
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오후 2:39:47
	 * @see			:	-
	 * @param student_id
	 * @return
	 * @throws SQLException
	 *
	 */
	StudentListRequest selectStudentAllById(String student_id)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	교수 한명 프로필 보기
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오후 2:40:44
	 * @see			:	-
	 * @param professor_id
	 * @return
	 * @throws SQLException
	 *
	 */
	ProfessorListReq selectProfessorAllById(String professor_id)throws SQLException;
		
	/**
	 * 	
	 * @기능설명		:	현재 출석일 수
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 4.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 4.오후 3:03:33
	 * @see			:	-
	 * @return
	 * @throws SQLException
	 *
	 */
	int selectStudent_lecture_attend_daycount(String student_id)throws SQLException; 
	
	/**
	 * 	
	 * @기능설명		:	총 출석일 수
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 4.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 4.오후 3:03:33
	 * @see			:	-
	 * @return
	 * @throws SQLException
	 *
	 */
	int selectStudent_lecture_attend_alldaycount(String student_id)throws SQLException; 
	
	/**
	 * 
	 * @기능설명		:	교수 상태 수정
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 5.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 5.오전 9:28:33
	 * @see			:	-
	 * @param studentAll
	 * @throws SQLException
	 *
	 */
	void updateProfessorAll(ProfessorListReq professorAll)throws SQLException;
		
	/**
	 * 
	 * @기능설명		:	수강생 한명 프로필 보기(member_id로)
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 9:50:12
	 * @see			    :	-
	 * @param member_id
	 * @return
	 * @throws SQLException
	 *
	 */
	public StudentListRequest selectStudentAllById_member_id(String member_id) throws SQLException;


}
