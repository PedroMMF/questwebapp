package com.pmmf.service;

import java.util.List;

import com.pmmf.entity.Questionnaire;

public interface QuestionnaireService {
	
	public List<Questionnaire> getQuestionnaires();

	public void saveQuestionnaire(Questionnaire theQuestionnaire);
	
	public Questionnaire getQuestionnaire(int theId);
	
	public void deleteQuestionnaire(int theId);
}
