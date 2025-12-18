package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.UserEntity;

public interface UserService {

    UserEntity insertUser(UserEntity user);
    List<UserEntity> getAllUsers();
    Optional<UserEntity> getOneUser(int id);
    void deleteUser(int id);
}
