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
        EventDto eventCreated = modelMapper.map(toEventDto(Optional.of(eventServiceImpl.create(eventDto.toEvent()))), EventDto.class);
        return new ResponseEntity<>(eventCreated, HttpStatus.CREATED);
    }

    private EventDto toEventDto(Optional<Event> event) {
        return event.map(value -> new EventDto(
                value.getEventId(),
                value.getEventName(),
                value.getDateTime(),
                value.getEventDescription(),
                value.getPrices(),
                value.getFeedbacks(),
                value.getLocation())).orElse(null);

    }

    @GetMapping
    public ResponseEntity<List<EventDto>> getEvents() {
        List<EventDto> eventDtoList = toEventDtoList(eventServiceImpl.findAll());
        return new ResponseEntity<>(eventDtoList, HttpStatus.OK);
    }

    private List<EventDto> toEventDtoList(List<Event> all) {
        return all.stream().map(event ->
                toEventDto(Optional.of(event)))
                .collect(Collectors.toList());
    }

    @GetMapping("/upcoming")
    public ResponseEntity<List<EventDto>> getUpcomingEvents() {
        return new ResponseEntity<>(toEventDtoList(eventServiceImpl.getUpcomingEvents()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<EventDto>> getEventById(@PathVariable("id") int id) {
        return eventServiceImpl.findById(id).isEmpty() ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(Optional.ofNullable( toEventDto(eventServiceImpl.findById(id)) ), HttpStatus.OK);
    }
}
