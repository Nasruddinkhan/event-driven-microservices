package com.mypractice.event.driven.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	private final Environment envoirment;
	
	@Autowired
	public ProductController(Environment envoirment) {
		super();
		this.envoirment = envoirment;
	}

	@GetMapping
	public String test() {
		return "test mapping "+envoirment.getProperty("local.server.port");
	}
}
