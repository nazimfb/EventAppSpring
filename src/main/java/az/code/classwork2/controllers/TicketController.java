package az.code.classwork2.controllers;

import az.code.classwork2.models.Ticket;
import az.code.classwork2.dto.TicketDto;
import az.code.classwork2.services.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/tickets")
public class TicketController {
    TicketService ticketService;

    // buying a ticket - user registration for event
    @PostMapping
    public ResponseEntity<Optional<TicketDto>> createTicket(@RequestBody TicketDto ticketDto) {
        Optional<TicketDto> ticketCreated = toTicketDto(Optional.of(ticketService.create(ticketDto.toTicket())));
        return new ResponseEntity<>(ticketCreated, HttpStatus.CREATED);
    }

    private Optional<TicketDto> toTicketDto(Optional<Ticket> ticket) {
        return ticket.map(value -> new TicketDto(
                value.getTicketId(),
                value.getPrice(),
                value.getUser(),
                value.getEvent()
        ));
    }

    @PostMapping("/{ticketId}/purchase")
    public ResponseEntity<Optional<TicketDto>> purchase(@PathVariable long ticketId, @RequestBody int cardNumber) {
        Optional<TicketDto> ticketDto = toTicketDto(ticketService.purchaseTicket(ticketId, cardNumber));
        return new ResponseEntity<>(ticketDto, HttpStatus.OK);
    }
}
