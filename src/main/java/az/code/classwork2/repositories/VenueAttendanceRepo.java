package az.code.classwork2.repositories;

import az.code.classwork2.models.VenueAttendance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueAttendanceRepo extends CrudRepository<VenueAttendance, Integer> {
}
