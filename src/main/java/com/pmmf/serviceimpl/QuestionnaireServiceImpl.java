package com.pmmf.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmmf.service.QuestionnaireService;
import com.pmmf.dao.QuestionnaireDAO;
import com.pmmf.entity.Questionnaire;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

	// Inject questionnaire dao
	@Autowired
	private QuestionnaireDAO questionnaireDAO;
			
	@Override
	@Transactional
	public List<Questionnaire> getQuestionnaires() {
			
		return questionnaireDAO.getQuestionnaires();
	}
	
	@Override
	@Transactional
	public void saveQuestionnaire(Questionnaire theQuestionnaire) {
		
		questionnaireDAO.saveQuestionnaire(theQuestionnaire);
	}
	
	@Override
	@Transactional
	public Questionnaire getQuestionnaire(int theId) {
		
		return questionnaireDAO.getQuestionnaire(theId);
	}

	@Override
	@Transactional
	public void deleteQuestionnaire(int theId) {
		
		questionnaireDAO.deleteQuestionnaire(theId);
	}
}
