package com.dlms.service.manager;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dlms.dao.manager.ManagerDAO;
import com.dlms.request.PageMaker;
import com.dlms.request.ProfessorListReq;
import com.dlms.request.SearchCriteria;
import com.dlms.request.StudentListRequest;

/**
 * 
 * @param <L>
 * @사용목적		:	관리자의 수강생, 교수관리와 관련된 Service
 * @작성자		:	이누리
 * @작성날짜     	:	2020. 6. 3.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 3.오후 4:20:34
 * @see			:	ManagerService
 *
 */
public class ManagerServiceImpl<L> implements ManagerService {
	
	private ManagerDAO managerDAO;
	public void setManagerDAO(ManagerDAO managerDAO) {
		this.managerDAO = managerDAO;
	}
	
	/**
	 * 
	 * @기능설명		:	수강생 리스트
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오후 4:36:14
	 * @see			:	-
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public List<StudentListRequest> getStudentList() throws SQLException {
		
		return managerDAO.selectStudentList();
	}	
	
	/**
	 * 
	 * @기능설명		:	수강생 리스트 
	 * @작성자			:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오후 4:36:55
	 * @see				:	-
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public Map<String, Object> getStudentList(SearchCriteria cri) throws SQLException {
		
		//수강생 리스트
		List<StudentListRequest> studentList= managerDAO.selectStudentList(cri);
		System.out.println(studentList);
			if(studentList.size()>0) {
				for(int i = 0; i<=studentList.size()-1; i++) {
					if(studentList.get(i).getLecture_no() != 0) {			
						int lecture_attend_percent = lecture_attend_percent(studentList.get(i).getStudent_id());
						int lecture_attend_all_percent = lecture_attend_all_percent(studentList.get(i).getStudent_id());
						studentList.get(i).setLecture_attend_percent(lecture_attend_percent);
						studentList.get(i).setLecture_attend_all_percent(lecture_attend_all_percent);
						
					}
				}
			}
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(managerDAO.selectStudentListCount(cri));
		
		Map<String,Object> dataMap=new HashMap<String,Object>();
		dataMap.put("studentList", studentList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;	
	}
	
	/**
	 * 
	 * @기능설명		:	수강생 현재 출석률 구하기
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 16.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 16.오후 9:12:39
	 * @see			    :	-
	 * @param lecture_no
	 * @return lecture_attend_percent
	 * @throws SQLException
	 *
	 */
	@Override
	public int lecture_attend_percent(String student_id) throws SQLException {
		
		//수강생 출석률
		int lecture_attend_percent = 0;
		int lecture_attend_daycount = managerDAO.selectStudent_lecture_attend_daycount(student_id);
		int lecture_attend_alldaycount = managerDAO.selectStudent_lecture_attend_alldaycount(student_id);
		
		
		if(lecture_attend_alldaycount != 0) {
			lecture_attend_percent = (lecture_attend_daycount * 100 / lecture_attend_alldaycount) ;
		}
				
		return lecture_attend_percent;	
	}
	
	/**
	 * 
	 * @기능설명		:	수강생 총 출석률 구하기
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 7. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 3.오후 12:15:07
	 * @see			    :	-
	 * @param student_id
	 * @return lecture_attend_all_percent
	 * @throws SQLException
	 *
	 */
	@Override
	public int lecture_attend_all_percent(String student_id) throws SQLException {
		
		//수강생 출석률
		int lecture_attend_all_percent = 0;
		int lecture_attend_daycount = managerDAO.selectStudent_lecture_attend_daycount(student_id);
				
		lecture_attend_all_percent = (lecture_attend_daycount * 100 / 20) ;
						
		return lecture_attend_all_percent;	
	}
	
	/**
	 * 
	 * @기능설명		:	교수 리스트 
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오후 4:37:12
	 * @see			:	-
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public List<ProfessorListReq> getProfessorList() throws SQLException {
	
		return managerDAO.selectProfessorList();
	}

	
	/**
	 * 
	 * @기능설명		:	교수 리스트
	 * @작성자			:	이누리
	 * @작성날짜    	:	2020. 6. 4.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 4.오후 12:21:20
	 * @see				:	-
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public Map<String, Object> getProfessorList(SearchCriteria cri) throws SQLException {
		List<ProfessorListReq> professorList= managerDAO.selectProfessorList();
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(managerDAO.selectProfessorListCount(cri));
		System.out.println(professorList);
		Map<String,Object> dataMap=new HashMap<String,Object>();
		dataMap.put("professorList", professorList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;	
	}
	
	/**
	 * 
	 * @기능설명		:	수강생 프로필
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오후 4:37:21
	 * @see			:	-
	 * @param student_id
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public Map<String, Object> getStudent(String student_id) throws SQLException {
		Map<String,Object> dataMap = new HashMap<String,Object>();
		
		StudentListRequest student = managerDAO.selectStudentAllById(student_id);
				
		dataMap.put("student", student);
		
		return dataMap; 
	}
	
	/**
	 * 
	 * @기능설명		:	교수 프로필
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오후 4:37:37
	 * @see			:	-
	 * @param professor_id
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public Map<String, Object> getProfessor(String professor_id) throws SQLException {
		Map<String,Object> dataMap = new HashMap<String,Object>();
		
		ProfessorListReq professor = managerDAO.selectProfessorAllById(professor_id);
				
		dataMap.put("professor", professor);
		
		return dataMap; 
	}

	/**
	 * 
	 * @기능설명		:	교수 재직 상태 수정
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 5.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 5.오후 2:05:43
	 * @see			:	-
	 * @param professorAll
	 * @throws SQLException
	 *
	 */
	@Override
	public void modify(ProfessorListReq professorAll) throws SQLException {
		managerDAO.updateProfessorAll(professorAll);
		
		
	}
	
	
	
	/**
	 * 
	 * @기능설명		:	수강생 프로필
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 18.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 18.오전 0:05:43
	 * @see			:	-
	 * @param member_id
	 * @throws SQLException
	 *
	 */
	@Override
	public StudentListRequest getStudentBy_member_id(String member_id) throws SQLException {
		
		StudentListRequest student = managerDAO.selectStudentAllById_member_id(member_id);
				
		return student; 
	}
	
	
}
