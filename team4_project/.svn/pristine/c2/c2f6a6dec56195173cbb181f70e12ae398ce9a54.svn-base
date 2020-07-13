package com.dlms.dao.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dlms.dto.DocumentVO;
import com.dlms.dto.Document_dataVO;
import com.dlms.request.SearchCriteria;

/**
 * 
 * @사용목적		:	문서를 처리하는 DAO
 * @작성자		:	민태홍
 * @작성날짜      	:	2020. 6. 2.
 * @마지막수정자	:	민태홍
 * @마지막수정일	:	2020. 6. 2.오전 10:36:07
 * @see			:	X
 *
 */
public class DocumentBoardDAOImpl implements DocumentBoardDAO{
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	/**
	 * 
	 * @기능설명		:	문서 리스트 출력
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:37:34
	 * @see			:	X
	 * @param cri
	 * @return documentList
	 * @throws SQLException
	 *
	 */
	@Override
	public List<DocumentVO> selectSearchDocumentList(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();		
		int limit=cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		List<DocumentVO> documentList = new ArrayList<DocumentVO>();
		documentList = sqlSession.selectList("document-mapper.selectSearchDocumentList",cri,rowBounds);
		return documentList;
	}
	
	/**
	 * 
	 * @기능설명		:	문서 리스트 출력
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:37:34
	 * @see			:	X
	 * @param X
	 * @return documentList
	 * @throws SQLException
	 *
	 */
	@Override
	public List<DocumentVO> selectDocumentList() throws SQLException {
		List<DocumentVO> documentList = new ArrayList<DocumentVO>();
		documentList = sqlSession.selectList("document-mapper.selectDocumentList");
		return documentList;
	}
	
	/**
	 * 
	 * @기능설명		:	문서 상세정보
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:37:34
	 * @see			:	X
	 * @param cri
	 * @return document
	 * @throws SQLException
	 *
	 */
	@Override
	public DocumentVO selectDocumenDetail(int document_no) throws SQLException {
		DocumentVO document = sqlSession.selectOne("document-mapper.selectDocumenDetail",document_no);
		
		return document;
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
	public int selectdocumentListCount() throws SQLException {
		int count = sqlSession.selectOne("document-mapper.selectdocumentListCount");
		return count;
	}
	
	/**
	 * 
	 * @기능설명		:	문서자료리스트 출력
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:41:07
	 * @see			:	X
	 * @param cri
	 * @return document_dataList
	 * @throws SQLException
	 *
	 */
	@Override
	public List<Document_dataVO> selectdocumentDataList(int document_no) throws SQLException {
		
		List<Document_dataVO> document_dataList = new ArrayList<Document_dataVO>();
		document_dataList = sqlSession.selectList("document-mapper.selectdocumentDataList",document_no);
		return document_dataList;
	}
	
	/**
	 * 
	 * @기능설명		:	문서등록
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:42:40
	 * @see			:	X
	 * @param document
	 * @throws SQLException
	 *
	 */
	@Override
	public void insertdocument(DocumentVO document) throws SQLException {
		sqlSession.update("document-mapper.insertdocument",document);
		
	}
	
	/**
	 * 
	 * @기능설명		:	문서 자료 첨부
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:42:55
	 * @see			:	X
	 * @param document_data
	 * @throws SQLException
	 *
	 */
	@Override
	public void insertdocumentData(Document_dataVO document_data) throws SQLException {
		sqlSession.update("document-mapper.insertdocumentData",document_data);
		
	}
	
	/**
	 * 
	 * @기능설명		:	문서 수정
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:43:05
	 * @see			:	X
	 * @param document
	 * @throws SQLException
	 *
	 */
	@Override
	public void updatedocument(DocumentVO document) throws SQLException {
		sqlSession.update("document-mapper.updatedocument",document);
		
	}
	
	/**
	 * 
	 * @기능설명		:	문서 첨부자료 수정
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:43:18
	 * @see			:	X
	 * @param document_data
	 * @throws SQLException
	 *
	 */
	@Override
	public void updatedocumentData(Document_dataVO document_data) throws SQLException {
		sqlSession.update("document-mapper.updatedocumentData",document_data);
		
	}
	
	/**
	 * 
	 * @기능설명		:	문서 삭제
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:43:42
	 * @see			:	X
	 * @param document_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void deletedocument(int document_no) throws SQLException {
		sqlSession.delete("document-mapper.deletedocument",document_no);
		
	}
	
	/**
	 * 
	 * @기능설명		:	문서 첨부자료 삭제
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:47:55
	 * @see			:	X
	 * @param document_data_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void deletedocumentData(int document_data_no) throws SQLException {
		sqlSession.delete("document-mapper.deletedocumentData",document_data_no);
		
	}
	
	/**
	 * 
	 * @기능설명		:	문서 번호를 생성한다.
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:43:52
	 * @see			:	X
	 * @return document_no
	 * @throws SQLException
	 *
	 */
	@Override
	public int selectdocumentSeqNext() throws SQLException {
		int document_no = sqlSession.selectOne("document-mapper.selectdocumentSeqNext");
		return document_no;
	}
	
	/**
	 * 
	 * @기능설명		:	문서 첨부자료 번호를 생성한다.
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오전 10:48:37
	 * @see			:	X
	 * @return document_data_no
	 * @throws SQLException
	 *
	 */
	@Override
	public int selectdocumentDataSeqNext() throws SQLException {
		int document_data_no = sqlSession.selectOne("document-mapper.selectdocumentDataSeqNext");
		return document_data_no;
	}

}
