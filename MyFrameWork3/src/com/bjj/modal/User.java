package com.bjj.modal;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
//@CompoundIndexes({
//	@CompoundIndex(name="",def="{}")
//})
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5297968621161872704L;
	@Id
	private String id;
	private String userName;
	private String passWord;
	private String mobile;
	
	@PersistenceConstructor
	public User(String userName,String passWord,String mobile){
		this.userName = userName;
		this.passWord = passWord;
		this.mobile = mobile;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
