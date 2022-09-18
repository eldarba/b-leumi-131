package app.core.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbacksController {

	@GetMapping("/fallback/serviceA")
	public String fallbackA(Throwable t) {
		return "Gatway Fallback: cant reach A: " + t;
	}

	@GetMapping("/fallback/serviceB")
	public String fallbackB(Throwable t) {
		return "Gatway Fallback: cant reach B: " + t;
	}
}
