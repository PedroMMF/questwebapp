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
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// save/update the questionaire
		currentSession.saveOrUpdate(theQuestionnaire);
		
	}

	@Override
	public Questionnaire getQuestionnaire(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
						
		// read from database using the primary key
		Questionnaire theQuestionnaire = currentSession.get(Questionnaire.class, theId);
		
		return theQuestionnaire;
	}

	@Override
	public void deleteQuestionnaire(int theId) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
						
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Questionnaire where id=:questionnaireId");
		theQuery.setParameter("questionnaireId", theId);
		
		theQuery.executeUpdate();
	}

}
