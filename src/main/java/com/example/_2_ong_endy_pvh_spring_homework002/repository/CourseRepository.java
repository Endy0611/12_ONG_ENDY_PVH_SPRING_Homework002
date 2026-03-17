package com.example._2_ong_endy_pvh_spring_homework002.repository;

import com.example._2_ong_endy_pvh_spring_homework002.model.entity.Course;
import com.example._2_ong_endy_pvh_spring_homework002.model.request.CourseRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Results(id = "coursesMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "instructor", column = "instructor_id",
                    one = @One(
                            select = "com.example._2_ong_endy_pvh_spring_homework002.repository.InstructorRepository.getInstructorById"// or FetchType.EAGER
                    ))
    })
    @Select("""
        SELECT * FROM courses OFFSET #{offSet} LIMIT #{size};
    """)
    List<Course> getAllCourse(int offSet, int size);

    @ResultMap("coursesMapper")
    @Select("""
        SELECT * FROM courses WHERE course_id = #{courseId};
    """)
    Course getCourseById(Long courseId);

    @ResultMap("coursesMapper")
    @Select("""
        INSERT INTO courses VALUES (default, #{req.courseName}, #{req.description}, #{req.instructorId}) RETURNING *;
    """)
    Course saveCourse(@Param("req") CourseRequest courseRequest);


    @ResultMap("coursesMapper")
    @Select("""
        DELETE FROM courses WHERE course_id = #{courseId} RETURNING NULL;
    """)
    Course deleteCourseById(Long courseId);
}
