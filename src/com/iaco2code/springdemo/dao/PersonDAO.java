package com.iaco2code.springdemo.dao;

import java.util.List;

import javax.validation.Valid;

import com.iaco2code.springdemo.entity.Evento;
import com.iaco2code.springdemo.entity.Persona;



public interface PersonDAO {

	public List<Persona> getPersons(String evento);

	public void savePerson(Persona thePerson);

	public Persona checkPerson(String theUserPers, String theUserPass);

	public Persona getPersonsId(int theId);

	public void assocPersEvent(int idPers, int idEvent);

	public void deleteAssocEventPers(Persona idPers,Evento theEvent);

	public List<Persona> checkIfExistEmailOrUser(String email,String username);

	public List<Persona> getPersonsAssocEventId(int idEvento);
}
