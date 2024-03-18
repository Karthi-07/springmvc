package com.example.springmvc.repository;

import com.example.springmvc.model.Student;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student,Integer>{
 List<Student> findAll();
 Student save(Student s);
 Optional<Student> findById(int id);

}
