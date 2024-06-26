package az.code.classwork2.dto;

import az.code.classwork2.models.Event;
import az.code.classwork2.models.Ticket;
import az.code.classwork2.models.User;

public record TicketDto(Long ticketId,
                        Double price,
                        User user,
                        Event event) {
    public Ticket toTicket() {
        Ticket ticket = new Ticket();

        ticket.setTicketId(ticketId);
        ticket.setPrice(price);
        ticket.setUser(user);
        ticket.setEvent(event);

        return ticket;
    }
}
