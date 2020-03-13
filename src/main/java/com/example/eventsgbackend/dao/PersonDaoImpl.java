package com.example.eventsgbackend.dao;

import com.example.eventsgbackend.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDaoImpl implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int count() {
        final String sql = "SELECT COUNT(*) FROM person";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public void insertPerson(UUID id, Person person) {
        // add a person into database;
        final String sql = "INSERT INTO person VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, id, person.getFirstName(), person.getLastName());
    }

    @Override
    public List<Person> getAllPeople() {
        final String sql = "SELECT id, firstName, lastName FROM person";

        // retrieve all people in the database;
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            return new Person(id, firstName, lastName);
        });
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        final String sql = "SELECT * FROM person WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (result, rowNum) -> (
                Optional.of(new Person(UUID.fromString(result.getString("id")),
                        result.getString("firstName"),
                        result.getString("lastName")))
        ));
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        // update person in the database;
        final String sql = "UPDATE person SET firstName = ?, lastName = ? WHERE id = ?";
        return jdbcTemplate.update(sql, person.getFirstName(), person.getLastName(), id);
    }

    @Override
    public int deletePersonById(UUID id) {
        // delete the person in the database
        final String sql = "DELETE FROM person WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

}
