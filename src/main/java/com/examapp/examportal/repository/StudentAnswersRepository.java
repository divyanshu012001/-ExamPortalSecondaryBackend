package com.examapp.examportal.repository;

import com.examapp.examportal.entity.StudentAnswers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAnswersRepository extends JpaRepository<StudentAnswers,Integer> {
}
