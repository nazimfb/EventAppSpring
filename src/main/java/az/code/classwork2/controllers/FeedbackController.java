package az.code.classwork2.controllers;

import az.code.classwork2.dto.FeedbackDto;
import az.code.classwork2.models.Feedback;
import az.code.classwork2.services.FeedbackServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {
    private final FeedbackServiceImpl feedbackService;
    public ModelMapper mapper = new ModelMapper();

    public FeedbackController(FeedbackServiceImpl feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<FeedbackDto> createFeedback(@RequestBody FeedbackDto feedbackDto) {
        FeedbackDto feedbackCreated = mapper.map(toFeedbackDto(feedbackService.create(feedbackDto.toFeedback())), FeedbackDto.class);
        return new ResponseEntity<>(feedbackCreated, HttpStatus.OK);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<List<FeedbackDto>> getFeedbacksOfEvent(@PathVariable int eventId) {
        List<FeedbackDto> feedbacksOfEvent = tofeedbackDtoList(feedbackService.getFeedbacksOfEvent(eventId));
        return new ResponseEntity<>(feedbacksOfEvent, HttpStatus.OK);
    }

    private FeedbackDto toFeedbackDto(Feedback feedback) {
        return new FeedbackDto(
                feedback.getFeedbackId(),
                feedback.getContent(),
                feedback.getRating(),
                feedback.getUser(),
                feedback.getEvent());
    }

    private List<FeedbackDto> tofeedbackDtoList(List<Feedback> all) {
        return all.stream().map(this::toFeedbackDto)
                .collect(Collectors.toList());
    }
}
