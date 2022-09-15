package com.examapp.examportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.examapp.examportal.entity.AdminSubjects;

public interface SubjectRepository extends JpaRepository<AdminSubjects, Integer> {

<<<<<<< Updated upstream
	@Query("select s from Subject s where subject=?1")
	List<Subject> findBySubject(String subject);
	
	@Query("select distinct s.subject from Subject s")
	List<String> findOnlySubject();
=======
	@Query("select s from AdminSubjects s where subject=?1")
	List<AdminSubjects> findBySubject(String subject);

	@Query("select distinct s.subject from AdminSubjects s")
	List<String> findOnlySubject();

	@Query("select s.question from AdminSubjects s where subject=?1")
	List<String> findQuestionsBySubject(String subject);
>>>>>>> Stashed changes
}
