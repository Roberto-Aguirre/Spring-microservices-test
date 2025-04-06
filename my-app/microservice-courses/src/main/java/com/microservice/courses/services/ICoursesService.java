package com.microservice.courses.services;

import com.microservice.courses.entities.Course;
import com.microservice.courses.services.http.response.StudentsByCourseResponse;

import java.util.List;

public interface ICoursesService {
    List<Course> findAll();
    Course findById(Long idCourse);
    void save(Course course);

    StudentsByCourseResponse findByIdCourse(Long idCourse);
}
