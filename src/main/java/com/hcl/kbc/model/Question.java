package com.hcl.kbc.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Question {

	private int id;
	private String questionString;
	private String correctAnswer;
	private List<String> options;
	
	public Question() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}
	public String getQuestionString() {
		return questionString;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setQuestionString(String questionString) {
		this.questionString = questionString;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", questionString=" + questionString + ", correctAnswer=" + correctAnswer
				+ ", options=" + options + "]";
	}
	public Question(int id, String questionString, String correctAnswer, List<String> options) {
		super();
		this.id = id;
		this.questionString = questionString;
		this.correctAnswer = correctAnswer;
		this.options = options;
	}
	
}
