package com.example.springmvc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studid;
    private String  studname;
    private String studdept;
    public Student(){

    }
    public Student(int studid,String studname,String studdept){
        this.studid=studid;
        this.studname=studname;
        this.studdept=studdept;
    }
    public int getStudid() {
        return studid;
    }
    public void setStudid(int studid) {
        this.studid = studid;
    }
    public String getStudname() {
        return studname;
    }
    public void setStudname(String studname) {
        this.studname = studname;
    }
    public String getStuddept() {
        return studdept;
    }
    public void setStuddept(String studdept) {
        this.studdept = studdept;
    }
}
