package com.example._2_ong_endy_pvh_spring_homework002.service.Impl;

import com.example._2_ong_endy_pvh_spring_homework002.model.entity.Instructor;
import com.example._2_ong_endy_pvh_spring_homework002.repository.InstructorRepository;
import com.example._2_ong_endy_pvh_spring_homework002.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }


    @Override
    public List<Instructor> getAllInstructors(int page, int size) {

        int offSet = size * (page-1);

        return instructorRepository.getAllInstructors(offSet, size);
    }

    @Override
    public Instructor getInstructorById(Long instructorId) {
        return instructorRepository.getInstructorById(instructorId);
    }
}
