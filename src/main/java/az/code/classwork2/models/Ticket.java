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
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "ticket_id")
    private Long ticketId;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @Column(nullable = false)
    private User user;

    @OneToOne
    @Column(nullable = false)
    private Event event;
}
