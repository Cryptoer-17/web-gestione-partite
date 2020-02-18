package com.iaco2code.springdemo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iaco2code.springdemo.entity.Amico;
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
		Query<Persona> theQuery = currentSession.createQuery("from Persona where Username = binary('"+theUserPers+"') AND Password = binary('"+theUserPass+"')");
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
				Query<Persona> theQuery = currentSession.createQuery("from Persona where Email = binary('"+email+"') OR Username=binary('"+username+"')");
				try {
				List<Persona> thePerson = theQuery.getResultList();
				return thePerson;
				}
				catch(NoResultException nre) {
					return null;	
				}
	}
	@Override
	@Transactional
	public List<Persona> getPersonsAssocEventId(int idEvento) {
		//get the current hibernate session
				Session currentSession= sessionFactory.getCurrentSession();
				
				//create query
				Query<Persona> theQuery = currentSession.createQuery("select p from Persona p join p.eventi e where e.idEvento='"+idEvento+"'",Persona.class);
				
				//execute query and get result list 
				List<Persona> persone = theQuery.getResultList();

				//return the result
				return persone;
	}
	
	@Override
	@Transactional
	public List<Persona> getAllPerson() {	
		//get the current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		//create query
		Query<Persona> theQuery = currentSession.createQuery("from Persona");
		
		//execute query and get result list 
		List<Persona> persone = theQuery.getResultList();

		//return the result
		return persone;
	}
	@Override
	@Transactional
	public boolean checkifPersonIsAssoc(int idPers, int idEvent) {
		//get the current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		
		//create query
		Query<Persona> theQuery = currentSession.createQuery("select p from Persona p join p.eventi e where e.idEvento='"+idEvent+"' AND p.idPersona='"+idPers+"'",Persona.class);
		
		//execute query and get result list 
		List<Persona> persone = theQuery.getResultList();
				
		if(persone.isEmpty())
			return false;
		else return true;
	}
	
	@Override
	@Transactional
	public List<Persona> getPersonSendRequest(int idCurrentPers) {
		//get current session
		Session currentSession= sessionFactory.getCurrentSession();				
		//retrive the person with query
		Query<Amico> theQuery = currentSession.createQuery("from Amico where (idPersona2="+idCurrentPers+" or idPersona1="+idCurrentPers+") AND (Status=1 or Status=3 or Status=0)");
		try {
		List<Amico> thePerson = theQuery.getResultList();
		List <Integer> viewIdListPers= new ArrayList<Integer>();
		if(!thePerson.isEmpty()) {
		for(Amico tempAmi : thePerson) {
			if(tempAmi.getIdPersona1().getIdPersona()==idCurrentPers) {
				viewIdListPers.add(tempAmi.getIdPersona2().getIdPersona());
			}
			else viewIdListPers.add(tempAmi.getIdPersona1().getIdPersona());
		}
		Query<Persona> theQuery2 = currentSession.createQuery("from Persona p where p.idPersona not in (:ids) AND p.idPersona!='"+idCurrentPers+"'").setParameterList("ids", viewIdListPers);
		List<Persona> thePersonList = theQuery2.getResultList();
		return thePersonList;
		}
		else {
			Query<Persona> theQuery3 = currentSession.createQuery("from Persona where idPersona != '"+idCurrentPers+"'");
			List<Persona> thePersonList2 = theQuery3.getResultList();
			return thePersonList2;
		} 
	
		}
		catch(NoResultException nre) {
			return null;	
		}
	}

	
	@Override
	@Transactional
	public void saveAmico(Amico theAmico) {
		//get current session
		Session currentSession= sessionFactory.getCurrentSession();		
		//save the person finally LOL
		currentSession.saveOrUpdate(theAmico);	
		
	}
	
	@Override
	@Transactional
	public List<Persona> getProvaPersone(int idPersona) {
		//get current session
				Session currentSession= sessionFactory.getCurrentSession();				
				//retrive the person with query
				Query<Persona> theQuery = currentSession.createQuery("from Persona where idPersona!="+idPersona+"");
				try {
				List<Persona> thePerson = theQuery.getResultList();
				return thePerson;
				}
				catch(NoResultException nre) {
					return null;	
				}
	}
	
	@Override
	@Transactional
	public List<Persona> getAttempList(int idCurrentPers) {
		//get current session
		Session currentSession= sessionFactory.getCurrentSession();				
		//retrive the person with query
		Query<Amico> theQuery = currentSession.createQuery("from Amico where idPersona2='"+idCurrentPers+"' AND Status=0");
		try {
		List<Amico> thePerson = theQuery.getResultList();
		List <Integer> viewIdListPers= new ArrayList<Integer>();
		for(Amico tempAmi : thePerson) {
			if(tempAmi.getIdPersona2().getIdPersona()==idCurrentPers) {
				viewIdListPers.add(tempAmi.getIdPersona1().getIdPersona());
			}
		}
		Query<Persona> theQuery2 = currentSession.createQuery("from Persona p where p.idPersona in (:ids) AND p.idPersona!='"+idCurrentPers+"'").setParameterList("ids", viewIdListPers);
		List<Persona> thePersonList = theQuery2.getResultList();
		return thePersonList;
		}
		catch(NoResultException nre) {
			return null;	
		}
	}
	
    @Override
	@Transactional
	public int getLastIdNotify(int idPersona) {
		Session currentSession= sessionFactory.getCurrentSession();				
		//retrive the person with query
		Query<Amico> theQuery = currentSession.createQuery("from Amico where idPersona1='"+idPersona+"' AND Status=0");
		try {
		List<Amico> thePerson = theQuery.getResultList();
		int i = 0;
		for(Amico tempAmi : thePerson) {
				i++;
		}
		return i;
		}
		catch(NoResultException nre) {
			return 0;	
		}	
	}
    
	@Override
	@Transactional
	public List<Amico> tempListDaAccett(int theId1) {
		Session currentSession= sessionFactory.getCurrentSession();				
		//retrive the person with query
		Query<Amico> theQuery = currentSession.createQuery("from Amico where idPersona1='"+theId1+"' AND Status=0");
		try {
		List<Amico> thePerson = theQuery.getResultList();
		return thePerson;
		}
		catch(NoResultException nre) {
			return null;	
		}	
	}
	
	@Override
	@Transactional
	public int countAllPersonAccept(int theId1) {
		//get current session
				Session currentSession= sessionFactory.getCurrentSession();				
				//retrive the person with query
				Query<Amico> theQuery = currentSession.createQuery("from Amico where idPersona2='"+theId1+"' AND Status=0");
				try {
				List<Amico> thePerson = theQuery.getResultList();
				int i = 0;
				for(Amico tempAmi : thePerson) {
					i++;
				}
				return i;
				}
				catch(NoResultException nre) {
					return 0;	
				}
	}
	
	@Override
	@Transactional
	public List<Amico> getPersonsBlock(int idPersona) {
		Session currentSession= sessionFactory.getCurrentSession();				
		//retrive the person with query
		Query<Amico> theQuery = currentSession.createQuery("from Amico where ActionUserId='"+idPersona+"' AND Status=3");
		try {
		List<Amico> thePerson = theQuery.getResultList();
		return thePerson;
		}
		catch(NoResultException nre) {
			return null;	
		}	
	}
	
	@Override
	@Transactional
	public void removeAmico(Amico theAmi) {
		Session currentSession= sessionFactory.getCurrentSession();				
		//remove the amis on table
		currentSession.remove(theAmi);
	}
	
	@Override
	@Transactional
	public Amico checkifAmisExist(int theId1, int theId2) {
		Session currentSession= sessionFactory.getCurrentSession();				
		//retrive the person with query
		Query<Amico> theQuery = currentSession.createQuery("from Amico where idPersona1='"+theId1+"' AND idPersona2 ='"+theId2+"'");
		try {
		Amico thePerson = theQuery.getSingleResult();
		return thePerson;
		}
		catch(NoResultException nre) {
			return null;	
		}	
	}
	
	@Override
	@Transactional
	public List<Persona> getListFriend(int idPersona) {
		Session currentSession= sessionFactory.getCurrentSession();				
		//retrive the person with query
		Query<Amico> theQuery = currentSession.createQuery("from Amico where (idPersona1='"+idPersona+"' or idPersona2='"+idPersona+"') AND Status=1");
		try {
		List<Amico> thePerson = theQuery.getResultList();
		List <Integer> viewIdListPers= new ArrayList<Integer>();
		for(Amico tempAmi : thePerson) {
			if(tempAmi.getIdPersona2().getIdPersona()==idPersona) {
				viewIdListPers.add(tempAmi.getIdPersona1().getIdPersona());
			}
			else {
				viewIdListPers.add(tempAmi.getIdPersona2().getIdPersona());
			}
		}
		Query<Persona> theQuery2 = currentSession.createQuery("from Persona p where p.idPersona in (:ids) AND p.idPersona!='"+idPersona+"'").setParameterList("ids", viewIdListPers);
		List<Persona> thePersonList = theQuery2.getResultList();
		return thePersonList;
		}
		catch(NoResultException nre) {
			return null;	
		}	
	}
	
	



	


	

}
