package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.entity.Student;
import com.wecp.progressive.entity.Teacher;
import com.wecp.progressive.service.TeacherService;

public class TeacherServiceImplArraylist implements TeacherService  {

    @Override
    public Integer addTeacher(Teacher teacher) {
        return -1;
    }

    @Override
    public void emptyArrayList() {

    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers= new ArrayList<>();
        return teachers;
    }

    @Override
    public List<Teacher> getTeacherSortedByExperience() {
        List<Teacher> teachers= new ArrayList<>();
        return teachers;
    }
    

}