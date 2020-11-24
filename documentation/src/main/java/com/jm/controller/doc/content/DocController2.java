package com.jm.controller.doc.content;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jm.doc.dao.DocContentDao;
import com.jm.model.doc.DocContent;
/*

@RestController
public class DocController2 {
	
	@Autowired
	private DocContentDao docContentDao;
	
	
    // Get content data
    @RequestMapping(value="/doc/content", method=RequestMethod.GET)
    public List<DocContent> displayAllContent() {
        return docContentDao.readAll();
    }
    
    
	@GetMapping(value = "/doc/content/{id}")
	public DocContent displayOneContent(@PathVariable int id) {
		return docContentDao.readById(id);
	}
	

	@PostMapping(value= "/doc/content")
	public ResponseEntity<Void> createDocContent(@RequestBody DocContent docContent) {
		DocContent docCreated = docContentDao.create(docContent);
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
*/