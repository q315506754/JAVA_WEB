package com.bjj.service.db;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.bjj.model.City;

public interface CityRepository extends MongoRepository<City, ObjectId>{
	@Override
	public List<City> findAll();
	
	@Query("{$or:[{'name':{'$regex':?0}},{'eName':{'$regex':?0}}]}")
	public List<City> findCitysLikeName(String name);
}
