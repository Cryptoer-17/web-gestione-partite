package com.iaco2code.springdemo.dao;

import java.util.List;

import javax.validation.Valid;

import com.iaco2code.springdemo.entity.Amico;
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

	public List<Persona> getAllPerson();

	public boolean checkifPersonIsAssoc(int idPers, int idEvent);

	public List<Persona> getPersonSendRequest(int idCurrentPers);
	
	public void saveAmico(Amico theAmico);

	public List<Persona> getProvaPersone(int idPersona);

	public List<Persona> getAttempList(int idPersona);

	public int getLastIdNotify(int idPersona);

	public List<Amico> tempListDaAccett(int theId1);

	public int countAllPersonAccept(int theId1);

	public List<Amico> getPersonsBlock(int idPersona);

	public void removeAmico(Amico theAmi);

	
}
