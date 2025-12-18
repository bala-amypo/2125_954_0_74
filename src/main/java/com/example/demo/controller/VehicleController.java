package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.VehicleEntity;
import com.example.demo.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @PostMapping("/add")
    public VehicleEntity post(@RequestBody VehicleEntity vehicle) {
        return service.insertVehicle(vehicle);
    }

    @GetMapping("/getAll")
    public List<VehicleEntity> getAll() {
        return service.getAllVehicles();
    }

    @GetMapping("/get/{id}")
    public Optional<VehicleEntity> get(@PathVariable int id) {
        return service.getOneVehicle(id);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody VehicleEntity newVehicle) {
        Optional<VehicleEntity> vehicle = service.getOneVehicle(id);
        if (vehicle.isPresent()) {
            newVehicle.setId(id);
            service.insertVehicle(newVehicle);
            return "Updated successfully";
        }
        return "Id not found";
    }

    @DeleteMapping("/del/{id}")
    public String deleteVehicle(@PathVariable int id) {
        Optional<VehicleEntity> vehicle = service.getOneVehicle(id);
        if (vehicle.isPresent()) {
            service.deleteVehicle(id);
            return "Deleted successfully";
        }
        return "Id not found";
    }
}
