package com.example.BasicCRUD.controller;

import com.example.BasicCRUD.exception.CustomerErrorResponse;
import com.example.BasicCRUD.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomErrorController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<CustomerErrorResponse> handleNotFoundException(NotFoundException exe) {
        CustomerErrorResponse error = new CustomerErrorResponse();
        error.setMessage(exe.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
