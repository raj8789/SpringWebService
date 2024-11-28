package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repository.EmployeeRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepositry employeeRepositry;

    @GetMapping("/greet")
    public String getGreeting(){
        return "Hello Welcome to Spring MVC Tutorial";
    }

@GetMapping("/{employeeID}")
public EmployeeEntity getEmployeeDTObyID(@PathVariable int employeeID){
    return employeeRepositry.findById(employeeID).orElse(null);
}
@GetMapping("/all")
public List<EmployeeEntity> getEmp(){
    return employeeRepositry.findAll();
}

    @PostMapping(path ="/enter", consumes = "application/json")
    public EmployeeEntity putEmp(@RequestBody EmployeeEntity employeeDTO){
        return employeeRepositry.save(employeeDTO);
    }
}
