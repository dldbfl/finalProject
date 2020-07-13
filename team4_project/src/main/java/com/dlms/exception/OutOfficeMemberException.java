package com.dlms.exception;

public class OutOfficeMemberException extends Exception{

	public OutOfficeMemberException() {
		super("해당 회원은 탈퇴한 회원 입니다.");
	}
}
