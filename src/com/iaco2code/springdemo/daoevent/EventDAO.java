package com.iaco2code.springdemo.daoevent;

import java.util.List;

import com.iaco2code.springdemo.entity.Evento;

public interface EventDAO {

	public void saveEvent(Evento theEvent);

	public void deleteEvent(Evento theEvent);

	public Evento getEventId(int idEvent);
	
	public String getTipoEvent(int idEvent);
	
	public List<Evento> getEvent(String evento);
	
	public List<Evento> getEvents();

}
