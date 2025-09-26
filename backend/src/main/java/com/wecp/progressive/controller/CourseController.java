package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Course;
import com.wecp.progressive.service.CourseService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        try
        {
            return new ResponseEntity<>(courseService.getAllCourses(),HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return null;
        
    }

    public ResponseEntity<Course> getCourseById(int courseId) {
        return null;
    }

    public ResponseEntity<Integer> addCourse(Course course) {
        return null;
    }

    public ResponseEntity<Void> updateCourse(int courseId, Course course) {
        return null;
    }

    public ResponseEntity<Void> deleteCourse(int courseId) {
        return null;
    }

    public ResponseEntity<List<Course>> getAllCourseByTeacherId(int teacherId) {
        return null;
    }
}
