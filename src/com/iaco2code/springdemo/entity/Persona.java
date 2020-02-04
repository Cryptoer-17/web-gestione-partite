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
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="persona")
public class Persona {

	// define our fields
	
	// define constructors
	
	// define getter setters
	
	// define tostring
	
	// annotate fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idPersona")
	private int idPersona;
	
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	@Column(name="Nome")
	private String nome;
	
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	@Column(name="Cognome")
	private String cognome;
	
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	@Column(name="Email")
	private String email;
	
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	@Column(name="Username")
	private String username;
	
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	@Column(name="Password")
	private String password;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="evento_has_persona",
			joinColumns=@JoinColumn(name="idPersona"),
			inverseJoinColumns=@JoinColumn(name="idEvento")
			)
	private List<Evento> eventi;
	
	public Persona() {
	
	}

	public Persona(String nome, String cognome, String email,String username,String password) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.username=username;
		this.password=password;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}

	
	
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Evento> getEventi() {
		return eventi;
	}

	// add a convenience method
	public void addEvento(Evento theEvent) {
		
		if (eventi == null) {
			eventi = new ArrayList<>();
		}
		
		eventi.add(theEvent);
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email
				+ ", username=" + username + ", password=" + password + "]";
	}

	
	
	
	
	
}



