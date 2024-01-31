package az.code.classwork2.models;

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
    @Column(nullable = false, name = "event_id")
    private Long eventId;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "event_description")
    private String eventDescription;

    @Column(nullable = false)
    private String location;

    @ElementCollection
    private List<Double> prices = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> visitors;

    @OneToOne
    private Feedback feedback;
}
