package com.example.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.JoinService;
import com.example.service.LoginService;

@Controller
public class UsersController {

	@Autowired
	private JoinService joinService;

	@Autowired
	private LoginService loginService;

	@PostMapping(value = "/joinRequest")
	public String joinRequest(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String page = joinService.joinUser(userId, userPw, userName);

		return page;
	}													

	@PostMapping(value = "/loginRequest")
	public String loginRequest(@RequestParam Map<String, String> paramMap) {
		String userId = paramMap.get("userId");
		String userPw = paramMap.get("userPw");
		String page = loginService.login(userId, userPw);

		return page;
	}
	
	@RequestMapping(value = "/logOut")
	public String logoutRequest() {
		String page = loginService.logout();
		return page;
	}
}