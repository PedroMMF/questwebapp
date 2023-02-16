package com.pmmf.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pmmf.dao.AnswerDAO;
import com.pmmf.entity.Answer;


@Repository
public class AnswerDAOImpl implements AnswerDAO{
	
	// Session factory injection
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Answer> getAnswers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query ... sort by text
		Query<Answer> theQuery =
				currentSession.createQuery("from Answer order by text", Answer.class);
				
		// execute query and get result list
		List<Answer> answers = theQuery.getResultList();
				
		return answers;
	}

	@Override
	public void saveAnswer(Answer theAnswer) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// save/update the answer
		currentSession.saveOrUpdate(theAnswer);
	}

	@Override
	public Answer getAnswer(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// read from database using the primary key
		Answer theAnswer = currentSession.get(Answer.class, theId);
				
		return theAnswer;
	}

	@Override
	public void deleteAnswer(int theId) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Answer where id=:answerId");
		theQuery.setParameter("answerId", theId);
				
		theQuery.executeUpdate();
	}

}
