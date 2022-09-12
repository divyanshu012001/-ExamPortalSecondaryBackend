package com.examapp.examportal.encrypter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncrypter {

    public String encrypter(String pass) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPass = encoder.encode(pass);
        return encryptedPass;
    }
}
