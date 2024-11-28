package com.example.demo.dto;

import java.time.LocalDate;

public class EmployeeDTO {
    private Integer id;
    private String name;
    private String email;
    private LocalDate dateOdJoining;

    private Boolean isActive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOdJoining() {
        return dateOdJoining;
    }

    public void setDateOdJoining(LocalDate dateOdJoining) {
        this.dateOdJoining = dateOdJoining;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public EmployeeDTO(Integer id, String name, String email, LocalDate dateOdJoining, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOdJoining = dateOdJoining;
        this.isActive = isActive;
    }
}
