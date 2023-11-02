package com.example.springboot.Exception;

import com.example.springboot.Exception.UsernameAlreadyExistsException;
import com.example.springboot.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ApiResponse handleUsernameAlreadyExistsException(UsernameAlreadyExistsException ex) {
    return new ApiResponse(HttpStatus.CONFLICT, ex.getMessage());
    }
}

