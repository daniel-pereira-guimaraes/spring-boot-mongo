package com.example.springbootmongo.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springbootmongo.entities.Person;
import com.example.springbootmongo.services.PersonService;

@RestController
@RequestMapping(value = "persons")
public class PersonController {

	@Autowired
	private PersonService service;

	@GetMapping
	public ResponseEntity<List<Person>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Person> findById(@PathVariable String id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@GetMapping("/byname")
	public ResponseEntity<List<Person>> findByName(@RequestParam(value = "name") String name) throws UnsupportedEncodingException {
		return ResponseEntity.ok(service.findByName(URLDecoder.decode(name, "UTF-8")));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Person person) {
		person = service.insert(person);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(person.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping
	public ResponseEntity<Void> update(@RequestBody Person person) {
		service.update(person);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
