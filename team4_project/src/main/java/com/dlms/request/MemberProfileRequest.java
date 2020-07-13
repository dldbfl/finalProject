package com.dlms.request;
/**
 * 
 * @사용목적		:	자유게시판 아이디 클릭시 프로필 출력	
 * @작성자		:	연은주
 * @작성날짜      	:	2020. 6. 25.
 * @마지막수정자	:	연은주
 * @마지막수정일	:	2020. 6. 25.오후 1:48:16
 * @see			:	
 *
 */
public class MemberProfileRequest {

	private String member_id; 
	private String member_email;
	private String member_picture;
	
	public MemberProfileRequest() {}
	
	public MemberProfileRequest(String member_id, String member_email, String member_picture) {
		super();
		this.member_id = member_id;
		this.member_email = member_email;
		this.member_picture = member_picture;
	}

	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_picture() {
		return member_picture;
	}
	public void setMember_picture(String member_picture) {
		this.member_picture = member_picture;
	}

	@Override
	public String toString() {
		return "MemberProfileRequest [member_id=" + member_id + ", member_email=" + member_email + ", member_picture="
				+ member_picture + "]";
	}
	
	
}
