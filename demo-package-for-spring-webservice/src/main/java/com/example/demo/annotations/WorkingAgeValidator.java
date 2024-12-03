package com.example.demo.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class WorkingAgeValidator implements ConstraintValidator<WorkingAge,Integer> {
    @Override
    public void initialize(WorkingAge constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {
        return (age>=18 && age<=85);
    }
}
