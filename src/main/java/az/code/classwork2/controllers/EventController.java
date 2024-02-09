package az.code.classwork2.controllers;

import az.code.classwork2.models.Event;
import az.code.classwork2.dto.EventDto;
import az.code.classwork2.services.EventServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/events")
public class EventController {
    public EventServiceImpl eventServiceImpl;

    public EventController(EventServiceImpl eventServiceImpl) {
        this.eventServiceImpl = eventServiceImpl;
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody EventDto eventDto) {
        Event eventCreated = eventServiceImpl.create(eventDto.toEvent());
        return new ResponseEntity<>(eventCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getEvents() {
        return new ResponseEntity<>(eventServiceImpl.findAll(), HttpStatus.OK);
    }

    @GetMapping("/upcoming")
    public ResponseEntity<List<Event>> getUpcomingEvents() {
        return new ResponseEntity<>(eventServiceImpl.getUpcomingEvents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Event>> getEventById(@PathVariable("id") int id) {
        return new ResponseEntity<>(eventServiceImpl.findById(id), HttpStatus.OK);
    }
}
