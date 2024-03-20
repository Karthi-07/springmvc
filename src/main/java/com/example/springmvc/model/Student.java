package com.example.springmvc.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String  studentName;
    private String studentDept;
}
