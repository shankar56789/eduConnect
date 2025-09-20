package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.entity.Course;
import com.wecp.progressive.entity.Student;
import com.wecp.progressive.service.StudentService;

public class StudentServiceImplArraylist implements StudentService {

    @Override
    public Integer addStudent(Student student) {
        return -1;
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
    public void emptyArrayList() {
    
    }
    

}