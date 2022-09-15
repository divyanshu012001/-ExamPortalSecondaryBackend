package com.examapp.examportal.service;

import com.examapp.examportal.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.examapp.examportal.entity.Students;
import com.examapp.examportal.entity.StudentAnswers;
import com.examapp.examportal.repository.StudentAnswersRepository;
import com.examapp.examportal.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentAnswersRepository studentAnswersRepository;

    @Autowired
    SubjectRepository subjectRepository;

    public void createStudent(Students student){
        studentRepository.save(student);
    }

    public Students fetchStudentByUserName(String name) {
        return studentRepository.findByEmail(name);
    }
    public String fetchPasswordByName(String name){
        return studentRepository.findPasswordByName(name);
    }
    
    public String fetchIdByName(String name) {
    	return studentRepository.findIdByStudent(name);
    }

    public boolean addAnswers(int student_id , String student_subject , String answer){
    	StudentAnswers s = new StudentAnswers(answer,student_subject,student_id);
        studentAnswersRepository.save(s);
        return true;
    }

    public List<String> findQuestions(String subject){
        System.out.println(subjectRepository.findQuestionsBySubject(subject));
        return subjectRepository.findQuestionsBySubject(subject);
    }
}
