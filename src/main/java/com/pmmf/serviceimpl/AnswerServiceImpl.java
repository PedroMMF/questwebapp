package com.pmmf.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmmf.service.AnswerService;
import com.pmmf.dao.AnswerDAO;
import com.pmmf.entity.Answer;

@Service
public class AnswerServiceImpl implements AnswerService {

	// Inject customer dao
	@Autowired
	private AnswerDAO answerDAO;
		
	@Override
	@Transactional
	public List<Answer> getAnswers() {
		
		return answerDAO.getAnswers();
	}

	@Override
	@Transactional
	public void saveAnswer(Answer theAnswer) {
		
		answerDAO.saveAnswer(theAnswer);
	}

	@Override
	@Transactional
	public Answer getAnswer(int theId) {
		
		return answerDAO.getAnswer(theId);
	}

	@Override
	@Transactional
	public void deleteAnswer(int theId) {
		
		answerDAO.deleteAnswer(theId);
	}

}
