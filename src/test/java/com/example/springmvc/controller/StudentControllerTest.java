package com.example.springmvc.controller;

import com.example.springmvc.model.Student;
import com.example.springmvc.service.StudentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Objects;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
@Mock
StudentServiceImpl studentServiceImpl;
@InjectMocks
StudentController studentController;
Student student = new Student(1,"Karthi","CSE");
Student student1 = new Student(2,"Jeevan","CSE");
List<Student> studentList = List.of(student1,student);

@Test
public void findStudentById(){
    when(studentServiceImpl.getStudentById(anyInt())).thenReturn(student);
    ResponseEntity<Student> student1 = studentController.getStudent("1");
    Assertions.assertEquals(HttpStatus.OK,student1.getStatusCode());
    Assertions.assertEquals(student1.getBody(),student);
}
@Test
public void addNewStudent(){
   when(studentServiceImpl.addNewStudent(any(Student.class))).thenReturn(student);
   ResponseEntity<Student> studentResponseEntity = studentController.addStudent(student);
   Assertions.assertEquals(studentResponseEntity.getStatusCode(),HttpStatus.CREATED);
   Assertions.assertEquals(studentResponseEntity.getBody(),student);
   Assertions.assertEquals(Objects.requireNonNull(studentResponseEntity.getBody()).getStudentId(),1);
}
@Test
public void updateStudentById() {
   Student updatedStudent = new Student(1,"Karthikeyan","IT");
   when(studentServiceImpl.updateStudentById(any(Student.class))).thenReturn(updatedStudent);
   ResponseEntity<Student> student1 = studentController.updateStudent(updatedStudent);
   Assertions.assertEquals(student1.getBody(),updatedStudent);
   Assertions.assertEquals(HttpStatus.OK,student1.getStatusCode());
   Assertions.assertEquals(Objects.requireNonNull(student1.getBody()).getStudentName(),"Karthikeyan");
}
@Test
public void findAllStudents(){
    when(studentServiceImpl.getAllStudents()).thenReturn(studentList);
    ResponseEntity<List<Student>> list = studentController.getStudents();
    Assertions.assertEquals(Objects.requireNonNull(list.getBody()).size(),2);
    Assertions.assertEquals(list.getStatusCode(),HttpStatus.OK);
    Assertions.assertEquals(list.getBody().get(0).getStudentName(),"Jeevan");
}
@Test
public void studentIdNotFound(){
    when(studentServiceImpl.getStudentById(anyInt())).thenReturn(null);
    ResponseEntity<Student> statusResponseEntity = studentController.getStudent("1");
    Assertions.assertEquals(statusResponseEntity.getStatusCode(),HttpStatus.NOT_FOUND);
    Assertions.assertNull(statusResponseEntity.getBody());
}
}