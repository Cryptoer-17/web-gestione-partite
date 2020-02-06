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


	@Override
	@Transactional
	public void deleteEvent(Evento theEvent) {
		//get current session
		Session currentSession= sessionFactory.getCurrentSession();
		//delete the event finally LOL
		currentSession.delete(theEvent);
	}

	
	@Override
	@Transactional
	public Evento getEventId(int idEvent) {
		Session currentSession= sessionFactory.getCurrentSession();		
		Query<Evento> theQuery = currentSession.createQuery("from Evento where idEvento=:idEvent");
		theQuery.setParameter("idEvent", idEvent);
		
		try {
			Evento theEvent = theQuery.getSingleResult();
			return theEvent;
			}
			catch(NoResultException nre) {
				return null;	
			}
	}
	
	
	@Override
	@Transactional
	public String getTipoEvent(int idEvent) {
		Session currentSession= sessionFactory.getCurrentSession();		
		Query<Evento> theQuery = currentSession.createQuery("from Evento where idEvento=:idEvent");
		theQuery.setParameter("idEvent", idEvent);
		
		try {
			Evento theEvent = theQuery.getSingleResult();
			return theEvent.getTipo();
			}
			catch(NoResultException nre) {
				return null;	
			}
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
}
