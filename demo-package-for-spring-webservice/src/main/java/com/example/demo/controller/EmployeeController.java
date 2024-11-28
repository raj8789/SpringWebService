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
//    public EmployeeController(EmployeeRepositry employeeRepositry){
//        this.employeeRepositry=employeeRepositry;
//    }
    @GetMapping("/greet")
    public String getGreeting(){
        return "Hello Welcome to Spring MVC Tutorial";
    }
//    @GetMapping("/{employeeID}")
//    public EmployeeDTO getEmployeeDTObyID(@PathVariable int employeeID){
//        return new EmployeeDTO(employeeID,"Raushan","raj@gamil.com", LocalDate.of(2024,1,24),true);
//    }
@GetMapping("/{employeeID}")
public EmployeeEntity getEmployeeDTObyID(@PathVariable int employeeID){
    //return new EmployeeDTO(employeeID,"Raushan","raj@gamil.com", LocalDate.of(2024,1,24),true);
    return employeeRepositry.findById(employeeID).orElse(null);
}
//    @GetMapping()
//    public EmployeeDTO getEmp(@RequestParam(required = false) int id,@RequestParam(required = false) String name){
//        return new EmployeeDTO(id,name,"raj@gamil.com", LocalDate.of(2024,1,24),true);
//    }
@GetMapping("/all")
public List<EmployeeEntity> getEmp(){
    return employeeRepositry.findAll();
}

//    @PostMapping(path ="/enter", consumes = "application/json")
//    public EmployeeDTO putEmp(@RequestBody EmployeeDTO employeeDTO){
//        employeeDTO.setId(100);
//        return employeeDTO;
//    }
    @PostMapping(path ="/enter", consumes = "application/json")
    public EmployeeEntity putEmp(@RequestBody EmployeeEntity employeeDTO){
        return employeeRepositry.save(employeeDTO);
    }
}
