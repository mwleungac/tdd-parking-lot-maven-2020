package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class SuperSmartParkingBoyTest {

    @Test
    public void should_park_car_to_parking_lot_with_higher_position_rate() {
        final int parkingLotACapacity = 9;
        final int parkingLotBCapacity = 100;
        final int carNumber = 15;

        ParkingLot[] parkingLotArray = new ParkingLot[2];
        ParkingLot parkingLotA = new ParkingLot(parkingLotACapacity);
        ParkingLot parkingLotB = new ParkingLot(parkingLotBCapacity);
        parkingLotArray[0] = parkingLotA;
        parkingLotArray[1] = parkingLotB;

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotArray);
        for (int i = 0; i < carNumber; i++) {
            superSmartParkingBoy.park(new Car());
        }

        Assert.assertEquals(7, parkingLotA.getAvailableParkingPosition());
        Assert.assertEquals(87, parkingLotB.getAvailableParkingPosition());
    }
}
