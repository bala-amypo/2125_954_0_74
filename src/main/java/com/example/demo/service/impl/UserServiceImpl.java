package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private Map<Integer, UserEntity> details = new HashMap<>();

    @Override
    public UserEntity insertUser(UserEntity user) {
        details.put(user.getId(), user);
        return user;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return new ArrayList<>(details.values());
    }

    @Override
    public Optional<UserEntity> getOneUser(int id) {
        return Optional.ofNullable(details.get(id));
    }

    @Override
    public void deleteUser(int id) {
        details.remove(id);
    }
}
