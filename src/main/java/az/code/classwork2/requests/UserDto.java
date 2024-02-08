package az.code.classwork2.requests;

import az.code.classwork2.models.Event;
import az.code.classwork2.models.Feedback;
import az.code.classwork2.models.User;

import java.util.List;

public record UserDto(Long userId,
                      String email,
                      Long creditCard,
                      Feedback feedback,
                      List<Event> events) {
    public User toUser() {
        User user = new User();

        user.setUserId(userId);
        user.setEmail(email);
        user.setCreditCard(creditCard);
        user.setFeedback(feedback);
        user.setEventList(events);

        return user;
    }
}
