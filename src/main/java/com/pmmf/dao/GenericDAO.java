package com.pmmf.dao;

import java.util.List;

public interface GenericDAO<E> {
	
	List<E> getList(E entity);
	
	void save(E entity);
	
	E get(int id);
	
	void delete(E entity);
}
