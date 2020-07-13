package com.dlms.request;

import org.springframework.web.multipart.MultipartFile;

import com.dlms.dto.Manager_boardVO;

/**
 * 
 * @사용목적		:	찾아오는 길 이미지 수정 목적
 * @작성자		    :	이누리
 * @작성날짜     	:	2020. 6. 9.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 9.오후 2:25:32
 * @see			    :	-
 *
 */
public class Manager_boardRequest {

	private int manager_board_no; 				// 관리자 보드 번호
	private String manager_board_writer; 		// 관리자 아이디
	private String enterprise_coming; 			// 찾아오는길
	private String education_curriculum; 			// 교육과정
	private String education_purpose; 			// 교육목표
	private String chairman_introduce; 			// 이사장 인사글
	
	private MultipartFile manager_data_filename;		// 찾아오는길 이미지
	private String old_manager_data_filename;
	
	public Manager_boardRequest() {}
	
	public int getManager_board_no() {
		return manager_board_no;
	}

	public void setManager_board_no(int manager_board_no) {
		this.manager_board_no = manager_board_no;
	}
	
	
	
	public MultipartFile getManager_data_filename() {
		return manager_data_filename;
	}

	public void setManager_data_filename(MultipartFile manager_data_filename) {
		this.manager_data_filename = manager_data_filename;
	}

	public String getOld_manager_data_filename() {
		return old_manager_data_filename;
	}

	public void setOld_manager_data_filename(String old_manager_data_filename) {
		this.old_manager_data_filename = old_manager_data_filename;
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

	@Override
	public String toString() {
		return "Manager_boardRequest [manager_board_no=" + manager_board_no + ", manager_board_writer="
				+ manager_board_writer + ", enterprise_coming=" + enterprise_coming + ", education_curriculum="
				+ education_curriculum + ", education_purpose=" + education_purpose + ", chairman_introduce="
				+ chairman_introduce + ", manager_data_filename=" + manager_data_filename
				+ ", old_manager_data_filename=" + old_manager_data_filename + "]";
	}

	public Manager_boardRequest(int manager_board_no, String manager_board_writer, String enterprise_coming,
			String education_curriculum, String education_purpose, String chairman_introduce,
			MultipartFile manager_data_filename, String old_manager_data_filename) {
		super();
		this.manager_board_no = manager_board_no;
		this.manager_board_writer = manager_board_writer;
		this.enterprise_coming = enterprise_coming;
		this.education_curriculum = education_curriculum;
		this.education_purpose = education_purpose;
		this.chairman_introduce = chairman_introduce;
		this.manager_data_filename = manager_data_filename;
		this.old_manager_data_filename = old_manager_data_filename;
	}

	public Manager_boardVO toManager_boardVO() {
		Manager_boardVO manager_board = new Manager_boardVO();	
		
		manager_board.setChairman_introduce(chairman_introduce);
		manager_board.setEducation_curriculum(education_curriculum);
		manager_board.setEducation_purpose(education_purpose);
		manager_board.setEnterprise_coming(enterprise_coming);
		manager_board.setManager_board_no(manager_board_no);
		manager_board.setManager_board_writer(manager_board_writer);
		
		return manager_board;
		
	}
	
}
