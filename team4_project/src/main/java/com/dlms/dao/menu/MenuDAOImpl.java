package com.dlms.dao.menu;

import org.apache.ibatis.session.SqlSession;

public class MenuDAOImpl {
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
