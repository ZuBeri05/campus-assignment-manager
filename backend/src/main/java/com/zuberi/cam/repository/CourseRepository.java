package com.zuberi.cam.repository;

import com.zuberi.cam.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
