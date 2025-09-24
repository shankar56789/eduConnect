package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Course;
import com.wecp.progressive.repository.CourseRepository;

@Service
public class CourseServiceImplJpa  {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() throws Exception{
        List<Course> al=new ArrayList<>();
        return al;
    }
    public Course getCourseById(int courseId) throws Exception{
        return null;
    }
    public Integer addCourse(Course course) throws Exception{
        return -1;
    }
    public void updateCourse(Course course) throws Exception{

    }
    public void deleteCourse(int courseId) throws Exception{

    }
    public List<Course> getAllCourseByTeacherId(int teacherId){
        return null;
    }

}