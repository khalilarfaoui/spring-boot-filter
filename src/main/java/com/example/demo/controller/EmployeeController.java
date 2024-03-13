package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.Room;
import com.example.demo.repository.EmplyeeRep;
import com.example.demo.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmplyeeRep emplyeeRep;
    @Autowired
    RoomRepo roomRepo;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return emplyeeRep.findAll();
    }
    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        return emplyeeRep.save(employee);
    }

    @GetMapping("getEmployeeByName/{name}")
    public Employee getEmployeeByName(@PathVariable String name){
        return emplyeeRep.findEmployeeByName(name);
    }


}
