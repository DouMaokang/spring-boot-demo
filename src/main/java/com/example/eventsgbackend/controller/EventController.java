package com.example.eventsgbackend.controller;


import com.example.eventsgbackend.model.Event;
import com.example.eventsgbackend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/event")
@RestController
public class EventController {

    private final EventService eventService;

    @Autowired // It injects the actual service into the constructor
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Event> getAllEvent() {
        return eventService.getAllEvent();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void postEvent(@RequestBody Event event) {
        eventService.postEvent(event);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Event getEvent(@PathVariable("id") UUID id) {
        return eventService.getEvent(id);
    }

}
