package com.example.demo.dto;

import com.example.demo.annotations.RoleValidation;
import com.example.demo.annotations.WorkingAge;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
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

    @NotNull
    @NotBlank(message = "Name of Employee Can't be blank")
    // @NotEmpty(message = "Name of Employee Can't be blank") // it will take empty string
    @Size(max = 10, min = 2, message = "Please Enter The length of name between 2 and 10 character only")
    private String name;
    @NotNull(message = "Age can not be Empty")
//    @Max(value = 85, message = "Age should be less than 86 for Corporate Employee")
//    @Min(value = 18, message = "Age should be Greater than 18 for Corporate Employee")
    @WorkingAge
    private Integer age;

    @NotNull
    @DecimalMax(value = "1000000.00",message = "Salary should be less than 1000000.00")
    @DecimalMin(value = "10000.00",message = "Salary Should be greater than 10000.00")
    private Double salary;
    // @Email(message = "Format of Mail is Not Correct")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format")
    private String email;
    @JsonProperty("dateOfJoining")
    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    private LocalDate dateOdJoining;
    @NotBlank(message = "Role of Employee Can not be blank")
   // @Pattern(regexp = "^(ADMIN|USER|admin|user)$", message = "Role can be ADMIN or USER only")
    @RoleValidation
    private String role;
    @JsonProperty("active")
    @AssertTrue(message = "Employee Should be active")
    private Boolean isActive;

}
