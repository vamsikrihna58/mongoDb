package com.MongoDBProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.MongoDBProject.Entity.UserEntity;
import com.MongoDBProject.Repository.UserRepo;

public class UserService {
	   @Autowired
	    private UserRepo userRepository;

	    public UserEntity createUser(UserEntity user) {
	        return userRepository.save(user);
	    }

	    public List<UserEntity> getAllUsers() {
	        return userRepository.findAll();
	    }

	    public UserEntity getUserById(String id) {
	        return userRepository.findById(id).orElse(null);
	    }

	    public UserEntity updateUser(String id, UserEntity userDetails) {
	    	UserEntity user = getUserById(id);
	        if (user != null) {
	            user.setName(userDetails.getName());
	            user.setEmail(userDetails.getEmail());
	            return userRepository.save(user);
	        }
	        return null;
	    }

	    public void deleteUser(String id) {
	        userRepository.deleteById(id);
	    }
	    public UserEntity findUserById(String id) {
	        Optional<UserEntity> user = userRepository.findById(id);
	        if (user == null) {
	            throw new RuntimeException("User not found with id: " + id);
	        }
	        return user.get();
	    }

	    public UserEntity findUserByName(String name) {
	        UserEntity user = userRepository.findByName(name);
	        if (user == null) {
	            throw new RuntimeException("User not found with name: " + name);
	        }
	        return user;
	    }

	    public UserEntity findUserByPassword(String email) {
	        UserEntity user = userRepository.findByEmail(email);
	        if (user == null) {
	            throw new RuntimeException("User not found with the given password.");
	        }
	        return user;
	    }


}
