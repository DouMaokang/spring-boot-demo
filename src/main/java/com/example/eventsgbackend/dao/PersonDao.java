package com.example.eventsgbackend.dao;

import com.example.eventsgbackend.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int count();

    void insertPerson(UUID id, Person person);

    default void insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        insertPerson(id, person);
    }

    List<Person> getAllPeople();

    Optional<Person> getPersonById(UUID id);

    int updatePersonById(UUID id, Person person);

    int deletePersonById(UUID id);



}
