package com.dlms.dao.draft;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dlms.dto.DraftVO;
import com.dlms.dto.Draft_AttachVO;
import com.dlms.request.DraftAttachRequest;
import com.dlms.request.SearchCriteria;

/**
 * 
 * @사용목적		:	기안서를 처리하는 DAO
 * @작성자		:	민태홍
 * @작성날짜      	:	2020. 6. 2.
 * @마지막수정자	:	민태홍
 * @마지막수정일	:	2020. 6. 2.오전 10:36:07
 * @see			:	X
 *
 */
public class DraftDAOImpl implements DraftDAO{
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	/**
	 * 
	 * @기능설명		:	기안서 리스트 출력
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:37:34
	 * @see			:	X
	 * @param cri
	 * @return DraftList
	 * @throws SQLException
	 *
	 */
	@Override
	public List<DraftVO> selectSearchDraftList(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();		
		int limit=cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		List<DraftVO> DraftList = new ArrayList<DraftVO>();
		DraftList = sqlSession.selectList("draft-mapper.selectSearchDraftList",cri,rowBounds);
		return DraftList;
	}
	/**
	 * 
	 * @기능설명		:	기안서 결재 승인 리스트 출력
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 12.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 12.오후 5:08:01
	 * @see			    :	-
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public List<DraftVO> selectSearchDraftOkList(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();		
		int limit=cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		List<DraftVO> DraftList = new ArrayList<DraftVO>();
		DraftList = sqlSession.selectList("draft-mapper.selectSearchDraftOkList",cri,rowBounds);
		return DraftList;
	}
	/**
	 * 
	 * @기능설명		:	기안서 결재 반려 리스트 출력
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 12.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 12.오후 5:08:12
	 * @see			    :	-
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public List<DraftVO> selectSearchDraftNoList(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();		
		int limit=cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		List<DraftVO> DraftList = new ArrayList<DraftVO>();
		DraftList = sqlSession.selectList("draft-mapper.selectSearchDraftNoList",cri,rowBounds);
		return DraftList;
	}
	/**
	 * 
	 * @기능설명		:	기안서 결재 대기 리스트 출력
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 12.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 12.오후 5:08:23
	 * @see			    :	-
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public List<DraftVO> selectSearchDraftPauseList(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();		
		int limit=cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		List<DraftVO> DraftList = new ArrayList<DraftVO>();
		DraftList = sqlSession.selectList("draft-mapper.selectSearchDraftPauseList",cri,rowBounds);
		return DraftList;
	}
	
	
	/**
	 * 
	 * @기능설명		:	기안서 리스트 출력
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:37:34
	 * @see			:	X
	 * @param X
	 * @return DraftList
	 * @throws SQLException
	 *
	 */
	@Override
	public List<DraftVO> selectDraftList() throws SQLException {
		List<DraftVO> DraftList = new ArrayList<DraftVO>();
		DraftList = sqlSession.selectList("draft-mapper.selectDraftList");
		return DraftList;
	}
	
	/**
	 * 
	 * @기능설명		:	기안서 상세정보
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:37:34
	 * @see			:	X
	 * @param cri
	 * @return Draft
	 * @throws SQLException
	 *
	 */
	@Override
	public DraftVO selectDraftDetail(int Draft_no) throws SQLException {
		DraftVO Draft = sqlSession.selectOne("draft-mapper.selectDraftDetail",Draft_no);
		
		return Draft;
	}
	
	/**
	 * 
	 * @기능설명		:	자료리스트에 페이지 달기위한 장치
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:38:59
	 * @see			:	X
	 * @return X
	 * @throws count
	 *
	 */
	@Override
	public int selectDraftListCount() throws SQLException {
		int count = sqlSession.selectOne("draft-mapper.selectDraftListCount");
		return count;
	}
	
	/**
	 * 
	 * @기능설명		:	기안서자료리스트 출력
	 * @작성자			:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 30.오전 10:41:07
	 * @see			:	X
	 * @param cri
	 * @return Draft_AttachList
	 * @throws SQLException
	 *
	 */
	@Override
	public List<DraftAttachRequest> selectDraftAttachList(int Draft_no) throws SQLException {
		
		List<DraftAttachRequest> Draft_AttachList = new ArrayList<DraftAttachRequest>();
		Draft_AttachList = sqlSession.selectList("draft-mapper.selectDraftAttachList",Draft_no);
		return Draft_AttachList;
	}
	
	@Override
	public Draft_AttachVO selectDraftAttach(int draft_attach_no) throws SQLException {
		
		Draft_AttachVO Draft_Attach = new Draft_AttachVO();
		Draft_Attach = sqlSession.selectOne("draft-mapper.selectDraftAttach",draft_attach_no);
		return Draft_Attach;
	}
	
	/**
	 * 
	 * @기능설명		:	기안서등록
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:42:40
	 * @see			:	X
	 * @param Draft
	 * @throws SQLException
	 *
	 */
	@Override
	public void insertDraft(DraftVO Draft) throws SQLException {
		sqlSession.update("draft-mapper.insertDraft",Draft);
		
	}
	
	/**
	 * 
	 * @기능설명		:	기안서 자료 첨부
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:42:55
	 * @see			:	X
	 * @param Draft_Attach
	 * @throws SQLException
	 *
	 */
	@Override
	public void insertDraftAttach(Draft_AttachVO Draft_Attach) throws SQLException {
		sqlSession.update("draft-mapper.insertDraftAttach",Draft_Attach);
		
	}
	
	/**
	 * 
	 * @기능설명		:	기안서 수정
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:43:05
	 * @see			:	X
	 * @param Draft
	 * @throws SQLException
	 *
	 */
	@Override
	public void updateDraft(DraftVO Draft) throws SQLException {
		sqlSession.update("draft-mapper.updateDraft",Draft);
		
	}
	
	/**
	 * 
	 * @기능설명		:	기안서 첨부자료 수정
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:43:18
	 * @see			:	X
	 * @param Draft_Attach
	 * @throws SQLException
	 *
	 */
	@Override
	public void updateDraftAttach(Draft_AttachVO Draft_Attach) throws SQLException {
		sqlSession.update("draft-mapper.updateDraftAttach",Draft_Attach);
		
	}
	
	/**
	 * 
	 * @기능설명		:	기안서 삭제
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:43:42
	 * @see			:	X
	 * @param Draft_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void deleteDraft(int Draft_no) throws SQLException {
		sqlSession.delete("draft-mapper.deleteDraft",Draft_no);
		
	}
	
	/**
	 * 
	 * @기능설명		:	기안서 첨부자료 삭제
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:47:55
	 * @see			:	X
	 * @param Draft_Attach_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void deleteDraftAttach(int Draft_Attach_no) throws SQLException {
		sqlSession.delete("draft-mapper.deleteDraftAttach",Draft_Attach_no);
		
	}
	
	/**
	 * 
	 * @기능설명		:	기안서 번호를 생성한다.
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:43:52
	 * @see			:	X
	 * @return Draft_no
	 * @throws SQLException
	 *
	 */
	@Override
	public int selectDraftSeqNext() throws SQLException {
		int Draft_no = sqlSession.selectOne("draft-mapper.selectDraftSeqNext");
		return Draft_no;
	}
	
	/**
	 * 
	 * @기능설명		:	기안서 첨부자료 번호를 생성한다.
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:48:37
	 * @see			:	X
	 * @return Draft_Attach_no
	 * @throws SQLException
	 *
	 */
	@Override
	public int selectDraftAttachSeqNext() throws SQLException {
		int Draft_Attach_no = sqlSession.selectOne("draft-mapper.selectDraftAttachSeqNext");
		return Draft_Attach_no;
	}
	
	/**
	 * 
	 * @기능설명		:	관리자 - 기안서 승인 상태를 수정한다.
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 10.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 10.오후 2:48:39
	 * @see			    :	-
	 * @param Draft
	 * @throws SQLException
	 *
	 */
	@Override
	public void updateDraftApproved(DraftVO Draft) throws SQLException {
		sqlSession.update("draft-mapper.updateDraftApproved",Draft);
		
	}
	/**
	 * 
	 * @기능설명		:	관리자 - 기안서 반려,대기 상태를 수정한다.
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 12.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 12.오후 5:09:46
	 * @see			    :	-
	 * @param Draft
	 * @throws SQLException
	 *
	 */
	@Override
	public void updateDraftApproved_pause_no(DraftVO Draft) throws SQLException {
		sqlSession.update("draft-mapper.updateDraftApproved_pause_no",Draft);
		
	}

	@Override
	public DraftVO selectDraftDetailBylno(int lecture_data_no) throws SQLException {
		DraftVO draft = sqlSession.selectOne("draft-mapper.selectDraftDetailBylno",lecture_data_no);
		return draft;
	}
	
	
}
