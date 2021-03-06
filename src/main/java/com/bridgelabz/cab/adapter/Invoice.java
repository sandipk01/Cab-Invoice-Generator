package com.bridgelabz.cab.adapter;

import com.bridgelabz.cab.model.InvoiceDetails;
import com.bridgelabz.cab.model.Ride;
import com.bridgelabz.cab.service.RideRepository;

import java.util.ArrayList;
import java.util.Map;

public class Invoice implements IInvoice {

    //Constants
    private double RATE_PER_KM;
    private int RATE_PER_MIN;
    private double MINIMUM_FARE;

    private double totalFare;
    private RideRepository rideRepository;

    public enum TypeOfSubscription {NORMAL, PREMIUM}

    public Invoice(TypeOfSubscription typeOfSubscription) {

        if (typeOfSubscription.equals(TypeOfSubscription.PREMIUM)) {
            this.RATE_PER_KM = 15;
            this.RATE_PER_MIN = 2;
            this.MINIMUM_FARE = 20;
        } else if (typeOfSubscription.equals(TypeOfSubscription.NORMAL)) {
            this.RATE_PER_KM = 10;
            this.RATE_PER_MIN = 1;
            this.MINIMUM_FARE = 5;
        }
    }

    //Calculating Fare
    @Override
    public double calculateFare(double distance, double time) {
        totalFare = RATE_PER_KM * distance + RATE_PER_MIN * time;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    //calculating total fares for multiple rides
    @Override
    public double calculateFare(Ride[] rides) {
        for (Ride ride : rides)
            totalFare += calculateFare(ride.getDistance(), ride.getTime());
        return Math.max(totalFare, MINIMUM_FARE);
    }

    //Method for inserting multiple rides
    @Override
    public Map<String, ArrayList<Ride>> addRides(String userId, Ride[] rides) {
        rideRepository = new RideRepository();
        return rideRepository.addRides(userId, rides);
    }

    //Method for getting rides detail of particular user
    @Override
    public InvoiceDetails getInvoiceDetails(String userId, Map<String, ArrayList<Ride>> userRides) {
        rideRepository = new RideRepository();
        totalFare = calculateFare(rideRepository.getRidesByUserId(userId, userRides));
        return new InvoiceDetails(rideRepository.getRidesByUserId(userId, userRides).length, totalFare);
    }

}
