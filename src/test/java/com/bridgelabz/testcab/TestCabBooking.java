package com.bridgelabz.testcab;

import com.bridgelabz.cab.model.InvoiceDetails;
import com.bridgelabz.cab.model.Ride;
import com.bridgelabz.cab.service.CabBooking;
import org.junit.Assert;
import org.junit.Test;

public class TestCabBooking {

    private CabBooking cabBooking;

    @Test
    public void givenDistanceTime_WhenCalculateFare_ThenShouldReturnTotalFare() {
        cabBooking = new CabBooking();
        double totalFare = cabBooking.calculateRideFare(15, 30.15);
        Assert.assertEquals(180.15, totalFare, 1);
    }

    @Test
    public void givenWrongExpectedInput_WhenCalculateFare_ThenShouldReturnTotalFare() {
        cabBooking = new CabBooking();
        double totalFare = cabBooking.calculateRideFare(15, 30.15);
        Assert.assertNotEquals(140.15, totalFare, 1);
    }

    @Test
    public void givenMinimumDistanceTime_WhenCalculateFare_ThenShouldReturnMinimumFare() {
        cabBooking = new CabBooking();
        double totalFare = cabBooking.calculateRideFare(0.2, 2);
        Assert.assertEquals(5, totalFare, 1);
    }

    @Test
    public void givenMultipleRides_WhenCalculateFare_ThenShouldReturnTotalFare() {
        cabBooking = new CabBooking();
        Ride[] rides = {new Ride(4, 10),
                        new Ride(10,15)};
        InvoiceDetails invoiceDetails = cabBooking.calculateRideFare(rides);
        Assert.assertEquals(165, invoiceDetails.getTotalFare(), 0);
    }

    @Test
    public void givenMultipleRides_WhenCalculateFare_ShouldReturnInvoiceSummaryTotalFare() {
        cabBooking=new CabBooking();
        Ride[] rides = {new Ride(2.0, 5),
                        new Ride(0.1, 1)};
        InvoiceDetails details = cabBooking.calculateRideFare(rides);
        InvoiceDetails expectedDetails=new InvoiceDetails(2,30);
        Assert.assertEquals(expectedDetails, details);
    }

    @Test
    public void givenMultipleRides_WhenCalculateFare_ShouldReturnNumberOfRides() {
        cabBooking=new CabBooking();
        Ride[] rides = {new Ride(2.0, 5),
                        new Ride(0.1, 1),
                        new Ride(0.1, 1)};
        InvoiceDetails details = cabBooking.calculateRideFare(rides);
        Assert.assertEquals(3, details.getNumOfRides(),0);
    }

    @Test
    public void givenMultipleRides_WhenCalculateFare_ShouldReturnAverageFare() {
        cabBooking=new CabBooking();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),
                new Ride(5.1, 10)};
        InvoiceDetails details = cabBooking.calculateRideFare(rides);
        Assert.assertEquals(30.33, details.getAverageFare(),1);
    }

}
