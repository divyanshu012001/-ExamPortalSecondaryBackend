package com.examapp.examportal.exceptions;

@SuppressWarnings("serial")
public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(){
        super("Student Not Found");
    }
}
