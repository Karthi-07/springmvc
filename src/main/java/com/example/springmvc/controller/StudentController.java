package com.example.springmvc.controller;

import com.example.springmvc.model.Student;
import com.example.springmvc.repository.StudentRepository;
import com.example.springmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
  @Autowired
  private StudentService studentService;
  @Autowired
  private StudentRepository studentRepository;
  @GetMapping("/students")
   public List<Student> getStudents(){
      return studentRepository.findAll();
  }
}
