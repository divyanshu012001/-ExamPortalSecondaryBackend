package com.examapp.examportal.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examapp.examportal.encrypter.PasswordDecrypter;
import com.examapp.examportal.encrypter.PasswordEncrypter;
import com.examapp.examportal.entity.Students;
import com.examapp.examportal.entity.StudentAnswers;
import com.examapp.examportal.service.StudentService;

import java.util.List;

@RestController
@CrossOrigin
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping("/studentregistration")
    public boolean studentRegistration(@RequestBody Students s) {
        Students stuobj = null;
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
<<<<<<< Updated upstream
    public Map<String, String> studentLogin(@RequestBody Student s){
    	 HashMap<String, String> map = new HashMap<>();
=======
    public boolean studentLogin(@RequestBody Students s){
>>>>>>> Stashed changes
        String tempName = s.getEmail();
        String tempPass = s.getPassword();
        String enPass = service.fetchPasswordByName(tempName);
        String stId = service.fetchIdByName(tempName);
        PasswordDecrypter pd = new PasswordDecrypter();
        boolean check = pd.decrypter(tempPass, enPass);
        if(check == false){
        	map.put("State", "False");
            return map;
        }
        map.put("State", "True");
        map.put("StudentId", stId);
        return map;
    }

    @PostMapping("/addAnswer/{student_id}/{student_subject}")
    public boolean addAnswer(@PathVariable int student_id ,@PathVariable String student_subject ,  @RequestBody StudentAnswers studentAnswers){
//        System.out.println(student_id);
//        System.out.println(student_subject);
//        System.out.print(studentAnswers.getAnswers());
        service.addAnswers(student_id,student_subject,studentAnswers.getAnswers());
        return true;
    }
    
    @PostMapping("/displayAnswersByStudent/{student_id}/{subject}")
    public void displayAnswersByStudent(@PathVariable int student_id,@PathVariable String subject) {
    	
    }

<<<<<<< Updated upstream
    //Show Subject------------------
=======
    @GetMapping("/displayQuestionsBySubject/{subject}")
    public List<String> displayQuestions(@PathVariable String subject){
        return service.findQuestions(subject);
    }

>>>>>>> Stashed changes
}
