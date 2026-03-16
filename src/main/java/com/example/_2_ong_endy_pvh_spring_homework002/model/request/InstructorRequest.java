package com.example._2_ong_endy_pvh_spring_homework002.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorRequest {
    private String instructorName;
    private String email;
}
