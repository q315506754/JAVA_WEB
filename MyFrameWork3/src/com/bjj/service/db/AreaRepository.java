package com.bjj.service.db;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.bjj.model.Area;

public interface AreaRepository extends MongoRepository<Area, ObjectId>{
	@Query("{'cityId':?0}")
	public List<Area> findAreasByCityId(ObjectId cityId);
}
