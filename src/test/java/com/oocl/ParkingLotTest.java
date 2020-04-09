package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {

    @Test
    public void return_ticket_when_car_parked() {
        ParkingLot parkingLot = new ParkingLot();

        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        Assert.assertNotNull(ticket);
    }
}
