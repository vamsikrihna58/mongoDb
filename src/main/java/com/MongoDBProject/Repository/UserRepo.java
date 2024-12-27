package com.MongoDBProject.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.MongoDBProject.Entity.UserEntity;

public interface UserRepo extends MongoRepository<UserEntity, String> {
	 UserEntity findByName(String name);
	 UserEntity findByEmail(String password);

}
