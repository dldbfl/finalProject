package com.dlms.request;

import java.util.Arrays;

import com.dlms.dto.MemberVO;
import com.dlms.dto.MessengerVO;
import com.dlms.service.message.MessengerService;

/**
 * 
 *
 * @기능설명		:	교수 문서자료실에서 해당 이메일 공유 에 필요한 ID Email 담는 커맨드객체
 * @작성자		:	강현철
 * @작성날짜		:	2020. 6. 27.
 * @마지막수정자	:	강현철
 * @마지막수정일	:	2020. 6. 27.오전 9:45:04
 */
public class ProfessorShareRequest {
	

	private String sendTitle;			//제목
	private String sendContent;			//내용

	private MemberVO[] member;			//아이디, 이메일주소 
	
	public ProfessorShareRequest() {}
	
	public String getSendTitle() {
		return sendTitle;
	}

	public void setSendTitle(String sendTitle) {
		this.sendTitle = sendTitle;
	}

	public String getSendContent() {
		return sendContent;
	}

	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}

	public MemberVO[] getMember() {
		return member;
	}

	public void setMember(MemberVO[] member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "EmailShareRequest [sendTitle=" + sendTitle + ", sendContent=" + sendContent + ", member="
				+ Arrays.toString(member) + "]";
	}
	
	public MemberVO toMemberVO() {
		MemberVO vo = new MemberVO();
		
		return vo;
	}
}
