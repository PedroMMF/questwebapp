package com.pmmf.dao;

import java.util.List;

import com.pmmf.entity.Question;

public interface QuestionDAO {

	public List<Question> getQuestions();

	public void saveQuestion(Question theQuestion);

	public Question getQuestion(int theId);

	public void deleteQuestion(int theId);
}
