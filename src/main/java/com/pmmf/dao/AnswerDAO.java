package com.pmmf.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pmmf.entity.Answer;

@Repository
public interface AnswerDAO {

	public List<Answer> getAnswers();

	public void saveAnswer(Answer theAnswer);

	public Answer getAnswer(int theId);

	public void deleteAnswer(int theId);
}
