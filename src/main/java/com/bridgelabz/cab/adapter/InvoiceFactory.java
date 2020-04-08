package com.bridgelabz.cab.adapter;

public class InvoiceFactory {

    //Method for getting instance of a invoice object
    public static IInvoice getInvoiceInstance() {
        IInvoice iInvoice = new Invoice();
        return iInvoice;
    }
}
