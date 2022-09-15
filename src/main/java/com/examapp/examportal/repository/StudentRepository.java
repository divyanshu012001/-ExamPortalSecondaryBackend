package com.examapp.examportal.repository;

<<<<<<< Updated upstream
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.examapp.examportal.entity.Student;
=======
import com.examapp.examportal.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
>>>>>>> Stashed changes

//@Repository
public interface StudentRepository extends JpaRepository<Students,Integer> {

    public Students findByEmail(String name);

    @Query("select password from Students s where email = ?1")
    public String findPasswordByName(String name);
    
    @Query("select id from Student s where email =?1")
    public String findIdByStudent(String name);

    @Query("select s.email,s.fullName from Students s")
    public List<String> findStudentsData();

}
