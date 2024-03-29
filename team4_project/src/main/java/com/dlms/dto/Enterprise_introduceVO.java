package com.dlms.dto;

/**
 * 
 * @사용목적		:	관리자가 기업소개 내용을 작성 및 수정하기위해
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 5.오후 4:59:06
 * @see			:	
 *
 */
public class Enterprise_introduceVO {

	private int enterprise_introduce_no;                   // 기업소개글 번호
	private String enterprise_introduce_writer;            // 관리자 아이디
	private String enterprise_name;             // 회사명
	private String enterprise_regdate;          // 설립일
	private String enterprise_manager;          // 대표이름
	private String enterprise_location;         // 회사위치
	private String enterprise_regno;            // 사업자등록번호
	private String enterprise_phone;			// 대표 폰번호 
	private String enterprise_email;   			// 대표 이메일
	
	
	private String manager_data_filename;		// 기업소개 이미지
	
	public Enterprise_introduceVO() {}
	

	public String getManager_data_filename() {
		return manager_data_filename;
	}


	public void setManager_data_filename(String manager_data_filename) {
		this.manager_data_filename = manager_data_filename;
	}


	public int getEnterprise_introduce_no() {
		return enterprise_introduce_no;
	}

	public void setEnterprise_introduce_no(int enterprise_introduce_no) {
		this.enterprise_introduce_no = enterprise_introduce_no;
	}

	public String getEnterprise_introduce_writer() {
		return enterprise_introduce_writer;
	}

	public void setEnterprise_introduce_writer(String enterprise_introduce_writer) {
		this.enterprise_introduce_writer = enterprise_introduce_writer;
	}

	public String getEnterprise_name() {
		return enterprise_name;
	}

	public void setEnterprise_name(String enterprise_name) {
		this.enterprise_name = enterprise_name;
	}

	public String getEnterprise_regdate() {
		return enterprise_regdate;
	}

	public void setEnterprise_regdate(String enterprise_regdate) {
		this.enterprise_regdate = enterprise_regdate;
	}

	public String getEnterprise_manager() {
		return enterprise_manager;
	}

	public void setEnterprise_manager(String enterprise_manager) {
		this.enterprise_manager = enterprise_manager;
	}

	public String getEnterprise_location() {
		return enterprise_location;
	}

	public void setEnterprise_location(String enterprise_location) {
		this.enterprise_location = enterprise_location;
	}

	public String getEnterprise_regno() {
		return enterprise_regno;
	}

	public void setEnterprise_regno(String enterprise_regno) {
		this.enterprise_regno = enterprise_regno;
	}

	public String getEnterprise_phone() {
		return enterprise_phone;
	}

	public void setEnterprise_phone(String enterprise_phone) {
		this.enterprise_phone = enterprise_phone;
	}

	public String getEnterprise_email() {
		return enterprise_email;
	}

	public void setEnterprise_email(String enterprise_email) {
		this.enterprise_email = enterprise_email;
	}


	@Override
	public String toString() {
		return "Enterprise_introduceVO [enterprise_introduce_no=" + enterprise_introduce_no
				+ ", enterprise_introduce_writer=" + enterprise_introduce_writer + ", enterprise_name="
				+ enterprise_name + ", enterprise_regdate=" + enterprise_regdate + ", enterprise_manager="
				+ enterprise_manager + ", enterprise_location=" + enterprise_location + ", enterprise_regno="
				+ enterprise_regno + ", enterprise_phone=" + enterprise_phone + ", enterprise_email=" + enterprise_email
				+ ", manager_data_filename=" + manager_data_filename + ", getManager_data_filename()="
				+ getManager_data_filename() + ", getEnterprise_introduce_no()=" + getEnterprise_introduce_no()
				+ ", getEnterprise_introduce_writer()=" + getEnterprise_introduce_writer() + ", getEnterprise_name()="
				+ getEnterprise_name() + ", getEnterprise_regdate()=" + getEnterprise_regdate()
				+ ", getEnterprise_manager()=" + getEnterprise_manager() + ", getEnterprise_location()="
				+ getEnterprise_location() + ", getEnterprise_regno()=" + getEnterprise_regno()
				+ ", getEnterprise_phone()=" + getEnterprise_phone() + ", getEnterprise_email()="
				+ getEnterprise_email() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


	public Enterprise_introduceVO(int enterprise_introduce_no, String enterprise_introduce_writer,
			String enterprise_name, String enterprise_regdate, String enterprise_manager, String enterprise_location,
			String enterprise_regno, String enterprise_phone, String enterprise_email, String manager_data_filename) {
		super();
		this.enterprise_introduce_no = enterprise_introduce_no;
		this.enterprise_introduce_writer = enterprise_introduce_writer;
		this.enterprise_name = enterprise_name;
		this.enterprise_regdate = enterprise_regdate;
		this.enterprise_manager = enterprise_manager;
		this.enterprise_location = enterprise_location;
		this.enterprise_regno = enterprise_regno;
		this.enterprise_phone = enterprise_phone;
		this.enterprise_email = enterprise_email;
		this.manager_data_filename = manager_data_filename;
	}

	
	
	
	
	
	
}
