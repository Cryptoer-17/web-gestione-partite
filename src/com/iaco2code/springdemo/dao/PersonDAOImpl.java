package com.iaco2code.springdemo.dao;

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

	@Override
	@Transactional
	public Persona getPersonsId(int theId) {
		Session currentSession= sessionFactory.getCurrentSession();		
		Query<Persona> theQuery = currentSession.createQuery("from Persona where idPersona=:theId");
		theQuery.setParameter("theId", theId);
		
		try {
			Persona thePerson = theQuery.getSingleResult();
			return thePerson;
			}
			catch(NoResultException nre) {
				return null;	
			}

	}


	@Override
	@Transactional
	public void assocPersEvent(int idPers, int idEvent) {
		Session currentSession= sessionFactory.getCurrentSession();		
		Persona thePers = currentSession.get(Persona.class, idPers);
		Evento theEvent = currentSession.get(Evento.class, idEvent);
		thePers.addEvento(theEvent);
		currentSession.save(thePers);
		
	}



	@Override
	@Transactional
	public void deleteAssocEventPers(Persona person,Evento theEvent) {
		Session currentSession= sessionFactory.getCurrentSession();		
		theEvent.removePerson(person);
		person.getEventi().clear();
		currentSession.flush();
		currentSession.delete(person);
		
	}




	@Override
	@Transactional
	public List<Persona> checkIfExistEmailOrUser(String email,String username) {
		
		//get current session
				Session currentSession= sessionFactory.getCurrentSession();
				
				//retrive the person with query
				Query<Persona> theQuery = currentSession.createQuery("from Persona where Email =:email OR Username=:user");
				theQuery.setParameter("email", email);
				theQuery.setParameter("user", username);
				try {
				List<Persona> thePerson = theQuery.getResultList();
				return thePerson;
				}
				catch(NoResultException nre) {
					return null;	
				}
	}


	


	

}
