package az.code.classwork2.dto;

import az.code.classwork2.models.Event;
import az.code.classwork2.models.Feedback;

import java.time.LocalDateTime;
import java.util.List;

public record EventDto(Long eventId,
                       String name,
                       LocalDateTime localDateTime,
                       String desc,
                       String location,
                       List<Double> prices,
                       Feedback feedback) {
    public Event toEvent() {
        Event event = new Event();

        event.setEventId(eventId);
        event.setEventName(name);
        event.setDateTime(localDateTime);
        event.setEventDescription(desc);
        event.setLocation(location);
        event.setPrices(prices);
        event.setFeedback(feedback);

        return event;
    }
}