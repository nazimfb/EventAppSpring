package az.code.classwork2.services;

import az.code.classwork2.models.Event;
import java.util.List;
import java.util.Optional;

public interface EventService {
    Event create(Event event);
    List<Event> findAll();

    Optional<Event> findById(int id);

    Event update(Event eventToUpdate);

    void delete(int id);

    List<Event> getUpcomingEvents();
}
