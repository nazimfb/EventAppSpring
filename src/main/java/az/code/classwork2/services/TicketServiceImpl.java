package az.code.classwork2.services;

import az.code.classwork2.models.Ticket;
import az.code.classwork2.repositories.TicketRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService{
    private final TicketRepo ticketRepo;
    public TicketServiceImpl(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    @Override
    public Ticket create(Ticket ticket) {
        return ticketRepo.save(ticket);
    }

    @Override
    public Optional<Ticket> findById(long id) {
        return ticketRepo.findById((int) id);
    }

    @Override
    public Optional<Ticket> purchaseTicket(long id, int cardNumber) {
        Optional<Ticket> ticket = findById(id);
        //purchase logic
        return ticket.isPresent() ? ticket : null;
    }

}
