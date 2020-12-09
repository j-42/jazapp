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
@Table(name = "doc_content")
public class DocContent {	
	
	// Default constructor
	public DocContent(){}
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToMany
	@JoinTable(
		name= "doc_permissions",
		joinColumns = @JoinColumn(name = "doc_content_id"), // Connect to the owner side of the relationship
		inverseJoinColumns = @JoinColumn(name = "permission_id")
	)
	Set<Permission> permission = new HashSet<>(); // => https://dzone.com/articles/why-set-is-better-than-list-in-manytomany
	
	@ManyToMany
	@JoinTable(
		name= "doc_os",
		joinColumns = @JoinColumn(name = "doc_content_id"), // Connect to the owner side of the relationship
		inverseJoinColumns = @JoinColumn(name = "os_id")
	)
	Set<Os> os = new HashSet<>(); // => https://dzone.com/articles/why-set-is-better-than-list-in-manytomany
	
	@ManyToMany
	@JoinTable(
		name= "doc_langages",
		joinColumns = @JoinColumn(name = "doc_content_id"), // Connect to the owner side of the relationship
		inverseJoinColumns = @JoinColumn(name = "langage_id")
	)
	Set<Langage> langages  = new HashSet<>();
	
	@ManyToMany
	@JoinTable(
		name= "doc_frameworks",
		joinColumns = @JoinColumn(name = "doc_content_id"), // Connect to the owner side of the relationship
		inverseJoinColumns = @JoinColumn(name = "framework_id")
	)
	Set<Framework> frameworks = new HashSet<>();
	
	@ManyToMany
	@JoinTable(
		name= "doc_libraries",
		joinColumns = @JoinColumn(name = "doc_content_id"), // Connect to the owner side of the relationship
		inverseJoinColumns = @JoinColumn(name = "library_id")
	)
	Set<Library> libraries = new HashSet<>();

	@NotNull
	private String content;
	
	public DocContent(
			int id, 
			Set<Permission> permission, 
			Set<Os> os, 
			Set<Langage> langages, 
			Set<Framework> frameworks, 
			Set<Library> libraries, 
			String content
			) {
				super();
				this.id = id;
				this.permission = permission;
				this.os = os;
				this.langages = langages;
				this.frameworks = frameworks;
				this.libraries = libraries;
				this.content = content;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Set<Os> getOs() {
		return os;
	}
	public void setOs(Set<Os> os) {
		this.os = os;
	}
	
	public Set<Permission> getPermission() {
		return permission;
	}

	public void setPermission(Set<Permission> permission) {
		this.permission = permission;
	}
	
	public Set<Langage> getLangage() {
		return langages;
	}
	public void setLangage(Set<Langage> langages) {
		this.langages = langages;
	}
	
	public Set<Framework> getFramework() {
		return frameworks;
	}
	public void setFramework(Set<Framework> frameworks) {
		this.frameworks = frameworks;
	}
	
	public Set<Library> getLibrary() {
		return libraries;
	}
	public void setLibrary(Set<Library> libraries) {
		this.libraries = libraries;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
	
}
