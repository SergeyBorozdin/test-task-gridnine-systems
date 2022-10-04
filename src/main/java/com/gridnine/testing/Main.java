package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        for (Object obj : FlightBuilder.createFlights()) {
//            System.out.println(obj);
//        }

    }

    public static List<Segment> getExcludeSegmentBeforeTime () {
        return new ArrayList<>();
    }

    public static List<Segment> getExcludeArrivalsBeforeDeparture () {
        return new ArrayList<>();
    }

    public static List<Segment> getExcludeTransferMore2hours () {
        return new ArrayList<>();
    }
}
