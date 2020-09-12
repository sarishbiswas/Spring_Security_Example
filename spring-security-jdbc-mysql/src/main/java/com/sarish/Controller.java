package com.sarish;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@RequestMapping("/")
	public String hello() {
		return "Hello World";
	}
	@RequestMapping("/user")
	public String user() {
		return "Hello World USER";
	}
	@RequestMapping("/admin")
	public String admin() {
		return "Hello World ADMIN";
	}
}
