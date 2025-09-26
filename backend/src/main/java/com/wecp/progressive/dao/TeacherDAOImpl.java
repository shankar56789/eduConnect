package com.wecp.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Student;
import com.wecp.progressive.entity.Teacher;

public class TeacherDAOImpl implements TeacherDAO{

    private Connection connection;
    public TeacherDAOImpl()
    {
    try{
    connection=DatabaseConnectionManager.getConnection();
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
}

    @Override
    public int addTeacher(Teacher teacher)  throws SQLException{
      String query="insert into teacher (full_name,subject,contact_number,email,years_of_experience) values(?,?,?,?,?)";
    try(PreparedStatement ps=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS))
    {
        ps.setString(1,teacher.getFullName());
        ps.setString(2,teacher.getSubject());
        ps.setString(3,teacher.getContactNumber());
        ps.setString(4,teacher.getEmail());
        ps.setInt(5,teacher.getYearsOfExperience());
        int rows=ps.executeUpdate();
      if(rows>0)
        {
                    ResultSet rs=ps.getGeneratedKeys();
            if(rs.next())
            {
                int id=rs.getInt(1);
                teacher.setTeacherId(id);
               return id;
            }

    }
}
    return -1;
    }

    @Override
    public Teacher getTeacherById(int teacherId) throws SQLException {

         String query="select * from teacher where teacher_id=?";
    try(PreparedStatement ps=connection.prepareStatement(query))
    {
         ps.setInt(1,teacherId);
         ResultSet rs=ps.executeQuery();
         if(rs.next())
         {
            Teacher t=new Teacher();
            t.setFullName(rs.getString("full_name"));
            t.setSubject(rs.getString("subject"));
            t.setContactNumber(rs.getString("contact_number"));
            t.setEmail(rs.getString("email"));
            t.setYearsOfExperience(rs.getInt("years_of_experience"));
            t.setTeacherId(rs.getInt("teacher_id"));
            return t;
         }
    }
    return null;
}

    @Override
    public void updateTeacher(Teacher teacher) throws SQLException {
        String query="update teacher set full_name=?,subject=?,contact_number=?,email=?,years_of_experience=? where teacher_id=?";
        try(PreparedStatement ps=connection.prepareStatement(query))
    {
        ps.setString(1,teacher.getFullName());
        ps.setString(2,teacher.getSubject());
        ps.setString(3,teacher.getContactNumber());
        ps.setString(4,teacher.getEmail());
        ps.setInt(5,teacher.getYearsOfExperience());
        ps.setInt(6,teacher.getTeacherId());
        ps.executeUpdate();
    }

}
    @Override
    public void deleteTeacher(int teacherId) throws SQLException {
        String query="delete from teacher where teacher_id=?";
        try(PreparedStatement ps=connection.prepareStatement(query))
        {
            ps.setInt(1,teacherId);
            ps.executeUpdate();
    }
}

    @Override
    public List<Teacher> getAllTeachers() throws SQLException{
        List<Teacher> teacher=new ArrayList<>();
        String query="select * from teacher";
        try(PreparedStatement ps=connection.prepareStatement(query))
        {
             ResultSet rs=ps.executeQuery();
          
             while(rs.next())
             {
                Teacher t=new Teacher();
                t.setFullName(rs.getString("full_name"));
                t.setSubject(rs.getString("subject"));
                t.setSubject(rs.getString("subject"));
                t.setContactNumber(rs.getString("contact_number"));
                t.setEmail(rs.getString("email"));
                t.setYearsOfExperience(rs.getInt("years_of_experience"));
                t.setTeacherId(rs.getInt("teacher_id"));
                teacher.add(t);
             }
    }
    return teacher;


    }
}
