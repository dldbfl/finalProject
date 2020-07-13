package com.dlms.dao.cheer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dlms.dto.CheerVO;

public class CheerDAOImpl implements CheerDAO{

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<CheerVO> selectCheerListAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CheerVO> selelctCheerListByDate(String searchDate) throws SQLException {
		List<CheerVO> cheerList= new ArrayList<CheerVO>();
		cheerList=sqlSession.selectList("cheer-mapper.selelctCheerListByDate",searchDate);
		return cheerList;
	}

	@Override
	public void insertCheerByCheer(CheerVO cheer) throws SQLException {
		sqlSession.update("cheer-mapper.insertCheerByCheer",cheer);
	}

	@Override
	public int selectCheerSeqNextNum() throws SQLException {
		int seqNum=0;
		seqNum=sqlSession.selectOne("cheer-mapper.selectCheerSeqNextNum",null);
		return seqNum;
	}

	@Override
	public int selectCheerListAllCnt() throws SQLException {
		int totalCnt =0;
		totalCnt=sqlSession.selectOne("cheer-mapper.selectCheerListAllCnt",null);
		return totalCnt;
	}

}
