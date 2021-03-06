package com.dlms.service.professor;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.dlms.dto.MemberVO;
import com.dlms.dto.ProfessorVO;
import com.dlms.dto.Professor_careerVO;


public interface ProfessorService {
	
	public Map<String, Object> getProfessorDetail(String member_id) throws SQLException;
	public Map<String, Object> modifyProfessorDetail(MemberVO member, ProfessorVO professor, List<Professor_careerVO> career, MultipartFile picture,List<MultipartFile> careerFile, HttpSession session)throws SQLException;
	public int checkProfessor (String professor_id) throws SQLException;
}
