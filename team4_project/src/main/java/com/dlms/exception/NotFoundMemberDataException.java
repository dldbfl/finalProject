package com.dlms.exception;

public class NotFoundMemberDataException extends Exception{

	public NotFoundMemberDataException () {
		super("일치하는 데이터가 없습니다.");
	}
	
}
