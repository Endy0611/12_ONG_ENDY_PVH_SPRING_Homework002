package com.example._2_ong_endy_pvh_spring_homework002.service;

import com.example._2_ong_endy_pvh_spring_homework002.model.entity.Course;
import com.example._2_ong_endy_pvh_spring_homework002.model.request.CourseRequest;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse(int page, int size);

    Course getCourseById(Long courseId);

    Course saveCourse(CourseRequest courseRequest);

    Course deleteCourseById(Long courseId);

    Course updateCourseById(Long courseId, CourseRequest courseRequest);
}
