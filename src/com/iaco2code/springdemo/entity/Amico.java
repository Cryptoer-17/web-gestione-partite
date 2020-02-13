package com.iaco2code.springdemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="amicizia")
public class Amico implements Serializable{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int idAmicizia;
	
	@Column
	private int idPersona1;
	
	@Column
	private int idPersona2;
	
	@Column
	private int Status;
	
	@Column(name="ActionUserId")
	private int ActionUserId;

	
	@ManyToOne
	private Persona persona;
	
	
	public Amico() {
		
	}


	
	public Amico(int idAmicizia, int idPersona1, int idPersona2, int status, int actionUserId) {
		this.idAmicizia = idAmicizia;
		this.idPersona1 = idPersona1;
		this.idPersona2 = idPersona2;
		Status = status;
		ActionUserId = actionUserId;
	}


	public int getIdPersona1() {
		return idPersona1;
	}

	public void setIdPersona1(int idPersona1) {
		this.idPersona1 = idPersona1;
	}

	public int getIdPersona2() {
		return idPersona2;
	}

	public void setIdPersona2(int idPersona2) {
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
