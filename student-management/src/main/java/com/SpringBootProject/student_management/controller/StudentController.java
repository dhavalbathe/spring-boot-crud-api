package com.SpringBootProject.student_management.controller;

import com.SpringBootProject.student_management.dto.StudentResponseDto;
import com.SpringBootProject.student_management.entity.Student;
import com.SpringBootProject.student_management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping()
    public StudentResponseDto createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
}
