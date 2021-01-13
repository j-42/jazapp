package com.jm.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
	
	// Default constructor
	public User() {};
	
	@Id
	@GeneratedValue
	private int id;
	
	private String email;
	
	@Column(name="pseudo")
	private String pseudo;
	
	private String name;
	private String surname;
	
	public User(int id, String email, String pseudo, String name, String surname) {
		this.id = id;
		this.email = email;
		this.pseudo = pseudo;
		this.name = name;
		this.surname = surname;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
}	
