package com.jm.dao;

import com.jm.model.Content2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentDao2 extends JpaRepository<Content2, Integer> {
	
	
	Content2 findById(int id);
	
	
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