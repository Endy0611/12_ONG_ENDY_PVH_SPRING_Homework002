package com.example._2_ong_endy_pvh_spring_homework002.controller;


import com.example._2_ong_endy_pvh_spring_homework002.model.entity.Instructor;
import com.example._2_ong_endy_pvh_spring_homework002.model.entity.Student;
import com.example._2_ong_endy_pvh_spring_homework002.model.response.ApiResponse;
import com.example._2_ong_endy_pvh_spring_homework002.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Student>> getAllStudent(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int  size) {
        ApiResponse<Student> apiResponse = ApiResponse.<Student>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Students retrieved successfully")
                .payload(studentService.getAllStudent(page,size))
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
