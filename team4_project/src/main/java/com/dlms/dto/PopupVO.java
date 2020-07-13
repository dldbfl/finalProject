package com.dlms.dto;
/**
 * 
 * @사용목적		:	팝업 관리 테이블	
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	박진영
 * @마지막수정일	:	2020. 6. 1.오후 4:19:47
 * @see			:	
 *
 */
public class PopupVO {

	private int popup_no; 			// 팝업 번호
	private String popup_writer;	// 매니저 아이디

	public int getPopup_no() {
		return popup_no;
	}

	public void setPopup_no(int popup_no) {
		this.popup_no = popup_no;
	}

	public String getPopup_writer() {
		return popup_writer;
	}

	public void setPopup_writer(String popup_writer) {
		this.popup_writer = popup_writer;
	}

	@Override
	public String toString() {
		return "PopupVO [popup_no=" + popup_no + ", popup_writer=" + popup_writer + "]";
	}

	public PopupVO(int popup_no, String popup_writer) {
		super();
		this.popup_no = popup_no;
		this.popup_writer = popup_writer;
	}

}
