package com.example._2_ong_endy_pvh_spring_homework002.repository;

import com.example._2_ong_endy_pvh_spring_homework002.model.entity.Instructor;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface InstructorRepository {

    @Results(id = "instructorMapper", value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name"),
    })
    @Select("""
        SELECT * FROM instructors OFFSET #{offSet} LIMIT #{size};
    """)
    List<Instructor> getAllInstructors(int offSet, int size);


    @ResultMap("instructorMapper")
    @Select("""
        SELECT * FROM instructors WHERE instructor_id = #{instructorId} ;
    """)
    Instructor getInstructorById(Long instructorId);
}
