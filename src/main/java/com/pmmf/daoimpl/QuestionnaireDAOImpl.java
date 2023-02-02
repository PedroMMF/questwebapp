package com.pmmf.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pmmf.dao.QuestionnaireDAO;
import com.pmmf.entity.Questionnaire;

@Repository
public class QuestionnaireDAOImpl implements QuestionnaireDAO {

	// Session factory injection
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Questionnaire> getQuestionnaires() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query ... sort by text
		Query<Questionnaire> theQuery =
				currentSession.createQuery("from Questionnaire order by title", Questionnaire.class);
		
		// execute query and get result list
		List<Questionnaire> questionnaires = theQuery.getResultList();
		
		return questionnaires;
	}

	@Override
	public void saveQuestionnaire(Questionnaire theQuestionnaire) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Questionnaire getQuestionnaire(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteQuestionnaire(int theId) {
		// TODO Auto-generated method stub
		
	}

}
