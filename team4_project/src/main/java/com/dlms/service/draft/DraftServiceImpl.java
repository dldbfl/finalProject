package com.dlms.service.draft;

import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.dlms.dao.draft.DraftDAO;
import com.dlms.dao.lecture.LectureDAO;
import com.dlms.dao.member.MemberDAO;
import com.dlms.dto.DraftVO;
import com.dlms.dto.Draft_AttachVO;
import com.dlms.dto.Lecture_dataVO;
import com.dlms.dto.MemberVO;
import com.dlms.request.DraftAttachRequest;
import com.dlms.request.PageMaker;
import com.dlms.request.SearchCriteria;

import freemarker.template.SimpleDate;

public class DraftServiceImpl implements DraftService{
	
	@Autowired
	private DraftDAO draftDAO;
	public void setDraftDAO(DraftDAO draftDAO) {
		this.draftDAO = draftDAO;
	}
	
	@Autowired
	private LectureDAO lectureDAO;
	public void setLectureDAO(LectureDAO lectureDAO) {
		this.lectureDAO = lectureDAO;
	}
	
	@Autowired
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Resource(name="draft_attachPath")
	String draft_path;
	
	
	/**
	 * 
	 * @기능설명		:	기안서검색 서비스
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오후 4:38:55
	 * @see			:	draftService
	 * @param cri
	 * @return AttachMap
	 * @throws SQLException
	 *
	 */
	@Override
	public Map<String, Object> getSearchDraftList(SearchCriteria cri) throws SQLException {
		Map<String, Object> AttachMap = new HashMap<String, Object>();
		List<String> nameList = new ArrayList<String>();		
		List<DraftVO> draft = draftDAO.selectSearchDraftList(cri);		
		List<MemberVO> member = new ArrayList<MemberVO>(); 
		
		for(int i = 0 ; i< draft.size(); i++) {
			System.out.println(i + draft.get(i).getProfessor_id());
			 member = memberDAO.selectMemberListById(draft.get(i).getProfessor_id());	
			 nameList.add(member.get(0).getMember_name());
		}		
		
		
		int totalCount = draftDAO.selectDraftListCount();
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		AttachMap.put("draft", draft);
		AttachMap.put("nameList", nameList);
		AttachMap.put("pageMaker", pageMaker);
		
		System.out.println("AttachMap.get(draft) : "+AttachMap.get("draft"));
		System.out.println("AttachMap.get(nameList) : "+AttachMap.get("nameList"));
		return AttachMap;
		
	}
	/**
	 * 
	 * @기능설명		:	기안서 결재 승인 리스트
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 12.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 12.오후 5:06:23
	 * @see			    :	-
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	public Map<String, Object> getSearchDraftOkList(SearchCriteria cri) throws SQLException {
		Map<String, Object> AttachMap = new HashMap<String, Object>();
		List<String> nameList = new ArrayList<String>();		
		List<DraftVO> draft = draftDAO.selectSearchDraftOkList(cri);		
		List<MemberVO> member = new ArrayList<MemberVO>(); 
		
		for(int i = 0 ; i< draft.size(); i++) {
			System.out.println(i + draft.get(i).getProfessor_id());
			 member = memberDAO.selectMemberListById(draft.get(i).getProfessor_id());	
			 nameList.add(member.get(0).getMember_name());
		}		
		
		
		int totalCount = draftDAO.selectDraftListCount();
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		AttachMap.put("draft", draft);
		AttachMap.put("nameList", nameList);
		AttachMap.put("pageMaker", pageMaker);
		
		System.out.println("AttachMap.get(draft) : "+AttachMap.get("draft"));
		System.out.println("AttachMap.get(nameList) : "+AttachMap.get("nameList"));
		return AttachMap;
		
	}
	
	/**
	 * 
	 * @기능설명		:	기안서 결재 반려 리스트
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 12.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 12.오후 5:06:43
	 * @see			    :	-
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	public Map<String, Object> getSearchDraftNoList(SearchCriteria cri) throws SQLException {
		Map<String, Object> AttachMap = new HashMap<String, Object>();
		List<String> nameList = new ArrayList<String>();		
		List<DraftVO> draft = draftDAO.selectSearchDraftNoList(cri);		
		List<MemberVO> member = new ArrayList<MemberVO>(); 
		
		for(int i = 0 ; i< draft.size(); i++) {
			System.out.println(i + draft.get(i).getProfessor_id());
			 member = memberDAO.selectMemberListById(draft.get(i).getProfessor_id());	
			 nameList.add(member.get(0).getMember_name());
		}		
		
		
		int totalCount = draftDAO.selectDraftListCount();
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		AttachMap.put("draft", draft);
		AttachMap.put("nameList", nameList);
		AttachMap.put("pageMaker", pageMaker);
		
		System.out.println("AttachMap.get(draft) : "+AttachMap.get("draft"));
		System.out.println("AttachMap.get(nameList) : "+AttachMap.get("nameList"));
		return AttachMap;
		
	}
	/**
	 * 
	 * @기능설명		:	기안서 결재 대기 리스트
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 12.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 12.오후 5:06:57
	 * @see			    :	-
	 * @param cri
	 * @return
	 * @throws SQLException
	 *
	 */
	public Map<String, Object> getSearchDraftPauseList(SearchCriteria cri) throws SQLException {
		Map<String, Object> AttachMap = new HashMap<String, Object>();
		List<String> nameList = new ArrayList<String>();		
		List<DraftVO> draft = draftDAO.selectSearchDraftPauseList(cri);		
		List<MemberVO> member = new ArrayList<MemberVO>(); 
		
		for(int i = 0 ; i< draft.size(); i++) {
			System.out.println(i + draft.get(i).getProfessor_id());
			 member = memberDAO.selectMemberListById(draft.get(i).getProfessor_id());	
			 nameList.add(member.get(0).getMember_name());
		}		
		
		
		int totalCount = draftDAO.selectDraftListCount();
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		AttachMap.put("draft", draft);
		AttachMap.put("nameList", nameList);
		AttachMap.put("pageMaker", pageMaker);
		
		System.out.println("AttachMap.get(draft) : "+AttachMap.get("draft"));
		System.out.println("AttachMap.get(nameList) : "+AttachMap.get("nameList"));
		return AttachMap;
		
	}
	
	/**
	 * 
	 * @기능설명		:	기안서리스트 서비스
	 * @작성자			:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오후 4:39:16
	 * @see			:	X
	 * @return draft
	 * @throws SQLException
	 *
	 */
	@Override
	public List<DraftVO> getDraftList() throws SQLException {
		List<DraftVO> draft = draftDAO.selectDraftList();
		return draft;
	}
	
	/**
	 * 
	 * @기능설명		:	기안서 첨부파일 출력
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오후 4:39:36
	 * @see			:	X
	 * @param draft_no
	 * @return draftAttach
	 * @throws SQLException
	 *
	 */
	@Override
	public List<DraftAttachRequest> getDraftAttachList(int draft_no) throws SQLException {
		List<DraftAttachRequest> draftAttach = draftDAO.selectDraftAttachList(draft_no);
		return draftAttach;
	}
	/**
	 * 
	 * @기능설명		:	기안서 첨부파일 선택
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 13.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 13.오전 10:34:59
	 * @see			    :	-
	 * @param draft_attach_no
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public Draft_AttachVO getDraftAttach(int draft_attach_no) throws SQLException {
		Draft_AttachVO draftAttach = draftDAO.selectDraftAttach(draft_attach_no);
		return draftAttach;
	}
	
	/**
	 * 
	 * @기능설명		:	기안서상세 출력
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오후 4:40:15
	 * @see			:	X
	 * @param draft_no
	 * @return draft
	 * @throws SQLException
	 *
	 */
	@Override
	public DraftVO getDraftDetail(int draft_no) throws SQLException {
		DraftVO draft =  draftDAO.selectDraftDetail(draft_no);

		return draft;
	}
	
	/**
	 * 
	 * @기능설명		:	기안서상세(다운로드포함)
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오후 4:40:34
	 * @see			:	X
	 * @param draft
	 * @throws SQLException
	 *
	 */
	@Override
	public Map<String,Object> getDraftDetailInclude(int draft_no) throws SQLException{
		Map<String,Object> dataMap = new HashMap<String,Object>();
		DraftVO draft =  draftDAO.selectDraftDetail(draft_no);
		
		Lecture_dataVO data = lectureDAO.selectLectureDataBylno(draft.getLecture_data_no());
		String videoFile = data.getLecture_data_filename();
		videoFile = videoFile.substring(videoFile.lastIndexOf("$$")+2);
		String imageFile = data.getLecture_data_image();
		imageFile = imageFile.substring(imageFile.lastIndexOf("$$")+2);
		dataMap.put("draft", draft);
		dataMap.put("data", data);
		dataMap.put("videoFile", videoFile);
		dataMap.put("imageFile", imageFile);
		dataMap.put("path", draft_path);
		return dataMap;
	}
	
	@Override
	public void writeDraft(DraftVO draft) throws SQLException {
		SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
	
		int draft_no = Integer.parseInt(format.format(System.currentTimeMillis()))+ draftDAO.selectDraftSeqNext();
		draft.setDraft_no(draft_no);
		draftDAO.insertDraft(draft);
		
	}

	
	/**
	 * 
	 * @기능설명		:	기안서 수정
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오후 4:41:21
	 * @see			:	X
	 * @param draft
	 * @throws SQLException
	 *
	 */
	@Override
	public void modifyDraft(DraftVO draft) throws SQLException {
		draftDAO.updateDraft(draft);
		for (Draft_AttachVO data : draft.getDraftFileList()) {
			data.setDraft_no(draft.getDraft_no());
			int draft_attach_no = draftDAO.selectDraftAttachSeqNext();
			data.setDraft_attach_no(draft_attach_no);
			draftDAO.insertDraftAttach(data);
		}
		
	}
	
	/**
	 * 
	 * @기능설명		:	기안서 삭제
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오후 4:42:01
	 * @see			:	X
	 * @param draft_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void removeDraft(int draft_no) throws SQLException {
		draftDAO.deleteDraft(draft_no);
		
	}
	
	/**
	 * 
	 * @기능설명		:	기안서 첨부파일 삭제
	 * @작성자		:	민태홍
	 * @작성날짜      	:	2020. 6. 2.
	 * @마지막수정자	:	민태홍
	 * @마지막수정일	:	2020. 6. 2.오후 4:42:09
	 * @see			:	X
	 * @param draft_Attach_no
	 * @throws SQLException
	 *
	 */
	@Override
	public void removeDraftAttach(int draft_Attach_no) throws SQLException {
		draftDAO.deleteDraftAttach(draft_Attach_no);
		
	}
	
	/**
	 * 
	 * @기능설명		:	기안서 상태 변경
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 6. 10.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 10.오후 3:13:53
	 * @see			    :	-
	 * @param draft
	 * @throws SQLException
	 *
	 */
	@Override
	public void modifyDraftStatus(DraftVO draft) throws SQLException {
		if(draft.getDraft_status().equals("결재승인")){
			draftDAO.updateDraftApproved(draft);	
		}else {
			draftDAO.updateDraftApproved_pause_no(draft);
		}
	}
}
