package com.wecp.progressive.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.wecp.progressive.dto.StudentDTO;
import com.wecp.progressive.entity.Student;
import com.wecp.progressive.repository.StudentRepository;
import com.wecp.progressive.service.StudentService;

@Service
public class StudentServiceImplJpa  {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;
    
    
    public List<Student> getAllStudents() throws Exception{
        
        return studentRepository.findAll();
    }
    public Integer addStudent(Student student) throws Exception{
        studentRepository.save(student);
        return student.getStudentId();
    }
    public List<Student> getAllStudentSortedByName() throws Exception{
        return studentService.getAllStudentSortedByName();
    }
    public void updateStudent(Student student) throws Exception{

    }
    public void deleteStudent(int studentId) throws Exception{

    }
    public Student getStudentById(int studentId) throws Exception{
        return null;
    }
    public void modifyStudentDetails(StudentDTO studentDTO){
        
    }

}