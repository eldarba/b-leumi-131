package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.entities.School;
import app.core.services.SchoolService;

//@CrossOrigin(originPatterns = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/school")
public class SchoolController {

	@Autowired
	private SchoolService service;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public int createSchool(@RequestBody School school) {
		return service.createSchool(school);
	}
	
	@GetMapping("/{id}")
	public School getSchool(@PathVariable int id) {
		try {
			return service.getSchool(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}
	
	

}
