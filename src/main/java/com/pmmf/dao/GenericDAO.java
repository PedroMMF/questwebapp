package com.pmmf.dao;

import java.util.List;

public interface GenericDAO<T> {
	
	List<T> getList(T entity);
	
	void save(T entity);
	
	T get(int id);
	
	void delete(T entity);
}
