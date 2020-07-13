package com.dlms.controller.manager.popup;

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
import com.dlms.dto.Manager_dataVO;
import com.dlms.request.Manager_dataRequest;
import com.dlms.service.popup.PopupService;

/**
 * 
 * @사용목적		:	메인화면 팝업 관리를 위한 컨트롤러
 * @작성자		    :	이누리
 * @작성날짜     	:	2020. 6. 18.
 * @마지막수정자	:	이누리
 * @마지막수정일	:	2020. 6. 18.오후 8:00:55
 * @see			    :	-
 *
 */
@Controller
@RequestMapping("/manager/*")
public class PopupController {

	@Autowired
	private PopupService popupService;
	
	/**
	 * 
	 * @기능설명		:	팝업 관리창을 보여준다.
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 18.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 18.오후 8:01:10
	 * @see			    :	-
	 * @param model
	 * @param manager_data
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/popup", method=RequestMethod.GET)
	public String popup(Model model, Manager_dataVO manager_data) throws Exception {
		String url = "manager/popup/popupManagement.page";
	
		Map<String, Object> dataMap = popupService.getPopup();
		
		model.addAllAttributes(dataMap);
		System.out.println("컨트롤러에서 보내는 dataMap : "+dataMap);
		return url;
	}	
		
	@Resource(name="popupPath")
	private String popupPath;
	
	/**
	 * 
	 * @기능설명		:	팝업 이미지를 출력한다.
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 18.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 18.오후 8:01:40
	 * @see			    :	-
	 * @param popup_no
	 * @param response
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping("popup/{popup_no}")
	@ResponseBody
	public ResponseEntity<byte[]> sendPicture(@PathVariable("popup_no") int popup_no, HttpServletResponse response)
			throws Exception {

		ResponseEntity<byte[]> entity = null;

		Manager_dataVO manager_data = popupService.getPopup(popup_no);
		//System.out.println("manager_data : " + manager_data );
		//String fileName = manager_data.getManager_data_filename();
		String savePath = popupPath + File.separator + manager_data.getManager_data_filename();

		FileInputStream in = null;
		//System.out.println("fileName : "+fileName);
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
	 * @기능설명		:	팝업 이미지를 순서에 맞춰 업데이트한다.
	 * @작성자		    :	이누리
	 * @작성날짜    	:	2020. 6. 18.
	 * @마지막수정자	:	이누리
	 * @마지막수정일	:	2020. 6. 18.오후 8:01:52
	 * @see			    :	-
	 * @param model
	 * @param manager_dataReq
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/popup", method=RequestMethod.POST)
	public String modifyPOST(Model model, Manager_dataRequest manager_dataReq) throws Exception {
		String url = "manager/popup/popupManagement_modify.page";
				
			Manager_dataVO manager_data = new Manager_dataVO();
			
			manager_data.setPopup_no(1);
			manager_data.setManager_data_filename((saveFile(manager_dataReq.getManager_data_filename1(),
					manager_dataReq.getOld_manager_data_filename1(), manager_data.getPopup_no())));
			//System.out.println("manager_data1에는 이런 것들이 들어가있다. : " + manager_data.toString());
			popupService.modifyAndDeletePopup(manager_data, manager_data.getPopup_no());
		
			manager_data.setPopup_no(2);
			manager_data.setManager_data_filename((saveFile(manager_dataReq.getManager_data_filename2(),
					manager_dataReq.getOld_manager_data_filename2(), manager_data.getPopup_no())));
			//System.out.println("manager_data2에는 이런 것들이 들어가있다. : " + manager_data.toString());
			popupService.modifyAndDeletePopup(manager_data, manager_data.getPopup_no());				
			
			manager_data.setPopup_no(3);
			manager_data.setManager_data_filename((saveFile(manager_dataReq.getManager_data_filename3(),
					manager_dataReq.getOld_manager_data_filename3(), manager_data.getPopup_no())));
			//System.out.println("manager_data3에는 이런 것들이 들어가있다. : " + manager_data.toString());
			popupService.modifyAndDeletePopup(manager_data, manager_data.getPopup_no());
			
		
		return url;
	}
	
	
	private String saveFile(MultipartFile file, String old_fileName, int popup_no) throws Exception {		
	
		//System.out.println("file.getOriginalFilename() : " + file.getOriginalFilename());
		/*System.out.println(popup_no);
		System.out.println(popupService.getPopup(popup_no));*/
		if(file==null || file.isEmpty()) { //새로 등록한 파일이 없고
			if(old_fileName == null || old_fileName.isEmpty()) { //예전 파일도 없을때(삭제 버튼 누른 후 아무것도 등록 안한채로 글 수정한 경우)
				//기존 파일 삭제
				old_fileName = popupService.getPopup(popup_no).getManager_data_filename();
				File oldFile = new File(popupPath + File.separator + old_fileName);
				if(oldFile.exists()) 
					System.out.println("oldFile 삭제했서.. : ");
					oldFile.delete();
				return "";
				
			}
			//예전 파일 그대로 두고 글 수정한 경우
			System.out.println("파일없서..");
			return old_fileName;
		}
				
		//신규 파일 저장
		String fileName = /*UUID.randomUUID().toString().replace("-", "") + "$$" + */file.getOriginalFilename();
		File savePath = new File(popupPath /*+ File.separator + introduce_no*/);
		
		System.out.println("fileName저장시도 : "+fileName);
		System.out.println("savePath저장시도 : "+savePath);
		
		if(!savePath.exists()) {
			savePath.mkdirs();
		}
		
		file.transferTo(new File(savePath, fileName));
		
		return fileName;
	}
	
	
}
