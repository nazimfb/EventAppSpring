package az.code.classwork2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    private String email;

    @Column(name = "credit_card")
    private Long creditCard;

    @ManyToMany(mappedBy = "visitors", cascade = CascadeType.ALL)
    @Column(name = "event_list")
    private List<Event> eventList;

    @OneToOne(cascade = CascadeType.ALL)
    private Feedback feedback;

    @OneToMany
    private List<Ticket> tickets;
}
