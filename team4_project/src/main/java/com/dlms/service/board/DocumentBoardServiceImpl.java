package com.dlms.service.board;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dlms.dao.board.DocumentBoardDAO;
import com.dlms.dto.DocumentVO;
import com.dlms.dto.Document_dataVO;
import com.dlms.request.PageMaker;
import com.dlms.request.SearchCriteria;

/**
 * 
 * @사용목적		:	문서관련 서비스
 * @작성자		:	민태홍
 * @작성날짜      	:	2020. 6. 2.
 * @마지막수정자	:	민태홍
 * @마지막수정일	:	2020. 6. 2.오후 4:38:23
 * @see			:	
 *
 */
public class DocumentBoardServiceImpl implements DocumentBoardService {
	
	private DocumentBoardDAO documentBoardDAO;
	public void setDocumentBoardDAO(DocumentBoardDAO documentBoardDAO) {
		this.documentBoardDAO = documentBoardDAO;
	}
	
	/**
	 * 
	 * @기능설명		:	문서검색 서비스
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오후 4:38:55
	 * @see			:	DocumentBoardService
	 * @param cri
	 * @return dataMap
	 * @throws SQLException
	 *
	 */
	@Override
	public Map<String, Object> getDocumentList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		List<DocumentVO> document = documentBoardDAO.selectSearchDocumentList(cri);
		List<Document_dataVO> dataList = new ArrayList<Document_dataVO>();
		List<Integer> dnoList = new ArrayList<Integer>();
		for(int i =0; i < document.size(); i++) {
			dnoList.add(document.get(i).getDocument_no());
			dataList.addAll(documentBoardDAO.selectdocumentDataList(dnoList.get(i)));
			document.get(i).setDocument_dataVO(dataList.get(i));
		}
		int totalCount = documentBoardDAO.selectdocumentListCount();
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("document", document);
		dataMap.put("pageMaker", pageMaker);
		return dataMap;
	}
	
	/**
	 * 
	 * @기능설명		:	문서리스트 서비스
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오후 4:39:16
	 * @see			:	X
	 * @return document
	 * @throws SQLException
	 *
	 */
	@Override
	public List<DocumentVO> getDocumentList() throws SQLException {
		List<DocumentVO> document = documentBoardDAO.selectDocumentList();
		return document;
	}
	
	/**
	 * 
	 * @기능설명		:	문서상세 출력
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오후 4:40:15
	 * @see			:	X
	 * @param document_no
	 * @return document
	 * @throws SQLException
	 *
	 */
	@Override
	public DocumentVO getDocumenDetail(int document_no) throws SQLException {
		DocumentVO document =  documentBoardDAO.selectDocumenDetail(document_no);
		List<Document_dataVO> data = documentBoardDAO.selectdocumentDataList(document_no);
		String fileName = data.get(0).getDocument_data_filename();
		String originalName = fileName.substring(fileName.lastIndexOf("$$")+2);
		document.setDocument_dataVO(data.get(0));
		document.setOriginalName(originalName);
		return document;
	}
	
	/**
	 * 
	 * @기능설명		:	문서작성
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오후 4:40:34
	 * @see			:	X
	 * @param document
	 * @throws SQLException
	 *
	 */
	@Override
	public void writeDocument(DocumentVO document) throws SQLException {
		
		int document_no = documentBoardDAO.selectdocumentSeqNext();
		document.setDocument_no(document_no);
		documentBoardDAO.insertdocument(document);
		
		if(document.getDocument_dataVO() !=null) {
				Document_dataVO data = document.getDocument_dataVO();
				data.setDocument_no(document_no);
				int document_data_no = documentBoardDAO.selectdocumentDataSeqNext();
				data.setDocument_data_no(document_data_no);
				documentBoardDAO.insertdocumentData(data);
			
		}	
	}
	
	/**
	 * 
	 * @기능설명		:	문서 수정
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오후 4:41:21
	 * @see			:	X
	 * @param document
	 * @throws SQLException
	 *
	 */
	@Override
	public void modifyDocument(DocumentVO document) throws SQLException {
		documentBoardDAO.updatedocument(document);

		if(document.getDocument_dataVO() !=null) {
			
			Document_dataVO data = document.getDocument_dataVO();
			data.setDocument_no(document.getDocument_no());
			int document_data_no = documentBoardDAO.selectdocumentDataSeqNext();
			data.setDocument_data_no(document_data_no);
			documentBoardDAO.insertdocumentData(data);	
		}		
	}

	/**
	 * 
	 * @기능설명		:	문서 삭제
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오후 4:42:01
	 * @see			:	X
	 * @param document_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void removeDocument(int document_no) throws SQLException {
		
		List<Document_dataVO> data = documentBoardDAO.selectdocumentDataList(document_no);
		
		String path = data.get(0).getDocument_data_path();
		String name =  data.get(0).getDocument_data_filename();
		
		File file = new File(path+name);
		file.delete();
		documentBoardDAO.deletedocument(document_no);
		
	}
	
	/**
	 * 
	 * @기능설명		:	문서 첨부파일 삭제
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오후 4:42:09
	 * @see			:	X
	 * @param document_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void removeDocumentData(int document_no) throws SQLException {
		List<Document_dataVO> data = documentBoardDAO.selectdocumentDataList(document_no);
		
		File file = new File(data.get(0).getDocument_data_path() + data.get(0).getDocument_data_filename());
		file.delete();
		
		documentBoardDAO.deletedocumentData(data.get(0).getDocument_data_no());
	}

}
