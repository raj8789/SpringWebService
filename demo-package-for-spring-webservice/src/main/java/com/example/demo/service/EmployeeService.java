package com.example.demo.service;

import com.example.demo.controller.EmployeeController;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repository.EmployeeRepositry;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepositry employeeRepositry;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepositry employeeRepositry,ModelMapper modelMapper) {
        this.employeeRepositry = employeeRepositry;
        this.modelMapper=modelMapper;
    }
    public EmployeeDTO getEmployeeDTObyID(int employeeID){
        EmployeeEntity employeeEntity=employeeRepositry.findById(employeeID).orElse(null);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }
    public List<EmployeeDTO> getEmp(){
        List<EmployeeDTO> ans=new ArrayList<>();
        for (EmployeeEntity e:employeeRepositry.findAll()){
            ans.add(modelMapper.map(e, EmployeeDTO.class));
        }
        return ans;
    }
    public EmployeeDTO putEmp(EmployeeDTO employeeDTO){
        EmployeeEntity temp=employeeRepositry.save(modelMapper.map(employeeDTO,EmployeeEntity.class));
        return modelMapper.map(temp, EmployeeDTO.class);
    }
}
