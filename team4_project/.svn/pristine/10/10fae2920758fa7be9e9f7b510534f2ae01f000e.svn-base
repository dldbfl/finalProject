package com.dlms.request;
/**
 * 
 * @사용목적		:	게시판 등의 검색 기능이 필요할때 사용
 * @작성자		:	강현철
 * @작성날짜      	:	2020. 6. 1.
 * @마지막수정자	:	강현철
 * @마지막수정일	:	2020. 6. 1.오후 3:05:50
 *
 */
public class SearchCriteria {
	
	private int page; 			// 페이지 번호
	private int perPageNum; 	// 한페이지당 리스트개수
	private String searchType;	// 검색구분
	private String keyword; 	// 검색어
	
	
	public SearchCriteria() {
		this.page = 1;
		this.perPageNum = 10;
		this.searchType="";
		this.keyword="";
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getPerPageNum() {
		return perPageNum;
	}


	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}


	public String getSearchType() {
		return searchType;
	}


	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	/**
	 * 
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 1.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 1.오후 3:04:09
	 * @return		:	int 각페이지마다 시작하는 행번호
	 *
	 */
	public int getPageStartRowNum(){
		return (this.page-1)*perPageNum;
	}

}