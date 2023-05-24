package com.springbootactrestapijpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.springbootactrestapijpa.model.Course;
import com.springbootactrestapijpa.model.Student;
import com.springbootactrestapijpa.repository.StudentRepository;

public class StudentServiceImpl implements StudentService{

    @Autowired
	private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll();

    }

    @Override
    public Optional<Student> getById( Long id) {
        return studentRepository.findById(id);
    }


    @Override
    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }
    
    @Override
    public Student updateById(Long id, Student updatedStudent){
        Student student = studentRepository.findById(id).orElseThrow();
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail());
        student.setCourse(updatedStudent.getCourse());
        return studentRepository.save(student);
    }

    @Override
    public Student enroll(Long id, Course course){
        Student student = studentRepository.findById(id).orElseThrow();
        student.setCourse(course);
        return studentRepository.save(student);
    }

    @Override
    public Student drop(Long id, Course course){
        Student student = studentRepository.findById(id).orElseThrow();
        student.setCourse(null);
        return studentRepository.save(student);
    }
    
}
