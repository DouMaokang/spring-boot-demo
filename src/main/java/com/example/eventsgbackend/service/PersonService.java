package com.example.eventsgbackend.service;

import com.example.eventsgbackend.dao.PersonDao;
import com.example.eventsgbackend.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int countPerson() {
        return personDao.count();
    }

    public void addPerson(Person person) {
        personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.getAllPeople();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDao.getPersonById(id);
    }

    public void updatePersonById(UUID id, Person person) {
        personDao.updatePersonById(id, person);
    }

    public void deletePersonById(UUID id) {
        personDao.deletePersonById(id);
    }

}
