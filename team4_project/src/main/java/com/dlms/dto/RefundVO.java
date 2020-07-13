package com.dlms.dto;

import java.util.Date;
/**
 * 
 * @사용목적		:	환불관련 테이블	
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	연은주
 * @마지막수정일	:	2020. 6. 30
 * @see			:	
 *
 */
public class RefundVO {

	private int refund_no; 			// 환불 번호
	private int pay_no; 			// 결제 번호
	private String refund_method; 	// 환불에 쓰인 방법
	private Date refund_date;		// 환불 일자
	private String class_name;		// 환불 강의명
	
	public RefundVO() {}

	public RefundVO(int refund_no, int pay_no, String refund_method, Date refund_date, String class_name) {
		super();
		this.refund_no = refund_no;
		this.pay_no = pay_no;
		this.refund_method = refund_method;
		this.refund_date = refund_date;
		this.class_name = class_name;
	}

	public int getRefund_no() {
		return refund_no;
	}

	public void setRefund_no(int refund_no) {
		this.refund_no = refund_no;
	}

	public int getPay_no() {
		return pay_no;
	}

	public void setPay_no(int pay_no) {
		this.pay_no = pay_no;
	}

	public String getRefund_method() {
		return refund_method;
	}

	public void setRefund_method(String refund_method) {
		this.refund_method = refund_method;
	}

	public Date getRefund_date() {
		return refund_date;
	}

	public void setRefund_date(Date refund_date) {
		this.refund_date = refund_date;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	@Override
	public String toString() {
		return "RefundVO [refund_no=" + refund_no + ", pay_no=" + pay_no + ", refund_method=" + refund_method
				+ ", refund_date=" + refund_date + ", class_name=" + class_name + "]";
	}

	
}
