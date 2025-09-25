package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.dao.TeacherDAO;
import com.wecp.progressive.entity.Teacher;
import com.wecp.progressive.service.TeacherService;

public class TeacherServiceImplJdbc implements TeacherService {
    private TeacherDAO teacherDAO;
    

    public TeacherServiceImplJdbc(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    public Integer addTeacher(Teacher teacher) {
        return -1;
    }

    @Override
    public void deleteTeacher(int teacherId) {
        
    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers= new ArrayList<>();
        return teachers;
    }

    @Override
    public Teacher getTeacherById(int teacherId) {
        return null;
    }

    @Override
    public List<Teacher> getTeacherSortedByExperience() {
        List<Teacher> teachers= new ArrayList<>();
        return teachers;
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        
    }
    

}