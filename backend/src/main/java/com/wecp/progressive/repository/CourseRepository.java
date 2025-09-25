package com.wecp.progressive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecp.progressive.entity.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
}
