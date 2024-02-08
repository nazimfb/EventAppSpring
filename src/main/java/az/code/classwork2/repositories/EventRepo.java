package az.code.classwork2.repositories;

import az.code.classwork2.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends CrudRepository<Event, Integer> {

}
