package com.bridgelabz.cab.adapter;

import com.bridgelabz.cab.model.Ride;

public class Invoice implements IInvoice {

    //Constants
    private double RATE_PER_KM = 10;
    private int RATE_PER_MIN = 1;
    private double MINIMUM_FARE = 5;

    private double totalFare;

    //Calculating Fare
    @Override
    public double calculateFare(double distance, double time) {
        totalFare = RATE_PER_KM * distance + RATE_PER_MIN * time;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    //calculating total fares for multiple rides
    @Override
    public double calculateFare(Ride[] rides) {
        for(Ride ride:rides)
            totalFare+=calculateFare(ride.getDistance(),ride.getTime());
        return Math.max(totalFare,MINIMUM_FARE);
    }

}
