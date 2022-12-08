package com.example.springbootmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootmongo.Messages;
import com.example.springbootmongo.entities.Person;
import com.example.springbootmongo.exceptions.NotFoundException;
import com.example.springbootmongo.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;

	public Person insert(Person person) {
		return repository.insert(person);
	}
	
	public Person findById(String id) throws Exception {
		return repository.findById(id).orElseThrow(
			() -> new NotFoundException(Messages.get(Messages.PERSON_NOT_FOUND), id));
	}
	
	public List<Person> findAll() {
		return repository.findAll();
	}

}
