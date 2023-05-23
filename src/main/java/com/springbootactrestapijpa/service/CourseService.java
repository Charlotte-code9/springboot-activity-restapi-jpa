package com.springbootactrestapijpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.springbootactrestapijpa.model.Course;
import com.springbootactrestapijpa.repository.CourseRepository;

public class CourseService {
    private final CourseRepository courseRepository;
    @Autowired
    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }


    public Course addCourse(Course course){
        return courseRepository.save(course);
    }


    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }


    public Optional<Course> getCourseById(Long id){
        return courseRepository.findById(id);
    }


    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }

    public Course updatedCourse( Long id, Course updatedCourse){
        Course course = courseRepository.findById(id).orElseThrow();
        course.setName(updatedCourse.getName());
        return courseRepository.save(course);

    }
}
