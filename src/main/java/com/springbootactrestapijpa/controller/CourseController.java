package com.springbootactrestapijpa.controller;


import org.springframework.web.bind.annotation.*;

import com.springbootactrestapijpa.model.Course;
import com.springbootactrestapijpa.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @GetMapping("/displayCourse")
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable Long id){
        return courseRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Course updatedCourse(@PathVariable Long id, @RequestBody Course updatedCourse){
        Course course = courseRepository.findById(id).orElseThrow();
        course.setName(updatedCourse.getName());
        return courseRepository.save(course);

    }
}
