package az.code.classwork2.repositories;

import az.code.classwork2.models.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends CrudRepository<Ticket, Integer> {

}
