package com.bjj.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="city")
public class City {
	@Id
	private String id;
	@Field("name")
	private String text;
	private String provinceId;
	
	@PersistenceConstructor
	public City(String id,String text,String provinceId){
		this.id = id;
		this.text = text;
		this.provinceId = provinceId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
}
