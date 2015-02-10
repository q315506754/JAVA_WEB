package com.bjj.modal;

import java.io.Serializable;


public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5297968621161872704L;
	private String userName;
	private String passWord;
	
	/**
	 * 提供无参构造
	 * */
	public User(){
		super();
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}
