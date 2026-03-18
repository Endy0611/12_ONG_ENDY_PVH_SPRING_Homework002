package com.example._2_ong_endy_pvh_spring_homework002.service;

import com.example._2_ong_endy_pvh_spring_homework002.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent(int page, int size);
}
