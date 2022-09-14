package com.examapp.examportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.examapp.examportal.entity.Student;

//@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    public Student findByEmail(String name);

    @Query("select password from Student s where email = ?1")
    public String findPasswordByName(String name);
    
    @Query("select id from Student s where email =?1")
    public String findIdByStudent(String name);

}
