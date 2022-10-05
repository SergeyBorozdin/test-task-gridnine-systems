package com.gridnine.testing;

public class Main {

    public static void main(String[] args) {

        System.out.println("\tstand==================");
        for (Object obj : FlightBuilder.createFlights()) {
            System.out.println(obj);
        }
        System.out.println("\tfilter1================");
        for (Object obj : FilterAirFlight.FlightBeforeTime(FlightBuilder.createFlights())) {
            System.out.println(obj);
        }
    }

}
