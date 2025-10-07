package com.wecp.progressive.dto;

public class TeacherDTO {
    private int teacherId;
    private String username;
    private String password;
    private String fullName;
    private String contactNumber;
    private String email;
    private String subject;
    private Integer yearsOfExperience;
    public int getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }
    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    public TeacherDTO() {
    }
    public TeacherDTO(int teacherId, String username, String password, String fullName, String contactNumber,
            String email, String subject, Integer yearsOfExperience) {
        this.teacherId = teacherId;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.subject = subject;
        this.yearsOfExperience = yearsOfExperience;
    }


    

}