package com.bridgelabz.cab.adapter;

public class Invoice implements IInvoice {

    //Constants
    private double RATE_PER_KM = 10;
    private int RATE_PER_MIN = 1;
    private double MINIMUM_FARE = 5;

    //Calculating Fare
    @Override
    public double calculateFare(double distance, double time) {
        double totalFare = RATE_PER_KM * distance + RATE_PER_MIN * time;
        return Math.max(totalFare, MINIMUM_FARE);
    }

}
