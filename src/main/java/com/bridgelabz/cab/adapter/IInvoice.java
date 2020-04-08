package com.bridgelabz.cab.adapter;

import com.bridgelabz.cab.model.InvoiceDetails;
import com.bridgelabz.cab.model.Ride;

import java.util.ArrayList;
import java.util.Map;

public interface IInvoice {

    double calculateFare(double distance,double time);
    double calculateFare(Ride[] rides);
    Map<String, ArrayList<Ride>> addRides(String userId, Ride[] rides);
    InvoiceDetails getInvoiceDetails(String userId, Map<String, ArrayList<Ride>> userRides);
}
