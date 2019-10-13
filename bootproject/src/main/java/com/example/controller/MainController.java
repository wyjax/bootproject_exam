package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	// 메인 컨트롤러는 페이지를 넘겨주는 역할을 한다.
	/*
	 * 
	 * getmapping postmapping 등등 다양한 방법이 있음
	 */

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/joinPage")
	public String joinPage() {
		return "joinPage";
	}
	
	@RequestMapping(value ="/loginPage")
	public String loginPage() {
		return "loginPage";
	}
}