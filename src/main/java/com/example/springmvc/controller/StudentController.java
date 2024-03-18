package com.example.springmvc.controller;

import com.example.springmvc.model.Student;
import com.example.springmvc.repository.StudentRepository;
import com.example.springmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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
   @GetMapping("/student/{id}")
   public Optional<Student> getStudent(@PathVariable String id){
     return studentService.getStudentById(id);
   }
   @PostMapping("/student/add")
    public Student addStudent(@RequestBody Map<String,String> student) {
      return studentService.addNewStudent(student);
   }
   @PutMapping("student/{id}")
    public Student updateStudent(@PathVariable String id,@RequestBody  Map<String,String> student){
      return studentService.updateExistingStudent(id,student);
   }
   @DeleteMapping("student/{id}")
    public void deleteStudent(@PathVariable String id){
       studentService.deleteStudentById(id);
   }

}
