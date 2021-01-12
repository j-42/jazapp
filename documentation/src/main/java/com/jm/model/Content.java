package com.jm.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "doc_content")
public class Content {

	// Default constructor
	public Content(){}

	@Id
	@Column(name="id")
	@GeneratedValue
	private int blabla;

	@ManyToMany
	@JoinTable(
		name= "doc_permissions",
		joinColumns = @JoinColumn(name =  "permission_id"), // Connect to the owner side of the relationship
		inverseJoinColumns = @JoinColumn(name ="doc_content_id")
	)
	Set<Permission> permiblabla = new HashSet<>(); // => https://dzone.com/articles/why-set-is-better-than-list-in-manytomany
// perm id
//	doc content id


	@ManyToMany
	@JoinTable(
		name= "doc_os",
		joinColumns = @JoinColumn(name ="os_id"), // Connect to the owner side of the relationship
		inverseJoinColumns = @JoinColumn(name =  "doc_content_id")
	)
	Set<Os> osblabla = new HashSet<>(); // => https://dzone.com/articles/why-set-is-better-than-list-in-manytomany
// content os
//	os id

	@ManyToMany
	@JoinTable(
		name= "doc_langages",
		joinColumns = @JoinColumn(name = "doc_content_id"), // Connect to the owner side of the relationship
		inverseJoinColumns = @JoinColumn(name =  "langage_id")
	)
	Set<Langage> langagesblabla = new HashSet<>();
	// content id
//	langage id

	@ManyToMany
	@JoinTable(
		name= "doc_frameworks",
		joinColumns = @JoinColumn(name = "framework_id"), // Connect to the owner side of the relationship
		inverseJoinColumns = @JoinColumn(name = "doc_content_id")
	)
	Set<Framework> frameworksblabla = new HashSet<>();
	// framework id
	// content id

	@ManyToMany
	@JoinTable(
		name= "doc_libraries",
		joinColumns = @JoinColumn(name = "doc_content_id"), // Connect to the owner side of the relationship
		inverseJoinColumns = @JoinColumn(name = "library_id")
	)
	Set<Library> librariesblabla = new HashSet<>();
	//content id
	// lib id


	@NotNull
	@Column(name="content")
	private String contentblabla;

	public Content(
			int id, 
			Set<Permission> permission, 
			Set<Os> os, 
			Set<Langage> langages, 
			Set<Framework> frameworks, 
			Set<Library> libraries, 
			String content
			) {
				super();
				this.blabla = id;
				this.permiblabla = permission;
				this.osblabla = os;
				this.langagesblabla = langages;
				this.frameworksblabla = frameworks;
				this.librariesblabla = libraries;
				this.contentblabla = content;
	}
	
	public int getBlabla() {
		return blabla;
	}
	public void setBlabla(int blabla) {
		this.blabla = blabla;
	}
	
	public Set<Os> getOsblabla() {
		return osblabla;
	}
	public void setOsblabla(Set<Os> osblabla) {
		this.osblabla = osblabla;
	}
	
	public Set<Permission> getPermiblabla() {
		return permiblabla;
	}

	public void setPermiblabla(Set<Permission> permiblabla) {
		this.permiblabla = permiblabla;
	}
	
	public Set<Langage> getLangage() {
		return langagesblabla;
	}
	public void setLangage(Set<Langage> langages) {
		this.langagesblabla = langages;
	}
	
	public Set<Framework> getFramework() {
		return frameworksblabla;
	}
	public void setFramework(Set<Framework> frameworks) {
		this.frameworksblabla = frameworks;
	}
	
	public Set<Library> getLibrary() {
		return librariesblabla;
	}
	public void setLibrary(Set<Library> libraries) {
		this.librariesblabla = libraries;
	}
	
	public String getContentblabla() {
		return contentblabla;
	}
	public void setContentblabla(String contentblabla) {
		this.contentblabla = contentblabla;
	}

	
	
}
