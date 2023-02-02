package com.pmmf.service;

import java.util.List;

import com.pmmf.entity.Question;

public interface QuestionService {

	public List<Question> getQuestions();

	public void saveQuestion(Question theQuestion);

	public Question getQuestion(int theId);

	public void deleteQuestion(int theId);
}
