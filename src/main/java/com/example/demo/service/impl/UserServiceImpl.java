package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserEntity addUser(UserEntity user) {
        return repo.save(user);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public UserEntity getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public UserEntity updateUser(Long id, UserEntity user) {
        UserEntity existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setUser(user.getUser());
            existing.setVehicleNumber(user.getVehicleNumber());
            existing.setCapacity(user.getCapacity());
            existing.setFuelEff(user.getFuelEff());
            return repo.save(existing);
        }
        return null;
    }
}