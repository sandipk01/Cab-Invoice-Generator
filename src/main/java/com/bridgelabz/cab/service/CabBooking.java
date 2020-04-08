package com.bridgelabz.cab.service;

import com.bridgelabz.cab.adapter.IInvoice;
import com.bridgelabz.cab.adapter.InvoiceFactory;

public class CabBooking {

    //Method for calculating fare
    public double calculateRideFare(double distance, double time) {
        IInvoice iInvoice= InvoiceFactory.getInvoiceInstance();
        return iInvoice.calculateFare(distance,time);
    }
}
