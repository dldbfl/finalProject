package com.dlms.service.member;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dlms.dto.Email_certificationVO;
import com.dlms.dto.MemberVO;
import com.dlms.dto.ProfessorVO;
import com.dlms.dto.Professor_careerVO;
import com.dlms.dto.StudentVO;
import com.dlms.dto.Student_certificateVO;
import com.dlms.exception.InUseIdException;
import com.dlms.exception.NotFoundEmailException;
import com.dlms.exception.NotFoundMemberDataException;
import com.dlms.exception.NotMatchEmailException;
import com.dlms.exception.NotMatchedUUIDPwd;
import com.dlms.exception.NotMathchedIdAndPwd;
import com.dlms.exception.OutOfficeMemberException;
import com.dlms.exception.PwdWrongInputException;
import com.dlms.request.StudentListRequest;
/**
 * 
 * @사용목적		:	사용자와 직접 관련된 기능
 * @작성자		:	강현철
 * @작성날짜      	:	2020. 6. 2.
 * @마지막수정자	:	강현철
 * @마지막수정일	:	2020. 6. 2.오전 11:42:19
 *
 */
public interface MemberService {
	
	/**
	 * 
	 * @기능설명		:	로그인
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 11:22:31
	 * @see			:	LoginController
	 * @param 		:	id 	아이디
	 * @param 		:	pwd 패스워드
	 * @throws 		:	SQLException
	 *
	 */
	void Login(String id , String pwd)throws SQLException,NotMathchedIdAndPwd,OutOfficeMemberException,PwdWrongInputException;
	
	/**
	 * 
	 * @기능설명		:	아이디 중복확인	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 11:24:04
	 * @see			:	CommonController
	 * @param 		:	id 아이디
	 * @throws		:	SQLException
	 *
	 */
	void idOverlapCheck(String id)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	수강생 회원가입
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 11:24:59
	 * @see			:	MemberController
	 * @param 		:	member		공통회원정보
	 * @param 		:	student		수강생필수정보
	 * @param 		:	certificate	수강생선택정보(자격증)
	 * @throws		:	SQLException
	 *
	 */

	void registStudent(MemberVO member,StudentVO student,Student_certificateVO[] certificate)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	교수 회원가입
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 2.오전 11:26:25
	 * @see			:	MemberController
	 * @param 		:	member		 	  공통회원정보
	 * @param 		:	professor		  교수 필수사항
	 * @param 		:	professor_career 교수 선택사항(경력)
	 * @throws 		:	SQLException
	 *
	 */
	void registProfessor(MemberVO member,ProfessorVO professor, Professor_careerVO[] professor_career)throws SQLException;
	
	//회원 조회
	/**
	 * 
	 * @기능설명		:	전체 회원 조회
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 4.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 4.오후 2:49:56
	 * @param 		:	member
	 * @return		:	Map<String, Object>
	 * @throws 		:	SQLException
	 *
	 */
	Map<String, Object> getMemberList(MemberVO member)throws SQLException;
	/**
	 * 
	 *
	 * @기능설명		:	회원 id를 가지고 회원정보전체가져오기  
	 * @작성자		:	강현철
	 * @작성날짜		:	2020. 6. 7.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 7.오전 9:13:36
	 * @param 		:	회원 id
	 * @return		:	MemberVO
	 * @throws 		:	SQLException
	 */
	MemberVO getMember(String id)throws SQLException,NotFoundMemberDataException;
	/**
	 * 
	 * @기능설명		:	아이디와 이메일 주소를 가지고잊어버린 아이디 찾기 	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 4.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 4.오후 2:51:34
	 * @see			:	CommonController
	 * @param		:	member
	 * @return		:	List_MemberVO
	 * @throws 		:	SQLException
	 *
	 */
	List<MemberVO> getMemberByNameAndEmailFind(MemberVO member)throws SQLException, NotFoundEmailException;
	
	/**
	 * 
	 *
	 * @기능설명		:	이름과 휴대폰 번호를 가지고 해당 멤버가 있는지 확인 하여 값을 불러오는 기능
	 * @작성자		:	강현철
	 * @작성날짜		:	2020. 6. 6.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 6.오후 9:13:37
	 * @param		:	member(이름 휴대폰번호)
	 * @return		:	List_MemberVO
	 * @throws 		:	SQLException
	 * @throws 		:	NotFoundMemberDataException(해당 멤버 기록이 일치하지 않을떄 예외처리)
	 */
	List<MemberVO> checkMemberByNameAndHpFind(MemberVO member)throws SQLException, NotFoundMemberDataException;
	/**
	 * 
	 * @기능설명		:	아이디,이름, 이메일주소를 가지고 해당 멤버가 있는지 확인 기능
	 * @작성자		:	강현철
	 * @작성날짜		:	2020. 6. 6.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 6.오후 9:16:03
	 * @param 		:	member(아이디,이름,이메일주소)
	 * @return		:	MemberVO
	 * @throws 		:	SQLException
	 * @throws 		:	NotFoundMemberDataException(해당 멤버 기록이 일치하지 않을떄 예외처리)
	 */
	void checkMemberByIdAndNameAndEmailFind(MemberVO member)throws SQLException,NotFoundMemberDataException;
	/**
	 * 
	 * @기능설명		:	아이디를 기준으로 패스워드를 변경 하는 기능(비밀번호변경 및 이메일인증시 사용) 
	 * @작성자		:	강현철
	 * @작성날짜		:	2020. 6. 7.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 7.오후 6:14:15
	 * @param member
	 * @throws SQLException
	 */
	void insertPwdByIdAndPwd(MemberVO member)throws SQLException;
	/**
	 * 				
	 * @기능설명		:	인증받은 문자가 있는지 확인 하는 작업
	 * @작성자		:	강현철
	 * @작성날짜		:	2020. 6. 7.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 7.오후 7:12:19
	 * @param 		:	member
	 * @throws 		:	SQLException
	 * @throws 		:	NotMatchedUUIDPwd
	 */
	void checkPwd(MemberVO member)throws SQLException,NotMatchedUUIDPwd;
	/**
	 * 
	 *
	 * @기능설명		:	아이디 중복검사 확인
	 * @작성자		:	강현철
	 * @작성날짜		:	2020. 6. 13.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 13.오후 10:22:04
	 * @param 		:	id(입력값)
	 * @throws 		:	SQLException
	 * @throws 		:	InUseIdException(아이디를 찾을 수 없을때 발생하는 예외)
	 */
	void searchId(String id)throws SQLException,InUseIdException;
	
	/**
	 *
	 * @기능설명		:	이메일 인증문자 저장 및 기록
	 * @작성자		:	강현철
	 * @작성날짜		:	2020. 6. 13.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 13.오후 10:20:31
	 * @param		:	certification
	 * @throws 		:	SQLException
	 */
	void insertEmailSendText(Email_certificationVO certification)throws SQLException;
	/**
	 *
	 * @기능설명		:	해당 이메일 주소와 text문자를 가지고 일치하는 부분에 인증완료 Y 표시 업데이트
	 * @작성자		:	강현철
	 * @작성날짜		:	2020. 6. 14.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 14.오전 12:22:42
	 * @param 		:	certification(checkText, emailAddress,check)
	 * @throws 		:	SQLException
	 */
	void updateEmailCheck(Email_certificationVO certification)throws SQLException;

	/**
	 * 
	 * @기능설명		:	가입버튼 클릭시 해당 이메일 인증 여부 확인 하는기능
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 15.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 15.오후 9:06:02
	 * @param 		:	emailVO(checkText, checkAddress)
	 * @throws		:	SQLException 
	 * @throws		:	NotMatchEmailException 
	 */
	void selectEmailTextCheck(Email_certificationVO emailVO) throws SQLException, NotMatchEmailException;
	/**
	 * 
	 * @기능설명		:	해당 멤버의 답글 완료 카운트
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 15.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 15.오전 10:37:40
	 * @see			    :	-
	 * @param member_id
	 * @return count(consult_status)
	 * @throws SQLException
	 *
	 */
	int mainConsultAlert(String member_id) throws SQLException;
	
	Map<String, Object> getCertificateList(String member_id)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	로그인 세션에서 수강생 하나의 특정 정보를 얻기위함
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 18.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 18.오전 9:48:15
	 * @see			    :	-
	 * @param member_id
	 * @return
	 * @throws SQLException
	 *
	 */
	public List<StudentListRequest> getStudent_member_id(String member_id) throws SQLException;
	
	
	
	public void modifyMember(MemberVO memberVO, Student_certificateVO[] certificates, StudentVO studentVO)throws SQLException;
	public void modifyMember(MemberVO memberVO)throws SQLException;
	
	/**
	 * 
	 * @기능설명		:	성공하여 권한 Student로 변경
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 25.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 25.오후 5:03:17
	 * @param 		:	text(id)
	 *
	 */
	public void updateStudentAuthority(String text)throws SQLException;

	/**
	 * 
	 * @기능설명		:	교수들 정보 가져오기
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 26.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 26.오전 8:53:25
	 * @return		:	교수정보 리스트
	 *
	 */
	List<MemberVO> getProfessorList()throws SQLException; 
	
	/**
	 * 
	 * @기능설명		:	결제취소 성공시 student를 User로 변경	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 7. 1.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 7. 1.오후 12:39:47
	 * @see			:	
	 * @param text(id)
	 * @throws SQLException
	 *
	 */
	void updateUserAuthority(String text)throws SQLException;


	/**
	 * 
	 * @기능설명		:	회원이름으로 회원 프로필정보 가져오기
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 7. 1.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 7. 1.오후 9:21:08
	 * @param 		:	writter(회원이름)
	 * @return		:	프로필정보(이름,에메일,전화번호,사진,성별등)
	 * @throws 		:	SQLException
	 *
	 */
	MemberVO getMemberProfileInfo(String writter)throws SQLException;
	
	
}
