package com.dlms.request;

public class DetailFoundedRequest {

	private int founded_review_no;				// 현재 게시글번호
	private int prevNum;						// 이전 글번호
	private int nextNum;						// 다음 글번호
	private String prevTitle;					// 이전 글제목
	private String nextTitle;					// 이전 글제목
	
	public DetailFoundedRequest() {}

	public int getFounded_review_no() {
		return founded_review_no;
	}

	public void setFounded_review_no(int founded_review_no) {
		this.founded_review_no = founded_review_no;
	}

	public int getPrevNum() {
		return prevNum;
	}

	public void setPrevNum(int prevNum) {
		this.prevNum = prevNum;
	}

	public int getNextNum() {
		return nextNum;
	}

	public void setNextNum(int nextNum) {
		this.nextNum = nextNum;
	}

	public String getPrevTitle() {
		return prevTitle;
	}

	public void setPrevTitle(String prevTitle) {
		this.prevTitle = prevTitle;
	}

	public String getNextTitle() {
		return nextTitle;
	}

	public void setNextTitle(String nextTitle) {
		this.nextTitle = nextTitle;
	}

	@Override
	public String toString() {
		return "DetailFoundedRequest [founded_review_no=" + founded_review_no + ", prevNum=" + prevNum + ", nextNum="
				+ nextNum + ", prevTitle=" + prevTitle + ", nextTitle=" + nextTitle + "]";
	}

}
