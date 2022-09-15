package com.examapp.examportal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class AdminSubjects {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String subject;
	private String question;
	private String answer;
	public AdminSubjects() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminSubjects(int id, String subject, String question, String answer) {
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

	@Override
	public String toString() {
		return "AdminSubjects{" +
				"id=" + id +
				", subject='" + subject + '\'' +
				", question='" + question + '\'' +
				", answer='" + answer + '\'' +
				'}';
	}
}
