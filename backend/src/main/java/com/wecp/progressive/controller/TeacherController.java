package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Teacher;
import com.wecp.progressive.service.impl.TeacherServiceImplArraylist;
import com.wecp.progressive.service.impl.TeacherServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/teacher")
public class TeacherController  {
 
    @Autowired
    TeacherServiceImplJpa teacherServiceImplJpa;
    
    public TeacherController(TeacherServiceImplJpa teacherServiceImplJpa) {
        this.teacherServiceImplJpa = teacherServiceImplJpa;
    }
@GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() throws Exception {
     return new ResponseEntity<>(teacherServiceImplJpa.getAllTeachers(),HttpStatus.OK);
    }
@GetMapping("/{teacherId}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable int teacherId) throws Exception {
        return new ResponseEntity<>(teacherServiceImplJpa.getTeacherById(teacherId),HttpStatus.OK);
    }
@PostMapping
    public ResponseEntity<Integer> addTeacher(@RequestBody Teacher teacher) throws Exception {
        Integer n=teacherServiceImplJpa.addTeacher(teacher);
        return new ResponseEntity<>(n,HttpStatus.CREATED);
    }
  
   public String putMethodName(@PathVariable String id, @RequestBody String entity) {
       //TODO: process PUT request
       
       return entity;
   }
   @PutMapping("/{teacherId}")
    public ResponseEntity<Void> updateTeacher(@PathVariable Integer teacherId, @RequestBody Teacher teacher)throws Exception {
        Teacher t=teacherServiceImplJpa.getTeacherById(teacherId);
        if(t!=null)
        {
            teacherServiceImplJpa.updateTeacher(teacher);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }
  @DeleteMapping("/{teacherId}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable int teacherId) throws Exception  {
        Teacher t=teacherServiceImplJpa.getTeacherById(teacherId);
        if(t!=null)
        {
            teacherServiceImplJpa.deleteTeacher(teacherId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
  
    @GetMapping("/yearofexperience")
    public ResponseEntity<List<Teacher>> getTeacherSortedByYearsOfExperience()
     {
        return new ResponseEntity<>(teacherServiceImplJpa.getTeacherSortedByExperience(),HttpStatus.OK);
    }
}
