package com.dlms.service.student;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.dlms.dao.student.StudentDAO;
import com.dlms.dto.StudentVO;

public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDAO studentDAO;
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	} 
	
	
	@Override
	public StudentVO getStudent(String student_id) throws SQLException {
		StudentVO student = studentDAO.selectStudent(student_id);
		return student;
	}

}
