package com.example.springbootmongo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmongo.entities.Person;

@RestController
@RequestMapping(value="persons")
public class PersonController {
	
	@GetMapping
	public ResponseEntity<List<Person>> findAll() {
		Person p1 = new Person(1L, "Emma");
		Person p2 = new Person(2L, "Jhon");
		List<Person> list = Arrays.asList(p1, p2);
		return ResponseEntity.ok(list);
	}

}
