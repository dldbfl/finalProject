package com.dlms.service.student;

import java.sql.SQLException;

import com.dlms.dto.StudentVO;

public interface StudentService {
	public StudentVO getStudent(String student_id)throws SQLException;
}
