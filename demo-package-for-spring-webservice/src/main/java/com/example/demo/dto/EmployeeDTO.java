package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class EmployeeDTO {
    private Integer id;
    private String name;
    private String email;
    private LocalDate dateOdJoining;

    private Boolean isActive;

}
