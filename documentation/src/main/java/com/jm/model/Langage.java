package com.jm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="langages")
public class Langage {
	
	// Default constructor
	public Langage(){}
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;

	
	public Langage(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
}
