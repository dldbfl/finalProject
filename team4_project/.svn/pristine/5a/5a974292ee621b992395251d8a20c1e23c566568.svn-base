package com.dlms.service.board;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dlms.dto.DocumentVO;
import com.dlms.dto.Document_dataVO;
import com.dlms.request.SearchCriteria;

public interface DocumentBoardService {

	public Map<String, Object> getDocumentList(SearchCriteria cri)throws SQLException;
	public List<DocumentVO> getDocumentList()throws SQLException;
	/**
	 * 
	 *
	 * @기능설명		:	문서 번호에 따른 문서 정보 가져오기
	 * @작성자		:	강현철
	 * @작성날짜		:	2020. 6. 26.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 26.오전 1:16:30
	 * @param 		:	document_no(문서번호)
	 * @return		:	해당문서정보
	 * @throws 		:	SQLException
	 */
	public DocumentVO getDocumenDetail(int document_no) throws SQLException;
	public void writeDocument(DocumentVO document) throws SQLException;
	public void modifyDocument(DocumentVO document) throws SQLException;
	public void removeDocument(int document_no) throws SQLException;
	public void removeDocumentData(int document_data_no) throws SQLException;

}
