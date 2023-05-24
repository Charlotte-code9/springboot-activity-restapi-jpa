package com.springbootactrestapijpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springbootactrestapijpa.model.Course;
import com.springbootactrestapijpa.model.Student;


@Service
public interface StudentService {
    Student addStudent(Student student);
    List<Student> getAllStudents();
    Optional<Student> getById( Long id);
    void deleteById(Long id);
    Student updateById(Long id, Student updatedStudent);
    Student enroll(Long id, Course course);
    Student drop(Long id, Course course);
}
