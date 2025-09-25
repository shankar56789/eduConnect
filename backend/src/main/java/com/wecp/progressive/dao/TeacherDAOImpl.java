package com.wecp.progressive.dao;

import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.entity.Course;
import com.wecp.progressive.entity.Teacher;

public class TeacherDAOImpl implements TeacherDAO{

    @Override
    public int addTeacher(Teacher teacher) {
        return -1;
    }

    @Override
    public void deleteTeacher(int teacherId) {
        
    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> list= new ArrayList<>();
        return list;
    }

    @Override
    public Teacher getTeacherById(int teacherId) {
        return null;
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        
    }
    



}
