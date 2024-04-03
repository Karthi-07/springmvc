package com.example.springmvc.controller;

import com.example.springmvc.model.Student;
import com.example.springmvc.repository.StudentRepository;
import com.example.springmvc.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {
  @Autowired
  private StudentServiceImpl studentServiceImpl;
  @Autowired
  private StudentRepository studentRepository;
   @GetMapping("/all")
   public ResponseEntity<List<Student>> getStudents(){
       List<Student> studentList = studentServiceImpl.getAllStudents();
       if(!studentList.isEmpty()){
           return new ResponseEntity<>(studentList,HttpStatus.OK);
       }
       else{
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
  }
   @GetMapping("/{id}")
   public ResponseEntity<Student> getStudent(@PathVariable String id) {
       Student student = studentServiceImpl.getStudentById(Integer.parseInt(id));
       if (student != null) {
           return new ResponseEntity<>(student, HttpStatus.OK);
       } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
   }
   @GetMapping("/dept/{deptname}")
   public ResponseEntity<List<Student>> getStudentByDept(@PathVariable String deptname){
       List<Student> studentList = studentServiceImpl.findStudentByDept(deptname);
       if(!studentList.isEmpty()){
           return new ResponseEntity<>(studentList,HttpStatus.OK);
       } else{
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
   }
   @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
       studentServiceImpl.addNewStudent(student);
       return new ResponseEntity<>(student,HttpStatus.CREATED);
   }
   @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
       studentServiceImpl.updateStudentById(student);
       return new ResponseEntity<>(student,HttpStatus.OK);
   }
   @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable String id){
       String value = studentServiceImpl.deleteStudentById(Integer.parseInt(id));
       if(value.equals("Successfully deleted"))
           return new ResponseEntity<>(HttpStatus.OK);
       else
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
}
