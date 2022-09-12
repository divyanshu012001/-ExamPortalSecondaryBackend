package com.examapp.examportal.entity;

import javax.persistence.*;

@Entity
public class StudentAnswers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String answers;

    private String subject;

    private int student_id;

    public StudentAnswers() {
    }

    
    public StudentAnswers(String answers, String subject, int student_id) {
		super();
		this.answers = answers;
		this.subject = subject;
		this.student_id = student_id;
	}


	public StudentAnswers(int id, String answers, String subject, int student_id) {
        this.id = id;
        this.answers = answers;
        this.subject = subject;
        this.student_id = student_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return "StudentAnswers{" +
                "id=" + id +
                ", answers='" + answers + '\'' +
                ", subject='" + subject + '\'' +
                ", student_id=" + student_id +
                '}';
    }
}
