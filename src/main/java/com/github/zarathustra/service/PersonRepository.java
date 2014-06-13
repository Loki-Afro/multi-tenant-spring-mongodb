package com.github.zarathustra.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.github.zarathustra.domain.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

}
