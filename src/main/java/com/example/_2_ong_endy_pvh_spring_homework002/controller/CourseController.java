package com.example._2_ong_endy_pvh_spring_homework002.controller;

import com.example._2_ong_endy_pvh_spring_homework002.model.entity.Course;
import com.example._2_ong_endy_pvh_spring_homework002.model.request.CourseRequest;
import com.example._2_ong_endy_pvh_spring_homework002.model.response.ApiResponse;
import com.example._2_ong_endy_pvh_spring_homework002.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @Operation(summary = "Get All Courses")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourse(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        ApiResponse<List<Course>> apiResponse = ApiResponse.<List<Course>>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Courses fetched successfully")
                .payload(courseService.getAllCourse(page, size))
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @Operation(summary = "Get cause by ID")
    @GetMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable("course-id") Long courseId) {
        Course course = courseService.getCourseById(courseId);
        if(course != null) {
            ApiResponse<Course> apiResponse = ApiResponse.<Course>builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Course fetched successfully")
                    .payload(course)
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } else {
            ApiResponse<Course> apiResponse = ApiResponse.<Course>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("No courses found with the given ID")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Create a new Course")
    @PostMapping
    public ResponseEntity<ApiResponse<Course>> saveCourse(@RequestBody CourseRequest courseRequest) {
        ApiResponse<Course> apiResponse = ApiResponse.<Course>builder()
                .success(true)
                .status(HttpStatus.CREATED)
                .message("Course created successfully")
                .payload(courseService.saveCourse(courseRequest))
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }


    @Operation(summary = "Deleted course by ID")
    @DeleteMapping("/{course_id}")
    public ResponseEntity<ApiResponse<Course>> deleteCourseById(@PathVariable("course_id") Long courseId) {
        Course course = courseService.deleteCourseById(courseId);
        if (course != null) {
            ApiResponse<Course> apiResponse = ApiResponse.<Course>builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Course deleted successfully")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } else {
            ApiResponse<Course> apiResponse = ApiResponse.<Course>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("No courses found with the given ID")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }

    }

    @Operation(summary = "Update a cause by ID")
    @PutMapping("/{course_id}")
    public ResponseEntity<ApiResponse<Course>> updateCourseById(@PathVariable("course_id") Long courseId, @RequestBody CourseRequest courseRequest) {
        Course course = courseService.updateCourseById(courseId, courseRequest);
        if (course != null) {
            ApiResponse<Course> apiResponse = ApiResponse.<Course>builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Course updated successfully")
                    .payload(course)
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } else {
            ApiResponse<Course> apiResponse = ApiResponse.<Course>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("No courses found with the given ID")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }

    }

}
