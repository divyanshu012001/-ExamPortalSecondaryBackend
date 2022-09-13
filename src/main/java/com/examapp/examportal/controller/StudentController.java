package com.examapp.examportal.controller;

import com.examapp.examportal.encrypter.PasswordDecrypter;
import com.examapp.examportal.encrypter.PasswordEncrypter;
import com.examapp.examportal.entity.Student;
import com.examapp.examportal.entity.StudentAnswers;
import com.examapp.examportal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping("/studentregistration")
    public boolean studentRegistration(@RequestBody Student s) {
        Student stuobj = null;
        String tempName =  s.getEmail();
        if(tempName != null && !"".equals(tempName)){
            stuobj = service.fetchStudentByUserName(tempName);
            if(stuobj != null){
                return false;
            }
        }
        else {
            return false;
        }
        PasswordEncrypter pe = new PasswordEncrypter();
        s.setPassword(pe.encrypter(s.getPassword()));
        service.createStudent(s);
        return true;
    }


    @PostMapping("/studentlogin")
    public boolean studentLogin(@RequestBody Student s){
        String tempName = s.getEmail();
        String tempPass = s.getPassword();
        String enPass = service.fetchPasswordByName(tempName);
        PasswordDecrypter pd = new PasswordDecrypter();
        boolean check = pd.decrypter(tempPass, enPass);
        if(check == false){
            return false;
        }
        return true;
    }

    @PostMapping("/addAnswer/{student_id}/{student_subject}")
    public boolean addAnswer(@PathVariable int student_id ,@PathVariable String student_subject ,  @RequestBody StudentAnswers studentAnswers){
        System.out.println(student_id);
        System.out.println(student_subject);
        System.out.print(studentAnswers.getAnswers());
        service.addAnswers(student_id,student_subject,studentAnswers.getAnswers());
        return true;
    }
    
    @PostMapping("/displayAnswersByStudent/{student_id}/{subject}")
    public void displayAnswersByStudent(@PathVariable int student_id,@PathVariable String subject) {
    	
    }

    //Show Subject------------------
}
