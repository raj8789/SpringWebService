package com.example.demo.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class RoleValidator implements ConstraintValidator<RoleValidation,String> {
    @Override
    public void initialize(RoleValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
        List<String> role=List.of("USER","ADMIN","admin","user");
        return role.contains(input);
    }
}
