package com.bjj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bjj.modal.User;
import com.bjj.service.db.UserRepository;

@Component
public class UserService {
	@Autowired
	UserRepository repo;
	
	public User doLogin(String userName,String passWord){
		User user = repo.findUserByNamdAndPwd(userName, passWord);
		return user;
	}
}
