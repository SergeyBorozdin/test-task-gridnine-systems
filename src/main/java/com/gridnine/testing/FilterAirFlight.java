package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilterAirFlight {

    public static List<Flight> FlightBeforeTime(List<Flight> flights ) {
        LocalDateTime now = LocalDateTime.now();
        Set<Flight> filterFlights = new HashSet<>(); // для больших наборов перелетов используем поиск в хеш сет
        for (Flight obj : flights) {
            if (obj.getSegments().get(0).getDepartureDate().isBefore(now)) {
                continue;
            }
            filterFlights.add(obj);
        }
        return filterFlights.stream().toList();
    }

    public static List<Segment> arrivalsBeforeDeparture() {
        return new ArrayList<>();
    }

    public static List<Segment> transferMore2hours() {
        return new ArrayList<>();
    }
}
