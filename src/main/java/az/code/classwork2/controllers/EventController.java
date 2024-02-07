package az.code.classwork2.controllers;

import az.code.classwork2.models.Event;
import az.code.classwork2.requests.EventDto;
import az.code.classwork2.services.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/events")
public class EventController {
    public EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody EventDto eventDto) {
        Event eventCreated = eventService.create(eventDto.toEvent());
        return new ResponseEntity<>(eventCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getEvents() {
        return new ResponseEntity<>(eventService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Event>> getEventById(@PathVariable("id") int id) {
        return new ResponseEntity<>(eventService.findById(id), HttpStatus.OK);
    }
}
