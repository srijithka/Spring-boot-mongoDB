package com.srijith.rest_spring.RestfulServices.user;

import org.springframework.data.mongodb.repository.MongoRepository;

//org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,Integer>{
	

}
