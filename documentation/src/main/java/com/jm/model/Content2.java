package com.jm.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "doc_content")
public class Content2 {

	// Default constructor
	public Content2(){}

	@Id
	@Column(name="id")
	@GeneratedValue
	private int blabla2;

	@ManyToMany
	@JoinTable(
		name= "doc_permissions",
		joinColumns = @JoinColumn(name =  "permission_id"), // Connect to the owner side of the relationship
		inverseJoinColumns = @JoinColumn(name ="doc_content_id")
	)
	Set<Permission> permiblabla2 = new HashSet<>(); // => https://dzone.com/articles/why-set-is-better-than-list-in-manytomany
// perm id
//	doc content id


	@ManyToMany
	@JoinTable(
		name= "doc_os",
		joinColumns = @JoinColumn(name = "doc_content_id"), // Connect to the owner side of the relationship
		inverseJoinColumns = @JoinColumn(name = "os_id")
	)
	Set<Os> osblabla2 = new HashSet<>(); // => https://dzone.com/articles/why-set-is-better-than-list-in-manytomany
// content os
//	os id

	@ManyToMany
	@JoinTable(
		name= "doc_langages",
		joinColumns = @JoinColumn(name = "doc_content_id"), // Connect to the owner side of the relationship
		inverseJoinColumns = @JoinColumn(name =  "langage_id")
	)
	Set<Langage> langagesblabla2 = new HashSet<>();
	// content id
//	langage id

	@ManyToMany
	@JoinTable(
		name= "doc_frameworks",
		joinColumns = @JoinColumn(name = "framework_id"), // Connect to the owner side of the relationship
		inverseJoinColumns = @JoinColumn(name = "doc_content_id")
	)
	Set<Framework> frameworksblabla2 = new HashSet<>();
	// framework id
	// content id

	@ManyToMany
	@JoinTable(
		name= "doc_libraries",
		joinColumns = @JoinColumn(name = "doc_content_id"), // Connect to the owner side of the relationship
		inverseJoinColumns = @JoinColumn(name = "library_id")
	)
	Set<Library> librariesblabla2 = new HashSet<>();
	//content id
	// lib id


	@NotNull
	@Column(name="content")
	private String contentblabla2;

	public Content2(
			int id, 
			Set<Permission> permission, 
			Set<Os> os, 
			Set<Langage> langages, 
			Set<Framework> frameworks, 
			Set<Library> libraries, 
			String content
			) {
				super();
				this.blabla2 = id;
				this.permiblabla2 = permission;
				this.osblabla2 = os;
				this.langagesblabla2 = langages;
				this.frameworksblabla2 = frameworks;
				this.librariesblabla2 = libraries;
				this.contentblabla2 = content;
	}
	
	public int getBlabla() {
		return blabla2;
	}
	public void setBlabla(int blabla) {
		this.blabla2 = blabla;
	}
	
	public Set<Os> getOsblabla() {
		return osblabla2;
	}
	public void setOsblabla(Set<Os> osblabla) {
		this.osblabla2 = osblabla;
	}
	
	public Set<Permission> getPermiblabla() {
		return permiblabla2;
	}

	public void setPermiblabla(Set<Permission> permiblabla) {
		this.permiblabla2 = permiblabla;
	}
	
	public Set<Langage> getLangage() {
		return langagesblabla2;
	}
	public void setLangage(Set<Langage> langages) {
		this.langagesblabla2 = langages;
	}
	
	public Set<Framework> getFramework() {
		return frameworksblabla2;
	}
	public void setFramework(Set<Framework> frameworks) {
		this.frameworksblabla2 = frameworks;
	}
	
	public Set<Library> getLibrary() {
		return librariesblabla2;
	}
	public void setLibrary(Set<Library> libraries) {
		this.librariesblabla2 = libraries;
	}
	
	public String getContentblabla() {
		return contentblabla2;
	}
	public void setContentblabla(String contentblabla) {
		this.contentblabla2 = contentblabla;
	}

	
	
}
