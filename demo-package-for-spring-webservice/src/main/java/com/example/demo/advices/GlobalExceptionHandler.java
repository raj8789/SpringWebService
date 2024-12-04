package com.example.demo.advices;


import com.example.demo.exception.ResourceNotFoundException;
import org.hibernate.ResourceClosedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

// This Class Is Used for Handling Global Exception Raised In Controller Level
@RestControllerAdvice
public class GlobalExceptionHandler {

    // By using RestControllerAdvice Now This Exception Handling is Available Globally
   // @ExceptionHandler(NoSuchElementException.class)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> elementNotFound(ResourceNotFoundException elementException){
        ApiError error= ApiError.builder().status(HttpStatus.NOT_FOUND).message(elementException.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> invalidParameter(MethodArgumentNotValidException elementException){
        List<String> errorMessage= elementException.getBindingResult().getAllErrors().stream().map(objectError ->objectError.getDefaultMessage()).collect(Collectors.toList());
        ApiError error= ApiError.builder().status(HttpStatus.BAD_REQUEST).message("Invalid Argument").errors(errorMessage).build();
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> AllError(Exception elementException){
        ApiError error= ApiError.builder().status(HttpStatus.BAD_REQUEST).message(elementException.getClass().getName()+"@@"+elementException.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
