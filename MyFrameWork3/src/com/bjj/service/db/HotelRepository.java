package com.bjj.service.db;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.bjj.model.Hotel;

public interface HotelRepository extends MongoRepository<Hotel, ObjectId>{
	@Query("{'cityId':?0,'name':{'$regex':?1}}")
	public List<Hotel> findHotelsByCityId_Name(String cityId,String name,Pageable page);
	
	@Query("{'areaId':?0,'name':{'$regex':?1}}")
	public List<Hotel> findHotelsByAreaId_Name(String areaId,String name,Pageable page);
	
	@Query("{'name':{'$regex':?1}}")
	public List<Hotel> findHotelsByName(String name,Pageable page);
}
