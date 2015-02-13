package com.bjj.modal;

public class ResponseModal {
	private int error;
	private Object message;
	
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
