package com.example._2_ong_endy_pvh_spring_homework002.repository;

import com.example._2_ong_endy_pvh_spring_homework002.model.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentCourseRepository {

    @Results(id = "StudentCourseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "instructor", column = "instructor_id", one = @One(select = "com.example._2_ong_endy_pvh_spring_homework002.repository.InstructorRepository.getInstructorById"))
    })

        @Select("""
        SELECT *
        FROM student_course sc
        INNER JOIN courses c
        ON sc.course_id = c.course_id
        WHERE student_id = #{studentId}
    """)
        List<Course> getCourseByStudentId(Long studentId);

    @Insert("""
        INSERT INTO student_course VALUES (#{studentId}, #{courseId})
    """)
    void insertStudentCourse(Long studentId, Long courseId);

    @Delete("""
DELETE FROM student_course WHERE student_id = #{studentId};
""")
    void deleteStudentCourseByStudentID(Long studentId);

}
