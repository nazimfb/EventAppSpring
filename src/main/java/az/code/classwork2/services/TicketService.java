package az.code.classwork2.services;

import az.code.classwork2.models.Ticket;

import java.util.Optional;

public interface TicketService {
    Ticket create(Ticket ticket);
    Optional<Ticket> purchaseTicket(long id, int cardNumber);
    Optional<Ticket> findById(long id);
}
