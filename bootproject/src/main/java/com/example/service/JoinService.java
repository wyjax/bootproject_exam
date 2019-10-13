package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Users;
import com.example.repository.UsersRepository;

@Service
public class JoinService {

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private UserPwHashClass userPwHashClass;

	public String joinUser(String userId, String userPw, String userName) {
		if(userId.equals("") || userPw.equals("") || userName.equals(""))
			return "join";
		
		Users users = new Users();
		users.setUserId(userId);
		String pw = userPwHashClass.getSHA256(userPw);
		users.setUserPw(pw);
		users.setUserName(userName);

		// save는 데이터베이스에 저장하는 함수
		userRepository.save(users);

		return "index";
	}
}
