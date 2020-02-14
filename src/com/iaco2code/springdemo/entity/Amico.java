package com.iaco2code.springdemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="amicizia")
public class Amico implements Serializable{

	
	
	@Id
	@ManyToOne
	@JoinColumn(name="idPersona1")
	private Persona idPersona1;
	
	@Id
	@ManyToOne
	@JoinColumn(name="idPersona2")
	private Persona idPersona2;
	
	@Column
	private int Status;
	
	@Column
	private int ActionUserId;

	

	public Amico() {
		
	}

	public Amico(Persona idPersona1, Persona idPersona2, int status, int actionUserId) {
		this.idPersona1 = idPersona1;
		this.idPersona2 = idPersona2;
		Status = status;
		ActionUserId = actionUserId;
	}




	public Persona getIdPersona1() {
		return idPersona1;
	}





	public void setIdPersona1(Persona idPersona1) {
		this.idPersona1 = idPersona1;
	}





	public Persona getIdPersona2() {
		return idPersona2;
	}





	public void setIdPersona2(Persona idPersona2) {
		this.idPersona2 = idPersona2;
	}





	public int getStatus() {
		return Status;
	}





	public void setStatus(int status) {
		Status = status;
	}





	public int getActionUserId() {
		return ActionUserId;
	}





	public void setActionUserId(int actionUserId) {
		ActionUserId = actionUserId;
	}


	
	
	
	
	
	
}
