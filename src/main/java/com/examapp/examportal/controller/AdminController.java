package com.examapp.examportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examapp.examportal.encrypter.PasswordDecrypter;
import com.examapp.examportal.encrypter.PasswordEncrypter;
import com.examapp.examportal.entity.Admin;
import com.examapp.examportal.entity.Subject;
import com.examapp.examportal.service.AdminService;

@RestController
@CrossOrigin
public class AdminController {


	@Autowired
	AdminService adminService;
	
	@PostMapping("/adminregistration")
	public boolean adminRegistration(@RequestBody Admin admin) {
		Admin adminObj = null;
		String tempName = admin.getUserName();
		if(tempName != null && !"".equals(tempName)) {
			adminObj = adminService.fetchAdminByUserName(tempName);
			if(adminObj != null) {
				return false;
			}
		}
		else {
			return false;
		}
		PasswordEncrypter pe = new PasswordEncrypter();
		admin.setPassword(pe.encrypter(admin.getPassword()));
		adminService.saveUser(admin);
		return true;
	}
	
	
	@PostMapping("/adminlogin")
	public boolean adminLogin(@RequestBody Admin admin) {
		String tempName = admin.getUserName();
		String tempPass = admin.getPassword();
		String enPass = adminService.fetchPassByName(tempName);
		PasswordDecrypter pd = new PasswordDecrypter();
		boolean check = pd.decrypter(tempPass, enPass);
		if(check == false) {
			return false;
		}
		return true; 
	}
	
	@PostMapping("/addSubject")
	public void addSubject(@RequestBody Subject subject) {
		adminService.saveSubject(subject);
	}
	
	@GetMapping("/displayAnswers/{subject}")
	public List<Subject> displayAnswers(@PathVariable String subject) {
		System.out.print(subject);
		List<Subject> list = adminService.fetchDataBySubject(subject);
		return list;
	}
	
	@GetMapping("/viewAllSubjects")
	public List<Subject> getAllSubject(){
		return adminService.getAllSub();
	}
	
	@DeleteMapping("/deleteSubject/{id}")
	public void deleteSubject(@PathVariable int id) {
		adminService.deleteSub(id);
	}
}

