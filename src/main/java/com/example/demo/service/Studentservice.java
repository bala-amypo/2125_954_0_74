package com.example.demo.service;

import java.util.*;

import org.springframework.stereotype.service;
import com.example.demo.entity.Studententity;

@service
public class Studentservice{
    private Map<Integer,Studententity> details=new HashMap<>();

    public Studententity saveData(Studententity st){
        details.put(st.getId(),st);
        return st;
    }
    public Studententity getStudent(int id){
        return details.get(id);
    }
    public List<Studententity> getStudents(){
        return details.values().stream().collect(Collectors.toList());
    }
    public Studententity updateStudent(int id,Studententity st){
        if(details.containsKey(id)){
            Studententity existing = details.get(id);
            existing
        }
    }
}