package com.jm.controller.content;

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
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jm.controller.exeption.NoContentExeption;
import com.jm.dao.DocContentDao;
import com.jm.dao.ContentDao;
import com.jm.dao.ContentDao2;
import com.jm.model.DocContent;
import com.jm.model.Content;
import com.jm.model.Content2;

@RestController
@RequestMapping("/api/")
public class DocController {
	
	@Autowired
	private DocContentDao docContentDao;

	@Autowired
	private ContentDao contentDao;

	@Autowired
	private ContentDao2 contentDao2;

	/*
    // Get content data
    @RequestMapping(value="/doc/content", method=RequestMethod.GET)
    public List<DocContent> displayAllContent() {
        
        return docContentDao.findAll();
    }
    */
  
	/* == Permet de récuperer les données dans un template 
	@RequestMapping(value="/doc/content", method=RequestMethod.GET)
    public String display_documentation(Model model) {

		String content = "hello I'm a content";
        model.addAttribute("content", content);
        
        return "display_documentation";
    }
	*/
	
	
	// == Données brutes pour la vue
	@GetMapping(value = "/doc/content/")
    public ResponseEntity<?> getDoc() {
		List<DocContent> doccontent = docContentDao.findAll();
		System.out.println(doccontent);
		System.out.println("toto");
        return ResponseEntity.ok(doccontent);
    }



	// == Données brutes pour la vue
	@GetMapping(value = "/doc/content1/")
	public ResponseEntity<?> getDoc1() {
		List<Content> content = contentDao.findAll();
		System.out.println(content);
		return ResponseEntity.ok(content);
	}

	// == Données brutes pour la vue
	@GetMapping(value = "/doc/2/")
	public ResponseEntity<?> getDoc2() {
		List<Content2> content2 = contentDao2.findAll();
		System.out.println(content2);
		return ResponseEntity.ok(content2);
	}



/*
	@GetMapping(value = "/doc/content/")
	public ModelAndView displayArticle(Map<String, Object> model) {

	    List<DocContent> doccontent = docContentDao.findAll();
	    model.put("doccontent", doccontent);

	    return new ModelAndView("display_documentation", model);
	}
 	
 */
	
    
	@GetMapping(value = "/doc/content/{id}")
	public DocContent displayOneContent(@PathVariable int id) throws NoContentExeption {
		DocContent doccontent = docContentDao.findById(id);
		
		if (doccontent == null) throw new NoContentExeption("Le content avec l'id" + id + "n'existe pas");
		
		return doccontent;
		
	}
	

	@PostMapping(value= "/doc/content/post/")
	public ResponseEntity<Void> createDocContent(@Validated @RequestBody DocContent docContent) {
		
		// DocContent docCreated = docContentDao.save(docContent);
		
		
		 DocContent docCreated = docContentDao.save(docContent);


		if (docCreated != null) {
			System.out.print("ok");
			URI location = ServletUriComponentsBuilder
					.fromCurrentContextPath()
					.path("/{id}")
					.buildAndExpand(docCreated.getId())
					.toUri();
			return ResponseEntity.created(location).build();
			
		} 
		else {
			System.out.print("probleme");
			return ResponseEntity.noContent().build();
			
		}

	}
	
}
