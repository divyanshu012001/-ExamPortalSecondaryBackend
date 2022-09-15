package com.examapp.examportal.service;

import java.util.List;

import com.examapp.examportal.entity.Students;
import com.examapp.examportal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examapp.examportal.entity.Admin;
<<<<<<< Updated upstream
import com.examapp.examportal.entity.StudentAnswers;
import com.examapp.examportal.entity.Subject;
=======
import com.examapp.examportal.entity.AdminSubjects;
>>>>>>> Stashed changes
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
	StudentRepository studentRepository;
	
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
	
	public void saveSubject(AdminSubjects subject) {
		subjectRepository.save(subject);
	}
	
	public List<AdminSubjects> fetchDataBySubject(String subject) {
		return (List<AdminSubjects>)subjectRepository.findBySubject(subject);
	}
	
	public List<AdminSubjects> getAllSub(){
		return subjectRepository.findAll();
	}

	public List<String> getOnlySubs(){
		return subjectRepository.findOnlySubject();
	}

	public List<String> getAllStudents(){
		return studentRepository.findStudentsData();
	}
	public void deleteSub(int id) {
		subjectRepository.deleteById(id);
	}
	
	public List<StudentAnswers> fetchAnswersByStudentId(int id){
		return (List<StudentAnswers>)studentAnswersRepository.findAnswersById(id);
	}
	
	public List<String> getOnlySubs(){
		   return subjectRepository.findOnlySubject();
		}
}
