package com.examapp.examportal.encrypter;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordDecrypter {

    public boolean decrypter(String password, String encodedPassword) {
        BCryptPasswordEncoder decoder = new BCryptPasswordEncoder();
        return decoder.matches(password, encodedPassword);
    }
}