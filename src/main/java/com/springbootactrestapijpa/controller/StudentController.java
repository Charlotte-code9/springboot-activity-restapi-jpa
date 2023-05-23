package com.springbootactrestapijpa.controller;

import org.springframework.web.bind.annotation.PostMapping;

import com.springbootactrestapijpa.model.Course;
import com.springbootactrestapijpa.model.Student;
import com.springbootactrestapijpa.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository){
        this.studentRepository =studentRepository;
    }

    @GetMapping("/displayStudents")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/{id}")
    public Optional<Student> getById(@PathVariable Long id) {
        return studentRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        studentRepository.deleteById(id);
    }

    @PutMapping("/{id}")
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
