package com.bridgelabz.cab.adapter;

public class InvoiceFactory {

    //Method for getting instance of a invoice object
    public static IInvoice getInvoiceInstance(Invoice.TypeOfSubscription typeOfSubscription) {
        IInvoice iInvoice = new Invoice(typeOfSubscription);
        return iInvoice;
    }
}
