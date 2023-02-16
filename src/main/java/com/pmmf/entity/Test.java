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
@Table(name="tests")
public class Test {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;
	
	@Column(name="title", length = 32, nullable = false)
	private String title;
	
	@Column(name="subject", length = 64, nullable = false)
	private String subject;
	
	@Column(name="level", length = 8, nullable = false)
	private int level;
	
	@ManyToMany(fetch=FetchType.LAZY, 
			cascade={CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="tests_questions",
			joinColumns=@JoinColumn(name="test_id"),
			inverseJoinColumns=@JoinColumn(name="question_id"))
	private List<Question> questions;
	
	@ManyToMany(fetch=FetchType.EAGER, 
			cascade={CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="questionnaires_tests",
			joinColumns=@JoinColumn(name="test_id"),
			inverseJoinColumns=@JoinColumn(name="questinnaire_id"))
	private List<Questionnaire> questionnaires;

	public Test() {
		
	}

	public Test(String title, String subject, int level) {
		this.title = title;
		this.subject = subject;
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Questionnaire> getQuestionnaires() {
		return questionnaires;
	}

	public void setQuestionnaires(List<Questionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", title=" + title + ", subject=" + subject + ", level=" + level + "]";
	}
}
