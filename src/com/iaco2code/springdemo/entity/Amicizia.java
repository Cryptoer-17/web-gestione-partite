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
public class Amicizia implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn
	private int idPersona1;
	
	@Id
	@Column
	private int idPersona2;
	
	@Column(name="Status")
	private int status;
	
	@Column(name="ActionUserId")
	private int action_user_id;

	public Amicizia(int idPersona1, int idPersona2, int status, int action_user_id) {
		this.idPersona1 = idPersona1;
		this.idPersona2 = idPersona2;
		this.status = status;
		this.action_user_id = action_user_id;
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
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAction_user_id() {
		return action_user_id;
	}

	public void setAction_user_id(int action_user_id) {
		this.action_user_id = action_user_id;
	}
	
	
	
	
	
}
