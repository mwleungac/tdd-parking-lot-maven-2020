package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class SmartParkingBoyTest {
    @Test
    public void should_park_car_to_more_empty_parking_lot() {
        final int parkingLotACapacity = 9;
        final int parkingLotBCapacity = 10;

        ParkingLot[] parkingLotArray = new ParkingLot[2];
        ParkingLot parkingLotA = new ParkingLot(parkingLotACapacity);
        ParkingLot parkingLotB = new ParkingLot(parkingLotBCapacity);
        parkingLotArray[0] = parkingLotA;
        parkingLotArray[1] = parkingLotB;

         SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotArray);

        smartParkingBoy.park(new Car());

        Assert.assertEquals(9, parkingLotA.getAvailableParkingPosition());
        Assert.assertEquals(9, parkingLotB.getAvailableParkingPosition());
    }
}
