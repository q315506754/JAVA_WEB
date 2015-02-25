package com.bjj.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="area")
public class Area {
	@Id
	private String id;
	private String name;
	private String cityId;
	
	@PersistenceConstructor
	public Area(String id,String name,String cityId){
		this.id = id;
		this.name = name;
		this.cityId = cityId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
}
