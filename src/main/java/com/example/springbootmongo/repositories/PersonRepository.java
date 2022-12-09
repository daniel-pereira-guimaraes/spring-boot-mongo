package com.example.springbootmongo.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springbootmongo.entities.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

	List<Person> findByNameContainingIgnoreCase(String text);
	
	@Query("{ $and: [ { birthDate: { $gte: ?0 } }, { birthDate: { $lte: ?1 } } ] }")
	List<Person> findByBirthDate(LocalDate minDate, LocalDate maxDate);
}
