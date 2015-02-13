package com.bjj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjj.modal.ResponseModal;
import com.bjj.modal.User;
import com.bjj.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	/**
	 *‘/’ 或者 ‘/login’都有此方法处理跳转
	 * */
	@RequestMapping({"/","/login"})
	public String goLogin(){
		return "login";
	}
	
	@RequestMapping({"/index"})
	public String goIndex(){
		return "index";
	}
	
	/**
	 * 处理登录逻辑
	 * */
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	@ResponseBody
	public ResponseModal userLogin(@RequestBody User user){
		System.out.println("userName is "+user.getUserName()+" password is "+user.getPassWord());
		ResponseModal res = new ResponseModal();
		res.setError(0);
		user = service.doLogin(user.getUserName(), user.getPassWord());
		System.out.println("==================="+(null!=user?user.getId():"null"));
		res.setMessage(user);
		return res;
	}
	
	/**
	 * 获取所有用户
	 * */
	@RequestMapping(value="/user/list",method=RequestMethod.GET)
	@ResponseBody
	public ResponseModal getUserList(){
		ResponseModal res = new ResponseModal();
		res.setError(0);
		res.setMessage(service.getAllUsers());
		return res;
	}
	
	/**
	 * 获取用户手机号
	 * */
	@RequestMapping(value="/user/{userName}/mobile",method=RequestMethod.GET)
	@ResponseBody
	public ResponseModal getUserMobile(@PathVariable String userName){
		ResponseModal res = new ResponseModal();
		res.setError(0);
		res.setMessage(service.getUserMobile(userName));
		return res;
	}
}
