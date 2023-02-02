package com.pmmf.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pmmf.dao.TestDAO;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Test getTest(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTest(int theId) {
		// TODO Auto-generated method stub
		
	}

}
