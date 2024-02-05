package az.code.classwork2.requests;

import java.time.LocalDateTime;
import java.util.List;

public record GetEvents(String name,
                        LocalDateTime localDateTime,
                        String desc,
                        String location,
                        List<Double> prices) {

}
