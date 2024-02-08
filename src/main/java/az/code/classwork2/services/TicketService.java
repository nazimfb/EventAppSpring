package az.code.classwork2.services;

import az.code.classwork2.models.Ticket;
import az.code.classwork2.repositories.TicketRepo;

public class TicketService {
    private final TicketRepo ticketRepo;

    public TicketService(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    public Ticket create(Ticket ticket) {
        return ticketRepo.save(ticket);
    }
}
