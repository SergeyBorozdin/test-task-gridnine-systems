package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FilterAirFlight {

    public static List<Flight> getExcludeSegmentBeforeTime (List<Flight> flights ) {
        LocalDateTime now = LocalDateTime.now();
        List<Flight> filterFlights = new ArrayList<>();
        for (Flight obj : flights) {
            String segment = obj.toString();
            int start = 1;
            int end = segment.indexOf('|', start);
            String dateDeparture = segment.substring(start, end);
            LocalDateTime dateTime = LocalDateTime.parse(dateDeparture);
            if (dateTime.isBefore(now)) {
                continue;
            }
            filterFlights.add(obj);
        }

        return filterFlights;
    }

    public static List<Segment> getExcludeArrivalsBeforeDeparture () {
        return new ArrayList<>();
    }

    public static List<Segment> getExcludeTransferMore2hours () {
        return new ArrayList<>();
    }
}
