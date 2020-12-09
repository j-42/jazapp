package com.jm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "frameworks")
public class Framework {

	// Default constructor
	public Framework() {}
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String name;

	
	
	@ManyToMany
	@JoinTable(
		name= "doc_frameworks",
		joinColumns = @JoinColumn(name = "framework_id"), // Connect to the owner side of the relationship
		inverseJoinColumns = @JoinColumn(name = "doc_content_id")
	)
	Set<DocContent> docContent = new HashSet<>();
	
	
	public Framework(int id, String name) {
		super();
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
