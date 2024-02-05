package az.code.classwork2.services;

import az.code.classwork2.models.Event;
import az.code.classwork2.repositories.EventRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    public final EventRepo eventRepo;

    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    public Event create(Event event) {
        return eventRepo.save(event);
    }

    public List<Event> findAll() {
        List<Event> events = new ArrayList<>();
        eventRepo.findAll().forEach(events::add);

        return events;
    }

    public Optional<Event> findById(int id) {
        return eventRepo.findById(id);
    }

    public Event update(Event eventToUpdate) {
        return eventRepo.save(eventToUpdate);
    }

    public void delete(int id) {
        eventRepo.deleteById(id);
    }
}
