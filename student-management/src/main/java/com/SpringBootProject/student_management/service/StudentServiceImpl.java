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
        return null;
    }

    public List<StudentResponseDto> getAllStudents(){
        return null;
    }
    public StudentResponseDto updateStudent(Long id, Student student){
        return null;
    }
    public void deleteStudent(Long id){
        return;
    }

}
