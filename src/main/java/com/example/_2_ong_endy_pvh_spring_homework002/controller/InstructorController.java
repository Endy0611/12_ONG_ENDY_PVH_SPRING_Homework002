package com.example._2_ong_endy_pvh_spring_homework002.controller;

import com.example._2_ong_endy_pvh_spring_homework002.model.entity.Instructor;
import com.example._2_ong_endy_pvh_spring_homework002.model.request.InstructorRequest;
import com.example._2_ong_endy_pvh_spring_homework002.model.response.ApiResponse;
import com.example._2_ong_endy_pvh_spring_homework002.service.InstructorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    @Operation(summary = "Get all instructors")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors(@RequestParam(defaultValue = "1") int page, @RequestParam (defaultValue = "10") int size) {

        ApiResponse<List<Instructor>> apiResponse = ApiResponse.<List<Instructor>>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Instructors fetched successfully")
                .payload(instructorService.getAllInstructors(page, size))
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @Operation(summary = "Get instructor by ID")
    @GetMapping("/{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> getInstructorById(@PathVariable("instructor-id") Long instructorId) {
        ApiResponse<Instructor> apiResponse = ApiResponse.<Instructor>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Instructor fetched successfully")
                .payload(instructorService.getInstructorById(instructorId))
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @Operation(summary = "Delete instructor by ID")
    @DeleteMapping("/{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> deleteById(@PathVariable ("instructor-id") Long instructorId) {
        ApiResponse<Instructor> apiResponse = ApiResponse.<Instructor>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Instructor deleted successfully")
                .payload(instructorService.deleteById(instructorId))
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @Operation(summary = "Create a new Instructor")
    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> saveInstructor(@RequestBody InstructorRequest instructorRequest) {
        ApiResponse<Instructor> apiResponse = ApiResponse.<Instructor>builder()
                .success(true)
                .status(HttpStatus.CREATED)
                .message("Instructor created successfully")
                .payload(instructorService.saveInstructor(instructorRequest))
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @Operation(summary = "Update course by ID")
    @PutMapping("/{instructor_id}")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructorById(@PathVariable("instructor_id") Long instructorId, @RequestBody InstructorRequest instructorRequest) {
        ApiResponse<Instructor> apiResponse = ApiResponse.<Instructor>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Instructor updated successfully")
                .payload(instructorService.updateInstructorById(instructorId, instructorRequest))
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
