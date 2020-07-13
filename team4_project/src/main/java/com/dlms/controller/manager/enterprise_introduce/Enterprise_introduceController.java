package com.dlms.controller.manager.enterprise_introduce;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

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
import com.dlms.request.Enterprise_introduceRequest;
import com.dlms.service.enterprise_introduce.Enterprise_introduceService;

/**
 * 
 * @사용목적		:	기업소개 관리
 * @작성자		    :	이누리
 * @작성날짜     	:	2020. 6. 17.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 17.오후 4:51:58
 * @see			    :	-
 *
 */
@Controller
@RequestMapping("/manager")
public class Enterprise_introduceController {

	@Autowired
	private Enterprise_introduceService enterprise_introduceService;
		
	/**
	 * 
	 * @기능설명		:	기업소개 관리 페이지
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 4:52:10
	 * @see			    :	-
	 * @param model
	 * @param enterprise_introduce
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/enterprise_introduce", method=RequestMethod.GET)
	public String enterprise_introduce(Model model, Enterprise_introduceVO enterprise_introduce) throws Exception {
		String url = "manager/enterprise_introduce/enterprise_introduce.page";

		//System.out.println("enterprise_introduceVO.toString()_get : " + enterprise_introduce.toString());
		
				
		
		//기업소개 가져오기
		Map<String, Object> dataMap = enterprise_introduceService.getEnterprise_introduce(1);
		
		model.addAllAttributes(dataMap);
		
		return url;
	}	
	

	
	
	@Resource(name="manager_Enterprise_Introduce_ImagePath")
	private String manager_Enterprise_Introduce_ImagePath;
	
	/**
	 * 
	 * @기능설명		:	기업소개 이미지 불러오기
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 4:52:31
	 * @see			    :	-
	 * @param introduce_no
	 * @param response
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/picture/enterprise_introduce/{introduce_no}" , produces="text/plain;charset=utf-8")
	@ResponseBody
	public ResponseEntity<byte[]> sendPicture(@PathVariable("introduce_no") int introduce_no, HttpServletResponse response)
			throws Exception {

		ResponseEntity<byte[]> entity = null;

		Enterprise_introduceVO enterprise_introduce = (Enterprise_introduceVO) enterprise_introduceService.getEnterprise_introduce(introduce_no).get("enterprise_introduce");
 
		System.out.println("enterprise_introduce"+enterprise_introduce.toString());
		
		System.out.println("introduce_no : "+introduce_no);
		String fileName = enterprise_introduce.getManager_data_filename();
		String savePath = manager_Enterprise_Introduce_ImagePath + File.separator + enterprise_introduce.getManager_data_filename();

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
		
	/**
	 * 
	 * @기능설명		:	기업소개 수정
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 17.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 17.오후 4:53:15
	 * @see			    :	-
	 * @param model
	 * @param enterprise_introduceReq
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/enterprise_introduce", method=RequestMethod.POST)
	public String modifyPOST(Model model, Enterprise_introduceRequest enterprise_introduceReq) throws Exception {
		String url = "manager/enterprise_introduce/enterprise_introduce_modify.page";
		
		
		Enterprise_introduceVO enterprise_introduce = enterprise_introduceReq.toEnterprise_introduceVO();
		enterprise_introduce.setManager_data_filename((saveFile(enterprise_introduceReq.getManager_data_filename(),
				enterprise_introduceReq.getOld_manager_data_filename(), enterprise_introduceReq.getEnterprise_introduce_no())));
		
		System.out.println("enterprise_introduceVO.toString()_post : " + enterprise_introduce.toString());
		
		enterprise_introduceService.modifyEnterprise_introduce(enterprise_introduce,1);
		
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
		File savePath = new File(manager_Enterprise_Introduce_ImagePath /*+ File.separator + introduce_no*/);
		
		System.out.println("fileName저장시도 : "+fileName);
		System.out.println("savePath저장시도 : "+savePath);
		
		if(!savePath.exists()) {
			savePath.mkdirs();
		}
		
		file.transferTo(new File(savePath, fileName));
		
		return fileName;
	}
	
	
}