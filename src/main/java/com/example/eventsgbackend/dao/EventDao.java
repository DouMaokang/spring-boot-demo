package com.example.eventsgbackend.dao;

import com.example.eventsgbackend.model.Event;

import java.util.List;
import java.util.UUID;

public interface EventDao {

    void postEvent(Event event);
    void saveEvent(Event event);
    void deleteEvent(UUID id);
    void updateEvent(UUID id, Event event);
    List<Event> getAllEvent();
    Event getEvent(UUID id);
    List<Event> searchEventByTitle(String keyword); // Can we use existing searching solutions?
    List<Event> sortEventByDistance(List<Event> eventList); // Is it better if we do this in the front end?
    List<Event> sortEventByTime(List<Event> eventList);
    // void addReview(Review);
    // void updateNumOfParticipants();
}
