package com.pmmf.service;

import java.util.List;

import com.pmmf.entity.Answer;

public interface AnswerService {

	public List<Answer> getAnswers();

	public void saveAnswer(Answer theAnswer);

	public Answer getAnswer(int theId);

	public void deleteAnswer(int theId);
}
