package com.sarish;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
	@RequestMapping("/")
	public String getHello() {
		return "<h1>Hello Wolrd.</h1>";
	}
}
