package com.sarish.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResources {
	@RequestMapping("/")
	public String hello() {
		return "<h1>Hello World</h1>";
	}
	@RequestMapping("/user")
	public String user() {
		return "<h1>Hello World USER</h1>";
	}
	@RequestMapping("/admin")
	public String admin() {
		return "<h1>Hello World ADMIN</h1>";
	}
}