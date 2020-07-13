package com.dlms.dao.member;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dlms.dto.Email_certificationVO;
import com.dlms.dto.MemberVO;
import com.dlms.dto.ProfessorVO;
import com.dlms.dto.Professor_careerVO;
import com.dlms.dto.StudentVO;
import com.dlms.dto.Student_certificateVO;
import com.dlms.request.StudentListRequest;

public class MemberDAOImpl implements MemberDAO{
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	/**
	 * 
	 * @기능설명		:	전체 회원(회원/교수) 조회 리스트
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 10:54:59
	 * @return		:	List<MemberVO>
	 * @throws		:	SQLException
	 *
	 */
	@Override
	public List<MemberVO> selectMemberList() throws SQLException {
		List<MemberVO> memberList =null;
		memberList=sqlSession.selectList("selectMemberList", null);
		return memberList;
	}
	
	/**
	 * 
	 * @기능설명		:	특정 회원 정보 조회
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 10:54:59
	 * @return		:	MemberVO
	 * @throws		:	SQLException
	 *
	 */
	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		MemberVO member= null;
		member= sqlSession.selectOne("member-mapper.selectMemberById", id);
		return member;
	}
	
	/**
	 * 
	 * @기능설명		:	특정 회원들 정보 조회
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 10.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 10.오후 3:02:47
	 * @see			    :	-
	 * @param id
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public List<MemberVO> selectMemberListById(String id) throws SQLException {
		List<MemberVO> member= null;
		member= sqlSession.selectList("member-mapper.selectMemberById", id);
		return member;
	}
	/**
	 * 
	 * @기능설명		:	회원 필수 사항 등록
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 10:54:59
	 * @param 		:	memberVO
	 * @return		:	MemberVO
	 * @throws		:	SQLException
	 *
	 */
	@Override
	public void insertMember(MemberVO memberVO) throws SQLException {
		System.out.println("memberVO : " + memberVO.toString());
		sqlSession.update("member-mapper.insertMember", memberVO);
	}
	/**
	 * 
	 * @기능설명		:	수강생 필수사항 Insert
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 10:57:18
	 * @param 		:	studentVO
	 * @return		:	StudentVO
	 * @throws 		:	SQLException
	 *
	 */
	@Override
	public void insertStudent(StudentVO studentVO) throws SQLException {
		sqlSession.update("member-mapper.insertStudent", studentVO);
	}
	/**
	 * 
	 * @기능설명		:	수강생 선택 사항 Insert
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 10:58:10
	 * @param		:	student_certificateVO
	 * @return		:	Student_certificateVO
	 * @throws 		:	SQLException
	 *
	 */
	@Override
	public void insertStudentCertificate(Student_certificateVO student_certificateVO)throws SQLException {
		sqlSession.update("member-mapper.insertStudentCertificate", student_certificateVO);
	}
	/**
	 * 
	 * @기능설명		:	교수 필수 선택 사항 Insert
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 10:59:20
	 * @param		:	professorVO
	 * @return		:	ProfessorVO
	 * @throws		:	SQLException
	 *
	 */
	@Override
	public void insertProfessor(ProfessorVO professorVO) throws SQLException {
		sqlSession.update("member-mapper.insertProfessor", professorVO);
	}
	/**
	 * 
	 * @기능설명		:	교수 선택 사항 Insert 
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 10:59:56
	 * @param 		:	professor_careerVO
	 * @return		:	Professor_careerVO
	 * @throws		:	SQLException
	 *
	 */
	@Override
	public void insertProfessorCareer(Professor_careerVO professor_careerVO) throws SQLException {
		sqlSession.update("member-mapper.insertProfessorCareer", professor_careerVO);
	}
	/**
	 * 
	 * @기능설명		:	회원 필수 사항 수정 Update
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 11:00:24
	 * @param 		:	memberVO
	 * @return		:	MemberVO
	 * @throws		:	SQLException
	 *
	 */
	@Override
	public void updateMember(MemberVO memberVO) throws SQLException {
		sqlSession.update("member-mapper.updateMember",memberVO);
	}
	/**
	 * 
	 * @기능설명		:	수강생  필수 사항 Update
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 11:00:56
	 * @param 		:	studentVO
	 * @return		:	StudentVO
	 * @throws 		:	SQLException
	 *
	 */
	@Override
	public void updateStudent(StudentVO studentVO) throws SQLException {
		sqlSession.update("member-mapper.updateStudent",studentVO);
	}
	/**
	 * 
	 * @기능설명		:	수강생 선택 사항 Update
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 11:01:24
	 * @param		:	student_certificateVO
	 * @return		:	Student_certificateVO
	 * @throws		:	SQLException
	 *
	 */
	@Override
	public void updateStudentCertificate(Student_certificateVO student_certificateVO)throws SQLException {
		sqlSession.update("member-mapper.updateStudentCertificate",student_certificateVO);
	}
	/**
	 * 
	 * @기능설명		:	교수 필수 사항 Update
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 11:02:37
	 * @param		:	professorVO
	 * @return		:	ProfessorVO
	 * @throws		:	SQLException
	 *
	 */
	@Override
	public void updateProfessor(ProfessorVO professorVO) throws SQLException {
		sqlSession.update("member-mapper.updateProfessor", professorVO);
	}
	/**
	 * 
	 * @기능설명		:	교수 선택 사항 Update
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 11:03:57
	 * @param		:	professor_careerVO
	 * @return		:	Professor_careerVO
	 * @throws		:	SQLException
	 *
	 */
	@Override
	public void updateProfessor_career(Professor_careerVO professor_careerVO) throws SQLException {
		sqlSession.update("member-mapper.updateProfessor_career", professor_careerVO);
	}
	/**
	 * 
	 * @기능설명		:	회원 상태 변경 Update	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 11:04:26
	 * @param		:	memberVO
	 * @return		:	MemberVO
	 * @throws		:	SQLException
	 *
	 */
	@Override
	public void statusUpdateMember(MemberVO memberVO) throws SQLException {
		sqlSession.update("member-mapper.statusUpdateMember",memberVO);
	}
	/**
	 * @기능설명		:	이름과 휴대폰번호를 가지고 해당 회원 정보 가져오기
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 8.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 8.오후 2:17:25
	 * @param 		:	memberVO(이름,휴대폰번호)
	 * @return		:	MemberVO
	 * @throws 		:	SQLException
	 */
	@Override
	public List<MemberVO> selectMemberByNameAndPhone(MemberVO memberVO) throws SQLException {

		List<MemberVO> member=sqlSession.selectList("member-mapper.selectMemberByNameAndPhone", memberVO);
		return member;
	}
	/**
	 * 
	 * @기능설명		:	이름과 이메일주소를 가지고 해당 회원 정보 가져오기
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 8.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 8.오후 2:19:06
	 * @param 		:	memberVO(이름, 이메일)
	 * @return		:	MemberVO
	 * @throws 		:	SQLException
	 */
	@Override
	public List<MemberVO> selectMemberByNameAndEmail(MemberVO memberVO) throws SQLException {
		List<MemberVO> memberList= new ArrayList<MemberVO>();
		memberList = sqlSession.selectList("member-mapper.selectMemberByNameAndEmail", memberVO);
		return memberList;
	}
	/**
	 * 
	 * @기능설명		:	아이디를 가지고 해당 회원 정보 업데
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 8.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 8.오후 2:19:56
	 * @param 		:	memberVO(아이디)
	 * @throws SQLException
	 */
	@Override
	public void updateMemberPwdByIdAndPwd(MemberVO memberVO) throws SQLException {
			sqlSession.update("member-mapper.updateMemberPwdByIdAndPwd",memberVO);
	}
	/**
	 * 
	 * @기능설명		:	비밀번호 입력 오류시 pwd카운터 올라가는 작업
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 8.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 8.오후 2:23:24
	 * @param 		:	id(회원아이디)
	 * @throws 		:	SQLException
	 */
	@Override
	public void updateLoginPwdWrongCount(String id) throws SQLException {
		sqlSession.update("member-mapper.updateLoginPwdWrongCount",id);
	}
	/**
	 * 
	 * @기능설명		:	정상 로그인시 pwd카운터 초기화 작업
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 8.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 8.오후 2:24:01
	 * @param 		:	id(회원아이디)
	 * @throws 		:	SQLException
	 */
	@Override
	public void updatePwdCheckReset(String id) throws SQLException {
		sqlSession.update("member-mapper.updatePwdCheckReset",id);
		
	}
	/**
	 * 
	 * @기능설명		:	자격증 번호 생성 Insert	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 12.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 12.오전 9:53:51
	 * @return		:	int(자격증 번호)
	 * @throws		:	SQLException
	 */
	@Override
	public int selectRegistStudentSeqNext() throws SQLException {
		int seqNum =0;
		seqNum=sqlSession.selectOne("member-mapper.selectRegistStudentSeqNext",null);
		return seqNum;
	}
	
	@Override
	public int selectRegistProfessorSeqNext() throws SQLException {
		int seqNum =0;
		seqNum=sqlSession.selectOne("member-mapper.selectRegistProfessorSeqNext",null);
		return seqNum;
	}
	
	@Override
	public int selectEmail_No() throws SQLException {
		int seqNum=0;
		seqNum=sqlSession.selectOne("member-mapper.selectEmail_No",null);
		return seqNum;
	}

	@Override
	public void insertEmailSendText(Email_certificationVO certification) throws SQLException {
		
		sqlSession.insert("member-mapper.insertEmailSendText",certification);
	}

	@Override
	public void updateEmailCheck(Email_certificationVO certification) throws SQLException {
		sqlSession.update("member-mapper.updateEmailCheck",certification);
	}
	
	
	/**
	 * 
	 * @기능설명		:	메인화면 상담완료 알림
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 15.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 15.오전 10:31:10
	 * @see			    :	-
	 * @param member_id
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public int mainConsultAlert(String member_id) throws SQLException{		
		int count_consult_end = sqlSession.selectOne("consult-mapper.mainConsultAlert", member_id);
		return count_consult_end;
		
	}

	@Override
	public Email_certificationVO selectEmailTextCheck(Email_certificationVO emailVO) {
		Email_certificationVO vo=sqlSession.selectOne("member-mapper.selectEmailTextCheck",emailVO);
		return vo;
	}

	@Override
	public List<Student_certificateVO> certificateBymember_id(String member_id) throws SQLException {
		List<Student_certificateVO> certificate = sqlSession.selectList("member-mapper.certificateBymember_id",member_id);
		return certificate;
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
	public List<StudentListRequest> selectStudentAllById_member_id(String member_id) throws SQLException {
		List<StudentListRequest> member= null;
		member= sqlSession.selectList("member-mapper.selectStudentAllById_member_id", member_id);
		return member;
	}

	@Override
	public void deleteStudent_certificate(int student_certificate_no) throws SQLException {
		sqlSession.selectList("member-mapper.deleteStudent_certificate", student_certificate_no);
		
	}

	@Override
	public StudentVO studentInfoByMemberId(String member_id) throws SQLException {
		StudentVO student = sqlSession.selectOne("member-mapper.studentInfoByMemberId", member_id);
		return student;
	}

	@Override
	public void remarkStudent(StudentVO studentVO) throws SQLException {
		sqlSession.selectList("member-mapper.remarkStudent", studentVO);
		
	}

	@Override
	public void memberOut(MemberVO memberVO) throws SQLException {
		sqlSession.selectList("member-mapper.memberOut", memberVO);
		
	}

	/**
	 * 
	 * @기능설명		:	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 25.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 25.오후 5:09:52
	 * @param text
	 * @throws SQLException
	 */
	@Override
	public void updateStudentAuthority(String text) throws SQLException {
		sqlSession.update("member-mapper.updateStudentAuthority", text);
	}

	/**
	 * 
	 * @기능설명		:	교수들 정보 가져오기	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 26.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 26.오전 8:59:01
	 * @return		:	교수정보 리스트
	 * @throws 		:	SQLException
	 */
	@Override
	public List<MemberVO> selectMemberByProfessor() throws SQLException {
		List<MemberVO> professorList = sqlSession.selectList("member-mapper.selectMemberByProfessor",null);
		return professorList;
	}

	@Override
	public void updateUserAuthority(String text) throws SQLException {
		sqlSession.update("member-mapper.updateUserAuthority", text);
		
	}

	
}
