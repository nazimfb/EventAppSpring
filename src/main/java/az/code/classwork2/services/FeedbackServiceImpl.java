package az.code.classwork2.services;

import az.code.classwork2.models.Event;
import az.code.classwork2.models.Feedback;
import az.code.classwork2.repositories.FeedbackRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepo feedbackRepo;
    private final EventServiceImpl eventService;

    public FeedbackServiceImpl(FeedbackRepo feedbackRepo, EventServiceImpl eventService) {
        this.feedbackRepo = feedbackRepo;
        this.eventService = eventService;
    }

    @Override
    public Feedback create(Feedback feedback) {
        return feedbackRepo.save(feedback);
    }

    @Override
    public List<Feedback> getFeedbacksOfEvent(int eventId) {
        Optional<Event> event = eventService.findById(eventId);
        return event.map(Event::getFeedbacks).orElse(null);
    }

    @Override
    public List<Feedback> getFeedbacksOfEventByUser(long eventId, long userId) {
        return null;
    }
}
