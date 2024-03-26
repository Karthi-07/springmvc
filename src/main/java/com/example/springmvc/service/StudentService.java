package com.example.springmvc.service;

import com.example.springmvc.exception.StudentNotFoundException;
import com.example.springmvc.model.Student;
import com.example.springmvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

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

    public List<Student> findStudentByDept(String dept){ return studentRepository.findByStudentDept(dept);}

    //return specific student by id
    public Student getStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent())
             return student.get();
        else
            throw new StudentNotFoundException("Student not found with the given id for getting");
    }

    //add new student into the database
    public Student addNewStudent(Student student) {
        return studentRepository.save(student);
    }

    //update the details of an existing student by id
    public Student updateStudentById(Student student) {
            return studentRepository.save(student);
    }

    //delete the particular student record by id
    public void deleteStudentById(int id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent())
             studentRepository.deleteById(id);
        else
            throw new StudentNotFoundException("With that given id student is not present for delete");
    }
}
