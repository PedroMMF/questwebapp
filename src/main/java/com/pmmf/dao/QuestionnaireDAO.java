package com.pmmf.dao;

import java.util.List;

import com.pmmf.entity.Questionnaire;

public interface QuestionnaireDAO {
	
	public List<Questionnaire> getQuestionnaires();
	
	public void saveQuestionnaire(Questionnaire theQuestionnaire);
	
	public Questionnaire getQuestionnaire(int theId);
	
	public void deleteQuestionnaire(int theId);
}
