package az.code.classwork2.dto;

import az.code.classwork2.models.Event;
import az.code.classwork2.models.User;
import az.code.classwork2.models.VenueAttendance;

public record VenueAttendanceDto(long id,
                                 Event event,
                                 User user,
                                 boolean attends) {
    public VenueAttendance toVenueAttendance(){
        VenueAttendance venueAttendance = new VenueAttendance();

        venueAttendance.setId(id);
        venueAttendance.setEvent(event);
        venueAttendance.setUser(user);
        venueAttendance.setAttends(attends);

        return venueAttendance;
    }
}
