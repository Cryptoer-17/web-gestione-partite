package com.iaco2code.springdemo.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iaco2code.springdemo.entity.Evento;
import com.iaco2code.springdemo.entity.Persona;




@Repository
public class PersonDAOImpl implements PersonDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Persona> getPersons(String event) {
		
		//get the current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		
		//create query
		Query<Persona> theQuery = currentSession.createQuery("select p from Persona p join p.eventi e where Tipo='"+event+"'",Persona.class);
		
		//execute query and get result list 
		List<Persona> persone = theQuery.getResultList();

		//return the result
		return persone;
	}


	@Override
	@Transactional
	public List<Evento> getEvent(String evento) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create query
		Query<Evento> theQuery = currentSession.createQuery("from Evento where Tipo='"+evento+"'");
		
		
		//execute query and get result list
		List<Evento> eventi = theQuery.getResultList();
		
		//return the result
		return eventi;
		
	}


	@Override
	@Transactional
	public List<Evento> getEvents() {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
			
		//create query
		Query<Evento> theQuery = currentSession.createQuery("from Evento");
						
				
		//execute query and get result list
		List<Evento> eventi = theQuery.getResultList();
				
		//return the result
		return eventi;
	}


	@Override
	@Transactional
	public void savePerson(Persona thePerson) {
		//get current session
		Session currentSession= sessionFactory.getCurrentSession();
		
		//save the person finally LOL
		currentSession.saveOrUpdate(thePerson);
		
		
		
	}


	@Override
	@Transactional
	public Persona checkPerson(String theUserPers, String theUserPass) {
		
		//get current session
		Session currentSession= sessionFactory.getCurrentSession();
		
		//retrive the person with query
		Query<Persona> theQuery = currentSession.createQuery("from Persona where Username=:user AND Password =:pass");
		theQuery.setParameter("user", theUserPers);
		theQuery.setParameter("pass", theUserPass);
		
		try {
		Persona thePerson = theQuery.getSingleResult();
		return thePerson;
		}
		catch(NoResultException nre) {
			return null;	
		}
		
		
	}


	

}
