package com.jm.controller.doc.content;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jm.controller.doc.exeption.NoContentExeption;
import com.jm.doc.dao.DocContentDao;
import com.jm.model.doc.DocContent;


@RestController
public class DocController {
	
	@Autowired
	private DocContentDao docContentDao;
	
	
    // Get content data
    @RequestMapping(value="/doc/content", method=RequestMethod.GET)
    public List<DocContent> displayAllContent() {
        return docContentDao.findAll();
    }
    
    
	@GetMapping(value = "/doc/content/{id}")
	public DocContent displayOneContent(@PathVariable int id) throws NoContentExeption {
		DocContent doccontent = docContentDao.findById(id);
		
		if (doccontent == null) throw new NoContentExeption("Le produit avec l'id" + id + "n'existe pas");
		
		return doccontent;
	}
	

	@PostMapping(value= "/doc/content/post")
	public ResponseEntity<Void> createDocContent(@Validated @RequestBody DocContent docContent) {
		
		//DocContent docCreated = docContentDao.save(docContent);
		DocContent docCreated = docContentDao.save(docContent);
		
		if (docCreated != null) {
			
			URI location = ServletUriComponentsBuilder
					.fromCurrentContextPath()
					.path("/{id}")
					.buildAndExpand(docCreated.getId())
					.toUri();
			return ResponseEntity.created(location).build();
			
		} 
		else {
			
			return ResponseEntity.noContent().build();
			
		}

	}
}
