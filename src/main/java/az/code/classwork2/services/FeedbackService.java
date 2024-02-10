package az.code.classwork2.services;

import az.code.classwork2.models.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> getFeedbacksOfEvent(long eventId);
    List<Feedback> getFeedbacksOfEventByUser(long eventId, long userId);
}
