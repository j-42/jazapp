package com.jm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="permissions")
public class Permission {
	
	// Default constructor
	public Permission() {}
	
	@Id
	@GeneratedValue
	private int id ;
	
	private String name;

	public Permission(int id, String name) {
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
