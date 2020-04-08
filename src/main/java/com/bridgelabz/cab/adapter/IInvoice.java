package com.bridgelabz.cab.adapter;

import com.bridgelabz.cab.model.Ride;

public interface IInvoice {

    double calculateFare(double distance,double time);
    double calculateFare(Ride[] rides);
}
