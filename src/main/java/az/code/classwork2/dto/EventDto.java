package az.code.classwork2.dto;

import az.code.classwork2.models.Event;
import az.code.classwork2.models.Feedback;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public record EventDto(Long eventId,
                       String name,
                       @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                       LocalDateTime localDateTime,
                       String desc,
                       @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT, pattern = "0.#")
                       List<Double> prices,
                       List<Feedback> feedbacks,
                       String location) {
    public Event toEvent() {
        Event event = new Event();

        event.setEventId(eventId);
        event.setEventName(name);
        event.setDateTime(localDateTime);
        event.setEventDescription(desc);
        event.setLocation(location);
        event.setPrices(prices);
        event.setFeedbacks(feedbacks);

        return event;
    }

}