package com.LearningRestApi.learningapiApplication.repository;

import com.LearningRestApi.learningapiApplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
