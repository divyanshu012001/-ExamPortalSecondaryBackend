package com.examapp.examportal.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.examapp.examportal.entity.Student;
import com.examapp.examportal.entity.StudentAnswers;
import com.examapp.examportal.repository.StudentAnswersRepository;
import com.examapp.examportal.repository.StudentRepository;

@org.springframework.stereotype.Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentAnswersRepository studentAnswersRepository;

    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public Student fetchStudentByUserName(String name) {
        return studentRepository.findByEmail(name);
    }
    public String fetchPasswordByName(String name){
        return studentRepository.findPasswordByName(name);
    }
    
    public String fetchIdByName(String name) {
    	return studentRepository.findIdByStudent(name);
    }

    public boolean addAnswers(int student_id , String student_subject , String answer){
    	StudentAnswers s = new StudentAnswers(student_subject,answer,student_id);
        studentAnswersRepository.save(s);
        return true;
    }

}
