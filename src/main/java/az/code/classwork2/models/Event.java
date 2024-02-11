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
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "event_id")
    private Long eventId;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "venue")
    private VenueAttendance venueAttendance;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "event_description")
    private String eventDescription;

    @Column(nullable = false)
    private String location;

    @ElementCollection
    @Column(nullable = false)
    private List<Double> prices = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private List<User> visitors; //users who bought tickets

    @OneToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Feedback> feedbacks;
}
