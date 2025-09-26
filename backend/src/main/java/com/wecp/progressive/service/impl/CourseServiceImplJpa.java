package com.wecp.progressive.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Course;
import com.wecp.progressive.repository.CourseRepository;
import com.wecp.progressive.service.CourseService;

import java.sql.SQLException;
import java.util.*;
@Service
public class CourseServiceImplJpa implements CourseService {
@Autowired
private CourseRepository courseRepository;



public CourseServiceImplJpa(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
}
public List<Course> getAllCourses() 
{
return courseRepository.findAll();
}
public Course getCourseById(int courseId) throws Exception
{
    // if(courseRepository.findById(courseId).isPresent())
    // {
   Optional<Course> c= courseRepository.findById(courseId);
   if(c.isPresent())
   {
    return c.get();
   }
  else{
    return null;
  }
}

public Integer addCourse(Course course)
{
    Course c=courseRepository.save(course);
    return c.getCourseId();
}
public void updateCourse(Course course) {
    if(courseRepository.findById(course.getCourseId()).isPresent())
    {
        Course c=courseRepository.findById(course.getCourseId()).get();
        c.setCourseId(course.getCourseId());
        c.setCourseName(course.getCourseName());
        c.setDescription(course.getDescription());
        c.setTeacherId(course.getTeacherId());
        courseRepository.save(c);
    }
    // else
    // {
    //     throw new Exception("course id"+ course.getCourseId() +"not found");
    // }
}
   public void deleteCourse(int courseId)  throws Exception
   {
     if(courseRepository.findById(courseId).isPresent())
     {
        courseRepository.deleteById(courseId);
     }
     
   }

   public List<Course> getAllCourseByTeacherId(int teacherId)
   {
    return courseRepository.findAll();
   }
}