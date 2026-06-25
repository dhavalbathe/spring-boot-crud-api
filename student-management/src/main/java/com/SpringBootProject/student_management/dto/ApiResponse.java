package com.SpringBootProject.student_management.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ApiResponse<T> {

    private boolean success;

    private String message;

    private int statusCode;

    private LocalDateTime timestamp;

    private T data;
}
