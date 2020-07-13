package com.dlms.service.founded;

import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dlms.dao.board.NoticeBoardDAO;
import com.dlms.dao.founded.FoundedReviewDAO;
import com.dlms.dao.founded.FoundedReviewImgDAO;
import com.dlms.dao.lecture.LectureAttendDAO;
import com.dlms.dto.Founded_reviewVO;
import com.dlms.dto.Founded_review_imgVO;
import com.dlms.dto.FreeBoardVO;
import com.dlms.dto.NoticeVO;
import com.dlms.request.DetailFoundedRequest;
import com.dlms.request.FoundedReviewImgRequest;
import com.dlms.request.PageMaker;
import com.dlms.request.SearchCriteria;

public class FoundedReviewServiceImpl implements FoundedReviewService {
	
	@Autowired
	private FoundedReviewDAO foundedReviewDAO;
	public void setFoundedReviewDAO(FoundedReviewDAO foundedReviewDAO) {
		this.foundedReviewDAO = foundedReviewDAO;
	}
	
	@Autowired
	private FoundedReviewImgDAO foundedReviewImgDAO;
	public void setFoundedReviewImgDAO(FoundedReviewImgDAO foundedReviewImgDAO) {
		this.foundedReviewImgDAO = foundedReviewImgDAO;
	}
	
	@Autowired
	private NoticeBoardDAO noticeBoardDAO;
	public void setNoticeBoardDAO(NoticeBoardDAO noticeBoardDAO) {
		this.noticeBoardDAO = noticeBoardDAO;
	}
	@Autowired
	private LectureAttendDAO lectureAttendDAO;
	public void setLectureAttendDAO(LectureAttendDAO lectureAttendDAO) {
		this.lectureAttendDAO = lectureAttendDAO;
	}
	
	
	@Override
	public List<Founded_reviewVO> getfoundedReviewList() throws SQLException {
		List<Founded_reviewVO> foundedList=foundedReviewDAO.selectFoundedReviewList();
		List<Founded_reviewVO> foundedList9 =new ArrayList<Founded_reviewVO>();
		//창업 후기 9개까지만 보여주는 작업 
		if(foundedList.size()<10) {
			for(int i =0; i<foundedList.size(); i++) {
				Founded_reviewVO vo = new Founded_reviewVO();
				vo.setFounded_review_no(foundedList.get(i).getFounded_review_no());
				vo.setFounded_review_title(foundedList.get(i).getFounded_review_title());
				vo.setFounded_review_regdate(foundedList.get(i).getFounded_review_regdate());
				foundedList9.add(vo);
			}
		}else {
			for(int i =0; i<10; i++) {
				Founded_reviewVO vo = new Founded_reviewVO();
				vo.setFounded_review_no(foundedList.get(i).getFounded_review_no());
				vo.setFounded_review_title(foundedList.get(i).getFounded_review_title());
				vo.setFounded_review_regdate(foundedList.get(i).getFounded_review_regdate());
				foundedList9.add(vo);
			}
		}
		return foundedList9;
	}
	@Override
	public Map<String, Object> getfoundedReviewList(SearchCriteria cri) throws SQLException, ParseException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int totalCount=0;
		String founded="founded";
		List<NoticeVO> pointList = noticeBoardDAO.selectNoticePoint(founded);
		List<Founded_reviewVO> foundedList = foundedReviewDAO.selectFoundedReviewSearchList(cri);
		totalCount=foundedReviewDAO.selectFoundedReviewCriteriaTotalCount(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		System.out.println("pageMaker : " + pageMaker.toString());
		dataMap.put("foundedList", foundedList);
		dataMap.put("pageMaker", pageMaker);
		dataMap.put("pointList", pointList);

		return dataMap;
	}
	
	@Override
	public FreeBoardVO getfoundedReviewForModify(int freeboard_no) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void modify(FreeBoardVO freeboard) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeFoundedReview(int founded_review_no, String foundedReivew_imgePath) throws SQLException {
		List<Founded_review_imgVO> imgList = foundedReviewImgDAO.selectFoundedReviewImgByReviewNo(founded_review_no);
		for(Founded_review_imgVO img : imgList) {
			File file = new File(foundedReivew_imgePath+File.separator,img.getFounded_review_img_name());
			if(file.mkdirs()) file.delete();
		}
		foundedReviewImgDAO.deleteAllImg(founded_review_no);
		foundedReviewDAO.deleteFoundedReview(founded_review_no);
	}

	@Override
	public int write(Founded_reviewVO review,List<Founded_review_imgVO>fileName) throws SQLException {
		int seqNum=0;
		seqNum=foundedReviewDAO.selectFoundedReviewSeqNext();
		System.out.println("seqNum : " + seqNum);
		review.setFounded_review_no(seqNum);
		foundedReviewDAO.insertFoundedReview(review);
		for(Founded_review_imgVO  filestr : fileName) {
			Founded_review_imgVO reviewImg = new Founded_review_imgVO();
			reviewImg.setFounded_review_no(seqNum);
			reviewImg.setFounded_review_img_name(filestr.getFounded_review_img_name());
			foundedReviewImgDAO.insertImg(reviewImg);
		}
			
		return seqNum;
	}

	@Override
	public Map<String, Object> getfoundedReviewByReviewNo(int review_no, String modifyText) throws SQLException {
		
		// 글 수정 후 조회수가 올라가지 않게 하는 작업
		if(modifyText ==null) {
			foundedReviewDAO.viewCountUP(review_no);
		}
		Founded_reviewVO review=foundedReviewDAO.selectFoundedReviewByReviewNo(review_no);
		List<Founded_review_imgVO> reviewImg=foundedReviewImgDAO.selectFoundedReviewImgByReviewNo(review_no);
		Map<String, Object> dataMap = new HashMap<String,Object>();
		
		
		dataMap.put("review", review);
		dataMap.put("reviewImg", reviewImg);
		return dataMap;
	}

	@Override
	public DetailFoundedRequest getPrevNextInfoByReviewNo(int detailReviewNo) throws SQLException {
			DetailFoundedRequest detailReq=foundedReviewDAO.selectPrevNexTitle(detailReviewNo);
		return detailReq;
	}

	@Override
	public void modifyFoundedReview(Founded_reviewVO review, FoundedReviewImgRequest imgeFiles, List<Founded_review_imgVO> fileNames)throws SQLException {
		//수정된 제목, 내용 수정작업
		foundedReviewDAO.updateFoundedReview(review);
		//해당 게시글번호, 이미지이름 가지고 이미지등록작업
		if(fileNames != null) {
			for(Founded_review_imgVO fileName : fileNames) {
				fileName.setFounded_review_no(review.getFounded_review_no());
				foundedReviewImgDAO.insertImg(fileName);
			}
		}
		//지울 이미지번호를 가져와서 삭제하는 작업
		List<Integer> removeFileNo=imgeFiles.getRemovefile();
		if(removeFileNo != null) {
			for(Integer removeNo : removeFileNo) {
				foundedReviewImgDAO.deleteImg(removeNo);
			}
		}
		
	}

	@Override
	public Map<String, Object> getfoundedReviewBestReview(int count) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		List<Founded_reviewVO> foundedList=foundedReviewDAO.selectfoundedListByCount(count);
		
		int upcnt=0;
		for(Founded_reviewVO foundedReview : foundedList) {
			int review_no=foundedReview.getFounded_review_no();
			List<Founded_review_imgVO> foundedImgList=foundedReviewImgDAO.selectFoundedReviewImgByReviewNo(review_no);
			dataMap.put("foundedImgList"+upcnt, foundedImgList);
			upcnt++;
		}
		dataMap.put("foundedList", foundedList);
		return dataMap;
	}

	@Override
	public Founded_review_imgVO getimgeFileByReviewNo(int review_img_no) throws SQLException {
			Founded_review_imgVO img=foundedReviewImgDAO.selectImgByfoundedImg(review_img_no);
		return img;
	}
	
	/**
	 * 
	 * @기능설명		:	멤버 아이디 기준으로 창업후기 가져오기
	 * @작성자		    : 	이누리
	 * @작성날짜    	:	2020. 7. 6.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 7. 6.오후 2:03:05
	 * @see			    :	-
	 * @param member_id
	 * @return
	 * @throws SQLException
	 *
	 */
	@Override
	public List<Founded_reviewVO> myfounded_reviewList(String member_id) throws SQLException {
			List<Founded_reviewVO> foundedList=foundedReviewDAO.myfounded_reviewList(member_id);
		return foundedList;
	}

}
