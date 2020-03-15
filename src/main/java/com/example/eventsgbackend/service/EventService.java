package com.example.eventsgbackend.service;

import com.example.eventsgbackend.dao.EventDao;
import com.example.eventsgbackend.dao.PersonDao;
import com.example.eventsgbackend.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventService {

    private final EventDao eventDao;

    @Autowired
    public EventService(@Qualifier("eventdao") EventDao eventDao) {
        this.eventDao = eventDao;
    }

    public List<Event> getAllEvent() {
        return eventDao.getAllEvent();
    }

    public void postEvent(Event event) {
        eventDao.postEvent(event);
    }

    public void saveEvent(Event event) {
        eventDao.saveEvent(event);
    }

    public Event getEvent(UUID id) {
        return eventDao.getEvent(id);
    }

}
