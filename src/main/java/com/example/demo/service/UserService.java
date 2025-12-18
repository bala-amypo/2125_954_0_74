package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.UserEntity;

public interface UserService {

    UserEntity addUser(UserEntity user);

    List<UserEntity> getAllUsers();

    UserEntity getUserById(Long id);

    UserEntity updateUser(Long id, UserEntity user);
}