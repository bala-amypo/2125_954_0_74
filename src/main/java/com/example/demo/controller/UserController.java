package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl ser;

    @Autowired
    UserService service;

    @PostMapping("/user/add")
    public UserEntity post(@RequestBody UserEntity user) {
        return ser.saveData(user);
    }

    @GetMapping("/user/getAll")
    public List<UserEntity> getAll() {
        return service.getAllUsers();
    }

    @GetMapping("/user/get/{id}")
    public Optional<UserEntity> get(@PathVariable int id) {
        return service.getOneUser(id);
    }

    @PutMapping("/user/update/{id}")
    public String update(@PathVariable int id, @RequestBody UserEntity newUser) {
        Optional<UserEntity> user = service.getOneUser(id);
        if (user.isPresent()) {
            newUser.setId(id);
            service.insertUser(newUser);
            return "Updated successfully";
        }
        return "Id not found";
    }

    @DeleteMapping("/user/del/{id}")
    public String deleteUser(@PathVariable int id) {
        Optional<UserEntity> user = service.getOneUser(id);
        if (user.isPresent()) {
            service.deleteUser(id);
            return "Deleted successfully";
        }
        return "Id not found";
    }
}
