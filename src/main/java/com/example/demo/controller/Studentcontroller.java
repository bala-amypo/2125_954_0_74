package com.example.demo.Studentcontroller;

import java.util.*;

import org.springframework.bean.factory.annotation.Autowired;
import org.springframework.web.bind.annotation

import com.example.demo.entity.Studententity;
import com.example.demo.service.Studentservice;

@RestController
public class Studentcontroller{

    @Autowired
    private Studentservice ser;

    @PostMapping("/Postadd")
    public Studentity saveData(@RequestBody Studententity st){
        return ser.saveData(st);
    }
    @GetMapping("/Getadd/{id}")
    public Studententity getStudent(@PathVariable int id){
        return ser.getStudent(id);
    }
    @GetMapping("/GetAll")
    public List<Studententity> getAllStudents(){
        return ser.getStudents();
    }
    @PutMapping("/Update/{id}")
    public Studententity updateStudent(@PathVariable int id,@RequestBody Studententity st){
        return ser.updateStudent(id,st);
    }
}