package com.test.oauth2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/success") 
	public String HelloWorld() {
		return "Hello World, this is success page";
	}
	
	@GetMapping("/test")
	public String restricted() {
		return "this is without auth test page!";
	}

}
