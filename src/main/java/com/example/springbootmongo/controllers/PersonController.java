package com.example.springbootmongo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmongo.entities.Person;
import com.example.springbootmongo.services.PersonService;

@RestController
@RequestMapping(value="persons")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@GetMapping
	public ResponseEntity<List<Person>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

}
