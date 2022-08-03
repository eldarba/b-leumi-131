package app.core.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

	// http://localhost:8080/greet/Eldar
	@GetMapping("/greet/{user}")
	public String greet1(@PathVariable String user) {
		return "hello " + user;
	}

	// http://localhost:8080/greet?user=Eldar
	@GetMapping("/greet")
	public String greet2(@RequestParam String user) {
		return "hello " + user;
	}

}
