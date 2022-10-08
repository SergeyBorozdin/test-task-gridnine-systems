import junit.framework.TestCase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ArrivalsBeforeDepartureTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        LocalDateTime nowDateTime = LocalDateTime.now();

        List<Flight> flightsTestList = new ArrayList<>();

        Segment segment1 = new Segment(nowDateTime.plusDays(2), nowDateTime.plusDays(2).plusHours(3));
        Segment segment2 = new Segment(nowDateTime.plusDays(2).plusHours(6), nowDateTime.plusDays(2).plusHours(9));

        Segment segment3 = new Segment(nowDateTime.plusDays(1), nowDateTime.plusHours(1).plusHours(3));
        Segment segment4 = new Segment(nowDateTime.plusDays(2), nowDateTime.plusHours(3));
        Segment segment5 = new Segment(nowDateTime.plusDays(2), nowDateTime.plusHours(3));
        Segment segment6 = new Segment(nowDateTime.plusDays(2), nowDateTime.plusHours(3));


        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
