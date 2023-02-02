package com.pmmf.daoimpl;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.pmmf.dao.GenericDAO;

public abstract class AbstractGenericDAO<E> implements GenericDAO<E> {

	private final Class<E> entityClass;
	
	public AbstractGenericDAO() {
		this.entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	// Session factory injection
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	

}
