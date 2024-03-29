package com.example.springboot.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message() default "Password must be at least 8 characters long";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
