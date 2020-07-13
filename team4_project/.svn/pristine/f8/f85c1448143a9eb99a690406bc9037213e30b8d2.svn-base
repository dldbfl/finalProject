package com.dlms.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.dlms.dto.DocumentVO;
import com.dlms.dto.Document_dataVO;
import com.dlms.request.SearchCriteria;

public interface DocumentBoardDAO {

	public List<DocumentVO> selectSearchDocumentList(SearchCriteria cri)throws SQLException;
	public int selectdocumentListCount() throws SQLException;
	public List<DocumentVO> selectDocumentList()throws SQLException;
	public DocumentVO selectDocumenDetail(int document_no) throws SQLException;
	public List<Document_dataVO> selectdocumentDataList(int document_no) throws SQLException;
	public void insertdocument(DocumentVO document) throws SQLException;
	public void insertdocumentData(Document_dataVO document_data) throws SQLException;
	public void updatedocument(DocumentVO document) throws SQLException;
	public void updatedocumentData(Document_dataVO document_data) throws SQLException;
	public void deletedocument(int document_no) throws SQLException;
	public void deletedocumentData(int document_data_no) throws SQLException;
	public int selectdocumentSeqNext() throws SQLException;
	public int selectdocumentDataSeqNext () throws SQLException;
}
