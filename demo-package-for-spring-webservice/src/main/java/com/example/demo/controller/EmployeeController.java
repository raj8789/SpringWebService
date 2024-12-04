package com.example.demo.controller;

import com.example.demo.annotations.PrimeNumberValidation;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

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
public ResponseEntity<EmployeeDTO> getEmployeeDTObyID(@PathVariable @Valid  int employeeID){
    EmployeeDTO  temp=employeeService.getEmployeeDTObyID(employeeID);
    if(temp==null){
        //return ResponseEntity.notFound().build();
       // throw new NoSuchElementException("No Employee Exist with id "+employeeID);
        throw new ResourceNotFoundException("No Employee Exist with id "+employeeID);
    }
    return ResponseEntity.ok(temp);
}

// This Way we can Handle Exception in this EmployeeController Controller only
//@ExceptionHandler(NoSuchElementException.class)
//public ResponseEntity<String> elementNotFound(NoSuchElementException elementException){
//        return new ResponseEntity<>("No Employee Exist with id "+elementException.getMessage(), HttpStatus.NOT_FOUND);
//}
@GetMapping("/all")
public ResponseEntity<List<EmployeeDTO>> getEmp(){
    List<EmployeeDTO> t= employeeService.getEmp();
    return ResponseEntity.ok(t);
}

    @PostMapping(path ="/enter")
    public ResponseEntity<EmployeeDTO> putEmp(@RequestBody @Valid EmployeeDTO employeeDTO){
        EmployeeDTO  employeeDTO1= employeeService.putEmp(employeeDTO);
        return ResponseEntity.ok(employeeDTO1);
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Integer employeeId){
        boolean b= employeeService.deleteEmployeeById(employeeId);
        if(!b){
            //return ResponseEntity.notFound().build();
         // throw new NoSuchElementException("No Employee Exist with id "+employeeId);
            throw new ResourceNotFoundException("No Employee Exist with id "+employeeId);
        }
        return ResponseEntity.ok(b);
    }
    @PutMapping(path ="/update/{employeeId}", consumes = "application/json")
    public ResponseEntity<EmployeeDTO> updateEmp(@RequestBody @Valid EmployeeDTO employeeDTO,@PathVariable Integer employeeId){
        return ResponseEntity.ok(employeeService.updateEmp(employeeDTO,employeeId));
    }

    @PatchMapping(path="partial/update/{employeeId}")
    public ResponseEntity<EmployeeDTO> partialUpdate(@RequestBody Map<String,Object> objectMap,@PathVariable Integer employeeId){
       EmployeeDTO t= employeeService.partialUpdate(objectMap,employeeId);
       if(t==null){
           //return ResponseEntity.notFound().build();
           throw new NoSuchElementException("No Employee Exist with id "+employeeId);
       }
       return ResponseEntity.ok(t);
    }
}
