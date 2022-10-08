import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrivalsBeforeDeparture implements Filters{

    @Override
    public List<Flight> filters(List<Flight> flightList) {
        Set<Flight> filterFlights = new HashSet<>();
        for (Flight obj : flightList) {
            if (obj.getSegments().get(0).getDepartureDate().isAfter(obj.getSegments().get(0).getArrivalDate())) {
                continue;
            }
            filterFlights.add(obj);
        }
        return filterFlights.stream().toList();
    }
}
