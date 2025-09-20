package com.wecp.progressive.dao;

import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.entity.Course;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public int addCourse(Course course) {
        return -1;
    }

    @Override
    public void deleteCourse(int courseId) {
        
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> list= new ArrayList<>();
        return list;
    }

    @Override
    public Course getCourseById(int courseId) {
        return null;
    }

    @Override
    public void updateCourse(Course course) {
        
    }
    

}
