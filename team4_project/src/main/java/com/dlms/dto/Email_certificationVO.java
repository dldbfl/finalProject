package com.dlms.dto;

import java.util.Date;
/**
 * 
 *
 * @기능설명		:	회원가입 및 기타이메일 인증에 필요한 리스트
 * @작성자		:	강현철
 * @작성날짜		:	2020. 6. 14.
 * @마지막수정자	:	강현철
 * @마지막수정일	:	2020. 6. 14.오전 09:53:23
 */
public class Email_certificationVO {

	private int email_no;				//인증메일 기준 번호
	private String email_checktext;		//이메일 인증번호
	private String email_address;		//이메일 주소
	private String email_check;			//이메일 인증 여부
	private Date email_date;			//인증메일 발송날짜

	public Email_certificationVO() {}

	public int getEmail_no() {
		return email_no;
	}

	public void setEmail_no(int email_no) {
		this.email_no = email_no;
	}

	public String getEmail_checktext() {
		return email_checktext;
	}

	public void setEmail_checktext(String email_checktext) {
		this.email_checktext = email_checktext;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getEmail_check() {
		return email_check;
	}

	public void setEmail_check(String email_check) {
		this.email_check = email_check;
	}

	public Date getEmail_date() {
		return email_date;
	}

	public void setEmail_date(Date email_date) {
		this.email_date = email_date;
	}

	@Override
	public String toString() {
		return "Email_certificationVO [email_no=" + email_no + ", email_checktext=" + email_checktext
				+ ", email_address=" + email_address + ", email_check=" + email_check + ", email_date=" + email_date
				+ "]";
	}

	public Email_certificationVO(int email_no, String email_checktext, String email_address, String email_check,
			Date email_date) {
		super();
		this.email_no = email_no;
		this.email_checktext = email_checktext;
		this.email_address = email_address;
		this.email_check = email_check;
		this.email_date = email_date;
	}
	
	
}
