package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle") // Optional, matches your DB table name
public class VehicleEntity {

    @Id
    private Long id;

    private String name;
    private String email;

    // Default constructor required by JPA
    public VehicleEntity() {
    }

    // Constructor
    public VehicleEntity(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getter and setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
