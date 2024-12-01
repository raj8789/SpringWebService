package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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

    @DeleteMapping("/delete/{employeeId}")
    public boolean deleteEmployeeById(@PathVariable Integer employeeId){
        return employeeService.deleteEmployeeById(employeeId);
    }
    @PutMapping(path ="/update/{employeeId}", consumes = "application/json")
    public EmployeeDTO updateEmp(@RequestBody EmployeeDTO employeeDTO,@PathVariable Integer employeeId){
        return employeeService.updateEmp(employeeDTO,employeeId);
    }

    @PatchMapping(path="partial/update/{employeeId}")
    public EmployeeDTO partialUpdate(@RequestBody Map<String,Object> objectMap,@PathVariable Integer employeeId){
        return employeeService.partialUpdate(objectMap,employeeId);
    }
}
