package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/add")
    public UserEntity addUser(@RequestBody UserEntity user) {
        return service.addUser(user);
    }

    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public UserEntity updateUser(
            @PathVariable Long id,
            @RequestBody UserEntity user) {
        return service.updateUser(id, user);
    }
}