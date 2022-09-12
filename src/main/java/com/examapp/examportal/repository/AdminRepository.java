package com.examapp.examportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.examapp.examportal.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {


	public Admin findByUserName(String name);
	
	@Query("select password from Admin a where user_name = ?1")
	public  String findPasswordByUserName(String name);
}
