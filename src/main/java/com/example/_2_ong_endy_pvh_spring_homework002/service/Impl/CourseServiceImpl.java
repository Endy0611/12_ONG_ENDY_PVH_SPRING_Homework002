package com.example._2_ong_endy_pvh_spring_homework002.service.Impl;

import com.example._2_ong_endy_pvh_spring_homework002.model.entity.Course;
import com.example._2_ong_endy_pvh_spring_homework002.model.request.CourseRequest;
import com.example._2_ong_endy_pvh_spring_homework002.repository.CourseRepository;
import com.example._2_ong_endy_pvh_spring_homework002.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourse(int page, int size) {
        int offSet = size * (page-1);
        return courseRepository.getAllCourse(offSet, size);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.getCourseById(courseId);
    }

    @Override
    public Course saveCourse(CourseRequest courseRequest) {
        return courseRepository.saveCourse(courseRequest);
    }

    @Override
    public Course deleteCourseById(Long courseId) {
        return courseRepository.deleteCourseById(courseId);
    }

    @Override
    public Course updateCourseById(Long courseId, CourseRequest courseRequest) {
        return courseRepository.updateCourseById(courseId, courseRequest);
    }
}
