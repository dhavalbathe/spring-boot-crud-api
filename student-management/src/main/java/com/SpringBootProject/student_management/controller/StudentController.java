package com.SpringBootProject.student_management.controller;

import com.SpringBootProject.student_management.dto.ApiResponse;
import com.SpringBootProject.student_management.dto.StudentResponseDto;
import com.SpringBootProject.student_management.entity.Student;
import com.SpringBootProject.student_management.repository.StudentRepository;
import com.SpringBootProject.student_management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping()
    public ResponseEntity<ApiResponse<StudentResponseDto>> createStudent(@RequestBody Student student) {
        StudentResponseDto stud =  studentService.createStudent(student);

        ApiResponse<StudentResponseDto> response = ApiResponse.<StudentResponseDto>builder()
                .success(true)
                .message("Student Created Successfully!")
                .statusCode(HttpStatus.CREATED.value())
                .timestamp(LocalDateTime.now())
                .data(stud)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<StudentResponseDto>>> getAllStudents() {
        List<StudentResponseDto> student = studentService.getAllStudents();

        ApiResponse<List<StudentResponseDto>> response = ApiResponse.<List<StudentResponseDto>>builder()
                .success(true)
                .message("All Student Data fetched successfully!")
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .data(student)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponseDto>> getStudentById(@PathVariable Long id) {

        StudentResponseDto stud = studentService.getStudentById(id);

        ApiResponse<StudentResponseDto> response = ApiResponse.<StudentResponseDto>builder()
                .success(true)
                .message("Student fetched successfully!")
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .data(stud)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponseDto>> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        StudentResponseDto stud =  studentService.updateStudent(id, updatedStudent);

        ApiResponse<StudentResponseDto> response = ApiResponse.<StudentResponseDto>builder()
                .success(true)
                .message("Student Record updated successfully!")
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .data(stud)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteStudent(@PathVariable Long id) {

        studentService.deleteStudent(id);

        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .success(true)
                .message("Student record deleted successfully!")
                .statusCode(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .data(null)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
