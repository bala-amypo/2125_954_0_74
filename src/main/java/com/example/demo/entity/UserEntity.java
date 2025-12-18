package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user;
    private String vehicleNumber;
    private Double capacity;
    private Double fuelEff;

    public UserEntity() {}

    public UserEntity(Long id, String user, String vehicleNumber,
                      Double capacity, Double fuelEff) {
        this.id = id;
        this.user = user;
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.fuelEff = fuelEff;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Double getCapacity() { return capacity; }
    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Double getFuelEff() { return fuelEff; }
    public void setFuelEff(Double fuelEff) {
        this.fuelEff = fuelEff;
    }
}