package com.bjj.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bjj.model.Area;
import com.bjj.service.db.AreaRepository;

@Component
public class AreaService {
	@Autowired
	AreaRepository repo;
	
	public List<Area> getAllAreas(String cityId){
		return repo.findAreasByCityId(new ObjectId(cityId));
	}
}
