package com.dlms.dto;
/**
 * 
 * @사용목적		:	관리자가 작성하는 게시판 테이블
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 9.오후 2:52:47
 * @see			:	
 *
 */
public class Manager_boardVO {

	private int manager_board_no; 				// 관리자 보드 번호
	private String manager_board_writer; 		// 관리자 아이디
	private String enterprise_coming; 			// 찾아오는길
	private String education_curriculum; 			// 교육과정
	private String education_purpose; 			// 교육목표
	private String chairman_introduce; 			// 이사장 인사글
	
	private String manager_data_filename;		// 찾아오는길 이미지
	
	public Manager_boardVO() {}
	
	public int getManager_board_no() {
		return manager_board_no;
	}

	public void setManager_board_no(int manager_board_no) {
		this.manager_board_no = manager_board_no;
	}

	public String getManager_board_writer() {
		return manager_board_writer;
	}

	public void setManager_board_writer(String manager_board_writer) {
		this.manager_board_writer = manager_board_writer;
	}

	public String getEnterprise_coming() {
		return enterprise_coming;
	}

	public void setEnterprise_coming(String enterprise_coming) {
		this.enterprise_coming = enterprise_coming;
	}


	public String getEducation_curriculum() {
		return education_curriculum;
	}

	public void setEducation_curriculum(String education_curriculum) {
		this.education_curriculum = education_curriculum;
	}

	public String getEducation_purpose() {
		return education_purpose;
	}

	public void setEducation_purpose(String education_purpose) {
		this.education_purpose = education_purpose;
	}

	public String getChairman_introduce() {
		return chairman_introduce;
	}

	public void setChairman_introduce(String chairman_introduce) {
		this.chairman_introduce = chairman_introduce;
	}
	
	

	public String getManager_data_filename() {
		return manager_data_filename;
	}

	public void setManager_data_filename(String manager_data_filename) {
		this.manager_data_filename = manager_data_filename;
	}

	@Override
	public String toString() {
		return "Manager_boardVO [manager_board_no=" + manager_board_no + ", manager_board_writer="
				+ manager_board_writer + ", enterprise_coming=" + enterprise_coming + ", education_curriculum="
				+ education_curriculum + ", education_purpose=" + education_purpose + ", chairman_introduce="
				+ chairman_introduce + ", manager_data_filename=" + manager_data_filename + "]";
	}

	public Manager_boardVO(int manager_board_no, String manager_board_writer, String enterprise_coming,
			String education_curriculum, String education_purpose, String chairman_introduce,
			String manager_data_filename) {
		super();
		this.manager_board_no = manager_board_no;
		this.manager_board_writer = manager_board_writer;
		this.enterprise_coming = enterprise_coming;
		this.education_curriculum = education_curriculum;
		this.education_purpose = education_purpose;
		this.chairman_introduce = chairman_introduce;
		this.manager_data_filename = manager_data_filename;
	}

	
	
	
}
