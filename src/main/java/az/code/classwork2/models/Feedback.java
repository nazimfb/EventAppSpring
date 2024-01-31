package az.code.classwork2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private User user;

    @OneToOne(mappedBy = "feedback")
    private Event event;
}
