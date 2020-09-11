package com.sarish.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicSecurityResource {
	//Accessible by Everyone
	@GetMapping("/")
	public String getWelcome() {
		return "<h1>WELCOME</h1>";
	}
	
	//Accessible By only Logged In User . here Admin and User.
	@GetMapping("/user")
	public String user() {
		return "<h1>WELCOME USER</h1>";
	}
	//Only Accessible by Admin
	@GetMapping("/admin")
	public String admin() {
		return "<h1>WELCOME Admin</h1>";
	}
}
