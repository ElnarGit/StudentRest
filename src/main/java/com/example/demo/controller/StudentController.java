package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping()
    public List<Student> getStudents() {
       return studentService.getStudents();
    }

    @PostMapping
    public void save(@RequestBody Student student){
        studentService.save(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id")Long id,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) String email){
        studentService.updateStudent(id, name, email);
    }
}

