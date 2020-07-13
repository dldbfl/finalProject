package com.dlms.dao.professor;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.dlms.dto.MemberVO;
import com.dlms.dto.ProfessorVO;
import com.dlms.dto.Professor_careerVO;

public class ProfessorDAOImpl implements ProfessorDAO {

	@Autowired
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public ProfessorVO detailProfessor(String member_id) throws SQLException {
		ProfessorVO professor = sqlSession.selectOne("professor-mapper.detailProfessor",member_id);
		return professor;
	}


	@Override
	public List<Professor_careerVO> detailProfessorCareer(String professor_id) throws SQLException {
		List<Professor_careerVO> careerList = sqlSession.selectList("professor-mapper.detailProfessorCareer",professor_id);
		return careerList;
	}

	@Override
	public void deleteProfessorCareer(String professor_career) throws SQLException {
		sqlSession.update("professor-mapper.deleteProfessorCareer",professor_career);
		
	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {
		
		sqlSession.update("professor-mapper.updateMember",member);
		
	}

	@Override
	public void updateProfessor(ProfessorVO professor) throws SQLException {
		
		sqlSession.update("professor-mapper.updateProfessor",professor);
		
	}

	@Override
	public void updateProfessorCareer(Professor_careerVO career) throws SQLException {
		System.out.println(career);
		sqlSession.update("professor-mapper.updateProfessorCareer",career);
		
	}

	@Override
	public int checkProfessor(String professor_id) throws SQLException {
		System.out.println(professor_id);
		int res = sqlSession.selectOne("professor-mapper.checkProfessor",professor_id);
		System.out.println(res);
		return res;
	}

	
}
