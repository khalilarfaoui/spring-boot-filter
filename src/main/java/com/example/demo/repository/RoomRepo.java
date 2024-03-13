package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepo extends JpaRepository<Room , Integer> {
    Room findRoomByRoomNumbr(String roomNumber);

    List<Room> findRoomsByEmployee(Employee employee);
}
