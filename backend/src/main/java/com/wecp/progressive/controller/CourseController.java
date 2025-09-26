package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Course;
import com.wecp.progressive.service.impl.CourseServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    
    private CourseServiceImplJpa courseServiceImplJpa;
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
          return new ResponseEntity<>(courseServiceImplJpa.getAllCourses(),HttpStatus.OK);
    }
    
     public String getMethodName(@RequestParam String param) {
         return new String();
     }
     @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable int courseId) throws Exception {
      return  new ResponseEntity<>(courseServiceImplJpa.getCourseById(courseId),HttpStatus.OK);
    }
   
  
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    @PostMapping
    public ResponseEntity<Integer> addCourse(Course course) {
        return new ResponseEntity<>(courseServiceImplJpa.addCourse(course),HttpStatus.OK);
    }

    public ResponseEntity<Void> updateCourse(int courseId, Course course) {
        courseServiceImplJpa.updateCourse(course);
     return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable int courseId) throws Exception {
        courseServiceImplJpa.deleteCourse(courseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<Course>> getAllCourseByTeacherId(int teacherId) {
        return new ResponseEntity<>(courseServiceImplJpa.getAllCourses(),HttpStatus.OK);
    }
}
