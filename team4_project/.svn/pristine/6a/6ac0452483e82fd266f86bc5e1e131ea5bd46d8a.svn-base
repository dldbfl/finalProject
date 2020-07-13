package com.dlms.dao.student;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.dlms.dto.StudentVO;

public class StudentDAOImpl implements StudentDAO {
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public StudentVO selectStudent(String student_id) throws SQLException {
		StudentVO student = sqlSession.selectOne("student-mapper.selectStudentList",student_id);
		return student;
		
	}
}
