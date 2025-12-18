package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

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
    public UserEntity post(@RequestBody UserEntity user) {
        return service.insertUser(user);
    }

    @GetMapping("/getAll")
    public List<UserEntity> getAll() {
        return service.getAllUsers();
    }

    @GetMapping("/get/{id}")
    public Optional<UserEntity> get(@PathVariable int id) {
        return service.getOneUser(id);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody UserEntity newUser) {
        Optional<UserEntity> user = service.getOneUser(id);
        if (user.isPresent()) {
            newUser.setId(id);
            service.insertUser(newUser);
            return "Updated successfully";
        }
        return "Id not found";
    }

    @DeleteMapping("/del/{id}")
    public String deleteUser(@PathVariable int id) {
        Optional<UserEntity> user = service.getOneUser(id);
        if (user.isPresent()) {
            service.deleteUser(id);
            return "Deleted successfully";
        }
        return "Id not found";
    }
}
