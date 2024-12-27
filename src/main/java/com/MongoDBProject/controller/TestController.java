package com.MongoDBProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.MongoDBProject.Entity.UserEntity;
import com.MongoDBProject.Service.UserService;

public class TestController {
	@Autowired
    private UserService userService;

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable String id, @RequestBody UserEntity user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
    @GetMapping("/findById")
    public UserEntity findUserById(@RequestParam String id) {
        return userService.findUserById(id);
    }

    @GetMapping("/findByName")
    public UserEntity findUserByName(@RequestParam String name) {
        return userService.findUserByName(name);
    }

    @GetMapping("/findByPassword")
    public UserEntity findUserByPassword(@RequestParam String email) {
        return userService.findUserByPassword(email);
    }
}
