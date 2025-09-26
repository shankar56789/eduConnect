package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.*;

import com.wecp.progressive.dao.TeacherDAO;
import com.wecp.progressive.entity.Teacher;
import com.wecp.progressive.service.TeacherService;

public class TeacherServiceImplJdbc implements TeacherService  {
    private TeacherDAO teacheDAO;
          
        public TeacherServiceImplJdbc(TeacherDAO teacheDAO) {
        this.teacheDAO = teacheDAO;
    }
        public List<Teacher> getAllTeachers() throws SQLException
    {
   return teacheDAO.getAllTeachers();
    }
    public Integer addTeacher(Teacher teacher) throws SQLException
    {
         return teacheDAO.addTeacher(teacher);
    }
public List<Teacher> getTeacherSortedByExperience() throws SQLException
{
    List<Teacher>list=new ArrayList<>(teacheDAO.getAllTeachers());
    Collections.sort(list);
         return list;
}
public void updateTeacher(Teacher teacher) throws SQLException
{
   teacheDAO.updateTeacher(teacher);
}

public void deleteTeacher(int teacherId) throws SQLException
{
    teacheDAO.deleteTeacher(teacherId);
}
public Teacher getTeacherById(int teacherId) throws SQLException
{
    return teacheDAO.getTeacherById(teacherId);
}


}