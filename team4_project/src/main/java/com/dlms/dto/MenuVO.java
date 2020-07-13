package com.dlms.dto;
/**
 * 
 * @사용목적		:	메뉴구조 테이블	
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	박진영
 * @마지막수정일	:	2020. 6. 1.오후 4:15:40
 * @see			:	
 *
 */
public class MenuVO {

	private String menu_code; 		// 메뉴의 코드
	private String menu_name; 		// 메뉴의 이름
	private String menu_url; 		// 메뉴의 URL주소
	private String menu_iconfile; 	// 메뉴가 갖고있는 아이콘파일
	private String menu_upcode; 	// 메뉴의 상위코드
	private int menu_enable; 		// 메뉴의 활성화 = 1, 비활성화 = 0
	private int menu_iscategory; 	// 카테고리가 달려있으면 1, 없으면 0 보통 하위코드는 갖고 있지 않댜
	private int menu_codelevel; 	// 메뉴의 단계 구조 레벨
	private String menu_script; 	// 메뉴가 갖고 있는 스크립트

	public String getMenu_code() {
		return menu_code;
	}

	public void setMenu_code(String menu_code) {
		this.menu_code = menu_code;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getMenu_url() {
		return menu_url;
	}

	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}

	public String getMenu_iconfile() {
		return menu_iconfile;
	}

	public void setMenu_iconfile(String menu_iconfile) {
		this.menu_iconfile = menu_iconfile;
	}

	public String getMenu_upcode() {
		return menu_upcode;
	}

	public void setMenu_upcode(String menu_upcode) {
		this.menu_upcode = menu_upcode;
	}

	public int getMenu_enable() {
		return menu_enable;
	}

	public void setMenu_enable(int menu_enable) {
		this.menu_enable = menu_enable;
	}

	public int getMenu_iscategory() {
		return menu_iscategory;
	}

	public void setMenu_iscategory(int menu_iscategory) {
		this.menu_iscategory = menu_iscategory;
	}

	public int getMenu_codelevel() {
		return menu_codelevel;
	}

	public void setMenu_codelevel(int menu_codelevel) {
		this.menu_codelevel = menu_codelevel;
	}

	public String getMenu_script() {
		return menu_script;
	}

	public void setMenu_script(String menu_script) {
		this.menu_script = menu_script;
	}

	@Override
	public String toString() {
		return "MenuVO [menu_code=" + menu_code + ", menu_name=" + menu_name + ", menu_url=" + menu_url
				+ ", menu_iconfile=" + menu_iconfile + ", menu_upcode=" + menu_upcode + ", menu_enable=" + menu_enable
				+ ", menu_iscategory=" + menu_iscategory + ", menu_codelevel=" + menu_codelevel + ", menu_script="
				+ menu_script + "]";
	}

	public MenuVO(String menu_code, String menu_name, String menu_url, String menu_iconfile, String menu_upcode,
			int menu_enable, int menu_iscategory, int menu_codelevel, String menu_script) {
		super();
		this.menu_code = menu_code;
		this.menu_name = menu_name;
		this.menu_url = menu_url;
		this.menu_iconfile = menu_iconfile;
		this.menu_upcode = menu_upcode;
		this.menu_enable = menu_enable;
		this.menu_iscategory = menu_iscategory;
		this.menu_codelevel = menu_codelevel;
		this.menu_script = menu_script;
	}

}
