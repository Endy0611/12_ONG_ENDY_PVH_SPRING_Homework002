package com.example._2_ong_endy_pvh_spring_homework002.controller;


import com.example._2_ong_endy_pvh_spring_homework002.model.entity.Instructor;
import com.example._2_ong_endy_pvh_spring_homework002.model.entity.Student;
import com.example._2_ong_endy_pvh_spring_homework002.model.request.StudentRequest;
import com.example._2_ong_endy_pvh_spring_homework002.model.response.ApiResponse;
import com.example._2_ong_endy_pvh_spring_homework002.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Get all students")
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

    @Operation(summary = "Get student by ID")
    @GetMapping ("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable("student-id") Long studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            ApiResponse<Student> apiResponse = ApiResponse.<Student>builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Students retrieved successfully")
                    .payload(student)
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } else {
            ApiResponse<Student> apiResponse = ApiResponse.<Student>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("No students found with the given ID")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }

    }

    @Operation(summary = "Create a new Student")
    @PostMapping
    public ResponseEntity<ApiResponse<Student>> saveStudent(@RequestBody StudentRequest studentRequest){
        ApiResponse<Student> apiResponse = ApiResponse.<Student>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Student created successfully")
                .payload(studentService.saveStudent(studentRequest))
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @Operation(summary = "Update student by ID")
    @PutMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> updateStudentById(@PathVariable("student-id") Long studentId,@RequestBody StudentRequest studentRequest){
        Student student = studentService.updateStudentById(studentId,studentRequest);
        if (student != null) {
            ApiResponse<Student> apiResponse = ApiResponse.<Student>builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Student updated successfully")
                    .payload(student)
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } else {
            ApiResponse<Student> apiResponse = ApiResponse.<Student>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("No students found with the given ID")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Delete student by ID")
    @DeleteMapping("/{student_id}")
    public ResponseEntity<ApiResponse<Student>> deleteStudentById(@PathVariable("student_id") Long studentId) {
        Student student = studentService.deleteStudentById(studentId);
        ApiResponse<Student> apiResponse = ApiResponse.<Student>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Deleted successfully")
                .payload(student)
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
