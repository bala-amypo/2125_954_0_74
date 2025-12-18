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

import com.example.demo.entity.VehicleEntity;
import com.example.demo.service.VehicleService;
import com.example.demo.service.VehicleServiceImpl;

@RestController
public class VehicleController {

    @Autowired
    VehicleServiceImpl ser;

    @Autowired
    VehicleService service;

    @PostMapping("/vehicle/add")
    public VehicleEntity post(@RequestBody VehicleEntity vehicle) {
        return ser.saveData(vehicle);
    }

    @GetMapping("/vehicle/getAll")
    public List<VehicleEntity> getAll() {
        return service.getAllVehicles();
    }

    @GetMapping("/vehicle/get/{id}")
    public Optional<VehicleEntity> get(@PathVariable int id) {
        return service.getOneVehicle(id);
    }

    @PutMapping("/vehicle/update/{id}")
    public String update(@PathVariable int id, @RequestBody VehicleEntity newVehicle) {
        Optional<VehicleEntity> vehicle = service.getOneVehicle(id);
        if (vehicle.isPresent()) {
            newVehicle.setId(id);
            service.insertVehicle(newVehicle);
            return "Updated successfully";
        }
        return "Id not found";
    }

    @DeleteMapping("/vehicle/del/{id}")
    public String deleteVehicle(@PathVariable int id) {
        Optional<VehicleEntity> vehicle = service.getOneVehicle(id);
        if (vehicle.isPresent()) {
            service.deleteVehicle(id);
            return "Deleted successfully";
        }
        return "Id not found";
    }
}
