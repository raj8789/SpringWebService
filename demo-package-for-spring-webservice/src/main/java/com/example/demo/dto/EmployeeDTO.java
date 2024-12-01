package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("dateOfJoining")
    private LocalDate dateOdJoining;

    @JsonProperty("active")
    private Boolean isActive;

}
