package app.core.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {
	
	// http://localhost:8080/greet
	@RequestMapping(method = RequestMethod.GET, path = "/greet")
	public String greet() {
		return "hello user";
	}

}
