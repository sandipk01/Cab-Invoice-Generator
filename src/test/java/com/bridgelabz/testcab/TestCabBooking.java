package com.bridgelabz.testcab;

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
}
