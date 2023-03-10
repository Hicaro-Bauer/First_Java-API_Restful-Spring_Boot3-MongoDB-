package com.hicarobauer.workshop_mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hicarobauer.workshop_mongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
}
