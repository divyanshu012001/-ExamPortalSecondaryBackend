package com.examapp.examportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.examapp.examportal.entity.StudentAnswers;

public interface StudentAnswersRepository extends JpaRepository<StudentAnswers,Integer> {
	
	@Query("select s from StudentAnswers s where student_id = ?1")
	List<StudentAnswers> findAnswersById(int id);
}
