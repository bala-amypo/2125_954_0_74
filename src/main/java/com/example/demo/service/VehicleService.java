package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.VehicleEntity;

public interface VehicleService {

    VehicleEntity insertVehicle(VehicleEntity vehicle);
    List<VehicleEntity> getAllVehicles();
    Optional<VehicleEntity> getOneVehicle(int id);
    void deleteVehicle(int id);
}
