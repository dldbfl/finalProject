package com.dlms.dao.professor;

import java.sql.SQLException;
import java.util.List;

import com.dlms.dto.MemberVO;
import com.dlms.dto.ProfessorVO;
import com.dlms.dto.Professor_careerVO;

public interface ProfessorDAO {
	public ProfessorVO detailProfessor(String member_id) throws SQLException;
	public List<Professor_careerVO> detailProfessorCareer(String professor_id) throws SQLException;
	public void deleteProfessorCareer(String professor_career) throws SQLException;
	public void updateMember(MemberVO member) throws SQLException;
	public void updateProfessor(ProfessorVO professor) throws SQLException;
	public void updateProfessorCareer(Professor_careerVO career)throws SQLException;
	public int checkProfessor(String professor_id)throws SQLException;
	
}
