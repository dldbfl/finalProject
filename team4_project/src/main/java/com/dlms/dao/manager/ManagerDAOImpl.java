package com.dlms.dao.manager;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dlms.request.StudentListRequest;
import com.dlms.request.ProfessorListReq;
import com.dlms.request.SearchCriteria;

 
public class ManagerDAOImpl implements ManagerDAO{
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	/**
	 * 
	 * @기능설명		:	교수의 필수 정보와 선택 정보를 조회
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오후 2:58:36
	 * @see			:	-
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public List<ProfessorListReq> selectProfessorList() throws SQLException {
		List<ProfessorListReq> professorList =null;
		professorList=sqlSession.selectList("member-mapper.selectProfessorList", null);
		return professorList;
	}
	
	/**
	 * 
	 * @기능설명		:	교수의 필수 정보와 선택 정보를 조회
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 4.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 4.오후 12:12:37
	 * @see			:	-
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public List<ProfessorListReq> selectProfessorList(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<ProfessorListReq> professorList = null;
		
		professorList=sqlSession.selectList("member-mapper.selectProfessorList",cri,rowBounds);
		return professorList;
	}
	
	/**
	 * 
	 * @기능설명		:	교수의 필수 정보와 선택 정보 리스트 개수
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 4.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 4.오후 12:12:42
	 * @see			:	-
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public int selectProfessorListCount(SearchCriteria cri) throws SQLException {
		List<ProfessorListReq> professorList = null;
		
		professorList=sqlSession.selectList("member-mapper.selectProfessorList",cri);
		
		return professorList.size();
	}
	
	
	
	/**
	 * 
	 * @기능설명		:	수강생의 필수 정보와 선택 정보를 조회
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오후 2:59:23
	 * @see			:	-
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public List<StudentListRequest> selectStudentList() throws SQLException {
		List<StudentListRequest> studentList =null;
		studentList=sqlSession.selectList("member-mapper.selectStudentList", null);
		return studentList;
	}
	/**
	 * 
	 * @기능설명		:	수강생의 조건에 따른 검색
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오후 2:59:33
	 * @see			:	-
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public List<StudentListRequest> selectStudentList(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<StudentListRequest> studentList = null;
		
		studentList=sqlSession.selectList("member-mapper.selectSearchStudentAll",cri,rowBounds);
		return studentList;
	}
	
	/**
	 * 
	 * @기능설명		:	검색 결과의 전체 리스트 개수
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오후 4:11:37
	 * @see			:	-
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public int selectStudentListCount(SearchCriteria cri) throws SQLException {
		List<StudentListRequest> studentList = null;
		
		studentList=sqlSession.selectList("member-mapper.selectSearchStudentAll",cri);
		
		return studentList.size();	
	}
	
	/**
	 * 
	 * @기능설명		:	특정 수강생의 필수 정보와 선택 정보를 조회(student_id로)
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오후 3:00:08
	 * @see			:	-
	 * @param student_id
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public StudentListRequest selectStudentAllById(String student_id) throws SQLException {
		StudentListRequest studentAll= null;
		studentAll= sqlSession.selectOne("member-mapper.selectStudentAllById", student_id);
		return studentAll;
	}
	
	/**
	 * 
	 * @기능설명		:	특정 수강생의 필수 정보와 선택 정보를 조회(member_id로)
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 9:49:21
	 * @see			    :	-
	 * @param member_id
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public StudentListRequest selectStudentAllById_member_id(String member_id) throws SQLException {
		StudentListRequest studentAll= null;
		studentAll= sqlSession.selectOne("member-mapper.selectStudentAllById_member_id", member_id);
		return studentAll;
	}
	
	
	/**
	 * 
	 * @기능설명		:	특정 교수의 필수 정보와 선택 정보를 조회
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 3.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 3.오후 3:00:30
	 * @see			:	-
	 * @param professor_id
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public ProfessorListReq selectProfessorAllById(String professor_id) throws SQLException {
		ProfessorListReq professorAll= null;
		professorAll= sqlSession.selectOne("member-mapper.selectProfessorAllById", professor_id);
		return professorAll;
	}
	
	/**
	 * 
	 * @기능설명		:   현재 출석일 
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 4.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 4.오후 3:05:57
	 * @see			:	-
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public int selectStudent_lecture_attend_daycount(String student_id) throws SQLException {
		int lecture_attend_daycount = sqlSession.selectOne("member-mapper.selectStudent_lecture_attend_daycount",student_id);
		System.out.println(lecture_attend_daycount);
		return lecture_attend_daycount;	
	}
	
	/**
	 * 
	 * @기능설명		:	총 출석일
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 4.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 4.오후 3:06:27
	 * @see			:	-
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public int selectStudent_lecture_attend_alldaycount(String student_id) throws SQLException {
		int lecture_attend_alldaycount = sqlSession.selectOne("member-mapper.selectStudent_lecture_attend_alldaycount",student_id);
		
		return lecture_attend_alldaycount;	
	}
	
	/**
	 * 
	 * @기능설명		:	교수 상태 수정
	 * @작성자		:	이누리
	 * @작성날짜    	:	2020. 6. 5.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 5.오전 9:29:03
	 * @see			:	-
	 * @param studentAll
	 * @throws SQLException
	 *
	 */
	@Override
	public void updateProfessorAll(ProfessorListReq professorAll) throws SQLException {
		sqlSession.update("member-mapper.statusUpdateMember",professorAll);
		
	}
	
}
