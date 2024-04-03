package com.example.springmvc.service;

import com.example.springmvc.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    List<Student> findStudentByDept(String dept);
    Student getStudentById(int id);
    Student addNewStudent(Student student);
    Student updateStudentById(Student student);
    String deleteStudentById(int id);
}
