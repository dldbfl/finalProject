package com.dlms.exception;

public class LeavedMemberException extends Exception{

	public LeavedMemberException() {
		super("퇴사처리된 회원입니다");
	}
}
