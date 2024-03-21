package com.example.springmvc.controller;

import com.example.springmvc.model.Student;
import com.example.springmvc.repository.StudentRepository;
import com.example.springmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
   public Student getStudent(@PathVariable String id){
       return studentService.getStudentById(id);
   }
   @GetMapping("student/dept/{deptname}")
   public List<Student> getStudentByDept(@PathVariable String deptname){
       return studentService.findStudentByDept(deptname);
   }
   @PostMapping("/student/add")
    public Student addStudent(@RequestBody Student student) {
      return studentService.addNewStudent(student);
   }
   @PutMapping("student/{id}")
    public Student updateStudent(@PathVariable String id,@RequestBody Student student){
      return studentService.updateStudentById(Integer.parseInt(id),student);
   }
   @DeleteMapping("student/{id}")
    public void deleteStudent(@PathVariable String id){
       studentService.deleteStudentById(id);
   }
}
