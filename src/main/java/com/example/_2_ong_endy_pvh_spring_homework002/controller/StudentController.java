package com.example._2_ong_endy_pvh_spring_homework002.controller;


import com.example._2_ong_endy_pvh_spring_homework002.model.entity.Instructor;
import com.example._2_ong_endy_pvh_spring_homework002.model.entity.Student;
import com.example._2_ong_endy_pvh_spring_homework002.model.response.ApiResponse;
import com.example._2_ong_endy_pvh_spring_homework002.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudent(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int  size) {
        ApiResponse<List<Student>> apiResponse = ApiResponse.<List<Student>>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Students retrieved successfully")
                .payload(studentService.getAllStudent(page,size))
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping ("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable("student-id") Long studentId) {
        ApiResponse<Student> apiResponse = ApiResponse.<Student>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Students retrieved successfully")
                .payload(studentService.getStudentById(studentId))
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
