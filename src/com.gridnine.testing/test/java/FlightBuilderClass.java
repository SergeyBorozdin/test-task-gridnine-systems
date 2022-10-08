import java.time.LocalDateTime;
import java.util.*;

public class FlightBuilderClass {

    final Filters filtersTest;
    LocalDateTime twoDaysFromNow = LocalDateTime.now().plusDays(2);
    List<Flight> flightsListTest;

    public FlightBuilderClass(Filters filtersTest) {
        this.filtersTest = filtersTest;
        flightsListTest = new ArrayList<>();
    }

    Segment segment1 = new Segment(twoDaysFromNow, twoDaysFromNow.plusHours(3));
    Segment segment2 = new Segment(twoDaysFromNow.plusHours(6), twoDaysFromNow.plusHours(9));
    Segment segment3 = new Segment(twoDaysFromNow.plusHours(1), twoDaysFromNow.plusHours(2));
    Segment segment4 = new Segment(twoDaysFromNow.minusDays(3), twoDaysFromNow.plusHours(3));
    Segment segment5 = new Segment(twoDaysFromNow, twoDaysFromNow.minusHours(1));


    Flight flight1 = new Flight(Collections.singletonList(segment1));
    Flight flight2 = new Flight(Arrays.asList(segment1, segment2));
    Flight flight3 = new Flight(Arrays.asList(segment1, segment3));
    Flight flight4 = new Flight(Collections.singletonList(segment4));
    Flight flight5 = new Flight(Collections.singletonList(segment5));
}
