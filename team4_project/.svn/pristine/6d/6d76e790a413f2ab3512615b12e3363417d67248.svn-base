package com.dlms.dao.member;

import java.sql.SQLException;
import java.util.List;

import com.dlms.dto.Email_certificationVO;
import com.dlms.dto.MemberVO;
import com.dlms.dto.ProfessorVO;
import com.dlms.dto.Professor_careerVO;
import com.dlms.dto.StudentVO;
import com.dlms.dto.Student_certificateVO;
import com.dlms.request.StudentListRequest;

public interface MemberDAO {

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
	List<MemberVO> selectMemberList()throws SQLException;
	
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
	MemberVO selectMemberById(String id)throws SQLException;
	/**
	 * 	
	 * @기능설명		:	특정 회원들의 정보 조회
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 10.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 10.오후 3:01:03
	 * @see			    :	-
	 * @param id
	 * @return
	 * @throws SQLException
	 *
	 */
	List<MemberVO> selectMemberListById(String id) throws SQLException;
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
	void insertMember(MemberVO memberVO)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	수강생 필수사항 Insert
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 10:57:18
	 * @param 		:	studentVO
	 * @throws 		:	SQLException
	 *
	 */
	void insertStudent(StudentVO studentVO)throws SQLException;
	/**
	 * 
	 * @기능설명		:	자격증 번호 생성
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 12.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 12.오전 9:52:44
	 * @see			:	MemberService(insertStudent)
	 * @return		: 	int(자격증번호)
	 * @throws 		:	SQLException
	 *
	 */
	int selectRegistStudentSeqNext()throws SQLException;
	/**
	 * 
	 * @기능설명		:	교수 경력 순번 생성 	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 15.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 15.오후 1:48:05
	 * @return		:	int(교수 경력 순번)
	 * @throws SQLException
	 *
	 */
	int selectRegistProfessorSeqNext()throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	수강생 선택 사항 Insert
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 10:58:10
	 * @param		:	student_certificateVO
	 * @throws 		:	SQLException
	 *
	 */
	void insertStudentCertificate(Student_certificateVO student_certificateVO)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	교수 필수 선택 사항 Insert
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 10:59:20
	 * @param		:	professorVO
	 * @throws		:	SQLException
	 *
	 */
	void insertProfessor(ProfessorVO professorVO)throws SQLException;
	
	//
	/**
	 * 
	 * @기능설명		:	교수 선택 사항 Insert 
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 10:59:56
	 * @param 		:	professor_careerVO
	 * @throws		:	SQLException
	 *
	 */
	void insertProfessorCareer(Professor_careerVO professor_careerVO)throws SQLException;
	
	//
	/**
	 * 
	 * @기능설명		:	회원 필수 사항 수정 Update
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 11:00:24
	 * @param 		:	memberVO
	 * @throws		:	SQLException
	 *
	 */
	void updateMember (MemberVO memberVO)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	수강생  필수 사항 Update
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 11:00:56
	 * @param 		:	studentVO
	 * @throws 		:	SQLException
	 *
	 */
	void updateStudent(StudentVO studentVO)throws SQLException;
	
	//
	/**
	 * 
	 * @기능설명		:	수강생 선택 사항 Update
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 11:01:24
	 * @param		:	student_certificateVO
	 * @throws		:	SQLException
	 *
	 */
	void updateStudentCertificate(Student_certificateVO student_certificateVO)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	교수 필수 사항 Update
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 11:02:37
	 * @param		:	professorVO
	 * @throws		:	SQLException
	 *
	 */
	void updateProfessor(ProfessorVO professorVO)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	교수 선택 사항 Update
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 11:03:57
	 * @param		:	professor_careerVO
	 * @throws		:	SQLException
	 *
	 */
	void updateProfessor_career(Professor_careerVO professor_careerVO)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	회원 상태 변경 Update	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 11:04:26
	 * @param		:	memberVO
	 * @throws		:	SQLException
	 *
	 */
	void statusUpdateMember (MemberVO memberVO)throws SQLException;

	/**
	 * 
	 *
	 * @기능설명		:	회원정보(이름, 이메일)을 가지고 해당 회원 정보 확인 및 조회	
	 * @작성자		:	강현철
	 * @작성날짜		:	2020. 6. 6.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 6.오전 2:46:38
	 * @param 		:	memberVO(이름, 이메일)
	 * @return		:	List_MemberVO
	 * @throws 		:	SQLException
	 */
	List<MemberVO> selectMemberByNameAndEmail(MemberVO memberVO)throws SQLException;
	/**
	 * 
	 * @기능설명		:	회원정보(이름, 휴대폰번호)를 가지고 해당 회원 정보 확인 및 조회	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 4.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 4.오후 2:54:44
	 * @param 		:	MeberVO
	 * @return		:	List_MemberVO
	 * @throws 		:	SQLException
	 *
	 */
	List<MemberVO> selectMemberByNameAndPhone(MemberVO memberVO)throws SQLException;
	/**
	 * 
	 * @기능설명		:	아이디와 비밀번호가지고 비밀번호 변경 하는 작업
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 8.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 8.오후 2:21:54
	 * @param 		:	memberVO(아이디,비밀번호)
	 * @throws 		:	SQLException
	 *
	 */
	void updateMemberPwdByIdAndPwd(MemberVO memberVO)throws SQLException;
	/**
	 * 
	 * @기능설명		:	비밀번호 입력 오류시 올라가는 pwd카운터
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 8.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 8.오후 2:22:38
	 * @param 		:	id(회원아이디)
	 * @throws 		:	SQLException
	 *
	 */
	void updateLoginPwdWrongCount(String id)throws SQLException;
	/**
	 * 
	 * @기능설명		:	정상 로그인시 비밀번호 5회 컬럼 초기화
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 8.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 8.오후 2:10:29
	 * @param 		:	id(회원아이디)
	 * @throws 		:	SQLException
	 *
	 */
	void updatePwdCheckReset(String id) throws SQLException;
	/**
	 * 
	 *
	 * @기능설명		:	이메일 인증 SEQ 만들어서 내보내기
	 * @작성자		:	강현철
	 * @작성날짜		:	2020. 6. 13.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 13.오후 10:31:04
	 * @return		:	시퀀스 번호(이메일 번호)
	 * @throws 		:	SQLException
	 */
	int selectEmail_No()throws SQLException;
	/**
	 * 
	 * @기능설명		:	이메일 번호,이메일 인증 문자, 이메일 주소를 등록 하여 기록 
	 * @작성자		:	강현철
	 * @작성날짜		:	2020. 6. 13.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 13.오후 10:32:23
	 * @param 		:	emailAddr(인증할 이메일주소)
	 * @param 		:	key(인증문자)
	 * @param 		:	email_no(이메일 번호)
	 * @throws 		:	SQLException
	 */
	void insertEmailSendText(Email_certificationVO certification)throws SQLException;
	
	/**
	 *
	 * @기능설명		:	이메일 주소, key ,Y 등록 작업
	 * @작성자		:	강현철
	 * @작성날짜		:	2020. 6. 14.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 14.오전 12:24:52
	 * @param 		:	certification
	 */
	void updateEmailCheck(Email_certificationVO certification)throws SQLException;
	/**
	 * 
	 * @기능설명		:	이메일 주소 인증 확인 
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 15.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 15.오후 9:08:36
	 * @param 		:	emailVO
	 *
	 */
	Email_certificationVO selectEmailTextCheck(Email_certificationVO emailVO);

	/**
	 * 
	 * @기능설명		:	상담완료 글 카운트
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 15.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 15.오전 10:33:16
	 * @see			    :	-
	 * @param member_id
	 * @return 완료된 상담 숫자
	 * @throws SQLException
	 *
	 */
	int mainConsultAlert(String member_id) throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	수강생 한명 프로필 보기(member_id로)
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 9:50:12
	 * @see			    :	-
	 * @param member_id
	 * @return
	 * @throws SQLException
	 *
	 */
	public List<StudentListRequest> selectStudentAllById_member_id(String member_id) throws SQLException;

	
	public List<Student_certificateVO> certificateBymember_id(String member_id)throws SQLException;
	
	public void deleteStudent_certificate(int student_certificate_no)throws SQLException;
	
	public StudentVO studentInfoByMemberId(String member_id)throws SQLException;
	
	public void remarkStudent(StudentVO studentVO)throws SQLException;
	
	public void memberOut(MemberVO memberVO)throws SQLException;
	/**
	 * 
	 * @기능설명		:	수강신청 성공하여 User 에서 Student로 권한변경 기능
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 25.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 25.오후 5:08:44
	 * @param 		:	text(id)
	 *
	 */
	void updateStudentAuthority(String text)throws SQLException;
	/**
	 * 
	 * @기능설명		:	교수들 정보 가져오기	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 26.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 26.오전 8:57:15
	 * @return		:	교수정보 리스트
	 *
	 */
	List<MemberVO> selectMemberByProfessor()throws SQLException;
	
	/**
	 * 
	 * @기능설명		: 	결제취소 성공시 Student에서 User로 권한 변경	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 7. 1.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 7. 1.오후 12:38:09
	 * @see			:	
	 * @param text
	 * @throws SQLException
	 *
	 */
	void updateUserAuthority(String text)throws SQLException;
}
