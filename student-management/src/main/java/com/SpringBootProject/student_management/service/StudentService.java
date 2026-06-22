package com.SpringBootProject.student_management.service;

import com.SpringBootProject.student_management.dto.StudentResponseDto;
import com.SpringBootProject.student_management.entity.Student;

import java.util.List;

public interface StudentService {
    StudentResponseDto createStudent(Student student);
    StudentResponseDto getStudentById(Long id);
    List<StudentResponseDto> getAllStudents();
    StudentResponseDto updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}
