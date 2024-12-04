package com.example.demo.service;

import com.example.demo.controller.EmployeeController;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepositry;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        if(employeeEntity==null){
            return null;
        }
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

    public EmployeeDTO updateEmp(EmployeeDTO employeeDTO, Integer employeeId) {
        EmployeeEntity  employeeEntity= modelMapper.map(employeeDTO, EmployeeEntity.class);
        if(employeeRepositry.existsById(employeeId)) {
            employeeEntity.setId(employeeId);
        }else{
            throw new ResourceNotFoundException("Employee Not Exists with id "+employeeId);
        }
        EmployeeEntity temp= employeeRepositry.save(employeeEntity);
        return modelMapper.map(temp, EmployeeDTO.class);
    }
    public boolean deleteEmployeeById(Integer employeeId){
        if(employeeRepositry.existsById(employeeId)){
            employeeRepositry.deleteById(employeeId);
            return  true;
        }
        return false;
    }

    public EmployeeDTO partialUpdate(Map<String,Object> objectMap, Integer employeeId) {
            boolean exists=employeeRepositry.existsById(employeeId);
            if(!exists) {
                 return null;
            }
            EmployeeEntity employeeEntity=employeeRepositry.findById(employeeId).get();
            objectMap.forEach((key,value)->{
                Field field=ReflectionUtils.findField(EmployeeEntity.class,key);
                field.setAccessible(true);
                ReflectionUtils.setField(field,employeeEntity,value);
            });
            EmployeeEntity employee= employeeRepositry.save(employeeEntity);
            return modelMapper.map(employee, EmployeeDTO.class);
    }
}
