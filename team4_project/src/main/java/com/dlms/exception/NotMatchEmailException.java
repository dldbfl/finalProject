package com.dlms.exception;

public class NotMatchEmailException extends Exception {

	public NotMatchEmailException() {
		super("이메일 인증이 되지 않았습니다.");
	}
}
