package com.iaco2code.springdemo.dao;

import java.util.List;

import com.iaco2code.springdemo.entity.Evento;
import com.iaco2code.springdemo.entity.Persona;



public interface PersonDAO {

	public List<Persona> getPersons(String evento);

	public List<Evento> getEvent(String evento);

	public List<Evento> getEvents();

	public void savePerson(Persona thePerson);

	public Persona checkPerson(String theUserPers, String theUserPass);

	public Persona getPersonsId(int theId);

	public void assocPersEvent(int idPers, int idEvent);

	public Evento getEventId(int idEvent);

	public String getTipoEvent(int idEvent);

	
}
