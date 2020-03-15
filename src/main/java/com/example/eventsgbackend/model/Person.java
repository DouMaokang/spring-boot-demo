package com.example.eventsgbackend.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;


/**
 * Represents a Person.
 */
public class Person {

    private UUID id;
    private String firstName;
    private String lastName;

    protected Person() {}

    public Person(
            @JsonProperty("id") UUID id,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
