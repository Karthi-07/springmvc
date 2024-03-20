package com.example.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    //Student with that id not found
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorObject> studentNotFoundException(StudentNotFoundException studentNotFoundException, WebRequest webRequest){
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObject.setMessage(studentNotFoundException.getMessage());
        return new ResponseEntity<>(errorObject,HttpStatus.NOT_FOUND);
    }
}
