package com.dlms.dao.draft;

import java.sql.SQLException;
import java.util.List;

import com.dlms.dto.DraftVO;
import com.dlms.dto.Draft_AttachVO;
import com.dlms.request.DraftAttachRequest;
import com.dlms.request.SearchCriteria;

public interface DraftDAO {

	public List<DraftVO> selectDraftList()throws SQLException;
	public List<DraftVO> selectSearchDraftList(SearchCriteria cri)throws SQLException;
	public List<DraftVO> selectSearchDraftOkList(SearchCriteria cri)throws SQLException;
	public List<DraftVO> selectSearchDraftNoList(SearchCriteria cri)throws SQLException;
	public List<DraftVO> selectSearchDraftPauseList(SearchCriteria cri)throws SQLException;
	public int selectDraftListCount() throws SQLException;
	public DraftVO selectDraftDetail(int Draft_no) throws SQLException;
	public DraftVO selectDraftDetailBylno(int lecture_data_no) throws SQLException;
	public List<DraftAttachRequest> selectDraftAttachList(int Draft_no) throws SQLException;
	public Draft_AttachVO selectDraftAttach(int draft_attach_no) throws SQLException;
	public void insertDraft(DraftVO Draft) throws SQLException;
	public void insertDraftAttach(Draft_AttachVO Draft_Attach) throws SQLException;
	public void updateDraft(DraftVO Draft) throws SQLException;
	public void updateDraftAttach(Draft_AttachVO Draft_Attach) throws SQLException;
	public void deleteDraft(int Draft_no) throws SQLException;
	public void deleteDraftAttach(int Draft_Attach_no) throws SQLException;
	public int selectDraftSeqNext() throws SQLException;
	public int selectDraftAttachSeqNext () throws SQLException;
	public void updateDraftApproved(DraftVO Draft) throws SQLException;
	public void updateDraftApproved_pause_no(DraftVO Draft) throws SQLException;
}
