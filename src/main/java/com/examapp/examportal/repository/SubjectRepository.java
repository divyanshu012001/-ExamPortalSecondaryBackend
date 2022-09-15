package com.examapp.examportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.examapp.examportal.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

	@Query("select s from Subject s where subject=?1")
	List<Subject> findBySubject(String subject);
	
	@Query("select distinct s.subject from Subject s")
	List<String> findOnlySubject();
}
