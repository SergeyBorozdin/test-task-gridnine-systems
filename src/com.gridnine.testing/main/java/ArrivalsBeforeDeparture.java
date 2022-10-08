import java.util.ArrayList;
import java.util.List;

public class ArrivalsBeforeDeparture implements Filters{

    @Override
    public List<Flight> filters(List<Flight> flightList) {
        List<Flight> filterFlights = new ArrayList<>();
        for (Flight obj : flightList) {
            if (obj.getSegments().get(0).getDepartureDate().isAfter(obj.getSegments().get(0).getArrivalDate())) {
                continue;
            }
            filterFlights.add(obj);
        }
        return filterFlights;
    }
}
