package com.jm.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name = "doc_content")
@JsonPropertyOrder(value= {"id","permission","os","langages","frameworks","libraries","content"}, alphabetic= false)
public class DocContent {	
	
	// Default constructor
	public DocContent(){}
	
	@Id
	@JsonProperty("id")
	@GeneratedValue
	private int id;
	
	@ManyToMany
	@JsonProperty("permission")
	@JoinTable(
		name= "doc_permissions",
		joinColumns = @JoinColumn(name = "doc_content_id"), // Connect to the owner side of the relationship
		inverseJoinColumns = @JoinColumn(name = "permission_id")
	)
	Set<Permission> permission = new HashSet<>(); // => https://dzone.com/articles/why-set-is-better-than-list-in-manytomany
	
	@ManyToMany
	@JsonProperty("os")
	@JoinTable(
		name= "doc_os",
		joinColumns = @JoinColumn(name = "doc_content_id"), // Connect to the owner side of the relationship
		inverseJoinColumns = @JoinColumn(name = "os_id")
	)
	Set<Os> os = new HashSet<>(); // => https://dzone.com/articles/why-set-is-better-than-list-in-manytomany
	
	@ManyToMany
	@JsonProperty("langages")
	@JoinTable(
		name= "doc_langages",
		joinColumns = @JoinColumn(name = "doc_content_id"), // Connect to the owner side of the relationship
		inverseJoinColumns = @JoinColumn(name = "langage_id")
	)
	Set<Langage> langages  = new HashSet<>();
	
	@ManyToMany
	@JsonProperty("frameworks")
	@JoinTable(
		name= "doc_frameworks",
		joinColumns = @JoinColumn(name = "doc_content_id"), // Connect to the owner side of the relationship
		inverseJoinColumns = @JoinColumn(name = "framework_id")
	)
	Set<Framework> frameworks = new HashSet<>();
	
	@ManyToMany
	@JsonProperty("libraries")
	@JoinTable(
		name= "doc_libraries",
		joinColumns = @JoinColumn(name = "doc_content_id"), // Connect to the owner side of the relationship
		inverseJoinColumns = @JoinColumn(name = "library_id")
	)
	Set<Library> libraries = new HashSet<>();

	@NotNull
	@JsonProperty("content")
	@Column(name="content")
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

	@JsonGetter
	public int getId() {
		return id;
	}

	@JsonSetter
	public void setId(int id) {
		this.id = id;
	}

	@JsonGetter
	public Set<Os> getOs() {
		return os;
	}

	@JsonSetter
	public void setOs(Set<Os> os) {
		this.os = os;
	}

	@JsonGetter
	public Set<Permission> getPermission() {
		return permission;
	}

	@JsonSetter
	public void setPermission(Set<Permission> permission) {
		this.permission = permission;
	}

	@JsonGetter
	public Set<Langage> getLangage() {
		return langages;
	}

	@JsonSetter
	public void setLangage(Set<Langage> langages) {
		this.langages = langages;
	}

	@JsonGetter
	public Set<Framework> getFramework() {
		return frameworks;
	}

	@JsonSetter
	public void setFramework(Set<Framework> frameworks) {
		this.frameworks = frameworks;
	}

	@JsonGetter
	public Set<Library> getLibrary() {
		return libraries;
	}

	@JsonSetter
	public void setLibrary(Set<Library> libraries) {
		this.libraries = libraries;
	}

	@JsonGetter
	public String getContent() {
		return content;
	}

	@JsonSetter
	public void setContent(String content) {
		this.content = content;
	}

	
	
}
