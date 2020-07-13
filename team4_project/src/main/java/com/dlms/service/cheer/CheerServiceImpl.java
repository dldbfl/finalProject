package com.dlms.service.cheer;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dlms.dao.cheer.CheerDAO;
import com.dlms.dao.member.MemberDAO;
import com.dlms.dto.CheerVO;
import com.dlms.dto.MemberVO;

public class CheerServiceImpl implements CheerService{

	private CheerDAO cheerDAO;
	public void setCheerDAO(CheerDAO cheerDAO) {
		this.cheerDAO = cheerDAO;
	}
	
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public void insertCheer(CheerVO cheer) throws SQLException {
		int seqNum=cheerDAO.selectCheerSeqNextNum();
		cheer.setCheer_no(seqNum);
		System.out.println("cheer.toString()"+cheer.toString());
		cheerDAO.insertCheerByCheer(cheer);
		
	}
	@Override
	public Map<String, Object> selectCheerListDaily() throws SQLException {
		Date day =new Date();
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		Map<String, Object> dataMap= new HashMap<String, Object>();
		
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
		String today=format.format(day);
		System.out.println("today"+today);
		List<CheerVO> cheerList=cheerDAO.selelctCheerListByDate(today);
		int cheerCnt =0;
		cheerCnt=cheerDAO.selectCheerListAllCnt();
		
		int a=0;
		for(CheerVO cheer : cheerList) {
			
			String writer=null;	
			writer=cheer.getCheer_writer();
			MemberVO member= new MemberVO();
			member=memberDAO.selectMemberById(writer);
			memberList.add(member);
			a++;
		}
		
		dataMap.put("memberList", memberList);
		dataMap.put("cheerList", cheerList);
		dataMap.put("cheerCnt", cheerCnt);
		return dataMap;
	}
	
	
	
}
