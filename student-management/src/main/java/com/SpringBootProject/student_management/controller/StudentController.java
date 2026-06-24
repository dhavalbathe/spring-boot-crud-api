package com.SpringBootProject.student_management.controller;

import com.SpringBootProject.student_management.dto.StudentResponseDto;
import com.SpringBootProject.student_management.entity.Student;
import com.SpringBootProject.student_management.repository.StudentRepository;
import com.SpringBootProject.student_management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping()
    public StudentResponseDto createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping()
    public List<StudentResponseDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponseDto getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentResponseDto updateStudent(@PathVariable Long id,@RequestBody Student updatedStudent) {
        return studentService.updateStudent(id, updatedStudent);
    }
}
