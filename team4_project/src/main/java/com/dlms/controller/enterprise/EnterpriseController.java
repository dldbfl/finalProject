package com.dlms.controller.enterprise;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dlms.dto.Enterprise_introduceVO;
import com.dlms.dto.Manager_boardVO;
import com.dlms.service.enterprise_introduce.Enterprise_introduceService;
import com.dlms.service.manager_board.Chairman_introduceService;
import com.dlms.service.manager_board.Education_curriculumService;
import com.dlms.service.manager_board.Education_purposeService;
import com.dlms.service.manager_board.Enterprise_comingService;

@Controller
@RequestMapping("enterprise")
public class EnterpriseController {
	@Autowired
	private Enterprise_introduceService entServuce;//기업소개 Service
	
	@Autowired
	private Education_curriculumService education_curriculumService;//교육과정 서비스

	@Autowired
	private Education_purposeService education_purposeService;//교육목표관리 서비스
	
	@Autowired
	private Chairman_introduceService chairman_introduceService;//이사장 인사 서비스
	
	@Autowired
	private Enterprise_comingService enterprise_comingService;//찾아오는길 서비스
	
	
	/**
	 * 
	 * @기능설명		:	기업소개 화면	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 22.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 22.오후 3:00:07
	 * @see			:	
	 * @param model
	 * @param enterprise_introduce
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/intro", method=RequestMethod.GET)
	public String enterprise_board(Model model, Enterprise_introduceVO enterprise_introduce) throws Exception {
		String url = "/enterprise/enterprise_intro.page";
		
		Map<String, Object> dataMap = entServuce.getEnterprise_introduce(1);
		
		model.addAllAttributes(dataMap);
		
		return url;
	}
	/**
	 * 
	 * @기능설명		:	교육과정 화면	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 22.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 22.오후 3:00:22
	 * @see			:	
	 * @param model
	 * @param boardVO
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/curriculum",method=RequestMethod.GET)
	public String entrprise_curriculum(Model model, Manager_boardVO boardVO)throws Exception{
		String url = "/enterprise/enterprise_curriculum.page";
		
		Map<String, Object> dataMap = education_curriculumService.getEducation_curriculum(2);
		
		model.addAllAttributes(dataMap);
		
		return url;
		
	}
	/**
	 * 
	 * @기능설명		:	교육목표관리	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 22.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 22.오후 10:00:48
	 * @see			:	
	 * @param model
	 * @param manager_board
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/purpose", method=RequestMethod.GET)
	public String education_purpose(Model model, Manager_boardVO manager_board) throws Exception {
		String url = "/enterprise/education_purpose.page";

		//찾아오는길 가져오기
		Map<String, Object> dataMap = education_purposeService.getEducation_purpose(3);
		
		model.addAllAttributes(dataMap);
		
		return url;
	}
	
	/**
	 * 	
	 * @기능설명		:	이사장 인사 화면	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 22.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 22.오후 10:02:37
	 * @see			:	
	 * @param model
	 * @param manager_board
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/chairman", method=RequestMethod.GET)
	public String chairman_introduce(Model model, Manager_boardVO manager_board) throws Exception {
		String url = "/enterprise/enterprise_chairman.page";

		
		Map<String, Object> dataMap = chairman_introduceService.getChairman_introduce(4);
		
		model.addAllAttributes(dataMap);
		
		return url;
	}	
	
	
	/**
	 * 
	 * @기능설명		:	찾아오는길 화면	
	 * @작성자		:	연은주
	 * @작성날짜      	:	2020. 6. 22.
	 * @마지막수정자	:	연은주
	 * @마지막수정일	:	2020. 6. 22.오후 10:03:19
	 * @see			:	
	 * @param model
	 * @param manager_board
	 * @return
	 * @throws Exception
	 *
	 */
	@RequestMapping(value="/coming", method=RequestMethod.GET)
	public String enterprise_coming(Model model, Manager_boardVO manager_board) throws Exception {
		String url = "/enterprise/enterprise_coming.page";
		
		Map<String, Object> dataMap = enterprise_comingService.getEnterprise_coming(1);
		
		model.addAllAttributes(dataMap);
		
		return url;
	}	
	
}
