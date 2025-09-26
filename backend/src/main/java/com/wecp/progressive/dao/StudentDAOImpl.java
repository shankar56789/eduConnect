package com.wecp.progressive.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Course;
import com.wecp.progressive.entity.Student;

public class StudentDAOImpl implements StudentDAO {

    private Connection connection;
    public StudentDAOImpl() {
     try{
    connection=DatabaseConnectionManager.getConnection();
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
}
    public int addStudent(Student student) throws SQLException {
    String query="insert into student (full_name,date_of_birth,contact_number,email,address) values(?,?,?,?,?)";
    try(PreparedStatement ps=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS))
    {
        ps.setString(1,student.getFullName());
        ps.setDate(2, new java.sql.Date(student.getDateOfBirth().getTime()));
        ps.setString(3,student.getContactNumber());
        ps.setString(4,student.getEmail());
        ps.setString(5,student.getAddress());
        int rows=ps.executeUpdate();
        if(rows>0)
        {
                    ResultSet rs=ps.getGeneratedKeys();
            if(rs.next())
            {
                int id=rs.getInt(1);
                student.setStudentId(id);
               return id;
            }

    }
}
    return -1;
}

    @Override
    public Student getStudentById(int studentId) throws SQLException{
     String query="select * from student where student_id=?";
    try(PreparedStatement ps=connection.prepareStatement(query))
    {
         ps.setInt(1,studentId);
         ResultSet rs=ps.executeQuery();
         if(rs.next())
         {
            Student s=new Student();
            s.setFullName(rs.getString("full_name"));
            s.setDateOfBirth(rs.getDate("date_of_birth"));
            s.setContactNumber(rs.getString("contact_number"));
            s.setEmail(rs.getString("email"));
            s.setAddress(rs.getString("address"));
            s.setStudentId(rs.getInt("student_id"));
            return s;
         }

    }
    return null;
}

    @Override
    public void updateStudent(Student student)  throws SQLException {
        String query="update student set full_name=?,date_of_birth=?,contact_number=?,email=?,address=? where student_id=?";
    try(PreparedStatement ps=connection.prepareStatement(query))
    {
        ps.setString(1,student.getFullName());
        ps.setDate(2, new java.sql.Date(student.getDateOfBirth().getTime()));
        ps.setString(3,student.getContactNumber());
        ps.setString(4,student.getEmail());
        ps.setString(5,student.getAddress());
        ps.setInt(6, student.getStudentId());
         ps.executeUpdate();
        
    }
}

    @Override
    public void deleteStudent(int studentId) throws SQLException {
        String query="delete from student where student_id=?";
        try(PreparedStatement ps=connection.prepareStatement(query))
        {
            ps.setInt(1,studentId);
            ps.executeUpdate();
    }
}

    @Override
    public List<Student> getAllStudents() throws SQLException {
        String query="select * from student";
        try(PreparedStatement ps=connection.prepareStatement(query))
    {
        ResultSet rs=ps.executeQuery();
        List<Student> student=new ArrayList<>();
        while(rs.next())
        {
            Student s=new Student();
            s.setFullName(rs.getString("full_name"));
            s.setDateOfBirth(rs.getDate("date_of_birth"));
            s.setContactNumber(rs.getString("contact_number"));
            s.setEmail(rs.getString("email"));
            s.setAddress(rs.getString("address"));
            s.setStudentId(rs.getInt("student_id"));
            student.add(s);
        }
         return student;
        
      
    }

}
}