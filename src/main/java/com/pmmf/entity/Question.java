package com.pmmf.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="questions")
public class Question {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;
	
	@Column(name="text", length = 256, nullable = false)
	private String text;
	
	@Column(name="subject", length = 32, nullable = false)
	private String subject;
	
	@Column(name="level", length = 8, nullable = false)
	private int level;
	
	@ManyToMany(fetch=FetchType.LAZY, 
			cascade={CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="questions_answers",
			joinColumns=@JoinColumn(name="question_id"),
			inverseJoinColumns=@JoinColumn(name="answer_id"))
	private List<Answer> answers;

	@ManyToMany(fetch=FetchType.LAZY, 
			cascade={CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="tests_questions",
			joinColumns=@JoinColumn(name="question_id"),
			inverseJoinColumns=@JoinColumn(name="test_id"))
	private List<Test> tests;
	
	public Question() {

	}

	public Question(String text, String subject, int level) {
		this.text = text;
		this.subject = subject;
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public List<Test> getTests() {
		return tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", text=" + text + ", subject=" + subject + ", level=" + level + "]";
	}
	
}
