import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FlightBeforeTimeTest extends FlightBuilderClass {

    public FlightBeforeTimeTest() {
        super(new FlightBeforeTime());
    }

    @Before
    public void setUp() {
        flightsListTest.add(flight1);
        flightsListTest.add(flight2);
        flightsListTest.add(flight3);
        flightsListTest.add(flight4);
    }

    @Test
    public void filter() {
        final List<Flight> actual = filtersTest.filters(flightsListTest.stream().toList());
        final List<Flight> expected = Arrays.asList(flight1, flight2, flight3);
        assertEquals(expected, actual);

    }
}
