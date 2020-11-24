package com.jm.model.doc;

public class DocContent2 {	
	
	private int id;
	private String os;
	private String langage;
	private String framework;
	private String library;
	private String content;
	
	public DocContent2(int id, String os, String langage, String framework, String library, String content) {
		super();
		this.id = id;
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
