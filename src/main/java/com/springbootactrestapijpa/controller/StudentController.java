package com.springbootactrestapijpa.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootactrestapijpa.model.Course;
import com.springbootactrestapijpa.model.Student;
import com.springbootactrestapijpa.repository.StudentRepository;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository){
        this.studentRepository =studentRepository;
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/getById/{id}")
    public Optional<Student> getById(@PathVariable Long id) {
        return studentRepository.findById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        studentRepository.deleteById(id);
    }

    @PutMapping("/updateById/{id}")
    public Student updateById(@PathVariable Long id, @RequestBody Student updatedStudent){
        Student student = studentRepository.findById(id).orElseThrow();
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail());
        student.setCourse(updatedStudent.getCourse());
        return studentRepository.save(student);
    }

    @PostMapping("/{id}/enroll")
        public Student enroll(@PathVariable Long id, @RequestBody Course course){
        Student student = studentRepository.findById(id).orElseThrow();
        student.setCourse(course);
        return studentRepository.save(student);
        }

    @PostMapping("/{id}/drop")
    public Student drop(@PathVariable Long id, @RequestBody Course course){
        Student student = studentRepository.findById(id).orElseThrow();
        student.setCourse(null);
        return studentRepository.save(student);
    }
}
