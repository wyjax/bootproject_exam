package com.example.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Users;
import com.example.repository.UsersRepository;

@Service
public class LoginService {

	@Autowired
	private UserPwHashClass userPwHashClass;

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	HttpSession session;

	public String login(String userId, String userPw) {
		if (userId.equals("") || userPw.equals(""))
			return "loginPage";

		String hashedPw = userPwHashClass.getSHA256(userPw);
		Users user = usersRepository.findByuserIdAndUserPw(userId, hashedPw);

		if (user == null)
			return "loginPage";

		session.setAttribute("loginUser", userId);

		return "index";
	}

	public String logout() {
		session.invalidate();
		return "index";
	}
}