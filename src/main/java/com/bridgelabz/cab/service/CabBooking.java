package com.bridgelabz.cab.service;

import com.bridgelabz.cab.adapter.IInvoice;
import com.bridgelabz.cab.adapter.InvoiceFactory;
import com.bridgelabz.cab.model.Ride;

public class CabBooking {

    private IInvoice iInvoice;

    //Method for calculating fare
    public double calculateRideFare(double distance, double time) {
        iInvoice = InvoiceFactory.getInvoiceInstance();
        return iInvoice.calculateFare(distance, time);
    }

    //Method for calculating multiple fare
    public double calculateRideFare(Ride[] rides) {
        iInvoice = InvoiceFactory.getInvoiceInstance();
        return iInvoice.calculateFare(rides);
    }
}
