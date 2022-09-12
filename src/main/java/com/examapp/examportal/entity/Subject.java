package com.examapp.examportal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subject {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String subject;
	private String question;
	private String answer;
	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(String subject, String question, String answer) {
		super();
		this.subject = subject;
		this.question = question;
		this.answer = answer;
	}

	public Subject(int id, String subject, String question, String answer) {
		super();
		this.id = id;
		this.subject = subject;
		this.question = question;
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
