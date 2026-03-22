package com.example._2_ong_endy_pvh_spring_homework002.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {
    private Long studentId;
    private String studentName;
    private String email;
    private String phoneNumber;
//    private Instructor instructor;
    private List<Course> course;
}
