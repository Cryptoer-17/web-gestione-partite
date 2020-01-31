package com.iaco2code.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iaco2code.springdemo.entity.Persona;



@Repository
public class PersonDAOImpl implements PersonDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Persona> getPersons() {
		
		//get the current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		
		//create query
		Query<Persona> theQuery = currentSession.createQuery("from Persona",Persona.class);
		
		//execute query and get result list 
		List<Persona> persone = theQuery.getResultList();

		//return the result
		return persone;
	}

}
