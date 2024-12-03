package com.example.demo.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD,ElementType.CONSTRUCTOR,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {WorkingAgeValidator.class}
)
public @interface WorkingAge {
    String message() default "Working age is between 18 and 85";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
