package com.examapp.examportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examapp.examportal.entity.Admin;
import com.examapp.examportal.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	public void saveUser(Admin admin) {
		adminRepository.save(admin);
	}
	
	public Admin fetchAdminByUserName(String name) {
		return adminRepository.findByUserName(name);
	}
	
	public String fetchPassByName(String name) {
		return adminRepository.findPasswordByUserName(name);
	}
}
