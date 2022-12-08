package com.example.springbootmongo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Person> findById(@PathVariable String id) throws Exception {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Person> insert(@RequestBody Person person) {
		return ResponseEntity.ok(service.insert(person));
	}
	

}
