package com.SpringBootProject.student_management.repository;

import com.SpringBootProject.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
