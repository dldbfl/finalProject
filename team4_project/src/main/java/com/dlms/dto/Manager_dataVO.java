package com.dlms.dto;

import java.util.Date;
/**
 * 
 * @사용목적		:	관리자가 작성하는 게시판을 참조하는 자료테이블	
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 13.오후 4:20:42
 * @see			:	
 *
 */
public class Manager_dataVO {

	private int manager_data_no; 			// 관리자 파일번호
	private int manager_board_no; 			// 관리자 게시판 번호
	private int popup_no; 					// 팝업번호
	private int introduce_no; 				// 기업소개글 번호
	private String manager_data_filename; 	// 파일명
	private Date manager_data_regdate; 		// 등록일자

	public Manager_dataVO() {}
	
	public int getManager_data_no() {
		return manager_data_no;
	}

	public void setManager_data_no(int manager_data_no) {
		this.manager_data_no = manager_data_no;
	}

	public int getManager_board_no() {
		return manager_board_no;
	}

	public void setManager_board_no(int manager_board_no) {
		this.manager_board_no = manager_board_no;
	}

	public int getPopup_no() {
		return popup_no;
	}

	public void setPopup_no(int popup_no) {
		this.popup_no = popup_no;
	}

	public int getIntroduce_no() {
		return introduce_no;
	}

	public void setIntroduce_no(int introduce_no) {
		this.introduce_no = introduce_no;
	}

	public String getManager_data_filename() {
		return manager_data_filename;
	}

	public void setManager_data_filename(String manager_data_filename) {
		this.manager_data_filename = manager_data_filename;
	}

	public Date getManager_data_regdate() {
		return manager_data_regdate;
	}

	public void setManager_data_regdate(Date manager_data_regdate) {
		this.manager_data_regdate = manager_data_regdate;
	}

	@Override
	public String toString() {
		return "Manager_dataVO [manager_data_no=" + manager_data_no + ", manager_board_no=" + manager_board_no
				+ ", popup_no=" + popup_no + ", introduce_no=" + introduce_no + ", manager_data_filename="
				+ manager_data_filename + ", manager_data_regdate=" + manager_data_regdate + "]";
	}

	public Manager_dataVO(int manager_data_no, int manager_board_no, int popup_no, int introduce_no,
			String manager_data_filename, Date manager_data_regdate) {
		super();
		this.manager_data_no = manager_data_no;
		this.manager_board_no = manager_board_no;
		this.popup_no = popup_no;
		this.introduce_no = introduce_no;
		this.manager_data_filename = manager_data_filename;
		this.manager_data_regdate = manager_data_regdate;
	}

}
