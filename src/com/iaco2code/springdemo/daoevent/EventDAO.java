package com.iaco2code.springdemo.daoevent;

import com.iaco2code.springdemo.entity.Evento;

public interface EventDAO {

	void saveEvent(Evento theEvent);

	void deleteEvent(Evento theEvent);

	Evento getEventId(int idEvent);
	
	String getTipoEvent(int idEvent);
}
