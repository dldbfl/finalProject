package com.dlms.request;

import java.util.Date;

public class MemberRequest {

	private String member_id; 			// 아이디
	private int member_status; 			// 1일때 활성, 0일때 정지. 2일 때 대기중
	
	public MemberRequest () {}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getMember_status() {
		return member_status;
	}

	public void setMember_status(int member_status) {
		this.member_status = member_status;
	}

	@Override
	public String toString() {
		return "MemberRequest [member_id=" + member_id + ", member_status=" + member_status + "]";
	}

	public MemberRequest(String member_id, int member_status) {
		super();
		this.member_id = member_id;
		this.member_status = member_status;
	}
	
	
	public ProfessorListReq toProfessorAllVO() {

		ProfessorListReq professorAll = new ProfessorListReq();
		professorAll.setMember_id(member_id);
		professorAll.setMember_status(member_status);
		
		return professorAll;
	}
	

}
