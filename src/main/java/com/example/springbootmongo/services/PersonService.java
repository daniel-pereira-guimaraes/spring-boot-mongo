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

	public Person findById(String id) throws NotFoundException {
		return repository.findById(id).orElseThrow(
			() -> new NotFoundException(Messages.get(Messages.PERSON_NOT_FOUND), id));
	}
	
	public List<Person> findAll() {
		return repository.findAll();
	}

	public Person insert(Person person) {
		return repository.insert(person);
	}

	public Person update(Person person) {
		Person p = findById(person.getId());
		p.setName(person.getName());
		return repository.save(p);
	}
	
	public void delete(String id) throws NotFoundException {
		repository.delete(findById(id));
	}

}
