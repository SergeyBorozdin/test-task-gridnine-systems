import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlightBeforeTime implements Filters{

    @Override
    public List<Flight> filters(List<Flight> flightList) {
        LocalDateTime now = LocalDateTime.now();
        Set<Flight> filterFlights = new HashSet<>(); // для больших наборов перелетов используем поиск в хеш сет
        for (Flight obj : flightList) {
            if (obj.getSegments().get(0).getDepartureDate().isBefore(now)) {
                continue;
            }
            filterFlights.add(obj);
        }
        return filterFlights.stream().toList();
    }
}
