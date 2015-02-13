package com.bjj.service.db;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.bjj.modal.User;

public interface UserRepository extends MongoRepository<User, ObjectId>{
	@Query(value="{'userName':?0,passWord:?1}")
	public User findUserByNamdAndPwd(String userName,String passWord);
}
