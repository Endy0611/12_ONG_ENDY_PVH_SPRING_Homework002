package com.example._2_ong_endy_pvh_spring_homework002.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Instructor {
    private Long instructorId;
    private String instructorName;
    private String email;
}
