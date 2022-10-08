import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightBeforeTime implements Filters{

    @Override
    public List<Flight> filters(List<Flight> flightList) {
        LocalDateTime now = LocalDateTime.now();
        List<Flight> filterFlights = new ArrayList<>();
        for (Flight obj : flightList) {
            if (obj.getSegments().get(0).getDepartureDate().isBefore(now)) {
                continue;
            }
            filterFlights.add(obj);
        }
        return filterFlights;
    }
}
