package az.code.classwork2.services;

import az.code.classwork2.models.Event;
import az.code.classwork2.repositories.EventRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    public final EventRepo eventRepo;

    public EventServiceImpl(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public Event create(Event event) {
        return eventRepo.save(event);
    }

    @Override
    public List<Event> findAll() {
        List<Event> events = new ArrayList<>();
        eventRepo.findAll().forEach(events::add);

        return events;
    }

    @Override
    public Optional<Event> findById(int id) {
        return eventRepo.findById(id);
    }

    @Override
    public Event update(Event eventToUpdate) {
        return eventRepo.save(eventToUpdate);
    }

    @Override
    public void delete(int id) {
        eventRepo.deleteById(id);
    }

    @Override
    public List<Event> getUpcomingEvents() {
        LocalDateTime now = LocalDateTime.now();
        List<Event> events = new ArrayList<>();
        eventRepo.findAll().forEach(events::add);
        return events.stream().filter(event -> event.getDateTime() != null && event.getDateTime().isAfter(now)).toList();
    }
}
