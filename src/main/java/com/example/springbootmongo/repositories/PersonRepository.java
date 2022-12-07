package com.example.springbootmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootmongo.entities.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, Long> {

}
