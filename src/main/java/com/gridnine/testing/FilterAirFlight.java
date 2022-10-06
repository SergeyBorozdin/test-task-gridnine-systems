package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilterAirFlight {

    public static List<Flight> flightBeforeTime(List<Flight> flights) {
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

    public static List<Flight> arrivalsBeforeDeparture(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        Set<Flight> filterFlights = new HashSet<>(); // для больших наборов перелетов используем поиск в хешсет
        for (Flight obj : flights) {
            if (obj.getSegments().get(0).getDepartureDate().isAfter(obj.getSegments().get(0).getArrivalDate())) {
                continue;
            }
            filterFlights.add(obj);
        }
        return filterFlights.stream().toList();
    }

    public static List<Flight> transferMore2hours(List<Flight> flights) {
        Set<Flight> filterFlights = new HashSet<>(); // для больших наборов перелетов используем поиск в хеш сет
        boolean min2hours = false;
        for (Flight obj : flights) {
            if (obj.getSegments().size() == 1) {
                filterFlights.add(obj);
            }
            else {
                for (int i = 0; i < obj.getSegments().size() - 1; i++) {
                    if (obj.getSegments().get(i).getArrivalDate().until(obj.getSegments().get(i + 1).getDepartureDate(), ChronoUnit.HOURS) < 2) {
                        min2hours = true;
                        continue;
                    }
                }
                if (!min2hours) {
                    filterFlights.add(obj);
                }
            }
            min2hours = false;
        }
        return filterFlights.stream().toList();
    }
}
