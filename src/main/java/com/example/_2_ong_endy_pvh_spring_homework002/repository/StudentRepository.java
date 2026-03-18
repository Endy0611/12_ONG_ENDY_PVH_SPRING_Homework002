package com.example._2_ong_endy_pvh_spring_homework002.repository;

import com.example._2_ong_endy_pvh_spring_homework002.model.entity.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentRepository {
    @Results(id = "studentMapper", value = {
//            @Result(property = "courseName", column = "course_name"),
            @Result(property = "course", column = "instructor_id",
                    one = @One(
                            select = "com.example._2_ong_endy_pvh_spring_homework002.repository.InstructorRepository.getInstructorById"
                    ))
    })
    @Select("""
        SELECT * FROM students OFFSET #{offSet} LIMIT #{size}
    """)
    Student getAllStudent(int offSet, int size);
}
