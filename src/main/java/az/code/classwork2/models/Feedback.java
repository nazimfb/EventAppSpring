package az.code.classwork2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "feedback_id")
    private Long feedbackId;

    @Column(nullable = false)
    private String content;

    private int rating;

    @OneToOne(mappedBy = "feedback")
    @ToString.Exclude
    @JsonIgnore
    private User user;

    @OneToOne(mappedBy = "feedback")
    @ToString.Exclude
    @JsonIgnore
    private Event event;
}
