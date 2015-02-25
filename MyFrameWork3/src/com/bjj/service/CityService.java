package com.bjj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bjj.model.City;
import com.bjj.service.db.CityRepository;

@Component
public class CityService {
	@Autowired
	CityRepository repo;
	
	public List<City> getAllCitys(){
		return repo.findAll();
	}
}
