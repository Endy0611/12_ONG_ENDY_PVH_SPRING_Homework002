package com.example._2_ong_endy_pvh_spring_homework002.repository;

import com.example._2_ong_endy_pvh_spring_homework002.model.entity.Student;
import com.example._2_ong_endy_pvh_spring_homework002.model.request.StudentRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Results(id = "studentMapper", value = {
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "phoneNumber", column = "phone_number"),

            @Result(property = "course", column = "student_id", many = @Many (select = "com.example._2_ong_endy_pvh_spring_homework002.repository.StudentCourseRepository.getCourseByStudentId")),
    })
    @Select("""
        SELECT * FROM students OFFSET #{offSet} LIMIT #{size}
    """)
    List<Student> getAllStudent(int offSet, int size);


    @ResultMap("studentMapper")
    @Select("""
        SELECT * FROM students WHERE student_id = #{studentId}
    """)
    Student getStudentById(Long studentId);

    @ResultMap("studentMapper")
    @Select("""
        INSERT INTO students VALUES (default,#{req.studentName}, #{req.email}, #{req.phoneNumber}) RETURNING *;
    """)
    Student saveStudent(@Param("req") StudentRequest studentRequest);

    @ResultMap("studentMapper")
    @Select("""
    UPDATE students SET student_name=#{req.studentName},email=#{req.email},phone_number=#{req.phoneNumber} WHERE student_id=#{studentId} RETURNING *;
""")
    Student updateStudentByID(Long studentId,@Param("req") StudentRequest studentRequest);


    @ResultMap("studentMapper")
    @Select("""
        DELETE FROM students WHERE student_id = #{studentId} RETURNING *;
    """)
    Student deleteStudentById(Long studentId);
}
