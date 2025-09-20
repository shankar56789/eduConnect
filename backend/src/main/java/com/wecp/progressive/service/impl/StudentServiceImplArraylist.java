package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wecp.progressive.entity.Course;
import com.wecp.progressive.entity.Student;
import com.wecp.progressive.service.StudentService;

public class StudentServiceImplArraylist implements StudentService {
    private static List<Student> studentList=new ArrayList<>();
    @Override
    public Integer addStudent(Student student) {
        studentList.add(student);
        return studentList.size();
    }

    @Override
    public List<Student> getAllStudentSortedByName() {
        Collections.sort(studentList,studentComparator);
        return studentList;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentList;
    }

    @Override
    public void emptyArrayList() {
        studentList.clear();
    
    }
    public Comparator<Student> studentComparator=new Comparator<Student>() {
        public int compare(Student arg0,Student arg1){
            return arg0.getFullName().compareTo(arg1.getFullName());
        }
    };
    

}