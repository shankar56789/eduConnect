package com.wecp.progressive.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Course;

public class CourseDAOImpl implements CourseDAO {

    private Connection connection;
    
public CourseDAOImpl() {
   try{
    connection=DatabaseConnectionManager.getConnection();
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
}
public int addCourse(Course course) throws SQLException
{
    String query="insert into course (course_name,description,teacher_id) values(?,?,?)";
    try(PreparedStatement ps=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS))
    {
        ps.setString(1,course.getCourseName());
        ps.setString(2,course.getDescription());
        ps.setInt(3,course.getTeacherId());
        int rows=ps.executeUpdate();
        if(rows>0)
        {
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next())
            {
                int id=rs.getInt(1);
                course.setCourseId(id);
               return id;
            }
        }
    }
    return -1;

}
   public  Course getCourseById(int courseId) throws SQLException
    {
        String query="select * from course where course_Id=?";
    try(PreparedStatement ps=connection.prepareStatement(query))
    {
         ps.setInt(1,courseId);
         ResultSet rs=ps.executeQuery();
         if(rs.next())
         {
            Course course=new Course();
            course.setCourseId(rs.getInt("course_id"));
            course.setCourseName(rs.getString("course_name"));
            course.setDescription(rs.getString("description"));
            course.setTeacherId(rs.getInt("teacher_id"));
            return course;
         }

    }
    return null;
}
    public void updateCourse(Course course) throws SQLException {
        String query="update course set course_name=?, description=?,teacher_id=? where course_id=?";{
    try(PreparedStatement ps=connection.prepareStatement(query))
    {
        ps.setString(1,course.getCourseName());
        ps.setString(2,course.getDescription());
        ps.setInt(3,course.getTeacherId());
        ps.setInt(4,course.getCourseId());
        ps.executeUpdate();
       
    }
}
}
    public void deleteCourse(int courseId) throws SQLException
    {
        String query="delete from course where course_id=?";
        try(PreparedStatement ps=connection.prepareStatement(query))
        {
            ps.setInt(1,courseId);
            ps.executeUpdate();
        }
    }
   public  List<Course> getAllCourses() throws SQLException
    {
      //  List<Course> list=new ArrayList<Course>();
      String query="select * from course ";
      List<Course> c=new ArrayList<>();
    try(PreparedStatement ps=connection.prepareStatement(query))
    {
         ResultSet rs=ps.executeQuery();
     
         while(rs.next())
         {
            Course course=new Course();
            course.setCourseId(rs.getInt("course_id"));
            course.setCourseName(rs.getString("course_name"));
            course.setDescription(rs.getString("description"));
            course.setTeacherId(rs.getInt("teacher_id"));
            c.add(course);
         }
         
    }
    return c;
    
    }

}
