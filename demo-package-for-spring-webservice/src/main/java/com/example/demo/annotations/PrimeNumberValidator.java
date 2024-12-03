package com.example.demo.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumberValidation,Integer> {
    @Override
    public void initialize(PrimeNumberValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        for(int i=2;i<integer;i++){
            if(integer%i==0){
                return false;
            }
        }
        return true;
    }
}
