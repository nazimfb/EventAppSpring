package az.code.classwork2.controllers;

import az.code.classwork2.models.Event;
import az.code.classwork2.requests.EventRequests;
import az.code.classwork2.services.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    public EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/events")
    public ResponseEntity<Event> createEvent(@RequestBody EventRequests eventRequests) {
        Event eventCreated = eventService.create(eventRequests.toEvent());
        return new ResponseEntity<>(eventCreated, HttpStatus.CREATED);
    }

    @GetMapping("/events")
    public ResponseEntity<Event> getEvents(@RequestBody Event event) {
        return  null;
    }
}
