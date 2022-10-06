package com.gridnine.testing;

public class Main {

    public static void main(String[] args) {

        System.out.println("\tstand==================");
        for (Object obj : FlightBuilder.createFlights()) {
            System.out.println(obj);
        }
        System.out.println("\tfilter1================");
        for (Object obj : FilterAirFlight.flightBeforeTime(FlightBuilder.createFlights())) {
            System.out.println(obj);
        }
        System.out.println("\tfilter2================");
        for (Object obj : FilterAirFlight.arrivalsBeforeDeparture(FlightBuilder.createFlights())) {
            System.out.println(obj);
        }
        System.out.println("\tfilter3================");
        for (Object obj : FilterAirFlight.transferMore2hours(FlightBuilder.createFlights())) {
            System.out.println(obj);
        }
    }
}
