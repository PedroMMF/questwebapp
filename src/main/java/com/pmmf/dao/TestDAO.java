package com.pmmf.dao;

import java.util.List;

import com.pmmf.entity.Test;

public interface TestDAO {

	public List<Test> getTests();
	
	public void saveTest(Test theTest);

	public Test getTest(int theId);

	public void deleteTest(int theId);
}
