package com.wecp.progressive.service.impl;
import java.util.*;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> 1ad1d074529ce688389d9a48e3f657964c2622b8
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Student;
import com.wecp.progressive.repository.StudentRepository;
import com.wecp.progressive.service.StudentService;

@Service
public class StudentServiceImplArraylist implements StudentService  {
<<<<<<< HEAD
// @Autowired
    private  StudentRepository studentRepository;

 

  //   public StudentServiceImplArraylist(StudentRepository studentRepository) {
  //     this.studentRepository = studentRepository;
  // }
  List<Student> studentList=new ArrayList<>();
=======

    private final StudentRepository studentRepository;

  List<Student> studentList=new ArrayList<>();

    StudentServiceImplArraylist(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
>>>>>>> 1ad1d074529ce688389d9a48e3f657964c2622b8
    public List<Student> getAllStudents()
    {
        //List<Student> list=new ArrayList<Student>();

         return studentList;

    }
    public Integer addStudent(Student student)
    {

        studentList.add(student);
        return studentList.size();
    }

    public List<Student> getAllStudentSortedByName()
    {
        //Collections.sort(studentList);
        List<Student> sortedStudent = studentList;

        Comparator<Student> compr = new Comparator<Student>() {
            
                @Override
                public int compare(Student s1, Student s2)
                {
                return s1.getFullName().compareTo(s2.getFullName());
                }
            };
            
         sortedStudent.sort(compr);
         return sortedStudent;

    }
    public void emptyArrayList()
    {
       studentList.clear();
      //  studentList=new ArrayList<>();
    }

    public Student getStudentById(int studentId)
    {
      return studentRepository.findByStudentId(studentId);
    }

}