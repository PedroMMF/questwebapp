package com.pmmf.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmmf.dao.TestDAO;
import com.pmmf.entity.Test;
import com.pmmf.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestDAO testDAO;
	
	@Override
	@Transactional
	public List<Test> getTests() {
		
		return testDAO.getTests();
	}

	@Override
	@Transactional
	public void saveTest(Test theTest) {
		
		testDAO.saveTest(theTest);
	}
	
	@Override
	@Transactional
	public Test getTest(int theId) {
		
		return testDAO.getTest(theId);
	}
	
	@Override
	@Transactional
	public void deleteTest(int theId) {
		
		testDAO.deleteTest(theId);
	}
}
