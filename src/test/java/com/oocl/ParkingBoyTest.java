package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class ParkingBoyTest {

    @Test
    public void return_ticket_when_car_parked() {

        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        Assert.assertNotNull(parkingBoy.parkACar(car));
    }


}
