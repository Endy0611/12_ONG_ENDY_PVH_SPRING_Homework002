package com.example._2_ong_endy_pvh_spring_homework002.service;

import com.example._2_ong_endy_pvh_spring_homework002.model.entity.Student;
import com.example._2_ong_endy_pvh_spring_homework002.model.request.StudentRequest;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent(int page, int size);

    Student getStudentById(Long studentId);

    Student saveStudent(StudentRequest studentRequest);
    Student updateStudentById(Long studentId,StudentRequest studentRequest);

    Student deleteStudentById(Long studentId);
}
