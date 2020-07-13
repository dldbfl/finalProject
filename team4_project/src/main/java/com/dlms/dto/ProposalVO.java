package com.dlms.dto;

import java.util.Date;

/**
 * 
 * @사용목적		:	창업계획서 테이블
 * @작성자		:	박진영
 * @작성날짜      :	2020. 6. 1.
 * @마지막수정자	:	박진영
 * @마지막수정일	:	2020. 6. 1.오후 4:23:09
 * @see			:	
 *
 */
public class ProposalVO {

	

	private int proposal_num           ;// 계획서 번호
	private String proposal_writer        ;// 수강생의 이름
	private String proposal_motivation    ;// 창업 목적 및 배경
	private String proposal_idea          ;// 창업 아이템의 내용 및 특성
	private String proposal_propulsion    ;// 상품개발 및 사업화 목표, 창업 후 추진계획
	private String proposal_market        ;// 매출 실현 가능성, 판로개척 방안등
	private String proposal_funds         ;// 수익 전망 및 손익 분기 예상시기 등
	private String proposal_effect        ;// 사업 성공에 따른 인력 채용 효과 등
	private Date proposal_regdate       ;// 계획서 등록날짜
	private String proposal_title         ;// 계획서 제목
	
	
	public ProposalVO() {
		super();
	}


	public int getProposal_num() {
		return proposal_num;
	}


	public void setProposal_num(int proposal_num) {
		this.proposal_num = proposal_num;
	}


	public String getProposal_writer() {
		return proposal_writer;
	}


	public void setProposal_writer(String proposal_writer) {
		this.proposal_writer = proposal_writer;
	}


	public String getProposal_motivation() {
		return proposal_motivation;
	}


	public void setProposal_motivation(String proposal_motivation) {
		this.proposal_motivation = proposal_motivation;
	}


	public String getProposal_idea() {
		return proposal_idea;
	}


	public void setProposal_idea(String proposal_idea) {
		this.proposal_idea = proposal_idea;
	}


	public String getProposal_propulsion() {
		return proposal_propulsion;
	}


	public void setProposal_propulsion(String proposal_propulsion) {
		this.proposal_propulsion = proposal_propulsion;
	}


	public String getProposal_market() {
		return proposal_market;
	}


	public void setProposal_market(String proposal_market) {
		this.proposal_market = proposal_market;
	}


	public String getProposal_funds() {
		return proposal_funds;
	}


	public void setProposal_funds(String proposal_funds) {
		this.proposal_funds = proposal_funds;
	}


	public String getProposal_effect() {
		return proposal_effect;
	}


	public void setProposal_effect(String proposal_effect) {
		this.proposal_effect = proposal_effect;
	}


	public Date getProposal_regdate() {
		return proposal_regdate;
	}


	public void setProposal_regdate(Date proposal_regdate) {
		this.proposal_regdate = proposal_regdate;
	}


	public String getProposal_title() {
		return proposal_title;
	}


	public void setProposal_title(String proposal_title) {
		this.proposal_title = proposal_title;
	}


	@Override
	public String toString() {
		return "ProposalVO [proposal_num=" + proposal_num + ", proposal_writer=" + proposal_writer
				+ ", proposal_motivation=" + proposal_motivation + ", proposal_idea=" + proposal_idea
				+ ", proposal_propulsion=" + proposal_propulsion + ", proposal_market=" + proposal_market
				+ ", proposal_funds=" + proposal_funds + ", proposal_effect=" + proposal_effect + ", proposal_regdate="
				+ proposal_regdate + ", proposal_title=" + proposal_title + "]";
	}


	public ProposalVO(int proposal_num, String proposal_writer, String proposal_motivation, String proposal_idea,
			String proposal_propulsion, String proposal_market, String proposal_funds, String proposal_effect,
			Date proposal_regdate, String proposal_title) {
		super();
		this.proposal_num = proposal_num;
		this.proposal_writer = proposal_writer;
		this.proposal_motivation = proposal_motivation;
		this.proposal_idea = proposal_idea;
		this.proposal_propulsion = proposal_propulsion;
		this.proposal_market = proposal_market;
		this.proposal_funds = proposal_funds;
		this.proposal_effect = proposal_effect;
		this.proposal_regdate = proposal_regdate;
		this.proposal_title = proposal_title;
	}

	
	
	
	
}
