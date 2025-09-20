package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.dao.StudentDAO;
import com.wecp.progressive.entity.Student;
import com.wecp.progressive.service.StudentService;

public class StudentServiceImplJdbc implements StudentService {
    private StudentDAO studentDAO;

    @Override
    public Integer addStudent(Student student) {
        return -1;
    }

    @Override
    public void deleteStudent(int studentId) {
    
    }

    @Override
    public List<Student> getAllStudentSortedByName() {
        List<Student> students= new ArrayList<>();
        return students;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students= new ArrayList<>();
        return students;
    }

    @Override
    public Student getStudentById(int studentId) {
        return null;
    }

    @Override
    public void updateStudent(Student student) {
    
    }
    

}