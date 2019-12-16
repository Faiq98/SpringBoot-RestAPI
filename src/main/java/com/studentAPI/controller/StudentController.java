/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentAPI.controller;

/**
 *
 * @author fhfai
 */
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.studentAPI.entity.Student;
import com.studentAPI.repository.StudentRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepo;

    //Create new Student
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return studentRepo.save(student);
    }

    //Retrieve all Student
    @GetMapping("/students")
    public Iterable<Student> allStudent() {
        return studentRepo.findAll();
    }

    //Retrieve Student by ID
    @GetMapping("/students/{id}")
    public Optional<Student> studentbyId(@PathVariable("id") int id) {
        return studentRepo.findById(id);
    }

    //Update Student by ID
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable("id") int id, @RequestBody Student studentData) throws Exception {
        Student stud = studentRepo.findById(id)
                .orElseThrow(() -> new Exception());
        stud.setFirst_name(studentData.getFirst_name());
        stud.setLast_name(studentData.getLast_name());
        stud.setEmail(studentData.getEmail());
        
        Student updateStud = studentRepo.save(stud);
        return updateStud;
    }

    //Delete Student by ID
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        studentRepo.deleteById(id);
    }
}
