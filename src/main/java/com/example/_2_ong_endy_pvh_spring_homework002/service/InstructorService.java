package com.example._2_ong_endy_pvh_spring_homework002.service;

import com.example._2_ong_endy_pvh_spring_homework002.model.entity.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructors(int page, int size);

    Instructor getInstructorById(Long instructorId);
}
