package com.example.demo.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@Data
public class ApiError {
    String message;
    HttpStatus status;

    List<String> errors;
}
