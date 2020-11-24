package com.jm.doc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jm.model.doc.DocContent;

@Repository
public interface DocContentDao extends JpaRepository<DocContent, Integer> { 
	
	
	DocContent findById(int id);
	
	
	/*
	@Query("SELECT id, nom, prix FROM Product p WHERE p.prix > :prixLimit")
	   List<DocContent>  chercherUnProduitCher(@Param("prixLimit") int prix); 
	
	
	public List<DocContent> readAll();

	public DocContent readById(int id);
	
	public DocContent create(DocContent docContent);
	
	public DocContent update(DocContent docContent);
	
	public DocContent delete();
*/
}