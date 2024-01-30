package models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    private String eventName;
    private LocalDateTime dateTime;
    private String eventDescription;
    private String location;

    @ElementCollection
    private List<Double> prices = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> visitors;

    @OneToOne
    private Feedback feedback;
}
