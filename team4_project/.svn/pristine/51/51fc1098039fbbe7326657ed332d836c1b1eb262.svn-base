package com.dlms.controller.founded;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dlms.dto.Founded_reviewVO;
import com.dlms.dto.Founded_review_imgVO;
import com.dlms.dto.MemberVO;
import com.dlms.request.DetailFoundedRequest;
import com.dlms.request.FoundedReviewImgRequest;
import com.dlms.request.SearchCriteria;
import com.dlms.service.founded.FoundedReviewService;
import com.dlms.service.lecture.LectureAttendService;
import com.dlms.service.lecture.LectureService;
import com.dlms.service.member.MemberService;

@Controller		 
@RequestMapping("/board")
public class FoundedReviewController {
	
	@Autowired
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Autowired
	private FoundedReviewService foundedService;
	public void setFoundedService(FoundedReviewService foundedService) {
		this.foundedService = foundedService;
	}
	
	@Autowired
	private LectureAttendService lectureAttendService;
	public void setLectureAttendService(LectureAttendService lectureAttendService) {
		this.lectureAttendService = lectureAttendService;
	}
	/**
	 * 
	 * @기능설명		:	글작성 화면 보여주는 기능	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오후 2:14:07
	 * @return		:	경로 주소
	 * @throws 		:	Exception
	 *
	 */
	@RequestMapping("foundedReview/registForm")
	public String registForm()throws Exception{
		
		String url="board/foundedReview/registForm.page";
		
		return url;
	}
	
	/*창업후기 이미지 저장 경로*/
	@Resource(name="foundedReivew_imgePath")
	private String foundedReivew_imgePath;
	/**
	 *
	 * @기능설명		:	창업후기 등록
	 * @작성자		:	강현철
	 * @작성날짜		:	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오전 3:34:05
	 * @param 		:	review (제목,작성자,내용)
	 * @param 		:	imgeFiles(첨부파일들)
	 * @return		:	mnv(화면 결정URL주소 및 Map객체);
	 */
	@RequestMapping("/foundedReview/regist")
	public ModelAndView registFoundedReivew(ModelAndView mnv, Founded_reviewVO review, FoundedReviewImgRequest imgeFiles){
		String url="board/foundedReview/registSuccess.page";
		int foundedReviewNum=0;
		if(imgeFiles.getAddFiles() !=null) {
			List<MultipartFile> addFiles=imgeFiles.getAddFiles();
			List<Founded_review_imgVO> fileNames=null;
			try {
				fileNames = saveFile(addFiles);
				foundedReviewNum=foundedService.write(review,fileNames);
			} catch (IllegalStateException | IOException | SQLException e) {
				url="board/foundedReview/registFail.page";
				e.printStackTrace();
			}
		}
		
		mnv.addObject("foundedReviewNum",foundedReviewNum);
		mnv.setViewName(url);
		return mnv;
	}
	/**
	 * 
	 *
	 * @기능설명		:	창업리스트 메인화면 리스트 출력
	 * @작성자		:	강현철
	 * @작성날짜		:	2020. 6. 19.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 19.오전 3:20:56
	 * @param 		:	cri 검색 
	 * @param 		:	mnv
	 * @return
	 */
	@RequestMapping("/foundReviewList")
	public ModelAndView foundReviewList(SearchCriteria cri,ModelAndView mnv) {
		String url="board/foundedReview/foundReviewList.page";
		try {
			Map<String, Object> dataMap = foundedService.getfoundedReviewList(cri);
			mnv.addAllObjects(dataMap);
			mnv.setViewName(url);
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
		return mnv;
	}
	
	@RequestMapping("/foundedReview/attendCnt")
	public ResponseEntity<Integer> attendCnt(String member_id) {
		System.out.println("member_id : " + member_id);
		ResponseEntity<Integer> entity=null;
		int cnt=0;
		try {
			cnt=lectureAttendService.getLectureAteendCnt(member_id);
			System.out.println("cnt : " + cnt);
			entity= new ResponseEntity<Integer>(cnt,HttpStatus.OK);
		} catch (SQLException e) {
			entity= new ResponseEntity<Integer>(cnt,HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	
	@RequestMapping("/foundedReview/bestFoundedReview")
	public ResponseEntity<Map<String, Object>>bestFoundedReview (){
			ResponseEntity<Map<String, Object>> entity= null;
			int count=5;
			
			try {
				Map<String,Object> dataMap = foundedService.getfoundedReviewBestReview(count);
				entity= new ResponseEntity<Map<String, Object>>(dataMap,HttpStatus.OK);
			} catch (SQLException e) {
				entity= new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
				e.printStackTrace();
			}
		return entity;
	}
	
	
	@RequestMapping("/foundedImge")
	public void foundedImge(String fileName, HttpServletResponse response) {
		try {
			File imgFile = new  File(foundedReivew_imgePath+File.separator+fileName)      ;
		   FileInputStream ifo = new FileInputStream(imgFile);
		   ByteArrayOutputStream baos = new ByteArrayOutputStream();
		   byte[] buf = new byte[1024];
		   int readlength = 0;
		   while( (readlength =ifo.read(buf)) != -1 )
		   {
		    baos.write(buf,0,readlength);
		   }
		   byte[] imgbuf = null;
		   imgbuf = baos.toByteArray();
		   baos.close();
		   ifo.close();    
		   
		   int length = imgbuf.length;   
		   OutputStream out;
			out = response.getOutputStream();
		   out.write(imgbuf , 0, length);
		   out.close();   
	     /*   BufferedReader reader = new BufferedReader(new FileReader(foundedReivew_imgePath+File.separator+fileName));
	        
	        String txt;
	        while((txt=reader.readLine())!= null) {
	        }
	        reader.close();*/
		} catch (IOException e) {
			e.printStackTrace();
		}    

	}
	
	
	/**
	 * 
	 * @기능설명		:	해당 게시글의 번호를 가져와서 상세보기화면을 보여주는 기능
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 22.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 22.오전 11:35:16
	 * @param 		:	ModelAndView mnv
	 * @param		:	founded_review_no(게시글번호)
	 * @return		:	mnv(화면 결정URL주소 및 Map객체);
	 * @throws 		:	Exception
	 *
	 */
	@RequestMapping("/foundedReview/detail")
	public ModelAndView detail(ModelAndView mnv,int founded_review_no, String modifyText)throws Exception {
		
		String url="board/foundedReview/detailForm.page";
		try {
			Map<String, Object> dataMap = foundedService.getfoundedReviewByReviewNo(founded_review_no, modifyText);
			mnv.addAllObjects(dataMap);
			mnv.setViewName(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mnv;
		
	}
	
	@RequestMapping("/foundedReview/{review_img_no}")
	@ResponseBody
	public ResponseEntity<byte[]> foundedReviewImg(@PathVariable("review_img_no") int review_img_no){
		ResponseEntity<byte[]> entity=null;
		try {
			Founded_review_imgVO imgs=foundedService.getimgeFileByReviewNo(review_img_no);
			System.out.println("imgs.toString() : "+imgs.toString());
			String savePath = foundedReivew_imgePath + File.separator +imgs.getFounded_review_img_name();
			FileInputStream in = null;
			System.out.println("savePath : "+savePath);
				in = new FileInputStream(savePath);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), HttpStatus.OK);
			} catch (FileNotFoundException e) {
				entity = new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return entity;
	}
	
	/**
	 * 
	 * @기능설명		:	수정 버튼을 눌렀을때 수정 화면을 보여주고 해당 관련 데이터를 뿌려준다.	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 23.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 23.오전 11:50:24
	 * @param 		:	mnv(화면 결정주소)
	 * @param 		:	founded_review_no(해당 글번호)
	 * @return		:	mnv(화면 결정주소)
	 * @throws 		:	Exception
	 *
	 */
	@RequestMapping("/foundedReview/founded_review_modify")
	public ModelAndView foundedReviewModifyForm(ModelAndView mnv, int founded_review_no, String modifyText)throws Exception{
		String url="board/foundedReview/modifyForm.page";
		
		try {
			Map<String, Object> dataMap = foundedService.getfoundedReviewByReviewNo(founded_review_no, modifyText);
			mnv.addAllObjects(dataMap);
			mnv.setViewName(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mnv;
	}
	/**
	 * 
	 * @기능설명		:	선택한 창업후기의 수정하는 기능 제목,내용,첨부파일,삭제된 첨부파일
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 23.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 23.오전 11:51:48
	 * @param 		:	mnv(화면결정주소)
	 * @param 		:	review(제목,내용,글번호)
	 * @param 		:	imgeFiles(추가한 첨부파일, 삭제한 첨부파일)
	 * @return		:	mnv(화면결정주소) 상세화면으로 전환
	 *
	 */
	@RequestMapping("foundedReview/modify")
	public ModelAndView foundedReviewModify(ModelAndView mnv, Founded_reviewVO review, FoundedReviewImgRequest imgeFiles) {
		String url="board/foundedReview/modifySuccess";
		int founded_review_no =review.getFounded_review_no();
		
		List<MultipartFile> addFiles=imgeFiles.getAddFiles();
								
		List<Founded_review_imgVO> fileNames=null;
		
		try {
			//추가된 파일을 저장하는 작업
			if(addFiles != null) {
				fileNames = saveFile(addFiles);
			}
			//추가된 파일명과 삭제된 파일과 변경된 제목,내용을 수정하는 작업
			foundedService.modifyFoundedReview(review,imgeFiles,fileNames);
		} catch (IllegalStateException | IOException | SQLException e) {
			url="board/foundedReview/registFail.page";
			e.printStackTrace();
		}
		mnv.addObject("founded_review_no",founded_review_no);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping("/foundedReview/founded_review_delete")
	public ModelAndView foundedReviewDelete(ModelAndView mnv, int founded_review_no)throws Exception{
		String url="board/foundedReview/removeSuccess";
		
			foundedService.removeFoundedReview(founded_review_no ,foundedReivew_imgePath);
		
		mnv.setViewName(url);
		return mnv;
	}
	/**
	 * 
	 * @기능설명		:	이전글번호, 다음글번호 , 이전글제목, 다음글제목 가져오기	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 6. 23.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 23.오전 11:54:25
	 * @param 		:	detailReviewNo(해당 글번호)
	 * @return		:	entity(ajax성공,실패시 결정값
	 *
	 */
	@RequestMapping("/foundedReview/detailPrevNextInfo")
	public ResponseEntity<DetailFoundedRequest> detailPrevNextInfo(String detailReviewNo){
		int detailReviewNum=0;
		detailReviewNum=Integer.parseInt(detailReviewNo);
		ResponseEntity<DetailFoundedRequest> entity= null;
		try {
			DetailFoundedRequest detailReq=foundedService.getPrevNextInfoByReviewNo(detailReviewNum);
			entity = new ResponseEntity<DetailFoundedRequest>(detailReq,HttpStatus.OK);
		} catch (SQLException e) {
			entity = new ResponseEntity<DetailFoundedRequest>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
		
	}
	
	/**
	 * 
	 * @기능설명		:	해당 아이디의 프로필 정보 가져오기	
	 * @작성자		:	강현철
	 * @작성날짜      	:	2020. 7. 1.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 7. 1.오후 9:38:48
	 * @param 		:	writter(회원아이디)
	 * @return		:	entity(ajax 성공,실패에 따른 값),member(회원정보)
	 *
	 */
	@RequestMapping("/foundedReview/profile")
	public ResponseEntity<MemberVO> profile(String writter){
		ResponseEntity<MemberVO> entity= null;
		MemberVO member= new MemberVO();
		try {
			member=memberService.getMemberProfileInfo(writter);
			entity = new ResponseEntity<MemberVO>(member,HttpStatus.OK);
		} catch (SQLException e) {
			entity = new ResponseEntity<MemberVO>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
		
	}
	
	/**
	 * 
	 * @기능설명		:	로컬에 파일 저장하는 기능
	 * @작성자		:	강현철
	 * @작성날짜      :	2020. 6. 23.
	 * @마지막수정자	:	강현철
	 * @마지막수정일	:	2020. 6. 23.오전 11:57:05
	 * @see			:	foundedReviewModify(수정) , registFoundedReivew(등록) 
	 * @param		:	foundedReivew_imgePath(로컬파일저장 경로)
	 * @param		:	addFiles(추가한 파일들)
	 * @return		:	fileNames (저장한 파일이름들)
	 * @throws 		:	IllegalStateException
	 * @throws 		:	IOException
	 *
	 */
	public List<Founded_review_imgVO> saveFile(List<MultipartFile> addFiles)throws IllegalStateException,IOException{
		List<Founded_review_imgVO>fileNames = new ArrayList<Founded_review_imgVO>();
		for(int i=0; i<addFiles.size(); i++) {
			Founded_review_imgVO vo = new Founded_review_imgVO();
			
			MultipartFile file=addFiles.get(i);
			String filename = UUID.randomUUID().toString().replace("-", "") + "$$"
					+ file.getOriginalFilename();
			vo.setFounded_review_img_name(filename);
			fileNames.add(vo);
			File savePath = new File(foundedReivew_imgePath,filename);
			if(!savePath.exists()) {
				savePath.mkdirs();
			}
			file.transferTo(savePath);
		}
		
		return fileNames;
	}

	
}
