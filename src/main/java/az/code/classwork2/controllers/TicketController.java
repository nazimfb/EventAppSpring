package az.code.classwork2.controllers;

import az.code.classwork2.models.Event;
import az.code.classwork2.models.Ticket;
import az.code.classwork2.requests.EventDto;
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
    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody EventDto eventDto) {
        Event ticketCreated = ticketService.create(ticketRequests.toEvent());
        return new ResponseEntity<>(ticketCreated, HttpStatus.CREATED);
    }
}
