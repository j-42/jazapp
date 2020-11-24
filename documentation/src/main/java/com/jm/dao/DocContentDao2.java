package com.jm.dao;

import java.util.List;

import com.jm.model.DocContent;

public interface DocContentDao2 {
	public List<DocContent> readAll();

	public DocContent readById(int id);
	
	public DocContent create(DocContent docContent);
	
	public DocContent update(DocContent docContent);
	
	public DocContent delete();
}
