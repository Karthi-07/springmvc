package com.example.springmvc.controller;

import com.example.springmvc.model.Student;
import com.example.springmvc.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.engine.TestExecutionResult;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

@Mock
StudentService studentService;
@InjectMocks
StudentController studentController;
@Autowired
MockMvc  mockMvc;

//@Test
//public void addNewStudent() throws Exception{
//    String uri = "/student/add";
//    Student student = new Student(22,"Arun","IT");
//    mockMvc.perform(MockMvcRequestBuilders
//            .post(uri)
//            .content(jsonToString(student))
//            .contentType(MediaType.APPLICATION_JSON)
//            .accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isCreated())
//            .andExpect(MockMvcResultMatchers.jsonPath("$.studentId").exists());
//}
//public String jsonToString(Object obj) throws JsonProcessingException {
//    return new ObjectMapper().writeValueAsString(obj);
//}
@Test
public void getStudent(){
    
}
}