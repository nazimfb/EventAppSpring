package az.code.classwork2.controllers;

import az.code.classwork2.models.Event;
import az.code.classwork2.dto.EventDto;
import az.code.classwork2.services.EventServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/events")
public class EventController {
    public EventServiceImpl eventServiceImpl;
    public ModelMapper modelMapper = new ModelMapper();

    public EventController(EventServiceImpl eventServiceImpl) {
        this.eventServiceImpl = eventServiceImpl;
    }

    @PostMapping
    public ResponseEntity<EventDto> createEvent(@RequestBody EventDto eventDto) {
        EventDto eventCreated = modelMapper.map(toEventDto(eventServiceImpl.create(eventDto.toEvent())), EventDto.class);
        return new ResponseEntity<>(eventCreated, HttpStatus.CREATED);
    }

    /*@PostMapping("{id}/register/{userId}")
    public ResponseEntity<TicketDto> registerToEvent(@PathVariable long id, @PathVariable long userId) {
        return null;
    }*/

    private EventDto toEventDto(Event event) {
        return new EventDto(
                event.getEventId(),
                event.getEventName(),
                event.getDateTime(),
                event.getEventDescription(),
                event.getPrices(),
                event.getFeedbacks(),
                event.getLocation());
    }

    @GetMapping
    public ResponseEntity<List<EventDto>> getEvents() {
        List<EventDto> eventDtoList = toEventDtoList(eventServiceImpl.findAll());
        return new ResponseEntity<>(eventDtoList, HttpStatus.OK);
    }

    private List<EventDto> toEventDtoList(List<Event> all) {
        return all.stream().map(
                this::toEventDto
        ).collect(Collectors.toList());
    }

    @GetMapping("/upcoming")
    public ResponseEntity<List<EventDto>> getUpcomingEvents() {
        return new ResponseEntity<>(toEventDtoList(eventServiceImpl.getUpcomingEvents()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Event>> getEventById(@PathVariable("id") int id) {
        return new ResponseEntity<>(eventServiceImpl.findById(id), HttpStatus.OK);
    }
}
