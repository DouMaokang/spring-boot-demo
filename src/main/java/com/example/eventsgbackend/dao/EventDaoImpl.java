package com.example.eventsgbackend.dao;

import com.example.eventsgbackend.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("eventdao")
public class EventDaoImpl implements EventDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EventDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void postEvent(Event event) {
        final String sql = "INSERT INTO event VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                UUID.randomUUID(),
                event.getTitle(),
                event.getDescription(),
                event.getMaxCapacity(),
                event.getNumOfParticipants(),
                event.getOverallRating(),
                event.getAttendanceRate());
    }

    @Override
    public void saveEvent(Event event) {

    }

    @Override
    public void deleteEvent(UUID id) {

    }

    @Override
    public void updateEvent(UUID id, Event event) {

    }

    @Override
    public List<Event> getAllEvent() {
        final String sql = "SELECT * FROM event";

        // retrieve all people in the database;
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            int maxCapacity = resultSet.getInt("maxCapacity");
            int numOfParticipants = resultSet.getInt("numOfParticipants");
            float overallRating = resultSet.getFloat("overallRating");
            float attendanceRate = resultSet.getFloat("attendanceRate");
            return new Event(id, title, description, maxCapacity, numOfParticipants, overallRating, attendanceRate);
        });
    }

    @Override
    public Event getEvent(UUID id) {
        return null;
    }

    @Override
    public List<Event> searchEventByTitle(String keyword) {
        return null;
    }

    @Override
    public List<Event> sortEventByDistance(List<Event> eventList) {
        return null;
    }

    @Override
    public List<Event> sortEventByTime(List<Event> eventList) {
        return null;
    }
}
