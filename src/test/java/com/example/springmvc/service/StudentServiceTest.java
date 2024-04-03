package com.example.springmvc.service;

import com.example.springmvc.exception.StudentNotFoundException;
import com.example.springmvc.model.Student;
import com.example.springmvc.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
@Mock
private StudentRepository studentRepository;
@InjectMocks
private StudentServiceImpl studentServiceImpl;
@BeforeEach
public void setup(){
    MockitoAnnotations.openMocks(this);
}
@Test
public void getAllStudents() {
    Student s1 = new Student(14, "Gopal", "ECE");
    Student s2 = new Student(11, "Tamil", "CA");
    List<Student> studentlist = new ArrayList<>();
    studentlist.add(s1);
    studentlist.add(s2);
    when(studentRepository.findAll()).thenReturn(studentlist);
    List<Student> students = studentServiceImpl.getAllStudents();
    Assertions.assertEquals(students.size(), 2);
    Assertions.assertEquals(students.get(0).getStudentName(),"Gopal");
    Assertions.assertEquals(students.get(1).getStudentDept(),"CA");
}
@Test
public void getStudentById() {
   Student s = new Student(13,"Bala","IT");
   when(studentRepository.findById(anyInt())).thenReturn(Optional.of(s));
   Student student = studentServiceImpl.getStudentById(13);
   org.assertj.core.api.Assertions.assertThat(student.getStudentId()).isEqualTo(13);
   Assertions.assertEquals(s.getStudentDept(),"IT");
}
@Test
public void studentNotFound(){
 when(studentRepository.findById(anyInt())).thenReturn(Optional.empty());
 Assertions.assertThrows(StudentNotFoundException.class,()->{
  studentServiceImpl.getStudentById(1);
 });
 verify(studentRepository).findById(anyInt());
}
@Test
public void addNewStudent(){
    Student s = new Student(11,"kiran","MECH");
    when(studentRepository.save(s)).thenReturn(s);
    Student savedStudent = studentServiceImpl.addNewStudent(s);
    Assertions.assertEquals("MECH",savedStudent.getStudentDept());
    Assertions.assertEquals("kiran",savedStudent.getStudentName());
    org.assertj.core.api.Assertions.assertThat(s).isNotNull();
    org.assertj.core.api.Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
}
@Test
public void findStudentsByDept(){
    Student student = new Student(1,"Tamil","CSE");
    Student student1 = new Student(2,"Renoline","CSE");
    List<Student> studentList = new ArrayList<>();
    studentList.add(student);
    studentList.add(student1);
    when(studentRepository.findByStudentDept(anyString())).thenReturn(studentList);
    List<Student> studentList1 = studentServiceImpl.findStudentByDept("CSE");
    org.assertj.core.api.Assertions.assertThat(studentList1).isNotNull();
    Assertions.assertEquals(studentList1.size(),2);
    Assertions.assertEquals(studentList1.get(0).getStudentName(),"Tamil");
    Assertions.assertEquals(studentList1.get(1).getStudentName(),"Renoline");
}
@Test
public void updateStudentById(){
 Student student = new Student(19,"Mahir","CSE");
 Student updatedStudent = new Student(19,"Sheik","IT");
 when(studentRepository.findById(anyInt())).thenReturn(Optional.of(student));
 when(studentRepository.save(any(Student.class))).thenReturn(updatedStudent);
 Student resultStudent = studentServiceImpl.updateStudentById(updatedStudent);
 Assertions.assertEquals(resultStudent.getStudentName(),"Sheik");
 Assertions.assertEquals(resultStudent.getStudentDept(),"IT");
}
@Test
public void updateStudentNotFound(){
    Student s1 = new Student(1,"karthi","CSE");
    when(studentRepository.findById(1)).thenReturn(Optional.empty());
    Assertions.assertThrows(StudentNotFoundException.class,()->{
        studentServiceImpl.updateStudentById(s1);
    });
    verify(studentRepository,never()).save(new Student(1,"keyan","IT"));
}
@Test
public void deleteStudentById(){
Student student = new Student(11,"kiran","CSE");
when(studentRepository.findById(anyInt())).thenReturn(Optional.of(student));
String val = studentServiceImpl.deleteStudentById(11);
verify(studentRepository).deleteById(11);
Assertions.assertEquals(val,"Successfully deleted");
}
@Test
public void deleteStudentNotFound(){
when(studentRepository.findById(anyInt())).thenReturn(Optional.empty());
Assertions.assertThrows(StudentNotFoundException.class,()->{
    studentServiceImpl.deleteStudentById(1);
});
verify(studentRepository,never()).deleteById(1);
}
}