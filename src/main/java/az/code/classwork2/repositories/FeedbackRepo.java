package az.code.classwork2.repositories;

import az.code.classwork2.models.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepo extends CrudRepository<Feedback, Integer> {

}
