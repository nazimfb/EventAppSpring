package az.code.classwork2.controllers;

import az.code.classwork2.models.Ticket;
import az.code.classwork2.dto.TicketDto;
import az.code.classwork2.services.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tickets")
public class TicketController {
    TicketService ticketService;
    // User registration for event - buying a ticket
    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody TicketDto ticketDto) {
        Ticket ticketCreated = ticketService.create(ticketDto.toTicket());
        return new ResponseEntity<>(ticketCreated, HttpStatus.CREATED);
    }

}
