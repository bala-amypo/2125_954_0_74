package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.VehicleEntity;
import com.example.demo.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

    private Map<Integer, VehicleEntity> details = new HashMap<>();

    @Override
    public VehicleEntity insertVehicle(VehicleEntity vehicle) {
        details.put(vehicle.getId(), vehicle);
        return vehicle;
    }

    @Override
    public List<VehicleEntity> getAllVehicles() {
        return new ArrayList<>(details.values());
    }

    @Override
    public Optional<VehicleEntity> getOneVehicle(int id) {
        return Optional.ofNullable(details.get(id));
    }

    @Override
    public void deleteVehicle(int id) {
        details.remove(id);
    }
}
