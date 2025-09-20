package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wecp.progressive.entity.Student;
import com.wecp.progressive.entity.Teacher;
import com.wecp.progressive.service.TeacherService;

public class TeacherServiceImplArraylist implements TeacherService  {
    private static List<Teacher> teacherList=new ArrayList<>();
    @Override
    public Integer addTeacher(Teacher teacher) {
        teacherList.add(teacher);
        return teacherList.size();
    }

    @Override
    public void emptyArrayList() {
        teacherList.clear();
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherList;
    }

    @Override
    public List<Teacher> getTeacherSortedByExperience() {
        Collections.sort(teacherList,teacherComparator);
        return teacherList;
    }
    public Comparator<Teacher> teacherComparator=new Comparator<Teacher>() {
        public int compare(Teacher arg0,Teacher arg1){
            return arg0.getYearsOfExperience()-arg1.getYearsOfExperience();
        }
    };
    

}