package com.microservice.courses.services;

import com.microservice.courses.client.StudentClient;
import com.microservice.courses.dto.StudentDTO;
import com.microservice.courses.entities.Course;
import com.microservice.courses.persistence.ICoursesRepository;
import com.microservice.courses.services.http.response.StudentsByCourseResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements ICoursesService{
    private final ICoursesRepository coursesRepository;
    private final StudentClient studentClient;
    @Override
    public List<Course> findAll() {
        return (List<Course>) coursesRepository.findAll();
    }

    @Override
    public Course findById(Long idCourse) {
        return coursesRepository.findById(idCourse).orElseThrow();
    }

    @Override
    public void save(Course course) {
        coursesRepository.save(course);
    }

    @Override
    public StudentsByCourseResponse findByIdCourse(Long idCourse) {
        Course course = coursesRepository.findById(idCourse).orElse(new Course());

        List<StudentDTO> studentDTOS = studentClient.findAllStudentsByCourse(idCourse);

        return StudentsByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOS)
                .build();
    }
}
