package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/greet")
    public String getGreeting(){
        return "Hello Welcome to Spring MVC Tutorial";
    }

@GetMapping("/{employeeID}")
public EmployeeDTO getEmployeeDTObyID(@PathVariable int employeeID){
    return employeeService.getEmployeeDTObyID(employeeID);
}
@GetMapping("/all")
public List<EmployeeDTO> getEmp(){
    return employeeService.getEmp();
}

    @PostMapping(path ="/enter", consumes = "application/json")
    public EmployeeDTO putEmp(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.putEmp(employeeDTO);
    }
}
