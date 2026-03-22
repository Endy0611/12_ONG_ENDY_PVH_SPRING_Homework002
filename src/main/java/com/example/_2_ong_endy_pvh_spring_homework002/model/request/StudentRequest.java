package com.example._2_ong_endy_pvh_spring_homework002.model.request;

import com.example._2_ong_endy_pvh_spring_homework002.model.entity.Course;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String studentName;
    private String email;
    private String phoneNumber;
    private List<Long> courseId;
}
