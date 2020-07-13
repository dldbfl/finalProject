package com.dlms.exception;

public class NotFoundEmailException extends Exception{
	
	public NotFoundEmailException() {
		super("이메일 주소가 일치 하지 않습니다.");
	}

}
