package com.dlms.request;

public class MessageRequest {

	private int page; 			// 페이지 번호
	private int perPageNum; 	// 한페이지당 리스트개수
	private String searchType;	// 검색구분
	private String keyword; 	// 검색어
	private String id;
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public SearchCriteria toCri() {
		SearchCriteria cri = new SearchCriteria();
		
		cri.setKeyword(this.keyword);
		cri.setPage(this.page);
		cri.setPerPageNum(this.perPageNum);
		cri.setSearchType(this.searchType);
		
		return cri;
		
	}
	
}
