package com.microservice.students.service;

import com.microservice.students.entities.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(Long id);
    void save(Student student);
    List<Student> findByCourse(Long idCourse);
}
