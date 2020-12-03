package com.jm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;



@Entity
@Table(name = "doc_content")
public class DocContent {	
	
	// Default constructor
	public DocContent(){}
	
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min = 3, max = 15)
	private String permissions;
	private String os;
	
	@NotNull
	private String langage;
	private String framework;
	private String library;
	private String content;
	
	public DocContent(int id, String permissions, String os, String langage, String framework, String library, String content) {
		super();
		this.id = id;
		this.permissions = permissions;
		this.os = os;
		this.langage = langage;
		this.framework = framework;
		this.library = library;
		this.content = content;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	
	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	
	public String getLangage() {
		return langage;
	}
	public void setLangage(String langage) {
		this.langage = langage;
	}
	
	public String getFramework() {
		return framework;
	}
	public void setFramework(String framework) {
		this.framework = framework;
	}
	
	public String getLibrary() {
		return library;
	}
	public void setLibrary(String library) {
		this.library = library;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	
	
}
