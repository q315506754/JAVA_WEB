package com.bjj.service.db;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.bjj.model.User;

public interface UserRepository extends MongoRepository<User, ObjectId>{
	@Query("{'userName':?0,'passWord':?1}")
	public User findUserByNamdAndPwd(String userName,String passWord);
	
	@Query(value="{'userName':?0}",fields="{mobile:1}")
	public User findMobileByNamd(String userName);
}
