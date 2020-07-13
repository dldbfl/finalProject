package com.dlms.controller.manager.manager_board;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.dlms.dto.Enterprise_introduceVO;
import com.dlms.dto.Manager_boardVO;
import com.dlms.request.Enterprise_introduceRequest;
import com.dlms.request.Manager_boardRequest;
import com.dlms.service.enterprise_introduce.Enterprise_introduceService;
import com.dlms.service.manager_board.Enterprise_comingService;

/**
 * 
 * @사용목적		:	찾아오는길 관리를 위한 컨트롤러
 * @작성자		    :	이누리
 * @작성날짜     	:	2020. 6. 18.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 18.오후 8:00:30
 * @see			    :	-
 *
 */
@Controller
@RequestMapping("/manager")
public class Enterprise_comingController {

	@Autowired
	private Enterprise_comingService enterprise_comingService;
		
	@RequestMapping(value="/enterprise_coming", method=RequestMethod.GET)
	public String enterprise_coming(Model model, Manager_boardVO manager_board) throws Exception {
		String url = "manager/enterprise_coming/enterprise_coming.page";

		//System.out.println("enterprise_introduceVO.toString()_get : " + enterprise_introduce.toString());
		
				
		
		//찾아오는길 가져오기
		Map<String, Object> dataMap = enterprise_comingService.getEnterprise_coming(1);
		
		model.addAllAttributes(dataMap);
		
		return url;
	}	
	

	
	
	@Resource(name="manager_Enterprise_Coming_ImagePath")
	private String manager_Enterprise_Coming_ImagePath;
	
	
	@RequestMapping("/picture/enterprise_coming/{manager_board_no}")
	@ResponseBody
	public ResponseEntity<byte[]> sendPicture(@PathVariable("manager_board_no") int manager_board_no, HttpServletResponse response)
			throws Exception {

		ResponseEntity<byte[]> entity = null;

		Manager_boardVO manager_board = (Manager_boardVO) enterprise_comingService.getEnterprise_coming(manager_board_no).get("manager_board");
		System.out.println("manager_board : " + manager_board );
		System.out.println("manager_board_no : "+manager_board_no);
		String fileName = manager_board.getManager_data_filename();
		String savePath = manager_Enterprise_Coming_ImagePath + File.separator + manager_board.getManager_data_filename();

		FileInputStream in = null;
		System.out.println("fileName : "+fileName);
		System.out.println("savePath : "+savePath);
		try {
			//in = new FileInputStream(savePath + File.separator + fileName);
			in = new FileInputStream(savePath);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), HttpStatus.OK);
		} catch (IOException e) {
			entity = new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		} finally {
			if(in!=null)in.close();
		}

		return entity;
	}
		
	
	@RequestMapping(value="/enterprise_coming", method=RequestMethod.POST)
	public String modifyPOST(Model model, Manager_boardRequest manager_boardReq) throws Exception {
		String url = "manager/enterprise_coming/enterprise_coming_modify.page";
		
		
		Manager_boardVO manager_board = manager_boardReq.toManager_boardVO();
		manager_board.setManager_data_filename((saveFile(manager_boardReq.getManager_data_filename(),
				manager_boardReq.getOld_manager_data_filename(), manager_boardReq.getManager_board_no())));
		
		System.out.println("manager_boardVO.toString()_post : " + manager_board.toString());
		
		enterprise_comingService.modifyEnterprise_coming(manager_board,1);
		
		return url;
	}
	
	
	private String saveFile(MultipartFile file, String old_fileName, int introduce_no) throws Exception {		
	
		System.out.println("file.getOriginalFilename() : " + file.getOriginalFilename());
		
		if(file==null || file.isEmpty()) { //새로 등록한 파일이 없고
			/*(if(old_fileName == null || old_fileName.isEmpty()) { //예전 파일도 없을때(삭제 버튼 누른 후 아무것도 등록 안한채로 글 수정한 경우)
				//기존 파일 삭제
				File oldFile = new File(manager_Enterprise_ImagePath + File.separator + introduce_no, old_fileName);
				if(oldFile.exists()) oldFile.delete();
				return "";
			}*/
			//예전 파일 그대로 두고 글 수정한 경우
			System.out.println("파일없서..");
			return old_fileName;
		}
		
		//기존 파일 삭제
		//File oldFile = new File(manager_Enterprise_ImagePath + File.separator + introduce_no, old_fileName);
		//if(oldFile.exists()) oldFile.delete();
		
		//신규 파일 저장
		String fileName = /*UUID.randomUUID().toString().replace("-", "") + "$$" + */file.getOriginalFilename();
		File savePath = new File(manager_Enterprise_Coming_ImagePath /*+ File.separator + introduce_no*/);
		
		System.out.println("fileName저장시도 : "+fileName);
		System.out.println("savePath저장시도 : "+savePath);
		
		if(!savePath.exists()) {
			savePath.mkdirs();
		}
		
		file.transferTo(new File(savePath, fileName)); 
		
		return fileName;
	}
	
	
}
