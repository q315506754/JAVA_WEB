package com.bjj.service.db;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.bjj.model.City;

public interface CityRepository extends MongoRepository<City, ObjectId>{
	@Override
	public List<City> findAll();
}
