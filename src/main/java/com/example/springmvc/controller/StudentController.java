package com.example.springmvc.controller;

import com.example.springmvc.model.Student;
import com.example.springmvc.repository.StudentRepository;
import com.example.springmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
  @Autowired
  private StudentService studentService;
  @Autowired
  private StudentRepository studentRepository;
  @GetMapping("/students")
   public List<Student> getStudents(){
      return studentService.getAllStudents();
  }
  @GetMapping("/students/{id}")
   public Optional<Student> getStudentById(@PathVariable String id){
      int id1 = Integer.parseInt(id);
      return studentRepository.findById(id1);
  }
}
