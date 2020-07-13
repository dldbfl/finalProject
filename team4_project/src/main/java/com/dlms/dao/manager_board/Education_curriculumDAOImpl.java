package com.dlms.dao.manager_board;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;

import com.dlms.dto.Enterprise_introduceVO;
import com.dlms.dto.Manager_boardVO;
import com.dlms.dto.Manager_dataVO;
import com.dlms.request.Enterprise_introduceRequest;
 
public class Education_curriculumDAOImpl implements Education_curriculumDAO{
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	/**
	 * 
	 * @기능설명		:	관리자 게시판 - 교육과정 조회
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 9.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 9.오후 2:12:00
	 * @see			    :	-
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public Manager_boardVO selectManager_board_Education_curriculum(int manager_board_no) throws SQLException {		
		Manager_boardVO manager_board =null;
		manager_board = sqlSession.selectOne("manager_board-mapper.selectManager_board",manager_board_no);
		return manager_board;
	}
	
	/**
	 * 
	 * @기능설명		:	관리자 게시판 - 교육과정 수정
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 9.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 9.오후 11:05:47
	 * @see			    :	-
	 * @param manager_board
	 * @throws SQLException
	 *
	 */
	@Override
	public void updateManager_board_education_curriculum(Manager_boardVO manager_board) throws SQLException {
		sqlSession.update("manager_board-mapper.updateManager_board_education_curriculum",manager_board);
		
	}
	
	/**
	 * 
	 * @기능설명		:	관리자게시판 - 이미지 조회
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 9.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 9.오후 1:52:48
	 * @see			    :	-
	 * @param manager_board_no
	 * @return
	 * @throws SqlSessionException
	 *
	 */
	@Override
	public String selectManager_board_getimage(int manager_board_no) throws SqlSessionException {
		//int manager_data_filename = sqlSession.selectOne("enterprise_introduce-mapper.updateEnterprise_introduce",enterprise_introduce_no);
		String manager_data_filename = sqlSession.selectOne("manager_board-mapper.selectManager_board_getimage",manager_board_no);
		return manager_data_filename;
	}

	/**
	 * 
	 * @기능설명		:	관리자 게시판 - 이미지 수정
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 9.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 9.오후 1:53:02
	 * @see			    :	-
	 * @param manager_board
	 * @throws SQLException
	 *
	 */
	@Override
	public void updateManager_board_Manager_data_filename(Manager_boardVO manager_board) throws SQLException {
		sqlSession.update("manager_board-mapper.updateManager_board_Manager_data_filename",manager_board);
		
	}
	

	
	
}
