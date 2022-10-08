package com.gridnine.testing;

import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TransferMore2hours implements Filters{

    @Override
    public List<Flight> filters(List<Flight> flightList) {
        Set<Flight> filterFlights = new HashSet<>(); // для больших наборов перелетов используем поиск в хеш сет
        boolean min2hours = false;
        for (Flight obj : flightList) {
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
