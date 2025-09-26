package com.wecp.progressive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.wecp.progressive.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher ,Integer> {

@Query("select t from Teacher t where t.id=teacherid")
 public Teacher findByTeacherId(@Param("teacherId") int teacherId);
}
