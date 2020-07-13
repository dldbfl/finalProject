package com.dlms.service.draft;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dlms.dto.DraftVO;
import com.dlms.dto.Draft_AttachVO;
import com.dlms.request.DraftAttachRequest;
import com.dlms.request.SearchCriteria;

public interface DraftService {

	
	public Map<String, Object> getSearchDraftList(SearchCriteria cri)throws SQLException;
	public Map<String, Object> getSearchDraftOkList(SearchCriteria cri)throws SQLException;
	public Map<String, Object> getSearchDraftNoList(SearchCriteria cri)throws SQLException;
	public Map<String, Object> getSearchDraftPauseList(SearchCriteria cri)throws SQLException;
	public List<DraftVO> getDraftList()throws SQLException;
	public DraftVO getDraftDetail(int draft_no) throws SQLException;
	public List<DraftAttachRequest> getDraftAttachList(int Draft_no) throws SQLException;
	public void writeDraft(DraftVO Draft) throws SQLException;
	public void modifyDraft(DraftVO Draft) throws SQLException;
	public void removeDraft(int Draft_no) throws SQLException;
	public void removeDraftAttach(int draft_Attach_no) throws SQLException;	
	public void modifyDraftStatus(DraftVO draft) throws SQLException;
	public Draft_AttachVO getDraftAttach(int draft_attach_no) throws SQLException;
	public Map<String,Object> getDraftDetailInclude(int draft_no)throws SQLException;
}
