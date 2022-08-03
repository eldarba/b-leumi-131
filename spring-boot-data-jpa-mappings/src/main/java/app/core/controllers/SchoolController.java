package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.School;
import app.core.services.SchoolService;

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
		return service.getSchool(id);
	}
	
	

}
