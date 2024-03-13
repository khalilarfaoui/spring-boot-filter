package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmplyeeRep extends JpaRepository<Employee , Integer> {

    Employee findEmployeeByName(String name);
}
