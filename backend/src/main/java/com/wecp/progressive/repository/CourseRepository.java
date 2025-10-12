package com.wecp.progressive.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wecp.progressive.entity.Course;
import java.util.List;
@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    // @Query("select c from course c where course_id=:id")
    public Course findByCourseId(int courseId);

    
}
