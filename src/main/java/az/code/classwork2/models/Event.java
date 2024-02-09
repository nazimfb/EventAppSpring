package az.code.classwork2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

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
    @JsonIgnore
    @ToString.Exclude
    private List<Double> prices = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private List<User> visitors;

    @OneToOne
    @JsonIgnore
    @ToString.Exclude
    private Feedback feedback;
}
