package com.iaco2code.springdemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="evento")
public class Evento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idEvento")
	private int idEvento;
	
	@Column(name="Tipo")
	private String tipo;
	
	@Column(name="Orario")
	private String orario;
			
	@Column(name="Luogo")
	private String luogo;
	
	@Column(name="Struttura")
	private String struttura;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="evento_has_persona",
			joinColumns=@JoinColumn(name="idPersona"),
			inverseJoinColumns=@JoinColumn(name="idEvento")
			)	
	private List<Persona> persone;

	
	public Evento() {
		
	}

	public Evento(String tipo, String orario, String luogo, String struttura) {
		this.tipo = tipo;
		this.orario = orario;
		this.luogo = luogo;
		this.struttura = struttura;
	}
	
	
	
	public int getIdEvento() {
		return idEvento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getOrario() {
		return orario;
	}

	public void setOrario(String orario) {
		this.orario = orario;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public String getStruttura() {
		return struttura;
	}

	public void setStruttura(String struttura) {
		this.struttura = struttura;
	}

	public List<Persona> getPersone() {
		return persone;
	}

	public void setPersone(List<Persona> persone) {
		this.persone = persone;
	}
	
	
	public void addPersona(Persona thePerson) {
		
		if (persone == null) {
			persone = new ArrayList<>();
		}
		
		persone.add(thePerson);
	}


	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", tipo=" + tipo + ", orario=" + orario + ", luogo=" + luogo
				+ ", struttura=" + struttura + "]";
	}

	
}	
