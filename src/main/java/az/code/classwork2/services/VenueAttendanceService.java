package az.code.classwork2.services;

import az.code.classwork2.models.VenueAttendance;
import java.util.List;
import java.util.Optional;

public interface VenueAttendanceService {
    // registration
    void Register();
    VenueAttendance create(VenueAttendance venueAttendance);
    List<VenueAttendance> findAll();

    Optional<VenueAttendance> findById(long id);

    VenueAttendance update(VenueAttendance venueAttendance);

    void delete(long id);
}
