package com.dlms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class AccessController {

	@RequestMapping()
	public String defaultError() {
		return "/error/defaultPage";
	}
	
	@RequestMapping("/denied-page")
	public String accessDenied() {
		return"/error/accessDenied";
	}
	
	@RequestMapping("/404Page")
	public String PageError_404() {
		return"/error/pageError_404";
	}
	
}
