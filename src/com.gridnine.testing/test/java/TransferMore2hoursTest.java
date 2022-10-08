import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TransferMore2hoursTest extends FlightBuilderClass{

    public TransferMore2hoursTest() {
        super(new TransferMore2hours());
    }

    @Before
    public void setUp() {
        flightsListTest.add(flight1);
        flightsListTest.add(flight2);
        flightsListTest.add(flight3);
        flightsListTest.add(flight4);
        flightsListTest.add(flight5);

    }

    @Test
    public void filter() {
        final List<Flight> actual = filtersTest.filters(flightsListTest);
        final List<Flight> expected = Arrays.asList(flight1, flight2, flight4, flight5);
        assertEquals(expected, actual);

    }
}
