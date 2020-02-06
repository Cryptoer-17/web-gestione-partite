package com.iaco2code.springdemo.daoevent;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iaco2code.springdemo.entity.Evento;
import com.iaco2code.springdemo.entity.Persona;

@Repository
public class EventDAOImpl implements EventDAO {

	
	//need to inject the session factory
		@Autowired
		private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public void saveEvent(Evento theEvent) {
		System.out.println("entrato");
		//get current session
		Session currentSession= sessionFactory.getCurrentSession();
		
		//save the person finally LOL
		currentSession.saveOrUpdate(theEvent);
		
	}

}
