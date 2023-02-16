package com.pmmf.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pmmf.dao.TestDAO;
import com.pmmf.entity.Answer;
import com.pmmf.entity.Test;

@Repository
public class TestDAOImpl implements TestDAO{

	// Session factory injection
	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	public List<Test> getTests() {
		
		// get the current hibernate session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query ... sort by title
		Query<Test> theQuery =
				currentSession.createQuery("from Test order by title", Test.class);
		
		// execute query and get result list
		List<Test> tests = theQuery.getResultList();
		
		return tests;
	}

	@Override
	public void saveTest(Test theTest) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update the answer
		currentSession.saveOrUpdate(theTest);
	}

	@Override
	public Test getTest(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// read from database using the primary key
		Test theTest = currentSession.get(Test.class, theId);
						
		return theTest;
	}

	@Override
	public void deleteTest(int theId) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
						
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Test where id=:testId");
		theQuery.setParameter("testId", theId);
						
		theQuery.executeUpdate();
		
	}

}
