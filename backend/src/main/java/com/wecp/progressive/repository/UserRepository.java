package com.wecp.progressive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wecp.progressive.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

    public User findByUsername(String username);
    // public User findByTeacherId(int teacherId);
    // public User findByStudentId(int studentId);
    // public void deleteByTeacher(int teacherId);
    // public void deleteByStudentId(int studentId);
}
