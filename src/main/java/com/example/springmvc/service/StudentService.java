package com.example.springmvc.service;

import com.example.springmvc.model.Student;
import com.example.springmvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    //return all the students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //return specific student by id
    public Optional<Student> getStudentById(String id) {
        Integer id1 = Integer.parseInt(id);
        return studentRepository.findById(id1);
    }

    //add new student into the database
    public Student addNewStudent(Map<String, String> student) {
        int id = Integer.parseInt(student.get("studid"));
        String name = student.get("studname");
        String dept = student.get("studdept");
        System.out.println(id + " " + name + " " + dept);
        return studentRepository.save(new Student(id, name, dept));
    }

    //update the details of an existing student by id
    public Student updateExistingStudent(String id, Map<String, String> student) {
        int id1 = Integer.parseInt(id);
        Optional<Student> s1 = studentRepository.findById(id1);
        Student c = s1.orElse(new Student());
        c.setStudname(student.get("studname"));
        c.setStuddept(student.get("studdept"));
        return studentRepository.save(c);
    }

    //delete the particular student record by id
    public void deleteStudentById(String id){
        studentRepository.deleteById(Integer.parseInt(id));
    }
}
