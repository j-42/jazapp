package com.jm.controller.content;

import com.jm.dao.*;
import com.jm.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/")
public class getDocRoutes {
	
	@Autowired 
	private FrameworksDao frameworksDao;
	
	@Autowired 
	private OsDao osDao;
	
	@Autowired 
	private LibrariesDao librariesDao;
	
	@Autowired 
	private PermissionsDao permissionsDao;	
	
	@Autowired 
	private LangagesDao langagesDao;	
	
	@Autowired 
	private UsersDao usersDao;	
	
	
	// == Données bruts pour la vue
	@GetMapping(value = "/doc/frameworks/")
    public ResponseEntity<?> getFramework() {
		List<Framework> frameworks = frameworksDao.findAll();
        return ResponseEntity.ok(frameworks);
    }
	
	// == Données bruts pour la vue
	@GetMapping(value = "/doc/os/")
    public ResponseEntity<?> getOs() {
		List<Os> os = osDao.findAll();
        return ResponseEntity.ok(os);
    }

	// == Données bruts pour la vue
	@GetMapping(value = "/doc/libraries/")
    public ResponseEntity<?> getLibraries() {
		List<Library> libraries = librariesDao.findAll();
        return ResponseEntity.ok(libraries);
    }
	
	// == Données bruts pour la vue
	@GetMapping(value = "/doc/permissions/")
    public ResponseEntity<?> getPermission() {
		List<Permission> permissions = permissionsDao.findAll();
        return ResponseEntity.ok(permissions);
    }
	
	// == Données bruts pour la vue
	@GetMapping(value = "/doc/langages/")
    public ResponseEntity<?> getLangages() {
		List<Langage> langages = langagesDao.findAll();
        return ResponseEntity.ok(langages);
    }

	
	// == Données bruts pour la vue
	@GetMapping(value = "/doc/users/")
    public ResponseEntity<?> getUsers() {
		List<User> users = usersDao.findAll();
        return ResponseEntity.ok(users);
    }
	
}


