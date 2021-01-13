package com.jm.controller.content;

import com.jm.controller.exeption.NoContentExeption;
import com.jm.dao.DocContentDao;
import com.jm.model.DocContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class DocController {

	@Autowired
	private DocContentDao docContentDao;

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
/*
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
*/
	// == Données brutes pour la vue
	@GetMapping(value = "/doc/content/")
	public ResponseEntity<List<DocContent>> getDoc() {
		List<DocContent> docContent = docContentDao.findAll();
		System.out.println(docContent);
		return ResponseEntity.ok(docContent);
	}


	@GetMapping(value = "/doc/content/{id}")
	public DocContent displayOneContent(@PathVariable int id) throws NoContentExeption {
		DocContent docContent = docContentDao.findById(id);

		if (docContent == null) throw new NoContentExeption("Le content avec l'id" + id + "n'existe pas");

		return docContent;

	}


/*
	@GetMapping(value = "/doc/content/")
	public ModelAndView displayArticle(Map<String, Object> model) {

	    List<DocContent> doccontent = docContentDao.findAll();
	    model.put("doccontent", doccontent);

	    return new ModelAndView("display_documentation", model);
	}
 	



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
 */
}
