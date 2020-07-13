package com.dlms.service.manager;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dlms.request.ProfessorListReq;
import com.dlms.request.SearchCriteria;
import com.dlms.request.StudentListRequest;

public interface ManagerService {
	
	/**
	 * 
	 * @기능설명		:	수강생 리스트
	 * @작성자			:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오후 4:04:16
	 * @see				:	-
	 * @return
	 * @throws SQLException
	 *
	 */
	List<StudentListRequest> getStudentList()throws SQLException;
	
	Map<String,Object> getStudentList(SearchCriteria cri)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	교수 리스트
	 * @작성자			:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오후 4:09:17
	 * @see				:	-
	 * @return
	 * @throws SQLException
	 *
	 */
	List<ProfessorListReq> getProfessorList()throws SQLException;	

	Map<String,Object> getProfessorList(SearchCriteria cri)throws SQLException;
	/**
	 * 
	 * @기능설명		:	학생 프로필
	 * @작성자			:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오후 4:09:33
	 * @see				:	-
	 * @param student_id
	 * @return
	 * @throws SQLException
	 *
	 */
	Map<String,Object> getStudent(String student_id)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	교수 프로필
	 * @작성자			:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오후 4:10:22
	 * @see				:	-
	 * @param professor_id
	 * @return
	 * @throws SQLException
	 *
	 */
	Map<String,Object> getProfessor(String professor_id)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	출석률 구하기
	 * @작성자			:	이누리
	 * @작성날짜    	:	2020. 6. 4.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 4.오후 5:24:23
	 * @see				:	-
	 * @param lecture_no
	 * @return
	 * @throws SQLException
	 *
	 */
	int lecture_attend_percent(String student_id) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	총 출석률 구하기
	 * @작성자			:	이누리
	 * @작성날짜    	:	2020. 6. 4.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 4.오후 5:24:23
	 * @see				:	-
	 * @param lecture_no
	 * @return
	 * @throws SQLException
	 *
	 */
	int lecture_attend_all_percent(String student_id) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	교수 상태 수정
	 * @작성자			:	이누리
	 * @작성날짜    	:	2020. 6. 5.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 5.오전 9:36:43
	 * @see				:	-
	 * @param ProfessorListReq
	 * @param careers
	 * @throws SQLException
	 *
	 */
	//void modify(ProfessorAllVO ProfessorAllVO,List<ProfessorAllVO> careers)throws SQLException;
	void modify(ProfessorListReq professorAll)throws SQLException;

	
	/**
	 * 
	 * @기능설명		:	학생 프로필(member_id 조회)
	 * @작성자			:	이누리
	 * @작성날짜    	:	2020. 6. 18.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 18.오전 9:36:43
	 * @see				:	-
	 * @param ProfessorListReq
	 * @param careers
	 * @throws SQLException
	 *
	 */
	StudentListRequest getStudentBy_member_id(String member_id) throws SQLException;
	
}


