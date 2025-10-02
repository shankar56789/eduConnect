package com.wecp.progressive.service.impl;

import com.wecp.progressive.dao.CourseDAO;
import com.wecp.progressive.entity.Course;
import com.wecp.progressive.service.CourseService;

import java.sql.SQLException;
import java.util.*;
public class CourseServiceImplJdbc implements CourseService{

public CourseServiceImplJdbc(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }
private CourseDAO courseDAO;

public List<Course> getAllCourseById(int courseId) throws SQLException
{
    return courseDAO.getAllCourses();
}
public Course getCourseById(int courseId) throws SQLException
{
    return courseDAO.getCourseById(courseId);
}
public Integer addCourse(Course course) throws SQLException
{
    return courseDAO.addCourse(course);
}
public void updateCourse(Course course) throws SQLException{
    courseDAO.updateCourse(course);
}

public List<Course> getAllCourses() throws SQLException{
   
    return courseDAO.getAllCourses();
}

public void deleteCourse(int courseId) throws SQLException {
   courseDAO.deleteCourse(courseId);
}
}