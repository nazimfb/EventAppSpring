package az.code.classwork2.services;

import az.code.classwork2.models.Feedback;

import java.util.List;

public interface FeedbackService {
    Feedback create(Feedback feedback);
    List<Feedback> getFeedbacksOfEvent(int eventId);
    List<Feedback> getFeedbacksOfEventByUser(long eventId, long userId);
}
