package com.gridnine.testing;

public class Main {

    public static void main(String[] args) {

        System.out.println("\tstand==================");
        for (Object obj : FlightBuilder.createFlights()) {
            System.out.println(obj);
        }
        System.out.println("\tflightBeforeTime=======================");
        Filters flightBeforeTime = new FlightBeforeTime();
        flightBeforeTime.filters(FlightBuilder.createFlights()).forEach(System.out::println);

        System.out.println("\tarrivalsBeforeDeparture================");
        Filters arrivalsBeforeDeparture = new ArrivalsBeforeDeparture();
        arrivalsBeforeDeparture.filters(FlightBuilder.createFlights()).forEach(System.out::println);

        System.out.println("\ttransferMore2hours=====================");
        Filters transferMore2hours = new TransferMore2hours();
        transferMore2hours.filters(FlightBuilder.createFlights()).forEach(System.out::println);
    }
}
