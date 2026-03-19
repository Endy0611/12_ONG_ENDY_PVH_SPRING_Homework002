package com.example._2_ong_endy_pvh_spring_homework002.service.Impl;

import com.example._2_ong_endy_pvh_spring_homework002.model.entity.Student;
import com.example._2_ong_endy_pvh_spring_homework002.model.request.StudentRequest;
import com.example._2_ong_endy_pvh_spring_homework002.repository.StudentCourseRepository;
import com.example._2_ong_endy_pvh_spring_homework002.repository.StudentRepository;
import com.example._2_ong_endy_pvh_spring_homework002.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;


    @Override
    public List<Student> getAllStudent(int page, int size) {
        int offSet = size * (page - 1);
        return studentRepository.getAllStudent(offSet, size);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.getStudentById(studentId);
    }

    @Override
    public Student saveStudent(StudentRequest studentRequest) {
        Student student=studentRepository.saveStudent(studentRequest);
        for (Long courseId : studentRequest.getCourseId()){
            studentCourseRepository.insertStudentCourse(student.getStudentId(),courseId);
        }
        return studentRepository.getStudentById(student.getStudentId());
    }

    @Override
    public Student updateStudentById(Long studentId, StudentRequest studentRequest) {
        Student student=studentRepository.updateStudentByID(studentId,studentRequest);
        studentCourseRepository.deleteStudentCourseByStudentID(studentId);
        for (Long courseId : studentRequest.getCourseId()){
            studentCourseRepository.insertStudentCourse(student.getStudentId(),courseId);
        }
        return studentRepository.getStudentById(student.getStudentId());
    }
}
