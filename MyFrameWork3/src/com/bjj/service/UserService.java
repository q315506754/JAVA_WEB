package com.bjj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bjj.model.User;
import com.bjj.service.db.UserRepository;

@Component
public class UserService {
	@Autowired
	UserRepository repo;
	
	public User doLogin(String userName,String passWord){
		System.out.println("params:"+userName+passWord);
		User user = repo.findUserByNamdAndPwd(userName, passWord);
		return user;
	}
	
	public User getUserMobile(String userName){
		return repo.findMobileByNamd(userName);
	}
	
	public List<User> getAllUsers(){
		return repo.findAll();
	}
}
