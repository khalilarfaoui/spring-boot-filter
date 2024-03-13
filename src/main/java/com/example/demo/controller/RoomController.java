package com.example.demo.controller;


import com.example.demo.model.Employee;
import com.example.demo.model.Room;
import com.example.demo.repository.EmplyeeRep;
import com.example.demo.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("room")
public class RoomController {

    @Autowired
    RoomRepo roomRepo;

    @Autowired
    EmplyeeRep emplyeeRep;

    @GetMapping
    public List<Room> getAllRoom(){
        return roomRepo.findAll();
    }
    @PostMapping
    public Room saveRoom(@RequestBody Room room){
        return roomRepo.save(room);
    }

    @GetMapping("/getByNumero/{numeroRoom}")
    public Room getRoomByNumero(@PathVariable String numeroRoom){
        return roomRepo.findRoomByRoomNumbr(numeroRoom);
    }

    @GetMapping("/getEmployeeByNumeroRoom/{numeroRoom}")
    public Employee getEmployeeByNumero(@PathVariable String numeroRoom){
        Room r =  roomRepo.findRoomByRoomNumbr(numeroRoom);
        return r.getEmployee();
    }

    @GetMapping("getRoomListByIdEmployee/{idEmployee}")
    public List<Room> getAllRoomByEmployeeId(@PathVariable int idEmployee){
        Employee employee = emplyeeRep.findById(idEmployee).orElse(null);
        return roomRepo.findRoomsByEmployee(employee);
    }

    @GetMapping("getRoomListByNameEmployee/{name}")
    public List<Room> getAllRoomByEmployeeName(@PathVariable String name){
        Employee employee = emplyeeRep.findEmployeeByName(name);
        return roomRepo.findRoomsByEmployee(employee);
    }
}
