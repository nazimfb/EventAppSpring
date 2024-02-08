package az.code.classwork2.dto;

import az.code.classwork2.models.Event;
import az.code.classwork2.models.Feedback;
import az.code.classwork2.models.User;

public record FeedbackDto(Long feedbackId,
                          String content,
                          int rating,
                          User user,
                          Event event) {
    public Feedback toFeedback() {
        Feedback feedback = new Feedback();

        feedback.setFeedbackId(feedbackId);
        feedback.setContent(content);
        feedback.setRating(rating);
        feedback.setUser(user);
        feedback.setEvent(event);

        return feedback;
    }
}
