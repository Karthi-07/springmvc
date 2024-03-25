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
    public Student getStudentById(String id) {
        Optional<Student> student = studentRepository.findById(Integer.parseInt(id));
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
    public Student updateStudentById(int id, Student student) {
        Optional<Student> s1 = studentRepository.findById(id);
        if(s1.isPresent()) {
            s1.get().setStudentName(student.getStudentName());
            s1.get().setStudentDept(student.getStudentDept());
            s1.get().setStudentId(student.getStudentId());
            return studentRepository.save(s1.get());
        }
        else
            throw new StudentNotFoundException("Student not found with the given id for update");
    }

    //delete the particular student record by id
    public void deleteStudentById(String id){
        Optional<Student> student = studentRepository.findById(Integer.parseInt(id));
        if(student.isPresent())
             studentRepository.deleteById(Integer.parseInt(id));
        else
            throw new StudentNotFoundException("With that given id student is not present for delete");
    }
}
