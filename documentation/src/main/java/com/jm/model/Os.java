package com.jm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "os")
public class Os {

	// Default constructor
	public Os(){}
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;

//	@ManyToMany(mappedBy = "w")
//	Set<DocContent> docContent;
	
	public Os(int id, String name) {
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
