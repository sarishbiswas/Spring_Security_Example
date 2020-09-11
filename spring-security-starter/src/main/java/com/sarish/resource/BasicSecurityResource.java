package com.sarish.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicSecurityResource {
	@RequestMapping("/welcome")
	public String getWelcome() {
		return "<h1>WELCOME</h1>";
	}
}
