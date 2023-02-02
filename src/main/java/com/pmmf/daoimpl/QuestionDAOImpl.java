package com.pmmf.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pmmf.dao.QuestionDAO;
import com.pmmf.entity.Question;

@Repository
public class QuestionDAOImpl implements QuestionDAO {

	// Session factory injection
	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	public List<Question> getQuestions() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query ... sort by text
		Query<Question> theQuery =
				currentSession.createQuery("from Question order by text", Question.class);
		
		// execute query and get result list
		List<Question> questions = theQuery.getResultList();
		
		return questions;
	}

	@Override
	public void saveQuestion(Question theQuestion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Question getQuestion(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteQuestion(int theId) {
		// TODO Auto-generated method stub
		
	}

	
}
