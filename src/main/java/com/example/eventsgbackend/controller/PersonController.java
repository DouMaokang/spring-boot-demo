package com.example.eventsgbackend.controller;

import com.example.eventsgbackend.model.Person;
import com.example.eventsgbackend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired // It injects the actual service into the constructor
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public int countPerson () {
        return personService.countPerson();
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople () {
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Optional<Person> getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id) ;
    }

    @PutMapping(path = "{id}")
    public void updatePersonById(@PathVariable("id") UUID id,
                                 @RequestBody Person person) {
        personService.updatePersonById(id, person);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePersonById(id);
    }
}
