package com.example.demo.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {RoleValidator.class}
)
public @interface RoleValidation {
    String message() default "Role can be ADMIN or USER only";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
