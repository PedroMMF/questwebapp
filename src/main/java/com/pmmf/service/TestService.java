package com.pmmf.service;

import java.util.List;

import com.pmmf.entity.Test;

public interface TestService {
	
	public List<Test> getTests();
	
	public void saveTest(Test theTest);
	
	public Test getTest(int theId);
	
	public void deleteTest(int theId);
}
