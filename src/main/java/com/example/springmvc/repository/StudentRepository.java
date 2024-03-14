package com.example.springmvc.repository;

import com.example.springmvc.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository {
 List<Student> findAll();

}
