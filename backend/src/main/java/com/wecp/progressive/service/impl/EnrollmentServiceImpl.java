package com.wecp.progressive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.controller.EnrollmentController;
import com.wecp.progressive.entity.Enrollment;
import com.wecp.progressive.repository.EnrollmentRepository;
import com.wecp.progressive.service.EnrollmentService;
@Service
public class EnrollmentServiceImpl implements EnrollmentService {


    @Autowired
    EnrollmentRepository enrollmentRepository;
    @Override
    public List<Enrollment> getAllEnrollments() {
       return enrollmentRepository.findAll();
    }

    @Override
    public int createEnrollment(Enrollment enrollment) {
        enrollmentRepository.save(enrollment);
        return enrollment.getEnrollmentId();
    }

    @Override
    public void updateEnrollment(Enrollment enrollment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEnrollment'");
    }

    @Override
    public Enrollment getEnrollmentById(int enrollmentId) {
        return enrollmentRepository.findById(enrollmentId).get();
    }

    @Override
    public List<Enrollment> getAllEnrollmentsByStudent(int studentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEnrollmentsByStudent'");
    }

    @Override
    public List<Enrollment> getAllEnrollmentsByCourse(int courseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEnrollmentsByCourse'");
    }

}