package com.wecp.progressive.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int attendanceId;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    private Date attendanceDate;
    private Date createdAt;
    public String status;
    public Attendance() {
    }
    public Attendance(Course course, Student student, Date attendanceDate, String status) {
        this.course = course;
        this.student = student;
        this.attendanceDate = attendanceDate;
        this.status = status;
    }
    public int getAttendanceId() {
        return attendanceId;
    }
    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Date getAttendanceDate() {
        return attendanceDate;
    }
    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    

}