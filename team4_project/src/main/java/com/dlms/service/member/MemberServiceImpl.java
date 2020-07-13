package com.dlms.service.member;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dlms.dao.member.MemberDAO;
import com.dlms.dto.Email_certificationVO;
import com.dlms.dto.MemberVO;
import com.dlms.dto.Member_imgVO;
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

public class MemberServiceImpl implements MemberService{
	
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public void Login(String id, String pwd) throws SQLException, NotMathchedIdAndPwd, OutOfficeMemberException,PwdWrongInputException {
		MemberVO member= new MemberVO();
		member=memberDAO.selectMemberById(id);
		if(member==null) throw new NotMathchedIdAndPwd();
		System.out.println("getMember_pwdcheck : " +member.getMember_pwdcheck() );
		if(member.getMember_pwdcheck()==5) {
			throw new PwdWrongInputException();
		}
		if(!member.getMember_pwd().equals(pwd)) {
			memberDAO.updateLoginPwdWrongCount(member.getMember_id());
			throw new NotMathchedIdAndPwd();
		}
		if(member.getMember_status()==0) {
			throw new OutOfficeMemberException();
		}
		memberDAO.updatePwdCheckReset(id);
	}

	@Override
	public void idOverlapCheck(String id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registStudent(MemberVO member, StudentVO student, Student_certificateVO[] certificates)
			throws SQLException {
		System.out.println("member.getMember_infoOpen() : " +member.getMember_infoOpen());
		System.out.println("member.getMember_eventReception() : " +member.getMember_eventReception());
		memberDAO.insertMember(member);
		memberDAO.insertStudent(student);
		for(Student_certificateVO certificate :certificates) {
			int seqNum=memberDAO.selectRegistStudentSeqNext();
			certificate.setStudent_certificate_no(seqNum);
			memberDAO.insertStudentCertificate(certificate);
		}
		
	}

	@Override
	public void registProfessor(MemberVO member, ProfessorVO professor, Professor_careerVO[] professor_career)
			throws SQLException {
		memberDAO.insertMember(member);
		System.out.println("professor : " + professor.toString());
		memberDAO.insertProfessor(professor);
		if(professor_career != null) {
			for(Professor_careerVO career : professor_career) {
				int seqNum=memberDAO.selectRegistProfessorSeqNext();
				System.out.println("seqNum : 교수 회원가입시 경력사항 순번 ==>" + seqNum);
				career.setProfessor_career_no(seqNum);
				System.out.println("career : " +career.toString());
				memberDAO.insertProfessorCareer(career);
			}
		}
	}

	@Override
	public Map<String, Object> getMemberList(MemberVO member) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MemberVO getMember(String id) throws SQLException, NotFoundMemberDataException {
		MemberVO member=memberDAO.selectMemberById(id);
			if(member==null) {
				throw new NotFoundMemberDataException();
			}
		return member; 
	}

	@Override
	public List<MemberVO> getMemberByNameAndEmailFind(MemberVO member) throws SQLException,NotFoundEmailException {
		List<MemberVO> memberList=memberDAO.selectMemberByNameAndEmail(member);
		if(memberList == null) throw new NotFoundEmailException();
		return memberList;
	}

	@Override
	public List<MemberVO> checkMemberByNameAndHpFind(MemberVO member) throws SQLException, NotFoundMemberDataException {
		List<MemberVO> memberList= new ArrayList<MemberVO>();
		memberList=memberDAO.selectMemberByNameAndPhone(member);
		if(memberList == null) throw new NotFoundMemberDataException();
		return memberList;
	}

	@Override
	public void checkMemberByIdAndNameAndEmailFind(MemberVO member) throws SQLException, NotFoundMemberDataException {
		MemberVO mem=memberDAO.selectMemberById(member.getMember_id());
		if(mem == null) {
			throw new NotFoundMemberDataException();
		}else if(!mem.getMember_name().equals(member.getMember_name())||
				 !mem.getMember_email().equals(member.getMember_email())) {
			throw new NotFoundMemberDataException();
		}else {
			
		}
	}

	@Override
	public void insertPwdByIdAndPwd(MemberVO member) throws SQLException {
		memberDAO.updateMemberPwdByIdAndPwd(member);
	}
	@Override
	public void checkPwd(MemberVO member)throws SQLException, NotMatchedUUIDPwd{
		System.out.println(member.toString());
		MemberVO memberinfo=memberDAO.selectMemberById(member.getMember_id());
		if(!memberinfo.getMember_pwd().equals(member.getMember_pwd())) {
			throw new NotMatchedUUIDPwd();
		}
	}

	@Override
	public void searchId(String id) throws SQLException,InUseIdException {
		MemberVO member = new MemberVO();
		
		member= memberDAO.selectMemberById(id);
		if(member!=null) {
			throw new InUseIdException();
		}
				
		
	}
	@Override
	public void insertEmailSendText(Email_certificationVO certification) throws SQLException {
		int email_no=memberDAO.selectEmail_No();
		System.out.println("email_no : " + email_no);
		certification.setEmail_no(email_no);
		memberDAO.insertEmailSendText(certification);
	}
	//해당 받은 이메일일에서 인증하기 클릭시  인증 했다는 Y 체크 표시 기능
	@Override
	public void updateEmailCheck(Email_certificationVO certification) throws SQLException {
		memberDAO.updateEmailCheck(certification);
	}
	
	/**
	 * 
	 * @기능설명		:	멤버 아이디에 따른 카운트 
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 15.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 15.오전 10:35:16
	 * @see			    :	-
	 * @param member_id
	 * @return 답글 완료 숫자 꺼내기
	 * @throws SQLException
	 *
	 */
	@Override
	public int mainConsultAlert(String member_id) throws SQLException{
		
		int count_consult_end = memberDAO.mainConsultAlert(member_id);
		
		return count_consult_end;		
	}

	//가입버튼 클릭시 이메일인증 됫는지 Y N 체크여부 확인 기능
	@Override
	public void selectEmailTextCheck(Email_certificationVO emailVO) throws NotMatchEmailException {
		Email_certificationVO vo = new Email_certificationVO();
		System.out.println("emailVO : " +emailVO.toString());
		vo=memberDAO.selectEmailTextCheck(emailVO);
		if(vo == null || vo.getEmail_check().equals("N")) {
			throw new NotMatchEmailException();
		}
	}

	@Override
	public Map<String, Object> getCertificateList(String member_id) throws SQLException {
		List<Student_certificateVO> certificateList = memberDAO.certificateBymember_id(member_id);
		System.out.println("서비스에서 certificateList : " + certificateList);
		
		StudentVO studentInfo = memberDAO.studentInfoByMemberId(member_id);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("certificateList", certificateList);
		dataMap.put("studentInfo", studentInfo);
		
		return dataMap;
	}
	
	/**
	 * 
	 * @기능설명		:	수강생 로그인 새션에서 정보 들고오기 위함
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 18.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 18.오전 9:46:10
	 * @see			    :	-
	 * @param member_id
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public List<StudentListRequest> getStudent_member_id(String member_id) throws SQLException {
		
		List<StudentListRequest> student = memberDAO.selectStudentAllById_member_id(member_id);
						
		return student; 
	}

	@Override
	public void modifyMember(MemberVO memberVO, Student_certificateVO[] certificateVO, StudentVO studentVO) throws SQLException {
		 
		memberDAO.updateMember(memberVO);
		if (certificateVO != null) {
			for(Student_certificateVO certificates : certificateVO) {
				if (certificates.getStudent_certificate_no() == 0) {
					certificates.setStudent_certificate_no(memberDAO.selectRegistStudentSeqNext());
					certificates.setStudent_id(memberVO.getMember_id());
					memberDAO.insertStudentCertificate(certificates);
				}else if(certificates.getStudent_certificate_no() !=0 && certificates.getStudent_certificate_division() != null){
					certificates.setStudent_id(memberVO.getMember_id());
					memberDAO.updateStudentCertificate(certificates);
				}else {
					memberDAO.deleteStudent_certificate(certificates.getStudent_certificate_no());
				}
				
				memberDAO.certificateBymember_id(memberVO.getMember_id());
				memberDAO.remarkStudent(studentVO);
			}
		}

	}

	@Override
	public void modifyMember(MemberVO memberVO) throws SQLException {
		memberDAO.memberOut(memberVO);
		
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
		memberDAO.updateStudentAuthority(text);
	}

	/**
	 * 
	 * @기능설명		:	교수들정보 가져오기	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 26.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 26.오전 8:55:14
	 * @return		:	교수정보 리스트
	 * @throws 		:	SQLException
	 */
	@Override
	public List<MemberVO> getProfessorList() throws SQLException {
			List<MemberVO> professorList = memberDAO.selectMemberByProfessor();
		return professorList;
	}

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
	@Override
	public void updateUserAuthority(String text) throws SQLException {
		memberDAO.updateUserAuthority(text);
	}

	/**
	 * 
	 * @기능설명		:	회원아이디를 가져와서 회원 프로필정보 가져오기	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 7. 1.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 7. 1.오후 9:22:52
	 * @param		:	writter(회원아이디)
	 * @return		:	회원프로필정보(이름,전화번호,이메일,성별,사진등)
	 * @throws 		:	SQLException
	 */
	
	@Override
	public MemberVO getMemberProfileInfo(String writter) throws SQLException {
		MemberVO member =new MemberVO();
			member=memberDAO.selectMemberById(writter);
		return member;
	}
		
	


}

