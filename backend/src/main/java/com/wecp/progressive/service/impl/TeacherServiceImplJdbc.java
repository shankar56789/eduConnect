package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.sql.SQLException;
import java.util.*;

import com.wecp.progressive.dao.TeacherDAO;
import com.wecp.progressive.entity.Teacher;
import com.wecp.progressive.service.TeacherService;

public class TeacherServiceImplJdbc implements TeacherService  {
    private TeacherDAO teacherDAO;
          
        public TeacherServiceImplJdbc(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }
        public List<Teacher> getAllTeachers() throws SQLException
    {
        return teacherDAO.getAllTeachers();
    }
    public Integer addTeacher(Teacher teacher) throws SQLException
    {
        return teacherDAO.addTeacher(teacher);
    }
public List<Teacher> getTeacherSortedByExperience() throws SQLException{
    
    List<Teacher>list=new ArrayList<>(teacherDAO.getAllTeachers());
    Collections.sort(list);
return list;
}
public void updateTeacher(Teacher teacher) throws SQLException
{
    teacherDAO.updateTeacher(teacher);
}

public void deleteTeacher(int teacherId) throws SQLException{
    teacherDAO.deleteTeacher(teacherId);
}
public Teacher getTeacherById(int teacherId) throws SQLException
{
    return teacherDAO.getTeacherById(teacherId);
}


}