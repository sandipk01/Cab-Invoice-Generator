package com.bridgelabz.cab.model;

public class Ride {
    private double time;
    private double distance;

    public Ride(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }

    public double getTime() {
        return time;
    }

    public double getDistance() {
        return distance;
    }
}
