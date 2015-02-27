package com.bjj.service.db;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.bjj.model.ReqOrder;

public interface HotelOrderRepository extends MongoRepository<ReqOrder, ObjectId>{
	@Override
	public <S extends ReqOrder> S save(S arg0);
}
