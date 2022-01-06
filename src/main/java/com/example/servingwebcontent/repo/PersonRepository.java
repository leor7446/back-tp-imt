package com.example.servingwebcontent.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.servingwebcontent.clas.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
	List<Person> findByName(String lastName);

	Person findById(int id);

	List<Person> findAll();

}