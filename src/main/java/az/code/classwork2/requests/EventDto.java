package az.code.classwork2.requests;

import az.code.classwork2.models.Event;

import java.time.LocalDateTime;
import java.util.List;

public record EventDto(String name,
                       LocalDateTime localDateTime,
                       String desc,
                       String location,
                       List<Double> prices) {
    public Event toEvent() {
        Event event = new Event();

        event.setEventName(name);
        event.setDateTime(localDateTime);
        event.setEventDescription(desc);
        event.setLocation(location);
        event.setPrices(prices);
        
        return event;
    }
}