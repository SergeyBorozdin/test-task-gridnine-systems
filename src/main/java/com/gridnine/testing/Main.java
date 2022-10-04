package com.gridnine.testing;

public class Main {

    public static void main(String[] args) {

        for (Object obj : FlightBuilder.createFlights()) {
            System.out.println(obj);
        }

    }
}
