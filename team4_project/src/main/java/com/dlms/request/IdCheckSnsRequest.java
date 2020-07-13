package com.dlms.request;

import com.dlms.dto.MemberVO;

public class IdCheckSnsRequest {
	
	private String id;
	private String name;
	private String hp;

	public IdCheckSnsRequest() {}
	
	public IdCheckSnsRequest(String id,String name, String hp) {
		super();
		this.id = id;
		this.name = name;
		this.hp = hp;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}

	@Override
	public String toString() {
		return "IdCheckSnsRequest [+id=" + id +", name=" + name + ", hp=" + hp +"]";
	}
	
	public MemberVO tomember() {
		MemberVO member = new MemberVO();
		member.setMember_id(id);
		member.setMember_name(name);
		member.setMember_phone(hp);		
		return member;
	}
}
