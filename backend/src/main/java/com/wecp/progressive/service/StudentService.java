package com.wecp.progressive.service;

import com.wecp.progressive.dto.StudentDTO;
import com.wecp.progressive.entity.Student;

import java.util.List;

import org.springframework.stereotype.Service;

public interface StudentService {

    public List<Student> getAllStudents() throws Exception;

    public Integer addStudent(Student student) throws Exception;

    public List<Student> getAllStudentSortedByName() throws Exception;

    public default void emptyArrayList() {
    }

    //Do not implement these methods in StudentServiceImplArraylist.java class
    public default void updateStudent(Student student) throws Exception {}

    public default void deleteStudent(int studentId) throws Exception{}

    public default Student getStudentById(int studentId) throws Exception{
        return null;
    }

    //Do not implement these methods in StudentServiceImplArraylist.java and StudentServiceImplJdbc.java class
    //Do not implement in StudentServiceImplJpa.java until Day-13
    default public void modifyStudentDetails(StudentDTO studentDTO) { }
}
