package com.bjj.model;

public class Response {
	private int error; //0 没有错误 1 有错误
	private Object message;
	
	public Response(){
		this.error = 0;
		this.message = null;
	}
	
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public Object getMessage() {
		return message;
	}
	public void setMessage(Object message) {
		this.message = message;
	}
}
