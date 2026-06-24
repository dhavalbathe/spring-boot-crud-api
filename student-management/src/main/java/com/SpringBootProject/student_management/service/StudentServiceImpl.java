package com.SpringBootProject.student_management.service;

import com.SpringBootProject.student_management.dto.StudentResponseDto;
import com.SpringBootProject.student_management.entity.Student;
import com.SpringBootProject.student_management.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private StudentResponseDto mapToResponseDto(Student student) {
        return StudentResponseDto.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .age(student.getAge())
                .build();
    }
    @Override
    public StudentResponseDto createStudent(Student student) {
        Student createdStudent = studentRepository.save(student);
        StudentResponseDto dto = StudentResponseDto.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .age(student.getAge()).build();

        return dto;
    }

    @Override
    public StudentResponseDto getStudentById(Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        return mapToResponseDto(student);
    }

    @Override
    public List<StudentResponseDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(this::mapToResponseDto)
                .toList();

    }
    public StudentResponseDto updateStudent(Long id, Student updatedStudent){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id : " + id));
        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());
        student.setAge(updatedStudent.getAge());

        Student savedStudent = studentRepository.save(student);

        return mapToResponseDto(savedStudent);
    }
    public void deleteStudent(Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id : " + id));

        studentRepository.delete(student);
        return;
    }

}
