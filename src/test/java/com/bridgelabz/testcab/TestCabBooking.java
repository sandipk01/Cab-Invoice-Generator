package com.bridgelabz.testcab;

import com.bridgelabz.cab.adapter.Invoice;
import com.bridgelabz.cab.model.InvoiceDetails;
import com.bridgelabz.cab.model.Ride;
import com.bridgelabz.cab.service.CabBooking;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestCabBooking {

    private CabBooking cabBooking;
    private Map<String, ArrayList<Ride>> userRides;

    @Test
    public void givenDistanceTime_WhenCalculateFare_ThenShouldReturnTotalFare() {
        cabBooking = new CabBooking(Invoice.TypeOfSubscription.NORMAL);
        double totalFare = cabBooking.calculateRideFare(15, 30.15);
        Assert.assertEquals(180.15, totalFare, 1);
    }

    @Test
    public void givenWrongExpectedInput_WhenCalculateFare_ThenShouldReturnTotalFare() {
        cabBooking = new CabBooking(Invoice.TypeOfSubscription.NORMAL);
        double totalFare = cabBooking.calculateRideFare(15, 30.15);
        Assert.assertNotEquals(140.15, totalFare, 1);
    }

    @Test
    public void givenMinimumDistanceTime_WhenCalculateFare_ThenShouldReturnMinimumFare() {
        cabBooking = new CabBooking(Invoice.TypeOfSubscription.NORMAL);
        double totalFare = cabBooking.calculateRideFare(0.2, 2);
        Assert.assertEquals(5, totalFare, 1);
    }

    @Test
    public void givenMultipleRides_WhenCalculateFare_ThenShouldReturnTotalFare() {
        cabBooking = new CabBooking(Invoice.TypeOfSubscription.NORMAL);
        Ride[] rides = {new Ride(4, 10),
                        new Ride(10,15)};
        InvoiceDetails invoiceDetails = cabBooking.calculateRideFare(rides);
        Assert.assertEquals(165, invoiceDetails.getTotalFare(), 0);
    }

    @Test
    public void givenMultipleRides_WhenCalculateFare_ShouldReturnInvoiceSummaryTotalFare() {
        cabBooking=new CabBooking(Invoice.TypeOfSubscription.NORMAL);
        Ride[] rides = {new Ride(2.0, 5),
                        new Ride(0.1, 1)};
        InvoiceDetails details = cabBooking.calculateRideFare(rides);
        InvoiceDetails expectedDetails=new InvoiceDetails(2,30);
        Assert.assertEquals(expectedDetails, details);
    }

    @Test
    public void givenMultipleRides_WhenCalculateFare_ShouldReturnNumberOfRides() {
        cabBooking=new CabBooking(Invoice.TypeOfSubscription.NORMAL);
        Ride[] rides = {new Ride(2.0, 5),
                        new Ride(0.1, 1),
                        new Ride(0.1, 1)};
        InvoiceDetails details = cabBooking.calculateRideFare(rides);
        Assert.assertEquals(3, details.getNumOfRides(),0);
    }

    @Test
    public void givenMultipleRides_WhenCalculateFare_ShouldReturnAverageFare() {
        cabBooking=new CabBooking(Invoice.TypeOfSubscription.NORMAL);
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),
                new Ride(5.1, 10)};
        InvoiceDetails details = cabBooking.calculateRideFare(rides);
        Assert.assertEquals(30.33, details.getAverageFare(),1);
    }

    @Test
    public void givenUserIdAndRides_WhenCalculateFare_ShouldReturnInvoiceDetails() {
        cabBooking=new CabBooking(Invoice.TypeOfSubscription.NORMAL);
        userRides=new HashMap<>();
        String userId = "Sandip52";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        userRides=cabBooking.addRides(userId,rides);
        InvoiceDetails details = cabBooking.getInvoiceDetails(userId,userRides);
        InvoiceDetails expectedDetails=new InvoiceDetails(2,30);
        Assert.assertEquals(expectedDetails,details);
    }

    @Test
    public void givenDistanceTimeForPremiumSubscription_WhenCalculateFare_ThenShouldReturnTotalFare() {
        cabBooking = new CabBooking(Invoice.TypeOfSubscription.PREMIUM);
        double totalFare = cabBooking.calculateRideFare(15, 30.15);
        Assert.assertEquals(285.3, totalFare, 1);
    }

    @Test
    public void givenMinimumDistanceTimeForPremiumSubscription_WhenCalculateFare_ThenShouldReturnMinimumFare() {
        cabBooking = new CabBooking(Invoice.TypeOfSubscription.PREMIUM);
        double totalFare = cabBooking.calculateRideFare(0.2, 2);
        Assert.assertEquals(20, totalFare, 1);
    }

    @Test
    public void givenMultipleRidesForPremiumSubscription_WhenCalculateFare_ThenShouldReturnTotalFare() {
        cabBooking = new CabBooking(Invoice.TypeOfSubscription.PREMIUM);
        Ride[] rides = {new Ride(4, 10),
                new Ride(10,15)};
        InvoiceDetails invoiceDetails = cabBooking.calculateRideFare(rides);
        Assert.assertEquals(260, invoiceDetails.getTotalFare(), 0);
    }


    @Test
    public void givenUserIdAndRidesPremiumSubscription_WhenCalculateFare_ShouldReturnInvoiceDetails() {
        cabBooking=new CabBooking(Invoice.TypeOfSubscription.PREMIUM);
        userRides=new HashMap<>();
        String userId = "Sandip52";
        Ride[] rides = {new Ride(4, 10),
                new Ride(10,15)};
        userRides=cabBooking.addRides(userId,rides);
        InvoiceDetails details = cabBooking.getInvoiceDetails(userId,userRides);
        InvoiceDetails expectedDetails=new InvoiceDetails(2,260);
        Assert.assertEquals(expectedDetails,details);
    }
}
