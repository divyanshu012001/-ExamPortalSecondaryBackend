package com.examapp.examportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examapp.examportal.entity.Admin;
import com.examapp.examportal.entity.StudentAnswers;
import com.examapp.examportal.entity.StudentAnswers;
import com.examapp.examportal.entity.Subject;
import com.examapp.examportal.repository.AdminRepository;
import com.examapp.examportal.repository.StudentAnswersRepository;
import com.examapp.examportal.repository.SubjectRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	StudentAnswersRepository studentAnswersRepository;
	
	public void saveUser(Admin admin) {
		adminRepository.save(admin);
	}
	
	public Admin fetchAdminByUserName(String name) {
		return adminRepository.findByUserName(name);
	}
	
	public String fetchPassByName(String name) {
		return adminRepository.findPasswordByUserName(name);
	}
	
	public void saveSubject(Subject subject) {
		subjectRepository.save(subject);
	}
	
	public List<Subject> fetchDataBySubject(String subject) {
		return (List<Subject>)subjectRepository.findBySubject(subject);
	}
	
	public List<Subject> getAllSub(){
		return subjectRepository.findAll();
	}
	
	public void deleteSub(int id) {
		subjectRepository.deleteById(id);
	}
	
	public List<StudentAnswers> fetchAnswersByStudentId(int id){
		return (List<StudentAnswers>)studentAnswersRepository.findAnswersById(id);
	}
}
