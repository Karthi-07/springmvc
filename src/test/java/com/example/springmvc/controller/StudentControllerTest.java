package com.example.springmvc.controller;

import com.example.springmvc.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
class StudentControllerTest {
@Mock
private StudentService studentService;
@InjectMocks
private StudentController studentController;

@BeforeEach
public void setup(){
    MockitoAnnotations.openMocks(this);
}

@Test
public void getStudent(){
    
}
}