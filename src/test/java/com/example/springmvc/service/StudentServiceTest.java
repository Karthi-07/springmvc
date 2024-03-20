package com.example.springmvc.service;

import com.example.springmvc.model.Student;
import com.example.springmvc.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class StudentServiceTest {
@Mock
private StudentRepository studentRepository;
@InjectMocks
private StudentService studentService;
@BeforeEach
public void setup(){
    MockitoAnnotations.openMocks(this);
}
//@Test
//public void getAllStudents() {
//  Student s1 = new Student(14,"Gopal","ECE");
//  Student s2 = new Student(15,"Mathan","EEE");
//  List<Student> studentlist = new ArrayList<>();
//  studentlist.add(s1);
//  studentlist.add(s2);
//  Mockito.when(studentRepository.findAll()).thenReturn(studentlist);
//
//}
//@Test
//public void addNewStudent(){
//    //arrange
//    Student s = new Student(11,"kiran","MECH");
//    //act
//    Mockito.when(studentRepository.save(s)).thenReturn(s);
//    Student student = studentRepository.save(s);
//    //assertions
//    Assertions.assertEquals("MECH",s.);
//    Assertions.assertEquals("kiran",s.getStudname());
//    org.assertj.core.api.Assertions.assertThat(s).isNotNull();
//    org.assertj.core.api.Assertions.assertThat(s.getStudid()).isGreaterThan(0);
//}
//@Test
//public void getStudentById() {
//   Student s = new Student(13,"Bala","IT");
//   Mockito.when(studentRepository.findById(13)).thenReturn(s);
//   org.assertj.core.api.Assertions.assertThat(s.getStudid()).isEqualTo(13);
//   Assertions.assertEquals(s.getStudid(),13);
//}
}